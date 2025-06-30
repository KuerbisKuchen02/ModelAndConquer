/**
 */
package ModelAndConquer.impl;

import ModelAndConquer.Effect;
import ModelAndConquer.Entity;
import ModelAndConquer.Item;
import ModelAndConquer.ModelAndConquerPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ModelAndConquer.impl.EntityImpl#getCurrHealth <em>Curr Health</em>}</li>
 *   <li>{@link ModelAndConquer.impl.EntityImpl#getMaxHealth <em>Max Health</em>}</li>
 *   <li>{@link ModelAndConquer.impl.EntityImpl#getInventory <em>Inventory</em>}</li>
 *   <li>{@link ModelAndConquer.impl.EntityImpl#getEffects <em>Effects</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class EntityImpl extends GenericGameElementImpl implements Entity {
	/**
	 * The default value of the '{@link #getCurrHealth() <em>Curr Health</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrHealth()
	 * @generated
	 * @ordered
	 */
	protected static final double CURR_HEALTH_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getCurrHealth() <em>Curr Health</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrHealth()
	 * @generated
	 * @ordered
	 */
	protected double currHealth = CURR_HEALTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxHealth() <em>Max Health</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxHealth()
	 * @generated
	 * @ordered
	 */
	protected static final double MAX_HEALTH_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMaxHealth() <em>Max Health</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxHealth()
	 * @generated
	 * @ordered
	 */
	protected double maxHealth = MAX_HEALTH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInventory() <em>Inventory</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInventory()
	 * @generated
	 * @ordered
	 */
	protected EList<Item> inventory;

	/**
	 * The cached value of the '{@link #getEffects() <em>Effects</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEffects()
	 * @generated
	 * @ordered
	 */
	protected EList<Effect> effects;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelAndConquerPackage.Literals.ENTITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getCurrHealth() {
		return currHealth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCurrHealth(double newCurrHealth) {
		double oldCurrHealth = currHealth;
		currHealth = newCurrHealth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelAndConquerPackage.ENTITY__CURR_HEALTH, oldCurrHealth, currHealth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getMaxHealth() {
		return maxHealth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMaxHealth(double newMaxHealth) {
		double oldMaxHealth = maxHealth;
		maxHealth = newMaxHealth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelAndConquerPackage.ENTITY__MAX_HEALTH, oldMaxHealth, maxHealth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Item> getInventory() {
		if (inventory == null) {
			inventory = new EObjectResolvingEList<Item>(Item.class, this, ModelAndConquerPackage.ENTITY__INVENTORY);
		}
		return inventory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Effect> getEffects() {
		if (effects == null) {
			effects = new EObjectResolvingEList<Effect>(Effect.class, this, ModelAndConquerPackage.ENTITY__EFFECTS);
		}
		return effects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelAndConquerPackage.ENTITY__CURR_HEALTH:
				return getCurrHealth();
			case ModelAndConquerPackage.ENTITY__MAX_HEALTH:
				return getMaxHealth();
			case ModelAndConquerPackage.ENTITY__INVENTORY:
				return getInventory();
			case ModelAndConquerPackage.ENTITY__EFFECTS:
				return getEffects();
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
			case ModelAndConquerPackage.ENTITY__CURR_HEALTH:
				setCurrHealth((Double)newValue);
				return;
			case ModelAndConquerPackage.ENTITY__MAX_HEALTH:
				setMaxHealth((Double)newValue);
				return;
			case ModelAndConquerPackage.ENTITY__INVENTORY:
				getInventory().clear();
				getInventory().addAll((Collection<? extends Item>)newValue);
				return;
			case ModelAndConquerPackage.ENTITY__EFFECTS:
				getEffects().clear();
				getEffects().addAll((Collection<? extends Effect>)newValue);
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
			case ModelAndConquerPackage.ENTITY__CURR_HEALTH:
				setCurrHealth(CURR_HEALTH_EDEFAULT);
				return;
			case ModelAndConquerPackage.ENTITY__MAX_HEALTH:
				setMaxHealth(MAX_HEALTH_EDEFAULT);
				return;
			case ModelAndConquerPackage.ENTITY__INVENTORY:
				getInventory().clear();
				return;
			case ModelAndConquerPackage.ENTITY__EFFECTS:
				getEffects().clear();
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
			case ModelAndConquerPackage.ENTITY__CURR_HEALTH:
				return currHealth != CURR_HEALTH_EDEFAULT;
			case ModelAndConquerPackage.ENTITY__MAX_HEALTH:
				return maxHealth != MAX_HEALTH_EDEFAULT;
			case ModelAndConquerPackage.ENTITY__INVENTORY:
				return inventory != null && !inventory.isEmpty();
			case ModelAndConquerPackage.ENTITY__EFFECTS:
				return effects != null && !effects.isEmpty();
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
		result.append(" (currHealth: ");
		result.append(currHealth);
		result.append(", maxHealth: ");
		result.append(maxHealth);
		result.append(')');
		return result.toString();
	}

} //EntityImpl
