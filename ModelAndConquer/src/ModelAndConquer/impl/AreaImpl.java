/**
 */
package ModelAndConquer.impl;

import ModelAndConquer.Area;
import ModelAndConquer.Connection;
import ModelAndConquer.Effect;
import ModelAndConquer.Item;
import ModelAndConquer.ModelAndConquerPackage;
import ModelAndConquer.Monster;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Area</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ModelAndConquer.impl.AreaImpl#getConnections <em>Connections</em>}</li>
 *   <li>{@link ModelAndConquer.impl.AreaImpl#getMonster <em>Monster</em>}</li>
 *   <li>{@link ModelAndConquer.impl.AreaImpl#getItems <em>Items</em>}</li>
 *   <li>{@link ModelAndConquer.impl.AreaImpl#getOnEnterEffect <em>On Enter Effect</em>}</li>
 *   <li>{@link ModelAndConquer.impl.AreaImpl#getAsciiArt <em>Ascii Art</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AreaImpl extends GenericGameElementImpl implements Area {
	/**
	 * The cached value of the '{@link #getConnections() <em>Connections</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnections()
	 * @generated
	 * @ordered
	 */
	protected EList<Connection> connections;

	/**
	 * The cached value of the '{@link #getMonster() <em>Monster</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMonster()
	 * @generated
	 * @ordered
	 */
	protected EList<Monster> monster;

	/**
	 * The cached value of the '{@link #getItems() <em>Items</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItems()
	 * @generated
	 * @ordered
	 */
	protected EList<Item> items;

	/**
	 * The cached value of the '{@link #getOnEnterEffect() <em>On Enter Effect</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnEnterEffect()
	 * @generated
	 * @ordered
	 */
	protected EList<Effect> onEnterEffect;

	/**
	 * The default value of the '{@link #getAsciiArt() <em>Ascii Art</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAsciiArt()
	 * @generated
	 * @ordered
	 */
	protected static final String ASCII_ART_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAsciiArt() <em>Ascii Art</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAsciiArt()
	 * @generated
	 * @ordered
	 */
	protected String asciiArt = ASCII_ART_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AreaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelAndConquerPackage.Literals.AREA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Connection> getConnections() {
		if (connections == null) {
			connections = new EObjectWithInverseResolvingEList.ManyInverse<Connection>(Connection.class, this, ModelAndConquerPackage.AREA__CONNECTIONS, ModelAndConquerPackage.CONNECTION__AREAS);
		}
		return connections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Monster> getMonster() {
		if (monster == null) {
			monster = new EObjectResolvingEList<Monster>(Monster.class, this, ModelAndConquerPackage.AREA__MONSTER);
		}
		return monster;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Item> getItems() {
		if (items == null) {
			items = new EObjectResolvingEList<Item>(Item.class, this, ModelAndConquerPackage.AREA__ITEMS);
		}
		return items;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Effect> getOnEnterEffect() {
		if (onEnterEffect == null) {
			onEnterEffect = new EObjectResolvingEList<Effect>(Effect.class, this, ModelAndConquerPackage.AREA__ON_ENTER_EFFECT);
		}
		return onEnterEffect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAsciiArt() {
		return asciiArt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAsciiArt(String newAsciiArt) {
		String oldAsciiArt = asciiArt;
		asciiArt = newAsciiArt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelAndConquerPackage.AREA__ASCII_ART, oldAsciiArt, asciiArt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelAndConquerPackage.AREA__CONNECTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConnections()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelAndConquerPackage.AREA__CONNECTIONS:
				return ((InternalEList<?>)getConnections()).basicRemove(otherEnd, msgs);
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
			case ModelAndConquerPackage.AREA__CONNECTIONS:
				return getConnections();
			case ModelAndConquerPackage.AREA__MONSTER:
				return getMonster();
			case ModelAndConquerPackage.AREA__ITEMS:
				return getItems();
			case ModelAndConquerPackage.AREA__ON_ENTER_EFFECT:
				return getOnEnterEffect();
			case ModelAndConquerPackage.AREA__ASCII_ART:
				return getAsciiArt();
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
			case ModelAndConquerPackage.AREA__CONNECTIONS:
				getConnections().clear();
				getConnections().addAll((Collection<? extends Connection>)newValue);
				return;
			case ModelAndConquerPackage.AREA__MONSTER:
				getMonster().clear();
				getMonster().addAll((Collection<? extends Monster>)newValue);
				return;
			case ModelAndConquerPackage.AREA__ITEMS:
				getItems().clear();
				getItems().addAll((Collection<? extends Item>)newValue);
				return;
			case ModelAndConquerPackage.AREA__ON_ENTER_EFFECT:
				getOnEnterEffect().clear();
				getOnEnterEffect().addAll((Collection<? extends Effect>)newValue);
				return;
			case ModelAndConquerPackage.AREA__ASCII_ART:
				setAsciiArt((String)newValue);
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
			case ModelAndConquerPackage.AREA__CONNECTIONS:
				getConnections().clear();
				return;
			case ModelAndConquerPackage.AREA__MONSTER:
				getMonster().clear();
				return;
			case ModelAndConquerPackage.AREA__ITEMS:
				getItems().clear();
				return;
			case ModelAndConquerPackage.AREA__ON_ENTER_EFFECT:
				getOnEnterEffect().clear();
				return;
			case ModelAndConquerPackage.AREA__ASCII_ART:
				setAsciiArt(ASCII_ART_EDEFAULT);
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
			case ModelAndConquerPackage.AREA__CONNECTIONS:
				return connections != null && !connections.isEmpty();
			case ModelAndConquerPackage.AREA__MONSTER:
				return monster != null && !monster.isEmpty();
			case ModelAndConquerPackage.AREA__ITEMS:
				return items != null && !items.isEmpty();
			case ModelAndConquerPackage.AREA__ON_ENTER_EFFECT:
				return onEnterEffect != null && !onEnterEffect.isEmpty();
			case ModelAndConquerPackage.AREA__ASCII_ART:
				return ASCII_ART_EDEFAULT == null ? asciiArt != null : !ASCII_ART_EDEFAULT.equals(asciiArt);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (asciiArt: ");
		result.append(asciiArt);
		result.append(')');
		return result.toString();
	}

} //AreaImpl
