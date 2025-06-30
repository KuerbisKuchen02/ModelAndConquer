/**
 */
package ModelAndConquer;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ModelAndConquer.Item#getDamage <em>Damage</em>}</li>
 *   <li>{@link ModelAndConquer.Item#getDamageType <em>Damage Type</em>}</li>
 *   <li>{@link ModelAndConquer.Item#isConsumable <em>Consumable</em>}</li>
 *   <li>{@link ModelAndConquer.Item#getOnDropEffect <em>On Drop Effect</em>}</li>
 *   <li>{@link ModelAndConquer.Item#getOnPickupEffect <em>On Pickup Effect</em>}</li>
 *   <li>{@link ModelAndConquer.Item#getOnUseEffect <em>On Use Effect</em>}</li>
 * </ul>
 *
 * @see ModelAndConquer.ModelAndConquerPackage#getItem()
 * @model
 * @generated
 */
public interface Item extends GenericGameElement {
	/**
	 * Returns the value of the '<em><b>Damage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Damage</em>' attribute.
	 * @see #setDamage(double)
	 * @see ModelAndConquer.ModelAndConquerPackage#getItem_Damage()
	 * @model required="true"
	 * @generated
	 */
	double getDamage();

	/**
	 * Sets the value of the '{@link ModelAndConquer.Item#getDamage <em>Damage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Damage</em>' attribute.
	 * @see #getDamage()
	 * @generated
	 */
	void setDamage(double value);

	/**
	 * Returns the value of the '<em><b>Damage Type</b></em>' reference list.
	 * The list contents are of type {@link ModelAndConquer.DamageType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Damage Type</em>' reference list.
	 * @see ModelAndConquer.ModelAndConquerPackage#getItem_DamageType()
	 * @model required="true"
	 * @generated
	 */
	EList<DamageType> getDamageType();

	/**
	 * Returns the value of the '<em><b>Consumable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Consumable</em>' attribute.
	 * @see #setConsumable(boolean)
	 * @see ModelAndConquer.ModelAndConquerPackage#getItem_Consumable()
	 * @model required="true"
	 * @generated
	 */
	boolean isConsumable();

	/**
	 * Sets the value of the '{@link ModelAndConquer.Item#isConsumable <em>Consumable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Consumable</em>' attribute.
	 * @see #isConsumable()
	 * @generated
	 */
	void setConsumable(boolean value);

	/**
	 * Returns the value of the '<em><b>On Drop Effect</b></em>' reference list.
	 * The list contents are of type {@link ModelAndConquer.Effect}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Drop Effect</em>' reference list.
	 * @see ModelAndConquer.ModelAndConquerPackage#getItem_OnDropEffect()
	 * @model
	 * @generated
	 */
	EList<Effect> getOnDropEffect();

	/**
	 * Returns the value of the '<em><b>On Pickup Effect</b></em>' reference list.
	 * The list contents are of type {@link ModelAndConquer.Effect}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Pickup Effect</em>' reference list.
	 * @see ModelAndConquer.ModelAndConquerPackage#getItem_OnPickupEffect()
	 * @model
	 * @generated
	 */
	EList<Effect> getOnPickupEffect();

	/**
	 * Returns the value of the '<em><b>On Use Effect</b></em>' reference list.
	 * The list contents are of type {@link ModelAndConquer.Effect}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Use Effect</em>' reference list.
	 * @see ModelAndConquer.ModelAndConquerPackage#getItem_OnUseEffect()
	 * @model
	 * @generated
	 */
	EList<Effect> getOnUseEffect();

} // Item
