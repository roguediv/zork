package src.classes.instances.locations.environments;

import src.classes.instances.entities.Enemy;
import src.classes.instances.items.Item;
import src.classes.instances.items.weapons.BluntObject;
import src.classes.instances.locations.environments.overworld_environments.*;
import src.classes.managers.MasterMethods;
import src.classes.managers.instances.*;

public class OverWorld extends Environment {

  private static OverWorld overworld = new OverWorld("castle");

  // Rooms
  // Entrance, courtyard, tavern, market, castle(leads to another environment)

  private OverWorld(String name) {
    super(name, new String[] {"test"});
    addRoom(new Shops("shopping_district", this));
    addRoom(new Palace("palace", this));
    addRoom(new Entrance("castle_entrance", this));
    addRoom(new Housing("housing_district", this));

    
    // entityManager.createEntity(new Enemy("Guard", 50));
    // entityManager.getEntity("Guard").changeDialog(new Stirng[] {"fdsfghdsafk"}, 3);
    // entityManager.getEntity("Guard").changeProperties(new int[] {1, 4, 3, 2});

    // itemManager.createItem(new BluntObject("longsword", 50, 25));
    // MasterMethods.getItemType(itemManager.getItem("longsword"));

    // entityManager.createEntity(guard = new Enemy<>("Guard", 50));
    // addEntity(entityManager.getEntity("Gu"));

    addEntity(entityManager.getEntity("james"));
    
    addItem(itemManager.getItem("Basic_Healing_Potion"));
    addItem(itemManager.getItem("Basic_Healing_Potion_2"));

    
  }

  public static OverWorld getOverWorld() {
    return overworld;
  }

}