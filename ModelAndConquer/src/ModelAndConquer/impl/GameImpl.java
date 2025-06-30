/**
 */
package ModelAndConquer.impl;

import ModelAndConquer.Area;
import ModelAndConquer.Game;
import ModelAndConquer.GenericGameElement;
import ModelAndConquer.ModelAndConquerPackage;
import ModelAndConquer.Player;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Game</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ModelAndConquer.impl.GameImpl#getPlayer <em>Player</em>}</li>
 *   <li>{@link ModelAndConquer.impl.GameImpl#getStartArea <em>Start Area</em>}</li>
 *   <li>{@link ModelAndConquer.impl.GameImpl#getGameElements <em>Game Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GameImpl extends GenericGameElementImpl implements Game {
	/**
	 * The cached value of the '{@link #getPlayer() <em>Player</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlayer()
	 * @generated
	 * @ordered
	 */
	protected Player player;

	/**
	 * The cached value of the '{@link #getStartArea() <em>Start Area</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartArea()
	 * @generated
	 * @ordered
	 */
	protected Area startArea;

	/**
	 * The cached value of the '{@link #getGameElements() <em>Game Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGameElements()
	 * @generated
	 * @ordered
	 */
	protected EList<GenericGameElement> gameElements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GameImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelAndConquerPackage.Literals.GAME;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Player getPlayer() {
		return player;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPlayer(Player newPlayer, NotificationChain msgs) {
		Player oldPlayer = player;
		player = newPlayer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelAndConquerPackage.GAME__PLAYER, oldPlayer, newPlayer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPlayer(Player newPlayer) {
		if (newPlayer != player) {
			NotificationChain msgs = null;
			if (player != null)
				msgs = ((InternalEObject)player).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelAndConquerPackage.GAME__PLAYER, null, msgs);
			if (newPlayer != null)
				msgs = ((InternalEObject)newPlayer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelAndConquerPackage.GAME__PLAYER, null, msgs);
			msgs = basicSetPlayer(newPlayer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelAndConquerPackage.GAME__PLAYER, newPlayer, newPlayer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Area getStartArea() {
		return startArea;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStartArea(Area newStartArea, NotificationChain msgs) {
		Area oldStartArea = startArea;
		startArea = newStartArea;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelAndConquerPackage.GAME__START_AREA, oldStartArea, newStartArea);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStartArea(Area newStartArea) {
		if (newStartArea != startArea) {
			NotificationChain msgs = null;
			if (startArea != null)
				msgs = ((InternalEObject)startArea).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelAndConquerPackage.GAME__START_AREA, null, msgs);
			if (newStartArea != null)
				msgs = ((InternalEObject)newStartArea).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelAndConquerPackage.GAME__START_AREA, null, msgs);
			msgs = basicSetStartArea(newStartArea, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelAndConquerPackage.GAME__START_AREA, newStartArea, newStartArea));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GenericGameElement> getGameElements() {
		if (gameElements == null) {
			gameElements = new EObjectContainmentEList<GenericGameElement>(GenericGameElement.class, this, ModelAndConquerPackage.GAME__GAME_ELEMENTS);
		}
		return gameElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelAndConquerPackage.GAME__PLAYER:
				return basicSetPlayer(null, msgs);
			case ModelAndConquerPackage.GAME__START_AREA:
				return basicSetStartArea(null, msgs);
			case ModelAndConquerPackage.GAME__GAME_ELEMENTS:
				return ((InternalEList<?>)getGameElements()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelAndConquerPackage.GAME__PLAYER:
				return getPlayer();
			case ModelAndConquerPackage.GAME__START_AREA:
				return getStartArea();
			case ModelAndConquerPackage.GAME__GAME_ELEMENTS:
				return getGameElements();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelAndConquerPackage.GAME__PLAYER:
				setPlayer((Player)newValue);
				return;
			case ModelAndConquerPackage.GAME__START_AREA:
				setStartArea((Area)newValue);
				return;
			case ModelAndConquerPackage.GAME__GAME_ELEMENTS:
				getGameElements().clear();
				getGameElements().addAll((Collection<? extends GenericGameElement>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelAndConquerPackage.GAME__PLAYER:
				setPlayer((Player)null);
				return;
			case ModelAndConquerPackage.GAME__START_AREA:
				setStartArea((Area)null);
				return;
			case ModelAndConquerPackage.GAME__GAME_ELEMENTS:
				getGameElements().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelAndConquerPackage.GAME__PLAYER:
				return player != null;
			case ModelAndConquerPackage.GAME__START_AREA:
				return startArea != null;
			case ModelAndConquerPackage.GAME__GAME_ELEMENTS:
				return gameElements != null && !gameElements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //GameImpl
