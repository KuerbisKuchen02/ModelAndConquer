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
		
		createFileWithContent(project, "models.generated", "Game.java", generateGame(game));
		
		// Generate all EDamageTypes
		createFileWithContent(project, "models.generated", "EDamageType.java", generateEDamageTypes(game.damageTypes));
		
		return void
	}
	
	def generateGame(Game game)'''
	// Imports
	import java.util.ArrayList;
	import models._static.*;

	public class Game extends GenericElement {
		
		// Attributes
		Player player;
		ArrayList<Area> areas;
		ArrayList<Connection> connections;
		ArrayList<Effect> effects;

		public Game(String name, String description) {
			super(name, description);
			this.areas = new ArrayList<>();
			this.connections = new ArrayList<>();
			this.damageTypes = new ArrayList<>();
			this.effects = new ArrayList<>();
			this.parser = new GameParser(this);
		}
		
		public void init() {
			ArrayList<INonPlayerEntity> entities;
			ArrayList<Item> items;
			ArrayList<DamageModificator> damageModificators;
			Entity entity;
			DamageModificator damageModificator;

			«generatePlayer(game.player)»
			
			«generateAreas(game.areas)»
			
			«generateConnections(game.connections)»
			
			«generateEffects(game.effects)»
			
			// Set all non Containment References
			// Map Areas and Connections
			Connection connection = null;
			Area areaFrom = null;
			Area areaTo = null;
			«FOR Connection connection: game.connections»
			// Get References
			connection = findConnectionByName("«connection.name»");
			areaFrom = findAreaByName("«connection.areaFrom.name»");
			areaTo = findAreaByName("«connection.areaTo.name»");

			// Set Connection Attributes
			connection.setAreaFrom(areaFrom);
			connection.setAreaTo(areaTo);

			// Set Area Attributes
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
			«ENDFOR»

			// Set unlock Item references

			// Set Effects for Areas
			«FOR Area area: game.areas»
			«IF area.onEnterEffect !== null»
			// Set Effect for Area «area.name»
			ArrayList<Effect> areaEffects = new ArrayList<Effects>();
			«FOR Effect effect: area.onEnterEffect»
			areaEffects.add(findEffectByName("«effect.name»"));
			«ENDFOR»
			findAreaByName("«area.name»").setOnEnterEffect(findEffectByName(areaEffects));
			«ENDIF»

			«ENDFOR»
		}
	}
	'''
	
	def generatePlayer(Player player)'''
		this.player = new Player("«player.name»", "«player.description»", «player.maxHealth», new ArrayList<Item>(), new ArrayList<Effect>(), new ArrayList<DamageModificator>(), «player.spawnpoint»);
	'''
	
	def generateAreas(EList<Area> areas)'''
		// Generate Areas
		«FOR Area area: areas»
		// Generate Area «area.name»
		// Generate INonPlayerEntities for «area.name»
		«generateINonPlayerEntities(area.entities)»
		
		// Generate Items for «area.name»
		«generateItems(area.items)»
		
		// Add Area «area.name» to list
		this.areas.add(new Area("«area.name»", "«area.description»", null, entities, items, null));
		«ENDFOR»
	'''

	def generateConnections(EList<Connection> connections)'''
		// Generate Connections
		«FOR Connection connection: connections»
			this.connections.add(new Connection("«connection.name»", "«connection.description»", null, null, null, null));
		«ENDFOR»
	'''
	
	def generateEffects(EList<Effect> effects)'''
	// Generate Effects
	«FOR Effect effect: effects»
		this.effects.add(
		«IF effect instanceof HealthEffect»new HealthEffect("«effect.name»", "«effect.description»", «effect.duration», «effect.amount», «effect.onSelf», null)«ENDIF»
		«IF effect instanceof SpawnEffect»new SpawnEffect("«effect.name»", "«effect.description»", null, null)«ENDIF»
		«IF effect instanceof DamageModificatorEffect»new DamageModificatorEffect("«effect.name»", "«effect.description»", null, «effect.onSelf»)«ENDIF»
		«IF effect instanceof EndGameEffect»new EndGameEffect("«effect.name»", "«effect.description»")«ENDIF»
		);
	«ENDFOR»
	'''
	
	def generateINonPlayerEntities(EList<INonPlayerEntity> entities)'''
		// Generate Non Player Entities
		entities = new ArrayList<>();
		«FOR INonPlayerEntity entity: entities»
			«IF entity instanceof Monster»
				// Generate Inventory of Monster «entity.name»
				«generateItems(entity.inventory)»
				// Generate DamageModificators of Monster «entity.name»
				«generateDamageModificator(entity.damageModificators)»
				entity = new Monster("«entity.name»", "«entity.description»", «entity.maxHealth», items, null, null, null, null, null, null, null);
			«ENDIF»
			«IF entity instanceof DestroyableObject»
			// Generate Inventory of Destroyable Object «entity.name»
				«generateItems(entity.inventory)»
				// Generate DamageModificators of DestroyableObject «entity.name»
				«generateDamageModificator(entity.damageModificators)»
				entity = new DestroyableObject("«entity.name»", "«entity.description»", «entity.maxHealth»,  items, null, null);
			«ENDIF»
			entities.add((INonPlayerEntity) entity);
		«ENDFOR»
	'''
	
	def generateItems(EList<Item> items)'''
		// Generate items
		items = new ArrayList<>();
		«FOR Item item: items»
			items.add(new Item("«item.name»", "«item.description»", «item.damage», «item.consumable», null, null, null, null));
		«ENDFOR»
	'''
	
	def generateDamageModificator(EList<DamageModificator> damageModificators)'''
		// Generate DamageModificator
		damageModificators = new ArrayList<>();
		«FOR DamageModificator damageModificator: damageModificators»
			DamageModificator damageModificator = new DamageModificator(«damageModificator.name», «damageModificator.description», null, «damageModificator.multiplikator»));
			damageModificators.add(damageModificator);
		«ENDFOR»
		
	'''
	
	def generateEDamageTypes(EList<DamageType> damageTypes) '''
	public enum EDamageType {
		«FOR int i: 0..damageTypes.size-1 SEPARATOR ','»
			«damageTypes.get(i).name.toUpperCase»(«i»)«IF i==damageTypes.size-1»;«ENDIF»
		«ENDFOR»
		
		private final int value;
		
		EDamageType(int value) { this.value=value; }
		
		public static String getValueString(int value) {
			return switch (value) {
				«FOR int i: 0..damageTypes.size-1»
					case «i» -> "«damageTypes.get(i).name»"
				«ENDFOR»
				default -> "Not an valid DamageType!"
			}
		}
	}
	'''

	
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
