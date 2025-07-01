/**
 */
package ModelAndConquer.tests;

import ModelAndConquer.EndGameEffect;
import ModelAndConquer.ModelAndConquerFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>End Game Effect</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class EndGameEffectTest extends EffectTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(EndGameEffectTest.class);
	}

	/**
	 * Constructs a new End Game Effect test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndGameEffectTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this End Game Effect test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EndGameEffect getFixture() {
		return (EndGameEffect)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ModelAndConquerFactory.eINSTANCE.createEndGameEffect());
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

} //EndGameEffectTest
