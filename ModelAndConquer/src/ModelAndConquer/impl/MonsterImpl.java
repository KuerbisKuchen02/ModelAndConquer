/**
 */
package ModelAndConquer.impl;

import ModelAndConquer.DamageType;
import ModelAndConquer.Effect;
import ModelAndConquer.ModelAndConquerPackage;
import ModelAndConquer.Monster;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Monster</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ModelAndConquer.impl.MonsterImpl#getWeakness <em>Weakness</em>}</li>
 *   <li>{@link ModelAndConquer.impl.MonsterImpl#getResistance <em>Resistance</em>}</li>
 *   <li>{@link ModelAndConquer.impl.MonsterImpl#getOnKillEffect <em>On Kill Effect</em>}</li>
 *   <li>{@link ModelAndConquer.impl.MonsterImpl#getOnSpawnEffect <em>On Spawn Effect</em>}</li>
 *   <li>{@link ModelAndConquer.impl.MonsterImpl#getOnHitEffect <em>On Hit Effect</em>}</li>
 *   <li>{@link ModelAndConquer.impl.MonsterImpl#getOnDamageEffect <em>On Damage Effect</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MonsterImpl extends EntityImpl implements Monster {
	/**
	 * The cached value of the '{@link #getWeakness() <em>Weakness</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeakness()
	 * @generated
	 * @ordered
	 */
	protected EList<DamageType> weakness;

	/**
	 * The cached value of the '{@link #getResistance() <em>Resistance</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResistance()
	 * @generated
	 * @ordered
	 */
	protected EList<DamageType> resistance;

	/**
	 * The cached value of the '{@link #getOnKillEffect() <em>On Kill Effect</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnKillEffect()
	 * @generated
	 * @ordered
	 */
	protected EList<Effect> onKillEffect;

	/**
	 * The cached value of the '{@link #getOnSpawnEffect() <em>On Spawn Effect</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnSpawnEffect()
	 * @generated
	 * @ordered
	 */
	protected EList<Effect> onSpawnEffect;

	/**
	 * The cached value of the '{@link #getOnHitEffect() <em>On Hit Effect</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnHitEffect()
	 * @generated
	 * @ordered
	 */
	protected EList<Effect> onHitEffect;

	/**
	 * The cached value of the '{@link #getOnDamageEffect() <em>On Damage Effect</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnDamageEffect()
	 * @generated
	 * @ordered
	 */
	protected EList<Effect> onDamageEffect;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MonsterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelAndConquerPackage.Literals.MONSTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DamageType> getWeakness() {
		if (weakness == null) {
			weakness = new EObjectResolvingEList<DamageType>(DamageType.class, this, ModelAndConquerPackage.MONSTER__WEAKNESS);
		}
		return weakness;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DamageType> getResistance() {
		if (resistance == null) {
			resistance = new EObjectResolvingEList<DamageType>(DamageType.class, this, ModelAndConquerPackage.MONSTER__RESISTANCE);
		}
		return resistance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Effect> getOnKillEffect() {
		if (onKillEffect == null) {
			onKillEffect = new EObjectResolvingEList<Effect>(Effect.class, this, ModelAndConquerPackage.MONSTER__ON_KILL_EFFECT);
		}
		return onKillEffect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Effect> getOnSpawnEffect() {
		if (onSpawnEffect == null) {
			onSpawnEffect = new EObjectResolvingEList<Effect>(Effect.class, this, ModelAndConquerPackage.MONSTER__ON_SPAWN_EFFECT);
		}
		return onSpawnEffect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Effect> getOnHitEffect() {
		if (onHitEffect == null) {
			onHitEffect = new EObjectResolvingEList<Effect>(Effect.class, this, ModelAndConquerPackage.MONSTER__ON_HIT_EFFECT);
		}
		return onHitEffect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Effect> getOnDamageEffect() {
		if (onDamageEffect == null) {
			onDamageEffect = new EObjectResolvingEList<Effect>(Effect.class, this, ModelAndConquerPackage.MONSTER__ON_DAMAGE_EFFECT);
		}
		return onDamageEffect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelAndConquerPackage.MONSTER__WEAKNESS:
				return getWeakness();
			case ModelAndConquerPackage.MONSTER__RESISTANCE:
				return getResistance();
			case ModelAndConquerPackage.MONSTER__ON_KILL_EFFECT:
				return getOnKillEffect();
			case ModelAndConquerPackage.MONSTER__ON_SPAWN_EFFECT:
				return getOnSpawnEffect();
			case ModelAndConquerPackage.MONSTER__ON_HIT_EFFECT:
				return getOnHitEffect();
			case ModelAndConquerPackage.MONSTER__ON_DAMAGE_EFFECT:
				return getOnDamageEffect();
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
			case ModelAndConquerPackage.MONSTER__WEAKNESS:
				getWeakness().clear();
				getWeakness().addAll((Collection<? extends DamageType>)newValue);
				return;
			case ModelAndConquerPackage.MONSTER__RESISTANCE:
				getResistance().clear();
				getResistance().addAll((Collection<? extends DamageType>)newValue);
				return;
			case ModelAndConquerPackage.MONSTER__ON_KILL_EFFECT:
				getOnKillEffect().clear();
				getOnKillEffect().addAll((Collection<? extends Effect>)newValue);
				return;
			case ModelAndConquerPackage.MONSTER__ON_SPAWN_EFFECT:
				getOnSpawnEffect().clear();
				getOnSpawnEffect().addAll((Collection<? extends Effect>)newValue);
				return;
			case ModelAndConquerPackage.MONSTER__ON_HIT_EFFECT:
				getOnHitEffect().clear();
				getOnHitEffect().addAll((Collection<? extends Effect>)newValue);
				return;
			case ModelAndConquerPackage.MONSTER__ON_DAMAGE_EFFECT:
				getOnDamageEffect().clear();
				getOnDamageEffect().addAll((Collection<? extends Effect>)newValue);
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
			case ModelAndConquerPackage.MONSTER__WEAKNESS:
				getWeakness().clear();
				return;
			case ModelAndConquerPackage.MONSTER__RESISTANCE:
				getResistance().clear();
				return;
			case ModelAndConquerPackage.MONSTER__ON_KILL_EFFECT:
				getOnKillEffect().clear();
				return;
			case ModelAndConquerPackage.MONSTER__ON_SPAWN_EFFECT:
				getOnSpawnEffect().clear();
				return;
			case ModelAndConquerPackage.MONSTER__ON_HIT_EFFECT:
				getOnHitEffect().clear();
				return;
			case ModelAndConquerPackage.MONSTER__ON_DAMAGE_EFFECT:
				getOnDamageEffect().clear();
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
			case ModelAndConquerPackage.MONSTER__WEAKNESS:
				return weakness != null && !weakness.isEmpty();
			case ModelAndConquerPackage.MONSTER__RESISTANCE:
				return resistance != null && !resistance.isEmpty();
			case ModelAndConquerPackage.MONSTER__ON_KILL_EFFECT:
				return onKillEffect != null && !onKillEffect.isEmpty();
			case ModelAndConquerPackage.MONSTER__ON_SPAWN_EFFECT:
				return onSpawnEffect != null && !onSpawnEffect.isEmpty();
			case ModelAndConquerPackage.MONSTER__ON_HIT_EFFECT:
				return onHitEffect != null && !onHitEffect.isEmpty();
			case ModelAndConquerPackage.MONSTER__ON_DAMAGE_EFFECT:
				return onDamageEffect != null && !onDamageEffect.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MonsterImpl
