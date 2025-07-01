/**
 */
package ModelAndConquer.tests;

import ModelAndConquer.ModelAndConquerFactory;
import ModelAndConquer.SpawnEffect;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Spawn Effect</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SpawnEffectTest extends EffectTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SpawnEffectTest.class);
	}

	/**
	 * Constructs a new Spawn Effect test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpawnEffectTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Spawn Effect test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SpawnEffect getFixture() {
		return (SpawnEffect)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ModelAndConquerFactory.eINSTANCE.createSpawnEffect());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //SpawnEffectTest
