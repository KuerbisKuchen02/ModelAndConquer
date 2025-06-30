/**
 */
package ModelAndConquer;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Area</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ModelAndConquer.Area#getConnections <em>Connections</em>}</li>
 *   <li>{@link ModelAndConquer.Area#getMonster <em>Monster</em>}</li>
 *   <li>{@link ModelAndConquer.Area#getItems <em>Items</em>}</li>
 *   <li>{@link ModelAndConquer.Area#getOnEnterEffect <em>On Enter Effect</em>}</li>
 *   <li>{@link ModelAndConquer.Area#getAsciiArt <em>Ascii Art</em>}</li>
 * </ul>
 *
 * @see ModelAndConquer.ModelAndConquerPackage#getArea()
 * @model
 * @generated
 */
public interface Area extends GenericGameElement {
	/**
	 * Returns the value of the '<em><b>Connections</b></em>' reference list.
	 * The list contents are of type {@link ModelAndConquer.Connection}.
	 * It is bidirectional and its opposite is '{@link ModelAndConquer.Connection#getAreas <em>Areas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connections</em>' reference list.
	 * @see ModelAndConquer.ModelAndConquerPackage#getArea_Connections()
	 * @see ModelAndConquer.Connection#getAreas
	 * @model opposite="areas" upper="6"
	 * @generated
	 */
	EList<Connection> getConnections();

	/**
	 * Returns the value of the '<em><b>Monster</b></em>' reference list.
	 * The list contents are of type {@link ModelAndConquer.Monster}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Monster</em>' reference list.
	 * @see ModelAndConquer.ModelAndConquerPackage#getArea_Monster()
	 * @model
	 * @generated
	 */
	EList<Monster> getMonster();

	/**
	 * Returns the value of the '<em><b>Items</b></em>' reference list.
	 * The list contents are of type {@link ModelAndConquer.Item}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Items</em>' reference list.
	 * @see ModelAndConquer.ModelAndConquerPackage#getArea_Items()
	 * @model
	 * @generated
	 */
	EList<Item> getItems();

	/**
	 * Returns the value of the '<em><b>On Enter Effect</b></em>' reference list.
	 * The list contents are of type {@link ModelAndConquer.Effect}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Enter Effect</em>' reference list.
	 * @see ModelAndConquer.ModelAndConquerPackage#getArea_OnEnterEffect()
	 * @model
	 * @generated
	 */
	EList<Effect> getOnEnterEffect();

	/**
	 * Returns the value of the '<em><b>Ascii Art</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ascii Art</em>' attribute.
	 * @see #setAsciiArt(String)
	 * @see ModelAndConquer.ModelAndConquerPackage#getArea_AsciiArt()
	 * @model required="true"
	 * @generated
	 */
	String getAsciiArt();

	/**
	 * Sets the value of the '{@link ModelAndConquer.Area#getAsciiArt <em>Ascii Art</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ascii Art</em>' attribute.
	 * @see #getAsciiArt()
	 * @generated
	 */
	void setAsciiArt(String value);

} // Area
