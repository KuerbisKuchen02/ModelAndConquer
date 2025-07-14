package models.generated;

// Imports
import java.util.ArrayList;
import models._static.*;

public class DungeonFactory {
	
	Player player;
	ArrayList<Area> areas = new ArrayList<>();
	ArrayList<Connection> connections = new ArrayList<>();
	ArrayList<Effect> effects = new ArrayList<>();
				
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
		
		return new Game("Jonny's Quest", "The lonely Quest of Jonny", player);
		
	}
	
	private void initPlayer() {
		ArrayList<Item> items = null;
		ArrayList<DamageModificator> damageModificators = null;
		
		// Set Inventory
		items = new ArrayList<Item>();
		
		// Set DamageModificator
		damageModificators = new ArrayList<>();
		
		this.player = new Player("jonny", "The player on a lonely quest", 100.0, damageModificators, items, 0.0);
	}
	
	private void initAreas() {
		ArrayList<Item> items = null;
		Entity entity = null;
		ArrayList<INonPlayerEntity> entities = null;
		ArrayList<DamageModificator> damageModificators = null;
		
		// Generate Areas
		// Generate Area Whispering Hollow
		// Generate INonPlayerEntities for Whispering Hollow
		entities = new ArrayList<INonPlayerEntity>();
		// Generate Inventory of Monster Rootlurker
		items = new ArrayList<Item>();
		// Generate DamageModificators of Monster Rootlurker
		damageModificators = new ArrayList<>();
		entity = new Monster("Rootlurker", "Camouflaged plant-beasts that rise from the undergrowth.", 70.0, damageModificators, items, 0.0, 0.0, 1.0);
		entities.add((INonPlayerEntity) entity);
		
		// Generate Items for Whispering Hollow
		items = new ArrayList<Item>();
		items.add(new Item("Small Health Potion", "", 1.0, true, 1.0));
		
		// Add Area Whispering Hollow to list
		this.areas.add(new Area("Whispering Hollow", "Myterious and magical Forest", entities, items));
		// Generate Area Ironspire Citadel
		// Generate INonPlayerEntities for Ironspire Citadel
		entities = new ArrayList<INonPlayerEntity>();
		// Generate Inventory of Monster Sentry Drone
		items = new ArrayList<Item>();
		// Generate DamageModificators of Monster Sentry Drone
		damageModificators = new ArrayList<>();
		entity = new Monster("Sentry Drone", "Hovering security machines with rapid-fire lasers and scanning beams.", 20.0, damageModificators, items, 0.0, 0.0, 1.0);
		entities.add((INonPlayerEntity) entity);
		
		// Generate Items for Ironspire Citadel
		items = new ArrayList<Item>();
		
		// Add Area Ironspire Citadel to list
		this.areas.add(new Area("Ironspire Citadel", "Dystopian, futuristic Fortress City", entities, items));
		// Generate Area Sunken Temple of Marduun
		// Generate INonPlayerEntities for Sunken Temple of Marduun
		entities = new ArrayList<INonPlayerEntity>();
		// Generate Inventory of Monster Abyssal Siren
		items = new ArrayList<Item>();
		items.add(new Item("Sirenscale", "", 1.0, false, 1.0));
		// Generate DamageModificators of Monster Abyssal Siren
		damageModificators = new ArrayList<>();
		entity = new Monster("Abyssal Siren", "Eerie, aquatic creatures with haunting voices that lure intruders into traps.", 35.0, damageModificators, items, 0.0, 0.0, 1.0);
		entities.add((INonPlayerEntity) entity);
		
		// Generate Items for Sunken Temple of Marduun
		items = new ArrayList<Item>();
		
		// Add Area Sunken Temple of Marduun to list
		this.areas.add(new Area("Sunken Temple of Marduun", "Underwater Ruins", entities, items));
		// Generate Area Home
		// Generate INonPlayerEntities for Home
		entities = new ArrayList<INonPlayerEntity>();
		
		// Generate Items for Home
		items = new ArrayList<Item>();
		items.add(new Item("Rusty Sword", "", 15.0, false, 1.0));
		
		// Add Area Home to list
		this.areas.add(new Area("Home", "Spawnpoint", entities, items));
	}
	
	private void initConnections() {
		// Generate Connections
		this.connections.add(new Connection("H to WH", ""));
		this.connections.add(new Connection("WH to IC", ""));
		this.connections.add(new Connection("IC to ST", ""));
		this.connections.add(new Connection("ST to WH", ""));
	}
	
	private void initEffects() {
		// Generate Effects
		Effect effect = null;
		ArrayList<INonPlayerEntity> spawnEffectEntities = null;
		DamageModificator damageModificator = null;
		
		damageModificator = new DamageModificator("PoisonModificator", "", EDamageType.getDamageTypeByName("Poison"), 1.2);
		effect = new DamageModificatorEffect("Poison Attack", "", 1.0, damageModificator, false, 0);
		this.effects.add(effect);
		
		effect = new HealthEffect("Small Heal", "Heal yourself by 20hp", 1.0, 20.0, 1, true);
		this.effects.add(effect);
		
		effect = new EndGameEffect("End Game", "");
		this.effects.add(effect);
		
	}
	
	private void mapPlayerReferences() {
		ArrayList<Effect> effects = null;
		
		// Set Spawnpoint
		player.setPosition(findAreaByName("Home"));
		
		// Set Effects
		effects = new ArrayList<Effect>();
		this.player.setEffects(effects);
	}
	
	private void mapAreasAndConnections() {
		// Map Areas and Connections
		Connection connection = null;
		Area areaFrom = null;
		Area areaTo = null;
		
		// Get References for Connection H to WH
		connection = findConnectionByName("H to WH");
		areaFrom = findAreaByName("Home");
		areaTo = findAreaByName("Whispering Hollow");
		
		// Set Connection Attributes for Connection H to WH
		connection.setAreaA(areaFrom);
		connection.setAreaB(areaTo);
		
		// Set Area Attributes for Connection H to WH
		areaFrom.setConnection(connection, EDirection.NORTH);
		areaTo.setConnection(connection, EDirection.SOUTH);
		
		
		
		// Get References for Connection WH to IC
		connection = findConnectionByName("WH to IC");
		areaFrom = findAreaByName("Whispering Hollow");
		areaTo = findAreaByName("Ironspire Citadel");
		
		// Set Connection Attributes for Connection WH to IC
		connection.setAreaA(areaFrom);
		connection.setAreaB(areaTo);
		
		// Set Area Attributes for Connection WH to IC
		areaFrom.setConnection(connection, EDirection.NORTH);
		areaTo.setConnection(connection, EDirection.SOUTH);
		
		
		
		// Get References for Connection IC to ST
		connection = findConnectionByName("IC to ST");
		areaFrom = findAreaByName("Ironspire Citadel");
		areaTo = findAreaByName("Sunken Temple of Marduun");
		
		// Set Connection Attributes for Connection IC to ST
		connection.setAreaA(areaFrom);
		connection.setAreaB(areaTo);
		
		// Set Area Attributes for Connection IC to ST
		areaFrom.setConnection(connection, EDirection.NORTH);
		areaTo.setConnection(connection, EDirection.SOUTH);
		
		
		
		// Get References for Connection ST to WH
		connection = findConnectionByName("ST to WH");
		areaFrom = findAreaByName("Sunken Temple of Marduun");
		areaTo = findAreaByName("Whispering Hollow");
		
		// Set Connection Attributes for Connection ST to WH
		connection.setAreaA(areaFrom);
		connection.setAreaB(areaTo);
		
		// Set Area Attributes for Connection ST to WH
		areaFrom.setConnection(connection, EDirection.NORTH);
		areaTo.setConnection(connection, EDirection.SOUTH);
		
		// Set unlock Item references for ST to WH
		connection.setLocked(findItemByName("Sirenscale"));
		
		// Set onTraverseEffect for ST to WH
		connection.setOnTraverse(findEffectByName("End Game"));
		
		
		// Set Effects for Areas
		
		
		
		
	}
	
	private void mapEffectsOfItems() {
		Item item = null;
		Effect effect = null;
		Area spawnEffectArea = null;
		
		// Set Effects and DamageType for Item Small Health Potion
		item = findItemByName("Small Health Potion");
		item.setOnUse(findEffectByName("Small Heal"));
		
		// Set Effects and DamageType for Item Sirenscale
		item = findItemByName("Sirenscale");
		
		// Set Effects and DamageType for Item Rusty Sword
		item = findItemByName("Rusty Sword");
		item.setDamageType(EDamageType.getDamageTypeByName("Normal"));
		
		
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
		
		return null;
	}
	
	private Item findItemByName(String name) {
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
}
