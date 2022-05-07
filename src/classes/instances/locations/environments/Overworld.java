package src.classes.instances.locations.environments;

import src.classes.instances.entities.Enemy;
import src.classes.instances.entities.Entity;
import src.classes.instances.entities.Peasant;
import src.classes.instances.items.weapons.SharpObject;
import src.classes.instances.items.weapons.Weapon;
import src.classes.instances.locations.environments.overworld_environments.*;
import src.classes.managers.MasterMethods;
import src.classes.managers.instances.*;

public class Overworld extends Environment {

  private static Overworld overworld = new Overworld("castle");

  // Rooms
  // Entrance, courtyard, tavern, market, castle(leads to another environment)

  private Overworld(String name) {
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

    // This is the process of creating an enemy
    entityManager.createEntity(new Peasant("Jack", 10.00, 50.00));
    addEntity(entityManager.getEntity("Jack"));
    // This is the process of creating a weapon and giving it to the enemy.
    itemManager.createItem(new SharpObject("Simple Shiv", 10.00, 7.00));
    entityManager.getEntity("Jack").inventory.add(itemManager.getItem("Simple Shiv"));
    entityManager.getEntity("Jack").equipItem((Weapon)entityManager.getEntity("Jack").inventory.getInstance("Simple Shiv"));

    entityManager.createEntity(new Enemy("Jacob", 100.00, 50.00));
    addEntity(entityManager.getEntity("Jacob"));
    itemManager.createItem(new SharpObject("Enemy dag", 0.00, 9.00));
    entityManager.getEntity("Jacob").inventory.add(itemManager.getItem("Enemy dag"));
    entityManager.getEntity("Jacob").equipItem((Weapon)entityManager.getEntity("Jacob").inventory.getInstance("Enemy dag"));
    
    addItem(itemManager.getItem("Basic_Healing_Potion"));
    addItem(itemManager.getItem("Basic_Healing_Potion_2"));

    
  }

  public static Overworld getOverWorld() {
    return overworld;
  }

}