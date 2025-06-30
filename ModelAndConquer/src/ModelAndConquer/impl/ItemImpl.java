/**
 */
package ModelAndConquer.impl;

import ModelAndConquer.DamageType;
import ModelAndConquer.Effect;
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
 * An implementation of the model object '<em><b>Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ModelAndConquer.impl.ItemImpl#getDamage <em>Damage</em>}</li>
 *   <li>{@link ModelAndConquer.impl.ItemImpl#getDamageType <em>Damage Type</em>}</li>
 *   <li>{@link ModelAndConquer.impl.ItemImpl#isConsumable <em>Consumable</em>}</li>
 *   <li>{@link ModelAndConquer.impl.ItemImpl#getOnDropEffect <em>On Drop Effect</em>}</li>
 *   <li>{@link ModelAndConquer.impl.ItemImpl#getOnPickupEffect <em>On Pickup Effect</em>}</li>
 *   <li>{@link ModelAndConquer.impl.ItemImpl#getOnUseEffect <em>On Use Effect</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ItemImpl extends GenericGameElementImpl implements Item {
	/**
	 * The default value of the '{@link #getDamage() <em>Damage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDamage()
	 * @generated
	 * @ordered
	 */
	protected static final double DAMAGE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getDamage() <em>Damage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDamage()
	 * @generated
	 * @ordered
	 */
	protected double damage = DAMAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDamageType() <em>Damage Type</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDamageType()
	 * @generated
	 * @ordered
	 */
	protected EList<DamageType> damageType;

	/**
	 * The default value of the '{@link #isConsumable() <em>Consumable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConsumable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONSUMABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isConsumable() <em>Consumable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConsumable()
	 * @generated
	 * @ordered
	 */
	protected boolean consumable = CONSUMABLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOnDropEffect() <em>On Drop Effect</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnDropEffect()
	 * @generated
	 * @ordered
	 */
	protected EList<Effect> onDropEffect;

	/**
	 * The cached value of the '{@link #getOnPickupEffect() <em>On Pickup Effect</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnPickupEffect()
	 * @generated
	 * @ordered
	 */
	protected EList<Effect> onPickupEffect;

	/**
	 * The cached value of the '{@link #getOnUseEffect() <em>On Use Effect</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnUseEffect()
	 * @generated
	 * @ordered
	 */
	protected EList<Effect> onUseEffect;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelAndConquerPackage.Literals.ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getDamage() {
		return damage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDamage(double newDamage) {
		double oldDamage = damage;
		damage = newDamage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelAndConquerPackage.ITEM__DAMAGE, oldDamage, damage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DamageType> getDamageType() {
		if (damageType == null) {
			damageType = new EObjectResolvingEList<DamageType>(DamageType.class, this, ModelAndConquerPackage.ITEM__DAMAGE_TYPE);
		}
		return damageType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isConsumable() {
		return consumable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConsumable(boolean newConsumable) {
		boolean oldConsumable = consumable;
		consumable = newConsumable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelAndConquerPackage.ITEM__CONSUMABLE, oldConsumable, consumable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Effect> getOnDropEffect() {
		if (onDropEffect == null) {
			onDropEffect = new EObjectResolvingEList<Effect>(Effect.class, this, ModelAndConquerPackage.ITEM__ON_DROP_EFFECT);
		}
		return onDropEffect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Effect> getOnPickupEffect() {
		if (onPickupEffect == null) {
			onPickupEffect = new EObjectResolvingEList<Effect>(Effect.class, this, ModelAndConquerPackage.ITEM__ON_PICKUP_EFFECT);
		}
		return onPickupEffect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Effect> getOnUseEffect() {
		if (onUseEffect == null) {
			onUseEffect = new EObjectResolvingEList<Effect>(Effect.class, this, ModelAndConquerPackage.ITEM__ON_USE_EFFECT);
		}
		return onUseEffect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelAndConquerPackage.ITEM__DAMAGE:
				return getDamage();
			case ModelAndConquerPackage.ITEM__DAMAGE_TYPE:
				return getDamageType();
			case ModelAndConquerPackage.ITEM__CONSUMABLE:
				return isConsumable();
			case ModelAndConquerPackage.ITEM__ON_DROP_EFFECT:
				return getOnDropEffect();
			case ModelAndConquerPackage.ITEM__ON_PICKUP_EFFECT:
				return getOnPickupEffect();
			case ModelAndConquerPackage.ITEM__ON_USE_EFFECT:
				return getOnUseEffect();
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
			case ModelAndConquerPackage.ITEM__DAMAGE:
				setDamage((Double)newValue);
				return;
			case ModelAndConquerPackage.ITEM__DAMAGE_TYPE:
				getDamageType().clear();
				getDamageType().addAll((Collection<? extends DamageType>)newValue);
				return;
			case ModelAndConquerPackage.ITEM__CONSUMABLE:
				setConsumable((Boolean)newValue);
				return;
			case ModelAndConquerPackage.ITEM__ON_DROP_EFFECT:
				getOnDropEffect().clear();
				getOnDropEffect().addAll((Collection<? extends Effect>)newValue);
				return;
			case ModelAndConquerPackage.ITEM__ON_PICKUP_EFFECT:
				getOnPickupEffect().clear();
				getOnPickupEffect().addAll((Collection<? extends Effect>)newValue);
				return;
			case ModelAndConquerPackage.ITEM__ON_USE_EFFECT:
				getOnUseEffect().clear();
				getOnUseEffect().addAll((Collection<? extends Effect>)newValue);
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
			case ModelAndConquerPackage.ITEM__DAMAGE:
				setDamage(DAMAGE_EDEFAULT);
				return;
			case ModelAndConquerPackage.ITEM__DAMAGE_TYPE:
				getDamageType().clear();
				return;
			case ModelAndConquerPackage.ITEM__CONSUMABLE:
				setConsumable(CONSUMABLE_EDEFAULT);
				return;
			case ModelAndConquerPackage.ITEM__ON_DROP_EFFECT:
				getOnDropEffect().clear();
				return;
			case ModelAndConquerPackage.ITEM__ON_PICKUP_EFFECT:
				getOnPickupEffect().clear();
				return;
			case ModelAndConquerPackage.ITEM__ON_USE_EFFECT:
				getOnUseEffect().clear();
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
			case ModelAndConquerPackage.ITEM__DAMAGE:
				return damage != DAMAGE_EDEFAULT;
			case ModelAndConquerPackage.ITEM__DAMAGE_TYPE:
				return damageType != null && !damageType.isEmpty();
			case ModelAndConquerPackage.ITEM__CONSUMABLE:
				return consumable != CONSUMABLE_EDEFAULT;
			case ModelAndConquerPackage.ITEM__ON_DROP_EFFECT:
				return onDropEffect != null && !onDropEffect.isEmpty();
			case ModelAndConquerPackage.ITEM__ON_PICKUP_EFFECT:
				return onPickupEffect != null && !onPickupEffect.isEmpty();
			case ModelAndConquerPackage.ITEM__ON_USE_EFFECT:
				return onUseEffect != null && !onUseEffect.isEmpty();
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
		result.append(" (damage: ");
		result.append(damage);
		result.append(", consumable: ");
		result.append(consumable);
		result.append(')');
		return result.toString();
	}

} //ItemImpl
