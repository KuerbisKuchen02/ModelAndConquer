package models._static;

import java.util.ArrayList;

public class DestroyableObject extends Entity implements INonPlayerEntity{
    public DestroyableObject(String name, String description, double maxHealth,
                             ArrayList<Item> inventory, Effect[] Effects,
                             ArrayList<DamageModificator> damageModificators) {
        super(name, description, maxHealth, inventory, Effects, damageModificators);
    }

}