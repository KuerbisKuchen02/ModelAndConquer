/**
 */
package ModelAndConquer.impl;

import ModelAndConquer.Area;
import ModelAndConquer.Connection;
import ModelAndConquer.Effect;
import ModelAndConquer.Item;
import ModelAndConquer.ModelAndConquerPackage;

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
 * An implementation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ModelAndConquer.impl.ConnectionImpl#getOnTraverseEffect <em>On Traverse Effect</em>}</li>
 *   <li>{@link ModelAndConquer.impl.ConnectionImpl#getUnlockedWith <em>Unlocked With</em>}</li>
 *   <li>{@link ModelAndConquer.impl.ConnectionImpl#isIsLocked <em>Is Locked</em>}</li>
 *   <li>{@link ModelAndConquer.impl.ConnectionImpl#getAreas <em>Areas</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConnectionImpl extends GenericGameElementImpl implements Connection {
	/**
	 * The cached value of the '{@link #getOnTraverseEffect() <em>On Traverse Effect</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnTraverseEffect()
	 * @generated
	 * @ordered
	 */
	protected EList<Effect> onTraverseEffect;

	/**
	 * The cached value of the '{@link #getUnlockedWith() <em>Unlocked With</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnlockedWith()
	 * @generated
	 * @ordered
	 */
	protected EList<Item> unlockedWith;

	/**
	 * The default value of the '{@link #isIsLocked() <em>Is Locked</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsLocked()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_LOCKED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsLocked() <em>Is Locked</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsLocked()
	 * @generated
	 * @ordered
	 */
	protected boolean isLocked = IS_LOCKED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAreas() <em>Areas</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAreas()
	 * @generated
	 * @ordered
	 */
	protected EList<Area> areas;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelAndConquerPackage.Literals.CONNECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Effect> getOnTraverseEffect() {
		if (onTraverseEffect == null) {
			onTraverseEffect = new EObjectResolvingEList<Effect>(Effect.class, this, ModelAndConquerPackage.CONNECTION__ON_TRAVERSE_EFFECT);
		}
		return onTraverseEffect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Item> getUnlockedWith() {
		if (unlockedWith == null) {
			unlockedWith = new EObjectResolvingEList<Item>(Item.class, this, ModelAndConquerPackage.CONNECTION__UNLOCKED_WITH);
		}
		return unlockedWith;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsLocked() {
		return isLocked;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsLocked(boolean newIsLocked) {
		boolean oldIsLocked = isLocked;
		isLocked = newIsLocked;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelAndConquerPackage.CONNECTION__IS_LOCKED, oldIsLocked, isLocked));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Area> getAreas() {
		if (areas == null) {
			areas = new EObjectWithInverseResolvingEList.ManyInverse<Area>(Area.class, this, ModelAndConquerPackage.CONNECTION__AREAS, ModelAndConquerPackage.AREA__CONNECTIONS);
		}
		return areas;
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
			case ModelAndConquerPackage.CONNECTION__AREAS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAreas()).basicAdd(otherEnd, msgs);
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
			case ModelAndConquerPackage.CONNECTION__AREAS:
				return ((InternalEList<?>)getAreas()).basicRemove(otherEnd, msgs);
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
			case ModelAndConquerPackage.CONNECTION__ON_TRAVERSE_EFFECT:
				return getOnTraverseEffect();
			case ModelAndConquerPackage.CONNECTION__UNLOCKED_WITH:
				return getUnlockedWith();
			case ModelAndConquerPackage.CONNECTION__IS_LOCKED:
				return isIsLocked();
			case ModelAndConquerPackage.CONNECTION__AREAS:
				return getAreas();
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
			case ModelAndConquerPackage.CONNECTION__ON_TRAVERSE_EFFECT:
				getOnTraverseEffect().clear();
				getOnTraverseEffect().addAll((Collection<? extends Effect>)newValue);
				return;
			case ModelAndConquerPackage.CONNECTION__UNLOCKED_WITH:
				getUnlockedWith().clear();
				getUnlockedWith().addAll((Collection<? extends Item>)newValue);
				return;
			case ModelAndConquerPackage.CONNECTION__IS_LOCKED:
				setIsLocked((Boolean)newValue);
				return;
			case ModelAndConquerPackage.CONNECTION__AREAS:
				getAreas().clear();
				getAreas().addAll((Collection<? extends Area>)newValue);
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
			case ModelAndConquerPackage.CONNECTION__ON_TRAVERSE_EFFECT:
				getOnTraverseEffect().clear();
				return;
			case ModelAndConquerPackage.CONNECTION__UNLOCKED_WITH:
				getUnlockedWith().clear();
				return;
			case ModelAndConquerPackage.CONNECTION__IS_LOCKED:
				setIsLocked(IS_LOCKED_EDEFAULT);
				return;
			case ModelAndConquerPackage.CONNECTION__AREAS:
				getAreas().clear();
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
			case ModelAndConquerPackage.CONNECTION__ON_TRAVERSE_EFFECT:
				return onTraverseEffect != null && !onTraverseEffect.isEmpty();
			case ModelAndConquerPackage.CONNECTION__UNLOCKED_WITH:
				return unlockedWith != null && !unlockedWith.isEmpty();
			case ModelAndConquerPackage.CONNECTION__IS_LOCKED:
				return isLocked != IS_LOCKED_EDEFAULT;
			case ModelAndConquerPackage.CONNECTION__AREAS:
				return areas != null && !areas.isEmpty();
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
		result.append(" (isLocked: ");
		result.append(isLocked);
		result.append(')');
		return result.toString();
	}

} //ConnectionImpl
