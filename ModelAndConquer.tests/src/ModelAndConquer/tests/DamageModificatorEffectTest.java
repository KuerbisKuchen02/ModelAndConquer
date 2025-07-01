/**
 */
package ModelAndConquer.tests;

import ModelAndConquer.DamageModificatorEffect;
import ModelAndConquer.ModelAndConquerFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Damage Modificator Effect</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DamageModificatorEffectTest extends EffectTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DamageModificatorEffectTest.class);
	}

	/**
	 * Constructs a new Damage Modificator Effect test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DamageModificatorEffectTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Damage Modificator Effect test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected DamageModificatorEffect getFixture() {
		return (DamageModificatorEffect)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ModelAndConquerFactory.eINSTANCE.createDamageModificatorEffect());
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

} //DamageModificatorEffectTest
