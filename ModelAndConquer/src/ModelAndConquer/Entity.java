/**
 */
package ModelAndConquer;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ModelAndConquer.Entity#getCurrHealth <em>Curr Health</em>}</li>
 *   <li>{@link ModelAndConquer.Entity#getMaxHealth <em>Max Health</em>}</li>
 *   <li>{@link ModelAndConquer.Entity#getInventory <em>Inventory</em>}</li>
 *   <li>{@link ModelAndConquer.Entity#getEffects <em>Effects</em>}</li>
 * </ul>
 *
 * @see ModelAndConquer.ModelAndConquerPackage#getEntity()
 * @model abstract="true"
 * @generated
 */
public interface Entity extends GenericGameElement {
	/**
	 * Returns the value of the '<em><b>Curr Health</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Curr Health</em>' attribute.
	 * @see #setCurrHealth(double)
	 * @see ModelAndConquer.ModelAndConquerPackage#getEntity_CurrHealth()
	 * @model required="true"
	 * @generated
	 */
	double getCurrHealth();

	/**
	 * Sets the value of the '{@link ModelAndConquer.Entity#getCurrHealth <em>Curr Health</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Curr Health</em>' attribute.
	 * @see #getCurrHealth()
	 * @generated
	 */
	void setCurrHealth(double value);

	/**
	 * Returns the value of the '<em><b>Max Health</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Health</em>' attribute.
	 * @see #setMaxHealth(double)
	 * @see ModelAndConquer.ModelAndConquerPackage#getEntity_MaxHealth()
	 * @model required="true"
	 * @generated
	 */
	double getMaxHealth();

	/**
	 * Sets the value of the '{@link ModelAndConquer.Entity#getMaxHealth <em>Max Health</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Health</em>' attribute.
	 * @see #getMaxHealth()
	 * @generated
	 */
	void setMaxHealth(double value);

	/**
	 * Returns the value of the '<em><b>Inventory</b></em>' reference list.
	 * The list contents are of type {@link ModelAndConquer.Item}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inventory</em>' reference list.
	 * @see ModelAndConquer.ModelAndConquerPackage#getEntity_Inventory()
	 * @model
	 * @generated
	 */
	EList<Item> getInventory();

	/**
	 * Returns the value of the '<em><b>Effects</b></em>' reference list.
	 * The list contents are of type {@link ModelAndConquer.Effect}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Effects</em>' reference list.
	 * @see ModelAndConquer.ModelAndConquerPackage#getEntity_Effects()
	 * @model
	 * @generated
	 */
	EList<Effect> getEffects();

} // Entity
