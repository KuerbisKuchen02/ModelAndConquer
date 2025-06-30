/**
 */
package ModelAndConquer;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ModelAndConquer.Connection#getOnTraverseEffect <em>On Traverse Effect</em>}</li>
 *   <li>{@link ModelAndConquer.Connection#getUnlockedWith <em>Unlocked With</em>}</li>
 *   <li>{@link ModelAndConquer.Connection#isIsLocked <em>Is Locked</em>}</li>
 *   <li>{@link ModelAndConquer.Connection#getAreas <em>Areas</em>}</li>
 * </ul>
 *
 * @see ModelAndConquer.ModelAndConquerPackage#getConnection()
 * @model
 * @generated
 */
public interface Connection extends GenericGameElement {
	/**
	 * Returns the value of the '<em><b>On Traverse Effect</b></em>' reference list.
	 * The list contents are of type {@link ModelAndConquer.Effect}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Traverse Effect</em>' reference list.
	 * @see ModelAndConquer.ModelAndConquerPackage#getConnection_OnTraverseEffect()
	 * @model
	 * @generated
	 */
	EList<Effect> getOnTraverseEffect();

	/**
	 * Returns the value of the '<em><b>Unlocked With</b></em>' reference list.
	 * The list contents are of type {@link ModelAndConquer.Item}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unlocked With</em>' reference list.
	 * @see ModelAndConquer.ModelAndConquerPackage#getConnection_UnlockedWith()
	 * @model
	 * @generated
	 */
	EList<Item> getUnlockedWith();

	/**
	 * Returns the value of the '<em><b>Is Locked</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Locked</em>' attribute.
	 * @see #setIsLocked(boolean)
	 * @see ModelAndConquer.ModelAndConquerPackage#getConnection_IsLocked()
	 * @model required="true"
	 * @generated
	 */
	boolean isIsLocked();

	/**
	 * Sets the value of the '{@link ModelAndConquer.Connection#isIsLocked <em>Is Locked</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Locked</em>' attribute.
	 * @see #isIsLocked()
	 * @generated
	 */
	void setIsLocked(boolean value);

	/**
	 * Returns the value of the '<em><b>Areas</b></em>' reference list.
	 * The list contents are of type {@link ModelAndConquer.Area}.
	 * It is bidirectional and its opposite is '{@link ModelAndConquer.Area#getConnections <em>Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Areas</em>' reference list.
	 * @see ModelAndConquer.ModelAndConquerPackage#getConnection_Areas()
	 * @see ModelAndConquer.Area#getConnections
	 * @model opposite="connections" lower="2"
	 * @generated
	 */
	EList<Area> getAreas();

} // Connection
