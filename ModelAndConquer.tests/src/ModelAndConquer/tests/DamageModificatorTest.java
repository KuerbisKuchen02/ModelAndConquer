/**
 */
package ModelAndConquer.tests;

import ModelAndConquer.DamageModificator;
import ModelAndConquer.ModelAndConquerFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Damage Modificator</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DamageModificatorTest extends GenericElementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DamageModificatorTest.class);
	}

	/**
	 * Constructs a new Damage Modificator test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DamageModificatorTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Damage Modificator test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected DamageModificator getFixture() {
		return (DamageModificator)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ModelAndConquerFactory.eINSTANCE.createDamageModificator());
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

} //DamageModificatorTest
