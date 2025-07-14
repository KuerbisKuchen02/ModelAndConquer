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

	public class DungeonFactory extends GenericElement {
		
		Player player;
		ArrayList<Area> areas = new ArrayList<>();
		ArrayList<Connection> connections = new ArrayList<>();
		ArrayList<Effect> effects = new ArrayList<>();
		ArrayList<INonPlayerEntity> entities;
		ArrayList<Item> items = new ArrayList<>();
					
		public Game generate() {
			// Create all GenericElements of the Game and their Sub-ELements which have a containment Relation within the Model
			initPlayer();
			initAreas();
			initConnections();
			initEffects();
			
			// Link all Generic Elements with their Reference Attributes
			mapPlayerReferences();
			mapAreasAndConnections();
			mapEffectsOfItems();
			
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
		
		private void mapEffectsOfItems() {
			«mapEffectsOfItems(game)»
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
				if (connection.getName().equals(name) {
					return connection;
				}
			}
			
			return null;
		}
		
		private Effect findEffectByName(String name) {
			for (Effect effect: this.effects) {
				if (effect.getName().equals(name) {
					return effect;
				}
			}
			
			return null;
		}
		
		private Monster findMonsterByName(String name) {
			for (INonplayerEntity entity: this.entities) {
				if (entity.instanceOf(Monster) && entity.getName().equals(name)) {
					return entity;
				}
			}
			
			return null;
		}
		
		private Item findItemByName(String name) {
			for (Item item: this.items) {
				if (item.getName().equals(name) {
					return item;
				}
			}
			
			return null;
		}
	}
	'''
	
	def generatePlayer(Player player)'''
	ArrayList<Item> items = null;
	ArrayList<DamageModificator> damageModificators = null;
	
	«IF player.inventory !== null»
		// Set Inventory
		items = new ArrayList<Item>();
		«generateItems(player.inventory)»
	«ENDIF»
	
	«IF player.damageModificators !== null»
		// Set DamageModificator
		«generateDamageModificator(player.damageModificators)»
	«ENDIF»
	
	this.player = new Player("«player.name»", "«player.description»", «player.maxHealth», damageModificators, items, «player.evasion»);
	'''
	
	def generateAreas(EList<Area> areas)'''
		ArrayList<Items> items = null;
		Entity entity = null;
		ArrayList<INonPlayerEntity> entities = null;
		ArrayList<DamageModificator> damageModificators = null;
		
		// Generate Areas
		«FOR Area area: areas»
		// Generate Area «area.name»
		// Generate INonPlayerEntities for «area.name»
		«generateINonPlayerEntities(area.entities)»
		
		// Generate Items for «area.name»
		items = new ArrayList<Item>();
		«generateItems(area.items)»
		
		// Add Area «area.name» to list
		this.areas.add(new Area("«area.name»", "«area.description»", entities, items));
		«ENDFOR»
	'''

	def generateConnections(EList<Connection> connections)'''
		// Generate Connections
		«FOR Connection connection: connections»
			this.connections.add(new Connection("«connection.name»", "«connection.description»", findAreaByName("«connection.areaFrom.name»"), findAreaByName("«connection.areaTo.name»")));
		«ENDFOR»
	'''
	
	def generateEffects(EList<Effect> effects)'''
	// Generate Effects
	Effect effect = null;
	ArrayList<Monster> spawnEffectEntities = null;
	Area spawnEffectArea = null;
	DamageModificator damageModificator = null;
	
	«FOR Effect effect: effects»
		«IF effect instanceof HealthEffect»
		effect = new HealthEffect("«effect.name»", "«effect.description»", «effect.duration», «effect.amount», «effect.onSelf»)
		«ENDIF»
		«IF effect instanceof SpawnEffect»
		spawnEffectEntities = new ArrayList<Monster>();
		«FOR Monster monster: (effect as SpawnEffect).monster»
		spawnEffectEntities.add(findMonsterByName("«monster.name»");
		«ENDFOR»
		spawnEffectArea = findAreaByName("«(effect as SpawnEffect).area.name»");
		effect = new SpawnEffect("«effect.name»", "«effect.description»", spawnEffectEntities, spawnEffectArea);
		«ENDIF»
		«IF effect instanceof DamageModificatorEffect»
		damageModificator = new DamageModificator("«(effect as DamageModificatorEffect).damageModificator.name»", "«(effect as DamageModificatorEffect).damageModificator.description»", findDamageTypeByName("«(effect as DamageModificatorEffect).damageModificator.damageType.name»"), «(effect as DamageModificatorEffect).damageModificator.multiplikator»);
		effect = new DamageModificatorEffect("«effect.name»", "«effect.description»", damageModificator, «effect.onSelf»)
		«ENDIF»
		«IF effect instanceof EndGameEffect»
		effect = new EndGameEffect("«effect.name»", "«effect.description»")
		«ENDIF»
		this.effects.add(effect);
		
	«ENDFOR»
	'''
	
	def generateINonPlayerEntities(EList<INonPlayerEntity> entities)'''
		entities = new ArrayList<INonPlayerEntity>();
		«FOR INonPlayerEntity entity: entities»
			«IF entity instanceof Monster»
				// Generate Inventory of Monster «entity.name»
				items = new ArrayList<Items>();
				«generateItems(entity.inventory)»
				// Generate DamageModificators of Monster «entity.name»
				«generateDamageModificator(entity.damageModificators)»
				entity = new Monster("«entity.name»", "«entity.description»", «entity.maxHealth», damageModificators, items, «entity.damage», «entity.evasion», «entity.accuracy»);
			«ENDIF»
			«IF entity instanceof DestroyableObject»
				// Generate Inventory of Destroyable Object «entity.name»
				items = new ArrayList<Item>();
				«generateItems(entity.inventory)»
				// Generate DamageModificators of DestroyableObject «entity.name»
				«generateDamageModificator(entity.damageModificators)»
				entity = new DestroyableObject("«entity.name»", "«entity.description»", «entity.maxHealth», damageModificators, items, «entity.evasion»);
			«ENDIF»
			entities.add((INonPlayerEntity) entity);
		«ENDFOR»
	'''
	
	def generateItems(EList<Item> items)'''
		«FOR Item item: items»
			items.add(new Item("«item.name»", "«item.description»", «item.damage», «item.consumable», «item.accuracy»));
		«ENDFOR»
	'''
	
	def generateDamageModificator(EList<DamageModificator> damageModificators)'''
		damageModificators = new ArrayList<>();
		«FOR DamageModificator damageModificator: damageModificators»
			damageModificators.add(new DamageModificator(«damageModificator.name», «damageModificator.description», «damageModificator.multiplikator»)));
		«ENDFOR»
	'''
	
	def generateEDamageTypes(EList<DamageType> damageTypes) '''
	package models.generated;
	
	public enum EDamageType {
		«FOR int i: 0..damageTypes.size-1 SEPARATOR ','»
			«damageTypes.get(i).name.toUpperCase»(«i»)«IF i==damageTypes.size-1»;«ENDIF»
		«ENDFOR»
		
		private final int value;
		
		EDamageType(int value) { this.value=value; }
		
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
	ArrayList<Effect> effects = null;
	
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

	def mapAreasAndConnections(Game game)'''
	// Map Areas and Connections
	Connection connection = null;
	Area areaFrom = null;
	Area areaTo = null;
	
	«FOR Connection connection: game.connections»
	// Get References for Connection «connection.name»
	connection = findConnectionByName("«connection.name»");
	areaFrom = findAreaByName("«connection.areaFrom.name»");
	areaTo = findAreaByName("«connection.areaTo.name»");

	// Set Connection Attributes for Connection «connection.name»
	connection.setAreaFrom(areaFrom);
	connection.setAreaTo(areaTo);

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
	connection.setLocked(findItemByName("«connection.unlockedWith.name»");
	«ENDIF»
	
	«IF connection.onTraverseEffect !== null && connection.onTraverseEffect.size !== 0»
	// Set onTraverseEffect for «connection.name»
	«FOR Effect effect: connection.onTraverseEffect»
	connection.setOnTraverseEffect(findEffectByName("«effect.name»");
	«ENDFOR»
	«ENDIF»
	
	«ENDFOR»

	// Set Effects for Areas
	«FOR Area area: game.areas»
	«IF area.onEnterEffect !== null && area.onEnterEffect.size !== 0»
	// Set Effect for Area «area.name»
	ArrayList<Effect> areaEffects = new ArrayList<Effects>();
	«FOR Effect effect: area.onEnterEffect»
	areaEffects.add(findEffectByName("«effect.name»"));
	«ENDFOR»
	findAreaByName("«area.name»").setOnEnterEffect(areaEffects));
	«ENDIF»

	«ENDFOR»
	'''

	def mapEffectsOfItems(Game game)'''
	Item item = null;
	
	«FOR Item item: getAllItems(game)»
	// Set Effects and DamageType for Item «item.name»
	item = findItemByName("«item.name»");
	«IF item.onUseEffect !== null»item.setOnUseEffect(findEffectByName("«item.onUseEffect.name»");«ENDIF»
	«IF item.onPickupEffect !== null»item.setOnPickupEffect(findEffectByName("«item.onPickupEffect.name»"); «ENDIF»
	«IF item.onDropEffect !== null»item.setOnDropEffect(findEffectByName("«item.onDropEffect.name»"); «ENDIF»
	«IF item.damageType !== null»item.setDamageType(getDamageTypeByName("«item.damageType.name»");«ENDIF»
	
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
	
	def void createFileWithContent(IProject project, String pckgName, String fileName, CharSequence content) {
		var String currentFolderString = "src-gen/";
		var IFolder folder
		
		folder = project.getFolder("src-gen");
		if(!folder.exists) {
			folder.create(true, true, null)
		}
	
		for(String n : pckgName.split("\\.")) { //de . thm . zdh . Toll
			currentFolderString = currentFolderString + n + "/";
			folder = project.getFolder(currentFolderString);
			
			if(!folder.exists) {
				folder.create(true,true,null);
			}
		}

		var IFile file = folder.getFile(fileName);
	
		if(file.exists) {
			file.delete(true,null);
		}
	
		if(!file.exists) {
			var byte[] bytes;
			bytes = content.toString.bytes;
			var InputStream source = new ByteArrayInputStream(bytes);
			file.create(source, true, null);
		}
	}

}
