package commands

import ModelAndConquer.DamageType

import ModelAndConquer.Game
import ModelAndConquer.presentation.ModelAndConquerEditor
import java.io.ByteArrayInputStream
import java.io.InputStream
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.IProject
import org.eclipse.emf.common.util.EList
import org.eclipse.jface.viewers.TreeSelection
import org.eclipse.ui.IFileEditorInput
import org.eclipse.ui.IWorkbenchPart
import org.eclipse.ui.handlers.HandlerUtil
import ModelAndConquer.Area
import ModelAndConquer.Connection
import ModelAndConquer.Effect
import ModelAndConquer.HealthEffect
import ModelAndConquer.SpawnEffect
import ModelAndConquer.DamageModificatorEffect
import ModelAndConquer.EndGameEffect
import ModelAndConquer.INonPlayerEntity
import ModelAndConquer.Monster
import ModelAndConquer.DestroyableObject
import ModelAndConquer.Item
import ModelAndConquer.Player
import ModelAndConquer.DamageModificator
import ModelAndConquer.EConnectionDirections
import java.util.ArrayList
import ModelAndConquer.Entity

class GeneratorHandler extends AbstractHandler {
	
	override execute(ExecutionEvent event) throws ExecutionException {
		println("Generator starting...");
		
		// Get active part of the model eclipse instance
		val IWorkbenchPart wbp = HandlerUtil.getActivePart(event);
		
		// Cast to project editor
		var ModelAndConquerEditor ue = wbp as ModelAndConquerEditor;
			
		// Get active project in the model eclipse instance
		var IProject project = (ue.getEditorInput() as IFileEditorInput).file.project;
		
		// Get selected element
		var TreeSelection ts = ue.selection as TreeSelection;
		
		var Game game = ts.firstElement as Game;	
		
		val IFolder folder = project.getFolder("src-gen");
		if (folder.exists) folder.delete(true, null);	
		
		copyStaticFiles(project, "models._static");
		copyStaticFiles(project, "compiler");
		
		createFileWithContent(project, "models.generated", "DungeonFactory.java", generateGame(game));
		
		// Generate all EDamageTypes
		createFileWithContent(project, "models.generated", "EDamageType.java", generateEDamageTypes(game.damageTypes));
		
		return void
	}
	
	def generateGame(Game game)'''
	package models.generated;
	
	// Imports
	import java.util.ArrayList;
	import models._static.*;
	

	public class DungeonFactory {
		
		public static final String TAG = DungeonFactory.class.getSimpleName();
		
		Player player;
		ArrayList<Area> areas = new ArrayList<>();
		ArrayList<Connection> connections = new ArrayList<>();
		ArrayList<Effect> effects = new ArrayList<>();
					
		public Game generate() throws Exception {
			// Create all GenericElements of the Game and their Sub-ELements which have a containment Relation within the Model
			initPlayer();
			initAreas();
			initConnections();
			initEffects();
			
			// Link all Generic Elements with their Reference Attributes
			mapPlayerReferences();
			mapAreasAndConnections();
			mapEffectsAndDamageTypes();
			mapDamageTypeToDamageModificators();
			
			if (!checkGame()) {
				throw new Exception("Game generation failed due to constraints not being met.");
			}
					
			return new Game("«game.name»", "«game.description»", player);
			
		}
		
		private void initPlayer() {
			«generatePlayer(game.player)»
		}
		
		private void initAreas() {
			«generateAreas(game.areas)»
		}
		
		private void initConnections() {
			«generateConnections(game.connections)»
		}
		
		private void initEffects() {
			«generateEffects(game.effects)»
		}
		
		private void mapPlayerReferences() {
			«mapPlayerReferences(game.player)»
		}
		
		private void mapAreasAndConnections() {
			«mapAreasAndConnections(game)»
		}
		
		private void mapEffectsAndDamageTypes() {
			«mapEffectsAndDamageTypes(game)»
		}
		
		private void mapDamageTypeToDamageModificators() {
			«mapDamageTypeToDamageModificators(game)»
		}
		
		private Area findAreaByName(String name) {
			for (Area area: this.areas) {
				if (area.getName().equals(name)) {
					return area;
				}
			}
			
			return null;
		}
		
		private Connection findConnectionByName(String name) {
			for (Connection connection: this.connections) {
				if (connection.getName().equals(name)) {
					return connection;
				}
			}
			
			return null;
		}
		
		private Effect findEffectByName(String name) {
			for (Effect effect: this.effects) {
				if (effect.getName().equals(name)) {
					return effect;
				}
			}
			
			return null;
		}
		
		private DamageModificator findDamageModificatorByName(String name) {
			for (DamageModificator damageModificator: player.getDamageModificators()) {
				if (damageModificator.getName().equals(name)) {
					return damageModificator;
				}
			}
			for (Area area: this.areas) {
				for (INonPlayerEntity entity : area.getEntities()) {
					for (DamageModificator damageModificator : ((Entity) entity).getDamageModificators()) {
						if (damageModificator.getName().equals(name)) {
							return damageModificator;
						}
					}
				}
			}
			for (Effect effect: this.effects) {
				if (effect instanceof DamageModificatorEffect) {
					if (((DamageModificatorEffect) effect).getDamageModificator().getName().equals(name)) {
						return ((DamageModificatorEffect) effect).getDamageModificator();
					}
				} else if (effect instanceof SpawnEffect) {
					for (INonPlayerEntity entity : ((SpawnEffect) effect).getNonPlayerEntities()) {
						if (entity instanceof Entity) {
							for (DamageModificator damageModificator : ((Entity) entity).getDamageModificators()) {
								if (damageModificator.getName().equals(name)) {
									return damageModificator;
								}
							}
						}
					}
				}
			}
					
			return null;
		}
		
		private INonPlayerEntity findINonPlayerEntityByName(String name) {
			for (Area area: this.areas) {
				for (INonPlayerEntity entity: area.getEntities()) {
					if (entity instanceof Monster) {
						if (((Monster) entity).getName().equals(name)) {
							return entity;
						}
					}
					else if (entity instanceof DestroyableObject) {
						if (((DestroyableObject) entity).getName().equals(name)) {
							return entity;
						}
					}
				}
			}
			
			for (Effect effect : this.effects) {
				if (effect instanceof SpawnEffect) {
					for (INonPlayerEntity entity : ((SpawnEffect) effect).getNonPlayerEntities()) {
						if (((Entity) entity).getName().equals(name)) {
							return entity;
						}
					}
				}
			}
			
			return null;
		}
		
		private Item findItemByName(String name) {
			for (Item item: player.getInventory()) {
				if (item.getName().equals(name)) {
					return item;
				}
			}
			for (Area area: this.areas) {
				for (Item item: area.getItems()) {
					if (item.getName().equals(name)) {
						return item;
					}
				}
				for (INonPlayerEntity entity: area.getEntities()) {
					if (entity instanceof Monster) {
						for (Item item: ((Monster) entity).getInventory()) {
							if (item.getName().equals(name)) {
								return item;
							}
						}
					}
					else if (entity instanceof DestroyableObject) {
						for (Item item: ((DestroyableObject) entity).getInventory()) {
							if (item.getName().equals(name)) {
								return item;
							}
						}
					}
				}
			}
			return null;
		}
		
		/**
		 * Checks whether the game was generated correctly according to constraints.
		 * @return
		 */
		private boolean checkGame() {
			// Errorcheck: Check if every Area has at least one outgoing connection.
			for (Area area : this.areas) {
				if (area.getConnections() == null || area.getConnections().length == 0) {
					System.out.println("Error: Area " + area.getName() + " has no outgoing connections.");
					return false;
				}
	
				boolean hasOutgoingConnection = false;
				for (Connection connection: area.getConnections()) {
					if (connection != null) {
						hasOutgoingConnection = true;
						break;
					}
				}
	
				if (!hasOutgoingConnection) {
					Logger.error(TAG, "Area " + area.getName() + " has no outgoing connections.");
					return false;
				}
			}
	
			// Errorcheck: Check if the Game has at least one EndGameEffect
			boolean hasEndGameEffect = false;
			for (Effect effect : this.effects) {
				if (effect instanceof EndGameEffect) {
					hasEndGameEffect = true;
				}
			}
	
			if (!hasEndGameEffect) {
				return false;
			}
	
			// Errorcheck: No Prepositions in any Names
			ArrayList<GenericElement> allGenericElements = getAllGenericElements();
			for (GenericElement element : allGenericElements) {
				if (element.getName().isEmpty() || element.getName().matches(" on | with ")) {
					Logger.error(TAG, "Element " + element.getName() + " contains a preposition in its name.");
					return false;
				}
			}
	
			// Errorcheck: OnSpawnEffect darf kein SpawnEffect sein
			for (Area area : this.areas) {
				for (INonPlayerEntity entity: area.getEntities()) {
					if (entity instanceof Monster) {
						Monster monster = (Monster) entity;
						if (monster.getOnSpawn() != null && monster.getOnSpawn() instanceof SpawnEffect) {
							Logger.error(TAG, "Monster " + monster.getName() + " has a SpawnEffect as OnSpawnEffect.");
							return false;
						}
					}
				}
			}
			
			// Errorcheck: Connections dürfen nicht die gleiche Area als Ein und Ausgang besitzen
			for (Connection connection: this.connections) {
				if (connection.getAreaA() == connection.getAreaB()) {
					Logger.error(TAG, "Connection " + connection.getName() + " has the same Area: " + connection.getAreaA().getName() + " as entry and exit");
					return false;
				}
			}
	
			return true;
		}
		
		private ArrayList<GenericElement> getAllGenericElements() {
			ArrayList<GenericElement> elements = new ArrayList<>();
			elements.add(player);
			for (Item item : player.getInventory()) {
				elements.add(item);
			}
			for (DamageModificator damageModificator : player.getDamageModificators()) {
				elements.add(damageModificator);
			}
			elements.addAll(areas);
			for (Area area : areas) {
				elements.addAll(area.getItems());
				for (INonPlayerEntity entity : area.getEntities()) {
					if (entity instanceof Monster) {
						Monster monster = (Monster) entity;
						elements.add(monster);
						elements.addAll(monster.getInventory());
						elements.addAll(monster.getDamageModificators());
					} else if (entity instanceof DestroyableObject) {
						DestroyableObject destroyableObject = (DestroyableObject) entity;
						elements.add(destroyableObject);
						elements.addAll(destroyableObject.getInventory());
						elements.addAll(destroyableObject.getDamageModificators());
					}
				}
			}
			elements.addAll(connections);
			elements.addAll(effects);
			return elements;
		}
	}
	'''
	
	def generatePlayer(Player player)'''
	ArrayList<Item> items;
	ArrayList<DamageModificator> damageModificators;
	
	«IF player.inventory !== null»
		// Set Inventory
		«generateItems(player.inventory)»
	«ENDIF»
	
	«IF player.damageModificators !== null»
		// Set DamageModificator
		«generateDamageModificators(player.damageModificators)»
	«ENDIF»
	
	this.player = new Player("«player.name»", "«player.description»", «player.maxHealth», damageModificators, items, «player.evasion»);
	'''
	
	def generateAreas(EList<Area> areas)'''
		ArrayList<Item> items;
		Entity entity;
		ArrayList<INonPlayerEntity> entities;
		ArrayList<DamageModificator> damageModificators;
		
		// Generate Areas
		«FOR Area area: areas»
		// Generate Area «area.name»
		// Generate INonPlayerEntities for «area.name»
		«generateINonPlayerEntities(area.entities)»
		
		// Generate Items for «area.name»
		«generateItems(area.items)»
		
		// Add Area «area.name» to list
		this.areas.add(new Area("«area.name»", "«area.description»", entities, items));
		«ENDFOR»
	'''

	def generateConnections(EList<Connection> connections)'''
		// Generate Connections
		«FOR Connection connection: connections»
		«IF connection.name === null || connection.name.isEmpty»
			this.connections.add(new Connection("«connection.areaFrom.name»" + " To " + "«connection.areaTo.name»", "«connection.description»"));
		«ELSE»
			this.connections.add(new Connection("«connection.name»", "«connection.description»"));
		«ENDIF»
		«ENDFOR»
	'''
	
	def generateEffects(EList<Effect> effects)'''
	// Generate Effects
	Effect effect;
	// Variables for Spawneffects
	ArrayList<INonPlayerEntity> spawnEffectEntities;
	ArrayList<Item> items;
	ArrayList<DamageModificator> damageModificators;
	// Variables for DamageModificatorEffect
	DamageModificator damageModificator;
	
	«FOR Effect effect: effects»
		«IF effect instanceof HealthEffect»
		effect = new HealthEffect("«effect.name»", "«effect.description»", «effect.probability», «effect.amount», «effect.duration», «effect.onSelf»);
		«ENDIF»
		«IF effect instanceof SpawnEffect»
		spawnEffectEntities = new ArrayList<>();
		«FOR INonPlayerEntity entity: (effect as SpawnEffect).entities»
		«IF entity instanceof Monster»
		«generateItems(entity.inventory)»
		«generateDamageModificators(entity.damageModificators)»
		spawnEffectEntities.add(new Monster("«entity.name»", "«entity.description»", «entity.maxHealth», damageModificators, items, «entity.damage», «entity.evasion», «entity.accuracy»));
		«ELSEIF entity instanceof DestroyableObject»
		«generateItems(entity.inventory)»
		«generateDamageModificators(entity.damageModificators)»
		spawnEffectEntities.add(new DestroyableObject("«entity.name»", "«entity.description»", «entity.maxHealth», damageModificators, items, «entity.evasion»));
		«ENDIF»
		«ENDFOR»
		effect = new SpawnEffect("«effect.name»", "«effect.description»", «effect.probability», spawnEffectEntities);
		«ENDIF»
		«IF effect instanceof DamageModificatorEffect»
		damageModificator = new DamageModificator("«effect.damageModificator.name»", "«effect.damageModificator.description»", «effect.damageModificator.multiplikator»);
		effect = new DamageModificatorEffect("«effect.name»", "«effect.description»", «effect.probability», damageModificator, «effect.onSelf», «effect.duration»);
		«ENDIF»
		«IF effect instanceof EndGameEffect»
		effect = new EndGameEffect("«effect.name»", "«effect.description»");
		«ENDIF»
		this.effects.add(effect);
		
	«ENDFOR»
	'''
	
	def generateINonPlayerEntities(EList<INonPlayerEntity> entities)'''
		entities = new ArrayList<>();
		«FOR INonPlayerEntity entity: entities»
			«IF entity instanceof Monster»
				// Generate Inventory of Monster «entity.name»
				«generateItems(entity.inventory)»
				// Generate DamageModificators of Monster «entity.name»
				«generateDamageModificators(entity.damageModificators)»
				entity = new Monster("«entity.name»", "«entity.description»", «entity.maxHealth», damageModificators, items, «entity.damage», «entity.evasion», «entity.accuracy»);
			«ENDIF»
			«IF entity instanceof DestroyableObject»
				// Generate Inventory of Destroyable Object «entity.name»
				«generateItems(entity.inventory)»
				// Generate DamageModificators of DestroyableObject «entity.name»
				«generateDamageModificators(entity.damageModificators)»
				entity = new DestroyableObject("«entity.name»", "«entity.description»", «entity.maxHealth», damageModificators, items, «entity.evasion»);
			«ENDIF»
			entities.add((INonPlayerEntity) entity);
		«ENDFOR»
	'''
	
	def generateItems(EList<Item> items)'''
		items = new ArrayList<Item>();
		«FOR Item item: items»
			items.add(new Item("«item.name»", "«item.description»", «item.damage», «item.consumable», «item.accuracy»));
		«ENDFOR»
	'''
	
	def generateDamageModificators(EList<DamageModificator> damageModificators)'''
		damageModificators = new ArrayList<>();
		«FOR DamageModificator damageModificator: damageModificators»
			damageModificators.add(new DamageModificator("«damageModificator.name»", "«damageModificator.description»", «damageModificator.multiplikator»));
		«ENDFOR»
	'''
	
	def generateEDamageTypes(EList<DamageType> damageTypes) '''
	package models.generated;
	
	public enum EDamageType {
		«FOR int i: 0..damageTypes.size-1 SEPARATOR ','»
			«damageTypes.get(i).name.split(" ").join("_").toUpperCase»(«i»)«IF i==damageTypes.size-1»;«ENDIF»
		«ENDFOR»
		
		private final int value;
		
		EDamageType(int value) { this.value=value; }
		
		public static EDamageType getDamageTypeByName(String name) {
			switch (name) {
				«FOR int i: 0..damageTypes.size-1»
					case "«damageTypes.get(i).name»": return EDamageType.«damageTypes.get(i).name.split(" ").join("_").toUpperCase»;
				«ENDFOR»
				default: return null;
			}
		}
		
		@Override
		public String toString() {
			return switch (value) {
				«FOR int i: 0..damageTypes.size-1»
					case «i» -> "«damageTypes.get(i).name»";
				«ENDFOR»
				default -> "Not an valid DamageType!";
			};
		}
	}
	'''

	def mapPlayerReferences(Player player)'''
	ArrayList<Effect> effects;
	
	// Set Spawnpoint
	player.setPosition(findAreaByName("«player.spawnpoint.name»"));
	
	«IF player.effects !== null»
	// Set Effects
	effects = new ArrayList<Effect>();
	«FOR Effect effect: player.effects»
	effects.add(findEffectByName("«effect.name»"));
	«ENDFOR»
	this.player.setEffects(effects);
	«ENDIF»
	'''
	
	def mapDamageTypeToDamageModificators(Game game)'''
	DamageModificator damageModificator;
	«FOR DamageModificator damageModificator: game.player.damageModificators»
		damageModificator = findDamageModificatorByName("«damageModificator.name»");
		damageModificator.setDamageType(EDamageType.getDamageTypeByName("«damageModificator.damageType.name»"));
	«ENDFOR»
	«FOR Effect effect : game.effects»
	«IF effect instanceof DamageModificatorEffect»
		damageModificator = findDamageModificatorByName("«effect.damageModificator.name»");
		damageModificator.setDamageType(EDamageType.getDamageTypeByName("«effect.damageModificator.damageType.name»"));
	«ELSEIF effect instanceof SpawnEffect»
		«FOR INonPlayerEntity entity : effect.entities»
			«IF entity instanceof Monster»
				«FOR DamageModificator damageModificator: entity.damageModificators»
					damageModificator = findDamageModificatorByName("«damageModificator.name»");
					damageModificator.setDamageType(EDamageType.getDamageTypeByName("«damageModificator.damageType.name»"));
				«ENDFOR»
			«ELSEIF entity instanceof DestroyableObject»
				«FOR DamageModificator damageModificator: entity.damageModificators»
					damageModificator = findDamageModificatorByName("«damageModificator.name»");
					damageModificator.setDamageType(EDamageType.getDamageTypeByName("«damageModificator.damageType.name»"));
				«ENDFOR»
			«ENDIF»
		«ENDFOR»
	«ENDIF»
	«ENDFOR»
	«FOR Area area : game.areas»
	«FOR INonPlayerEntity entity: area.entities»
	«FOR DamageModificator damageModificator : (entity as Entity).damageModificators»
		damageModificator = findDamageModificatorByName("«damageModificator.name»");
		damageModificator.setDamageType(EDamageType.getDamageTypeByName("«damageModificator.damageType.name»"));
	«ENDFOR»
	«ENDFOR»
	«ENDFOR»
	

	'''

	def mapAreasAndConnections(Game game)'''
	// Map Areas and Connections
	Connection connection;
	Area areaFrom;
	Area areaTo;
	SpawnEffect spawnEffect;
	
	«FOR Connection connection: game.connections»
	«IF connection.name === null || connection.name.isEmpty»
		// Get References for Connection «connection.areaFrom.name»" + " To " + "«connection.areaTo.name»
		connection = findConnectionByName("«connection.areaFrom.name»" + " To " + "«connection.areaTo.name»");
	«ELSE»
		// Get References for Connection «connection.name»
		connection = findConnectionByName("«connection.name»");
	«ENDIF»
	areaFrom = findAreaByName("«connection.areaFrom.name»");
	areaTo = findAreaByName("«connection.areaTo.name»");

	// Set Connection Attributes for Connection «connection.name»
	connection.setAreaA(areaFrom);
	connection.setAreaB(areaTo);

	// Set Area Attributes for Connection «connection.name»
	«IF connection.direction == EConnectionDirections.NORTHTOSOUTH»
	areaFrom.setConnection(connection, EDirection.NORTH);
	areaTo.setConnection(connection, EDirection.SOUTH);
	«ELSEIF connection.direction == EConnectionDirections.EASTTOWEST»
	areaFrom.setConnection(connection, EDirection.EAST);
	areaTo.setConnection(connection, EDirection.WEST);
	«ELSEIF connection.direction == EConnectionDirections.SOUTHTONORTH»
	areaFrom.setConnection(connection, EDirection.SOUTH);
	areaTo.setConnection(connection, EDirection.NORTH);
	«ELSEIF connection.direction == EConnectionDirections.WESTTOEAST»
	areaFrom.setConnection(connection, EDirection.WEST);
	areaTo.setConnection(connection, EDirection.EAST);
	«ELSEIF connection.direction == EConnectionDirections.UPTODOWN»
	areaFrom.setConnection(connection, EDirection.UP);
	areaTo.setConnection(connection, EDirection.DOWN);
	«ELSEIF connection.direction == EConnectionDirections.DOWNTOUP»
	areaFrom.setConnection(connection, EDirection.DOWN);
	areaTo.setConnection(connection, EDirection.UP);
	«ENDIF»
	
	«IF connection.unlockedWith !== null»
	// Set unlock Item references for «connection.name»
	connection.setLocked(findItemByName("«connection.unlockedWith.name»"));
	«ENDIF»
	
	«IF connection.onTraverseEffect !== null»
	// Set onTraverseEffect for «connection.name»
	connection.setOnTraverse(findEffectByName("«connection.onTraverseEffect.name»"));
	«ENDIF»
	«ENDFOR»

	// Set Effects for Areas
	«FOR Area area: game.areas»
	«IF area.onEnterEffect !== null»
	// Set Effect for Area «area.name»
	findAreaByName("«area.name»").setOnEnter(findEffectByName("«area.onEnterEffect.name»"));
	«ENDIF»
	«ENDFOR»
	
	// Set SpawnAreas in SpawnEffects
	«FOR Effect effect: game.effects»
		«IF effect instanceof SpawnEffect»
			spawnEffect = (SpawnEffect) findEffectByName("«effect.name»");
			spawnEffect.setArea(findAreaByName("«effect.area.name»"));
		«ENDIF»
	«ENDFOR»
	'''

	def mapEffectsAndDamageTypes(Game game)'''
	Item item;
	Monster monster;
	Effect effect;
	ArrayList<Effect> effectlist;
	Area spawnEffectArea;
	
	// Set Effects and DamageType for Items
	«FOR Item item: getAllItems(game)»
	// Set Effects and DamageType for Item «item.name»
	item = findItemByName("«item.name»");
	«IF item.onUseEffect !== null»item.setOnUse(findEffectByName("«item.onUseEffect.name»"));«ENDIF»
	«IF item.onPickupEffect !== null»item.setOnPickup(findEffectByName("«item.onPickupEffect.name»")); «ENDIF»
	«IF item.onDropEffect !== null»item.setOnDrop(findEffectByName("«item.onDropEffect.name»")); «ENDIF»
	«IF item.damageType !== null»item.setDamageType(EDamageType.getDamageTypeByName("«item.damageType.name»"));«ENDIF»
	«ENDFOR»
	
	// Set initial effects of INonPlayerEntities
	«FOR Area area: game.areas»
		«FOR INonPlayerEntity entity: area.entities»
			«IF entity instanceof Entity»
				«IF entity.effects !== null && entity.effects.length != 0»
					effectlist = new ArrayList<>();
					«FOR Effect effect : entity.effects»
					effectlist.add(findEffectByName("«effect.name»"));
					«ENDFOR»
					((Entity) findINonPlayerEntityByName("«entity.name»")).setEffects(effectlist);
				«ENDIF»
			«ENDIF»
		«ENDFOR»
	«ENDFOR»
	
	// Set Monster Specific Effects and DamageType
	«FOR Area area: game.areas»
		«FOR INonPlayerEntity entity: area.entities»
			«IF entity instanceof Monster»
				monster = (Monster) findINonPlayerEntityByName("«entity.name»");
				«IF entity.onHitEffect !== null»
					«FOR Effect effect : entity.onHitEffect»
						monster.setOnHit(findEffectByName("«effect.name»"));
					«ENDFOR»
				«ENDIF»
				«IF entity.onDamageEffect !== null»
					«FOR Effect effect : entity.onDamageEffect»
						monster.setOnDamage(findEffectByName("«effect.name»"));
					«ENDFOR»
				«ENDIF»
				«IF entity.onKillEffect !== null»
					«FOR Effect effect : entity.onKillEffect»
						monster.setOnKill(findEffectByName("«effect.name»"));
					«ENDFOR»
				«ENDIF»
				«IF entity.damageType !== null»
					monster.setDamageType(EDamageType.getDamageTypeByName("«entity.damageType.name»"));
				«ENDIF»
			«ENDIF»
		«ENDFOR»
	«ENDFOR»
	
	«FOR Effect effect: game.effects»
		«IF effect instanceof SpawnEffect»
			«FOR INonPlayerEntity entity: effect.entities»
				«IF entity instanceof Monster»
					monster = (Monster) findINonPlayerEntityByName("«entity.name»");
					«IF entity.onHitEffect !== null»
						«FOR Effect monsterEffect : entity.onHitEffect»
							monster.setOnHit(findEffectByName("«monsterEffect.name»"));
						«ENDFOR»
					«ENDIF»
					«IF entity.onDamageEffect !== null»
						«FOR Effect monsterEffect : entity.onDamageEffect»
							monster.setOnDamage(findEffectByName("«monsterEffect.name»"));
						«ENDFOR»
					«ENDIF»
					«IF entity.onKillEffect !== null»
						«FOR Effect monsterEffect : entity.onKillEffect»
							monster.setOnKill(findEffectByName("«monsterEffect.name»"));
						«ENDFOR»
					«ENDIF»
				«ENDIF»
			«ENDFOR»
		«ENDIF»
	«ENDFOR»
	
	«FOR Effect effect: game.effects»
	«IF effect instanceof SpawnEffect»
	// Set SpawnArea of SpawnEffect «effect.name»
	effect = findEffectByName("«effect.name»");
	spawnEffectArea = findAreaByName("«effect.area.name»");
	((SpawnEffect) effect).setArea(spawnEffectArea);
	«ENDIF»
	«ENDFOR»
	'''

	def ArrayList<Item> getAllItems(Game game) {
		var items = new ArrayList<Item>();
		// Get Items from the player
		if (game.player.inventory !== null) {
			for (Item item: game.player.inventory) {
				items.add(item);
			}
		}
		
		
		for (Area area: game.areas) {
			// Get Items from the Areas
			if (area.items !== null) {
				for (Item item: area.items) {
					items.add(item);
				}
			}
			// Get Items from the INonPlayerEntities in the Area
			if (area.entities !== null) {
				for (INonPlayerEntity entity: area.entities) {
					if ((entity as Entity).inventory !== null) {
						for (Item item: (entity as Entity).inventory) {
							items.add(item);
						}
					}
				}
			}
		}
		
		return items;
	}
	
	def void copyStaticFiles(IProject project, String pckgName) {
		var String currentFolderString = "src-gen/"
		var IFolder folder;
		
		folder = project.getFolder("src-gen");
		if (!folder.exists) folder.create(true, true, null)
		
		for(String n : pckgName.split("\\.")) { //de . thm . zdh . Toll
			currentFolderString = currentFolderString + n + "/";
			folder = project.getFolder(currentFolderString);
			
			if(!folder.exists) folder.create(true,true,null);
		}
		
		// TODO Copy files
		
	}
	
	def void createFileWithContent(IProject project, String pckgName, String fileName, CharSequence content) {
		var String currentFolderString = "src-gen/";
		var IFolder folder;
		
		folder = project.getFolder("src-gen");
		if (!folder.exists) folder.create(true, true, null)

	
		for(String n : pckgName.split("\\.")) { //de . thm . zdh . Toll
			currentFolderString = currentFolderString + n + "/";
			folder = project.getFolder(currentFolderString);
			
			if(!folder.exists) folder.create(true,true,null);
		}

		var IFile file = folder.getFile(fileName);
	
		if(file.exists) file.delete(true,null);
	
		if(!file.exists) {
			var byte[] bytes;
			bytes = content.toString.bytes;
			var InputStream source = new ByteArrayInputStream(bytes);
			file.create(source, true, null);
		}
	}

}
