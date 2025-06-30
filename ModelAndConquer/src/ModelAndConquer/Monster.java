/**
 */
package ModelAndConquer;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Monster</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ModelAndConquer.Monster#getWeakness <em>Weakness</em>}</li>
 *   <li>{@link ModelAndConquer.Monster#getResistance <em>Resistance</em>}</li>
 *   <li>{@link ModelAndConquer.Monster#getOnKillEffect <em>On Kill Effect</em>}</li>
 *   <li>{@link ModelAndConquer.Monster#getOnSpawnEffect <em>On Spawn Effect</em>}</li>
 *   <li>{@link ModelAndConquer.Monster#getOnHitEffect <em>On Hit Effect</em>}</li>
 *   <li>{@link ModelAndConquer.Monster#getOnDamageEffect <em>On Damage Effect</em>}</li>
 * </ul>
 *
 * @see ModelAndConquer.ModelAndConquerPackage#getMonster()
 * @model
 * @generated
 */
public interface Monster extends Entity {
	/**
	 * Returns the value of the '<em><b>Weakness</b></em>' reference list.
	 * The list contents are of type {@link ModelAndConquer.DamageType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weakness</em>' reference list.
	 * @see ModelAndConquer.ModelAndConquerPackage#getMonster_Weakness()
	 * @model
	 * @generated
	 */
	EList<DamageType> getWeakness();

	/**
	 * Returns the value of the '<em><b>Resistance</b></em>' reference list.
	 * The list contents are of type {@link ModelAndConquer.DamageType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resistance</em>' reference list.
	 * @see ModelAndConquer.ModelAndConquerPackage#getMonster_Resistance()
	 * @model
	 * @generated
	 */
	EList<DamageType> getResistance();

	/**
	 * Returns the value of the '<em><b>On Kill Effect</b></em>' reference list.
	 * The list contents are of type {@link ModelAndConquer.Effect}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Kill Effect</em>' reference list.
	 * @see ModelAndConquer.ModelAndConquerPackage#getMonster_OnKillEffect()
	 * @model
	 * @generated
	 */
	EList<Effect> getOnKillEffect();

	/**
	 * Returns the value of the '<em><b>On Spawn Effect</b></em>' reference list.
	 * The list contents are of type {@link ModelAndConquer.Effect}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Spawn Effect</em>' reference list.
	 * @see ModelAndConquer.ModelAndConquerPackage#getMonster_OnSpawnEffect()
	 * @model
	 * @generated
	 */
	EList<Effect> getOnSpawnEffect();

	/**
	 * Returns the value of the '<em><b>On Hit Effect</b></em>' reference list.
	 * The list contents are of type {@link ModelAndConquer.Effect}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Hit Effect</em>' reference list.
	 * @see ModelAndConquer.ModelAndConquerPackage#getMonster_OnHitEffect()
	 * @model
	 * @generated
	 */
	EList<Effect> getOnHitEffect();

	/**
	 * Returns the value of the '<em><b>On Damage Effect</b></em>' reference list.
	 * The list contents are of type {@link ModelAndConquer.Effect}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Damage Effect</em>' reference list.
	 * @see ModelAndConquer.ModelAndConquerPackage#getMonster_OnDamageEffect()
	 * @model
	 * @generated
	 */
	EList<Effect> getOnDamageEffect();

} // Monster
