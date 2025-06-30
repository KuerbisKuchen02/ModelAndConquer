/**
 */
package ModelAndConquer;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Game</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ModelAndConquer.Game#getPlayer <em>Player</em>}</li>
 *   <li>{@link ModelAndConquer.Game#getStartArea <em>Start Area</em>}</li>
 *   <li>{@link ModelAndConquer.Game#getGameElements <em>Game Elements</em>}</li>
 * </ul>
 *
 * @see ModelAndConquer.ModelAndConquerPackage#getGame()
 * @model
 * @generated
 */
public interface Game extends GenericGameElement {
	/**
	 * Returns the value of the '<em><b>Player</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Player</em>' containment reference.
	 * @see #setPlayer(Player)
	 * @see ModelAndConquer.ModelAndConquerPackage#getGame_Player()
	 * @model containment="true"
	 * @generated
	 */
	Player getPlayer();

	/**
	 * Sets the value of the '{@link ModelAndConquer.Game#getPlayer <em>Player</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Player</em>' containment reference.
	 * @see #getPlayer()
	 * @generated
	 */
	void setPlayer(Player value);

	/**
	 * Returns the value of the '<em><b>Start Area</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Area</em>' containment reference.
	 * @see #setStartArea(Area)
	 * @see ModelAndConquer.ModelAndConquerPackage#getGame_StartArea()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Area getStartArea();

	/**
	 * Sets the value of the '{@link ModelAndConquer.Game#getStartArea <em>Start Area</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Area</em>' containment reference.
	 * @see #getStartArea()
	 * @generated
	 */
	void setStartArea(Area value);

	/**
	 * Returns the value of the '<em><b>Game Elements</b></em>' containment reference list.
	 * The list contents are of type {@link ModelAndConquer.GenericGameElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Game Elements</em>' containment reference list.
	 * @see ModelAndConquer.ModelAndConquerPackage#getGame_GameElements()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<GenericGameElement> getGameElements();

} // Game
