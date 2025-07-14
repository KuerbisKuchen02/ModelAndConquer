package models._static;

import java.util.ArrayList;

public class DestroyableObject extends Entity implements INonPlayerEntity{
    public DestroyableObject(String name,
                             String description,
                             double maxHealth,
                             ArrayList<DamageModificator> damageModificators,
                             ArrayList<Item> inventory,
                             double evasionChance) {
        super(name, description, maxHealth, damageModificators, inventory, evasionChance);
    }
}