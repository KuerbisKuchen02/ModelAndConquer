/**
 */
package ModelAndConquer;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see ModelAndConquer.ModelAndConquerFactory
 * @model kind="package"
 * @generated
 */
public interface ModelAndConquerPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ModelAndConquer";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://zdh.thm.de/modelandconquer";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "conquer";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelAndConquerPackage eINSTANCE = ModelAndConquer.impl.ModelAndConquerPackageImpl.init();

	/**
	 * The meta object id for the '{@link ModelAndConquer.impl.GenericGameElementImpl <em>Generic Game Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ModelAndConquer.impl.GenericGameElementImpl
	 * @see ModelAndConquer.impl.ModelAndConquerPackageImpl#getGenericGameElement()
	 * @generated
	 */
	int GENERIC_GAME_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_GAME_ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_GAME_ELEMENT__DESCRIPTION = 1;

	/**
	 * The number of structural features of the '<em>Generic Game Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_GAME_ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Generic Game Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_GAME_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ModelAndConquer.impl.GameImpl <em>Game</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ModelAndConquer.impl.GameImpl
	 * @see ModelAndConquer.impl.ModelAndConquerPackageImpl#getGame()
	 * @generated
	 */
	int GAME = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME__NAME = GENERIC_GAME_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME__DESCRIPTION = GENERIC_GAME_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Player</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME__PLAYER = GENERIC_GAME_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Start Area</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME__START_AREA = GENERIC_GAME_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Game Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME__GAME_ELEMENTS = GENERIC_GAME_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Game</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_FEATURE_COUNT = GENERIC_GAME_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Game</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_OPERATION_COUNT = GENERIC_GAME_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ModelAndConquer.impl.EntityImpl <em>Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ModelAndConquer.impl.EntityImpl
	 * @see ModelAndConquer.impl.ModelAndConquerPackageImpl#getEntity()
	 * @generated
	 */
	int ENTITY = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__NAME = GENERIC_GAME_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__DESCRIPTION = GENERIC_GAME_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Curr Health</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__CURR_HEALTH = GENERIC_GAME_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Max Health</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__MAX_HEALTH = GENERIC_GAME_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Inventory</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__INVENTORY = GENERIC_GAME_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Effects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__EFFECTS = GENERIC_GAME_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FEATURE_COUNT = GENERIC_GAME_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_OPERATION_COUNT = GENERIC_GAME_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ModelAndConquer.impl.PlayerImpl <em>Player</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ModelAndConquer.impl.PlayerImpl
	 * @see ModelAndConquer.impl.ModelAndConquerPackageImpl#getPlayer()
	 * @generated
	 */
	int PLAYER = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER__NAME = ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER__DESCRIPTION = ENTITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Curr Health</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER__CURR_HEALTH = ENTITY__CURR_HEALTH;

	/**
	 * The feature id for the '<em><b>Max Health</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER__MAX_HEALTH = ENTITY__MAX_HEALTH;

	/**
	 * The feature id for the '<em><b>Inventory</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER__INVENTORY = ENTITY__INVENTORY;

	/**
	 * The feature id for the '<em><b>Effects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER__EFFECTS = ENTITY__EFFECTS;

	/**
	 * The number of structural features of the '<em>Player</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Player</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER_OPERATION_COUNT = ENTITY_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link ModelAndConquer.impl.MonsterImpl <em>Monster</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ModelAndConquer.impl.MonsterImpl
	 * @see ModelAndConquer.impl.ModelAndConquerPackageImpl#getMonster()
	 * @generated
	 */
	int MONSTER = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONSTER__NAME = ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONSTER__DESCRIPTION = ENTITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Curr Health</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONSTER__CURR_HEALTH = ENTITY__CURR_HEALTH;

	/**
	 * The feature id for the '<em><b>Max Health</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONSTER__MAX_HEALTH = ENTITY__MAX_HEALTH;

	/**
	 * The feature id for the '<em><b>Inventory</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONSTER__INVENTORY = ENTITY__INVENTORY;

	/**
	 * The feature id for the '<em><b>Effects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONSTER__EFFECTS = ENTITY__EFFECTS;

	/**
	 * The feature id for the '<em><b>Weakness</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONSTER__WEAKNESS = ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resistance</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONSTER__RESISTANCE = ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>On Kill Effect</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONSTER__ON_KILL_EFFECT = ENTITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>On Spawn Effect</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONSTER__ON_SPAWN_EFFECT = ENTITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>On Hit Effect</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONSTER__ON_HIT_EFFECT = ENTITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>On Damage Effect</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONSTER__ON_DAMAGE_EFFECT = ENTITY_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Monster</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONSTER_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Monster</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONSTER_OPERATION_COUNT = ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ModelAndConquer.impl.AreaImpl <em>Area</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ModelAndConquer.impl.AreaImpl
	 * @see ModelAndConquer.impl.ModelAndConquerPackageImpl#getArea()
	 * @generated
	 */
	int AREA = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA__NAME = GENERIC_GAME_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA__DESCRIPTION = GENERIC_GAME_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA__CONNECTIONS = GENERIC_GAME_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Monster</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA__MONSTER = GENERIC_GAME_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Items</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA__ITEMS = GENERIC_GAME_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>On Enter Effect</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA__ON_ENTER_EFFECT = GENERIC_GAME_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Ascii Art</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA__ASCII_ART = GENERIC_GAME_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Area</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_FEATURE_COUNT = GENERIC_GAME_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Area</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_OPERATION_COUNT = GENERIC_GAME_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ModelAndConquer.impl.ConnectionImpl <em>Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ModelAndConquer.impl.ConnectionImpl
	 * @see ModelAndConquer.impl.ModelAndConquerPackageImpl#getConnection()
	 * @generated
	 */
	int CONNECTION = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__NAME = GENERIC_GAME_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__DESCRIPTION = GENERIC_GAME_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>On Traverse Effect</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__ON_TRAVERSE_EFFECT = GENERIC_GAME_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Unlocked With</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__UNLOCKED_WITH = GENERIC_GAME_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Locked</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__IS_LOCKED = GENERIC_GAME_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Areas</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__AREAS = GENERIC_GAME_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_FEATURE_COUNT = GENERIC_GAME_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_OPERATION_COUNT = GENERIC_GAME_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ModelAndConquer.impl.ItemImpl <em>Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ModelAndConquer.impl.ItemImpl
	 * @see ModelAndConquer.impl.ModelAndConquerPackageImpl#getItem()
	 * @generated
	 */
	int ITEM = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM__NAME = GENERIC_GAME_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM__DESCRIPTION = GENERIC_GAME_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Damage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM__DAMAGE = GENERIC_GAME_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Damage Type</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM__DAMAGE_TYPE = GENERIC_GAME_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Consumable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM__CONSUMABLE = GENERIC_GAME_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>On Drop Effect</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM__ON_DROP_EFFECT = GENERIC_GAME_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>On Pickup Effect</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM__ON_PICKUP_EFFECT = GENERIC_GAME_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>On Use Effect</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM__ON_USE_EFFECT = GENERIC_GAME_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_FEATURE_COUNT = GENERIC_GAME_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_OPERATION_COUNT = GENERIC_GAME_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ModelAndConquer.impl.EffectImpl <em>Effect</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ModelAndConquer.impl.EffectImpl
	 * @see ModelAndConquer.impl.ModelAndConquerPackageImpl#getEffect()
	 * @generated
	 */
	int EFFECT = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFECT__NAME = GENERIC_GAME_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFECT__DESCRIPTION = GENERIC_GAME_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFECT__DURATION = GENERIC_GAME_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Effect</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFECT_FEATURE_COUNT = GENERIC_GAME_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Effect</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFECT_OPERATION_COUNT = GENERIC_GAME_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ModelAndConquer.impl.DamageTypeImpl <em>Damage Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ModelAndConquer.impl.DamageTypeImpl
	 * @see ModelAndConquer.impl.ModelAndConquerPackageImpl#getDamageType()
	 * @generated
	 */
	int DAMAGE_TYPE = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAMAGE_TYPE__NAME = GENERIC_GAME_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAMAGE_TYPE__DESCRIPTION = GENERIC_GAME_ELEMENT__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Damage Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAMAGE_TYPE_FEATURE_COUNT = GENERIC_GAME_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Damage Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAMAGE_TYPE_OPERATION_COUNT = GENERIC_GAME_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ModelAndConquer.Directions <em>Directions</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ModelAndConquer.Directions
	 * @see ModelAndConquer.impl.ModelAndConquerPackageImpl#getDirections()
	 * @generated
	 */
	int DIRECTIONS = 10;


	/**
	 * Returns the meta object for class '{@link ModelAndConquer.Game <em>Game</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Game</em>'.
	 * @see ModelAndConquer.Game
	 * @generated
	 */
	EClass getGame();

	/**
	 * Returns the meta object for the containment reference '{@link ModelAndConquer.Game#getPlayer <em>Player</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Player</em>'.
	 * @see ModelAndConquer.Game#getPlayer()
	 * @see #getGame()
	 * @generated
	 */
	EReference getGame_Player();

	/**
	 * Returns the meta object for the containment reference '{@link ModelAndConquer.Game#getStartArea <em>Start Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Start Area</em>'.
	 * @see ModelAndConquer.Game#getStartArea()
	 * @see #getGame()
	 * @generated
	 */
	EReference getGame_StartArea();

	/**
	 * Returns the meta object for the containment reference list '{@link ModelAndConquer.Game#getGameElements <em>Game Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Game Elements</em>'.
	 * @see ModelAndConquer.Game#getGameElements()
	 * @see #getGame()
	 * @generated
	 */
	EReference getGame_GameElements();

	/**
	 * Returns the meta object for class '{@link ModelAndConquer.GenericGameElement <em>Generic Game Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generic Game Element</em>'.
	 * @see ModelAndConquer.GenericGameElement
	 * @generated
	 */
	EClass getGenericGameElement();

	/**
	 * Returns the meta object for the attribute '{@link ModelAndConquer.GenericGameElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ModelAndConquer.GenericGameElement#getName()
	 * @see #getGenericGameElement()
	 * @generated
	 */
	EAttribute getGenericGameElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link ModelAndConquer.GenericGameElement#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see ModelAndConquer.GenericGameElement#getDescription()
	 * @see #getGenericGameElement()
	 * @generated
	 */
	EAttribute getGenericGameElement_Description();

	/**
	 * Returns the meta object for class '{@link ModelAndConquer.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity</em>'.
	 * @see ModelAndConquer.Entity
	 * @generated
	 */
	EClass getEntity();

	/**
	 * Returns the meta object for the attribute '{@link ModelAndConquer.Entity#getCurrHealth <em>Curr Health</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Curr Health</em>'.
	 * @see ModelAndConquer.Entity#getCurrHealth()
	 * @see #getEntity()
	 * @generated
	 */
	EAttribute getEntity_CurrHealth();

	/**
	 * Returns the meta object for the attribute '{@link ModelAndConquer.Entity#getMaxHealth <em>Max Health</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Health</em>'.
	 * @see ModelAndConquer.Entity#getMaxHealth()
	 * @see #getEntity()
	 * @generated
	 */
	EAttribute getEntity_MaxHealth();

	/**
	 * Returns the meta object for the reference list '{@link ModelAndConquer.Entity#getInventory <em>Inventory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inventory</em>'.
	 * @see ModelAndConquer.Entity#getInventory()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_Inventory();

	/**
	 * Returns the meta object for the reference list '{@link ModelAndConquer.Entity#getEffects <em>Effects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Effects</em>'.
	 * @see ModelAndConquer.Entity#getEffects()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_Effects();

	/**
	 * Returns the meta object for class '{@link ModelAndConquer.Player <em>Player</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Player</em>'.
	 * @see ModelAndConquer.Player
	 * @generated
	 */
	EClass getPlayer();

	/**
	 * Returns the meta object for class '{@link ModelAndConquer.Monster <em>Monster</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Monster</em>'.
	 * @see ModelAndConquer.Monster
	 * @generated
	 */
	EClass getMonster();

	/**
	 * Returns the meta object for the reference list '{@link ModelAndConquer.Monster#getWeakness <em>Weakness</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Weakness</em>'.
	 * @see ModelAndConquer.Monster#getWeakness()
	 * @see #getMonster()
	 * @generated
	 */
	EReference getMonster_Weakness();

	/**
	 * Returns the meta object for the reference list '{@link ModelAndConquer.Monster#getResistance <em>Resistance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Resistance</em>'.
	 * @see ModelAndConquer.Monster#getResistance()
	 * @see #getMonster()
	 * @generated
	 */
	EReference getMonster_Resistance();

	/**
	 * Returns the meta object for the reference list '{@link ModelAndConquer.Monster#getOnKillEffect <em>On Kill Effect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>On Kill Effect</em>'.
	 * @see ModelAndConquer.Monster#getOnKillEffect()
	 * @see #getMonster()
	 * @generated
	 */
	EReference getMonster_OnKillEffect();

	/**
	 * Returns the meta object for the reference list '{@link ModelAndConquer.Monster#getOnSpawnEffect <em>On Spawn Effect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>On Spawn Effect</em>'.
	 * @see ModelAndConquer.Monster#getOnSpawnEffect()
	 * @see #getMonster()
	 * @generated
	 */
	EReference getMonster_OnSpawnEffect();

	/**
	 * Returns the meta object for the reference list '{@link ModelAndConquer.Monster#getOnHitEffect <em>On Hit Effect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>On Hit Effect</em>'.
	 * @see ModelAndConquer.Monster#getOnHitEffect()
	 * @see #getMonster()
	 * @generated
	 */
	EReference getMonster_OnHitEffect();

	/**
	 * Returns the meta object for the reference list '{@link ModelAndConquer.Monster#getOnDamageEffect <em>On Damage Effect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>On Damage Effect</em>'.
	 * @see ModelAndConquer.Monster#getOnDamageEffect()
	 * @see #getMonster()
	 * @generated
	 */
	EReference getMonster_OnDamageEffect();

	/**
	 * Returns the meta object for class '{@link ModelAndConquer.Area <em>Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Area</em>'.
	 * @see ModelAndConquer.Area
	 * @generated
	 */
	EClass getArea();

	/**
	 * Returns the meta object for the reference list '{@link ModelAndConquer.Area#getConnections <em>Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Connections</em>'.
	 * @see ModelAndConquer.Area#getConnections()
	 * @see #getArea()
	 * @generated
	 */
	EReference getArea_Connections();

	/**
	 * Returns the meta object for the reference list '{@link ModelAndConquer.Area#getMonster <em>Monster</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Monster</em>'.
	 * @see ModelAndConquer.Area#getMonster()
	 * @see #getArea()
	 * @generated
	 */
	EReference getArea_Monster();

	/**
	 * Returns the meta object for the reference list '{@link ModelAndConquer.Area#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Items</em>'.
	 * @see ModelAndConquer.Area#getItems()
	 * @see #getArea()
	 * @generated
	 */
	EReference getArea_Items();

	/**
	 * Returns the meta object for the reference list '{@link ModelAndConquer.Area#getOnEnterEffect <em>On Enter Effect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>On Enter Effect</em>'.
	 * @see ModelAndConquer.Area#getOnEnterEffect()
	 * @see #getArea()
	 * @generated
	 */
	EReference getArea_OnEnterEffect();

	/**
	 * Returns the meta object for the attribute '{@link ModelAndConquer.Area#getAsciiArt <em>Ascii Art</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ascii Art</em>'.
	 * @see ModelAndConquer.Area#getAsciiArt()
	 * @see #getArea()
	 * @generated
	 */
	EAttribute getArea_AsciiArt();

	/**
	 * Returns the meta object for class '{@link ModelAndConquer.Connection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection</em>'.
	 * @see ModelAndConquer.Connection
	 * @generated
	 */
	EClass getConnection();

	/**
	 * Returns the meta object for the reference list '{@link ModelAndConquer.Connection#getOnTraverseEffect <em>On Traverse Effect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>On Traverse Effect</em>'.
	 * @see ModelAndConquer.Connection#getOnTraverseEffect()
	 * @see #getConnection()
	 * @generated
	 */
	EReference getConnection_OnTraverseEffect();

	/**
	 * Returns the meta object for the reference list '{@link ModelAndConquer.Connection#getUnlockedWith <em>Unlocked With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Unlocked With</em>'.
	 * @see ModelAndConquer.Connection#getUnlockedWith()
	 * @see #getConnection()
	 * @generated
	 */
	EReference getConnection_UnlockedWith();

	/**
	 * Returns the meta object for the attribute '{@link ModelAndConquer.Connection#isIsLocked <em>Is Locked</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Locked</em>'.
	 * @see ModelAndConquer.Connection#isIsLocked()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_IsLocked();

	/**
	 * Returns the meta object for the reference list '{@link ModelAndConquer.Connection#getAreas <em>Areas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Areas</em>'.
	 * @see ModelAndConquer.Connection#getAreas()
	 * @see #getConnection()
	 * @generated
	 */
	EReference getConnection_Areas();

	/**
	 * Returns the meta object for class '{@link ModelAndConquer.Item <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Item</em>'.
	 * @see ModelAndConquer.Item
	 * @generated
	 */
	EClass getItem();

	/**
	 * Returns the meta object for the attribute '{@link ModelAndConquer.Item#getDamage <em>Damage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Damage</em>'.
	 * @see ModelAndConquer.Item#getDamage()
	 * @see #getItem()
	 * @generated
	 */
	EAttribute getItem_Damage();

	/**
	 * Returns the meta object for the reference list '{@link ModelAndConquer.Item#getDamageType <em>Damage Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Damage Type</em>'.
	 * @see ModelAndConquer.Item#getDamageType()
	 * @see #getItem()
	 * @generated
	 */
	EReference getItem_DamageType();

	/**
	 * Returns the meta object for the attribute '{@link ModelAndConquer.Item#isConsumable <em>Consumable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Consumable</em>'.
	 * @see ModelAndConquer.Item#isConsumable()
	 * @see #getItem()
	 * @generated
	 */
	EAttribute getItem_Consumable();

	/**
	 * Returns the meta object for the reference list '{@link ModelAndConquer.Item#getOnDropEffect <em>On Drop Effect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>On Drop Effect</em>'.
	 * @see ModelAndConquer.Item#getOnDropEffect()
	 * @see #getItem()
	 * @generated
	 */
	EReference getItem_OnDropEffect();

	/**
	 * Returns the meta object for the reference list '{@link ModelAndConquer.Item#getOnPickupEffect <em>On Pickup Effect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>On Pickup Effect</em>'.
	 * @see ModelAndConquer.Item#getOnPickupEffect()
	 * @see #getItem()
	 * @generated
	 */
	EReference getItem_OnPickupEffect();

	/**
	 * Returns the meta object for the reference list '{@link ModelAndConquer.Item#getOnUseEffect <em>On Use Effect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>On Use Effect</em>'.
	 * @see ModelAndConquer.Item#getOnUseEffect()
	 * @see #getItem()
	 * @generated
	 */
	EReference getItem_OnUseEffect();

	/**
	 * Returns the meta object for class '{@link ModelAndConquer.Effect <em>Effect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Effect</em>'.
	 * @see ModelAndConquer.Effect
	 * @generated
	 */
	EClass getEffect();

	/**
	 * Returns the meta object for the attribute '{@link ModelAndConquer.Effect#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration</em>'.
	 * @see ModelAndConquer.Effect#getDuration()
	 * @see #getEffect()
	 * @generated
	 */
	EAttribute getEffect_Duration();

	/**
	 * Returns the meta object for class '{@link ModelAndConquer.DamageType <em>Damage Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Damage Type</em>'.
	 * @see ModelAndConquer.DamageType
	 * @generated
	 */
	EClass getDamageType();

	/**
	 * Returns the meta object for enum '{@link ModelAndConquer.Directions <em>Directions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Directions</em>'.
	 * @see ModelAndConquer.Directions
	 * @generated
	 */
	EEnum getDirections();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelAndConquerFactory getModelAndConquerFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link ModelAndConquer.impl.GameImpl <em>Game</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ModelAndConquer.impl.GameImpl
		 * @see ModelAndConquer.impl.ModelAndConquerPackageImpl#getGame()
		 * @generated
		 */
		EClass GAME = eINSTANCE.getGame();
		/**
		 * The meta object literal for the '<em><b>Player</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GAME__PLAYER = eINSTANCE.getGame_Player();
		/**
		 * The meta object literal for the '<em><b>Start Area</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GAME__START_AREA = eINSTANCE.getGame_StartArea();
		/**
		 * The meta object literal for the '<em><b>Game Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GAME__GAME_ELEMENTS = eINSTANCE.getGame_GameElements();
		/**
		 * The meta object literal for the '{@link ModelAndConquer.impl.GenericGameElementImpl <em>Generic Game Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ModelAndConquer.impl.GenericGameElementImpl
		 * @see ModelAndConquer.impl.ModelAndConquerPackageImpl#getGenericGameElement()
		 * @generated
		 */
		EClass GENERIC_GAME_ELEMENT = eINSTANCE.getGenericGameElement();
		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERIC_GAME_ELEMENT__NAME = eINSTANCE.getGenericGameElement_Name();
		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERIC_GAME_ELEMENT__DESCRIPTION = eINSTANCE.getGenericGameElement_Description();
		/**
		 * The meta object literal for the '{@link ModelAndConquer.impl.EntityImpl <em>Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ModelAndConquer.impl.EntityImpl
		 * @see ModelAndConquer.impl.ModelAndConquerPackageImpl#getEntity()
		 * @generated
		 */
		EClass ENTITY = eINSTANCE.getEntity();
		/**
		 * The meta object literal for the '<em><b>Curr Health</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY__CURR_HEALTH = eINSTANCE.getEntity_CurrHealth();
		/**
		 * The meta object literal for the '<em><b>Max Health</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY__MAX_HEALTH = eINSTANCE.getEntity_MaxHealth();
		/**
		 * The meta object literal for the '<em><b>Inventory</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__INVENTORY = eINSTANCE.getEntity_Inventory();
		/**
		 * The meta object literal for the '<em><b>Effects</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__EFFECTS = eINSTANCE.getEntity_Effects();
		/**
		 * The meta object literal for the '{@link ModelAndConquer.impl.PlayerImpl <em>Player</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ModelAndConquer.impl.PlayerImpl
		 * @see ModelAndConquer.impl.ModelAndConquerPackageImpl#getPlayer()
		 * @generated
		 */
		EClass PLAYER = eINSTANCE.getPlayer();
		/**
		 * The meta object literal for the '{@link ModelAndConquer.impl.MonsterImpl <em>Monster</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ModelAndConquer.impl.MonsterImpl
		 * @see ModelAndConquer.impl.ModelAndConquerPackageImpl#getMonster()
		 * @generated
		 */
		EClass MONSTER = eINSTANCE.getMonster();
		/**
		 * The meta object literal for the '<em><b>Weakness</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MONSTER__WEAKNESS = eINSTANCE.getMonster_Weakness();
		/**
		 * The meta object literal for the '<em><b>Resistance</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MONSTER__RESISTANCE = eINSTANCE.getMonster_Resistance();
		/**
		 * The meta object literal for the '<em><b>On Kill Effect</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MONSTER__ON_KILL_EFFECT = eINSTANCE.getMonster_OnKillEffect();
		/**
		 * The meta object literal for the '<em><b>On Spawn Effect</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MONSTER__ON_SPAWN_EFFECT = eINSTANCE.getMonster_OnSpawnEffect();
		/**
		 * The meta object literal for the '<em><b>On Hit Effect</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MONSTER__ON_HIT_EFFECT = eINSTANCE.getMonster_OnHitEffect();
		/**
		 * The meta object literal for the '<em><b>On Damage Effect</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MONSTER__ON_DAMAGE_EFFECT = eINSTANCE.getMonster_OnDamageEffect();
		/**
		 * The meta object literal for the '{@link ModelAndConquer.impl.AreaImpl <em>Area</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ModelAndConquer.impl.AreaImpl
		 * @see ModelAndConquer.impl.ModelAndConquerPackageImpl#getArea()
		 * @generated
		 */
		EClass AREA = eINSTANCE.getArea();
		/**
		 * The meta object literal for the '<em><b>Connections</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AREA__CONNECTIONS = eINSTANCE.getArea_Connections();
		/**
		 * The meta object literal for the '<em><b>Monster</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AREA__MONSTER = eINSTANCE.getArea_Monster();
		/**
		 * The meta object literal for the '<em><b>Items</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AREA__ITEMS = eINSTANCE.getArea_Items();
		/**
		 * The meta object literal for the '<em><b>On Enter Effect</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AREA__ON_ENTER_EFFECT = eINSTANCE.getArea_OnEnterEffect();
		/**
		 * The meta object literal for the '<em><b>Ascii Art</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AREA__ASCII_ART = eINSTANCE.getArea_AsciiArt();
		/**
		 * The meta object literal for the '{@link ModelAndConquer.impl.ConnectionImpl <em>Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ModelAndConquer.impl.ConnectionImpl
		 * @see ModelAndConquer.impl.ModelAndConquerPackageImpl#getConnection()
		 * @generated
		 */
		EClass CONNECTION = eINSTANCE.getConnection();
		/**
		 * The meta object literal for the '<em><b>On Traverse Effect</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION__ON_TRAVERSE_EFFECT = eINSTANCE.getConnection_OnTraverseEffect();
		/**
		 * The meta object literal for the '<em><b>Unlocked With</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION__UNLOCKED_WITH = eINSTANCE.getConnection_UnlockedWith();
		/**
		 * The meta object literal for the '<em><b>Is Locked</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__IS_LOCKED = eINSTANCE.getConnection_IsLocked();
		/**
		 * The meta object literal for the '<em><b>Areas</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION__AREAS = eINSTANCE.getConnection_Areas();
		/**
		 * The meta object literal for the '{@link ModelAndConquer.impl.ItemImpl <em>Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ModelAndConquer.impl.ItemImpl
		 * @see ModelAndConquer.impl.ModelAndConquerPackageImpl#getItem()
		 * @generated
		 */
		EClass ITEM = eINSTANCE.getItem();
		/**
		 * The meta object literal for the '<em><b>Damage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITEM__DAMAGE = eINSTANCE.getItem_Damage();
		/**
		 * The meta object literal for the '<em><b>Damage Type</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITEM__DAMAGE_TYPE = eINSTANCE.getItem_DamageType();
		/**
		 * The meta object literal for the '<em><b>Consumable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITEM__CONSUMABLE = eINSTANCE.getItem_Consumable();
		/**
		 * The meta object literal for the '<em><b>On Drop Effect</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITEM__ON_DROP_EFFECT = eINSTANCE.getItem_OnDropEffect();
		/**
		 * The meta object literal for the '<em><b>On Pickup Effect</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITEM__ON_PICKUP_EFFECT = eINSTANCE.getItem_OnPickupEffect();
		/**
		 * The meta object literal for the '<em><b>On Use Effect</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITEM__ON_USE_EFFECT = eINSTANCE.getItem_OnUseEffect();
		/**
		 * The meta object literal for the '{@link ModelAndConquer.impl.EffectImpl <em>Effect</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ModelAndConquer.impl.EffectImpl
		 * @see ModelAndConquer.impl.ModelAndConquerPackageImpl#getEffect()
		 * @generated
		 */
		EClass EFFECT = eINSTANCE.getEffect();
		/**
		 * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EFFECT__DURATION = eINSTANCE.getEffect_Duration();
		/**
		 * The meta object literal for the '{@link ModelAndConquer.impl.DamageTypeImpl <em>Damage Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ModelAndConquer.impl.DamageTypeImpl
		 * @see ModelAndConquer.impl.ModelAndConquerPackageImpl#getDamageType()
		 * @generated
		 */
		EClass DAMAGE_TYPE = eINSTANCE.getDamageType();
		/**
		 * The meta object literal for the '{@link ModelAndConquer.Directions <em>Directions</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ModelAndConquer.Directions
		 * @see ModelAndConquer.impl.ModelAndConquerPackageImpl#getDirections()
		 * @generated
		 */
		EEnum DIRECTIONS = eINSTANCE.getDirections();

	}

} //ModelAndConquerPackage
