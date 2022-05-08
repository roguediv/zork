package src.classes.instances.locations.environments;

import src.classes.instances.entities.BountyPlacer;
import src.classes.instances.entities.Enemy;
import src.classes.instances.entities.Entity;
import src.classes.instances.entities.Peasant;
import src.classes.instances.items.Quest;
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

    // This is the process of creating an enemy, creating a weapon, and giving it to the enemy.
    Enemy jack = new Enemy("Jack", 10.00, 50.00, this);
    SharpObject shiv = new SharpObject("Simple Shiv", 10.00, 7.00);
    jack.equipNewItem(shiv);
    // End process

    Enemy jacob = new Enemy("Jacob", 100.00, 50.00, this);
    SharpObject dagger = new SharpObject("Enemy dag", 0.00, 9.00);
    if (addEntity(jacob)) jacob.equipNewItem(dagger);
    
    // Creating Quest
    Quest bountyJack = new Quest((Enemy)entityManager.getEntity("Jack"), 200.00);

    // Copy and paste this where we want wulfstan the bounty giver
    BountyPlacer wulfstan = BountyPlacer.getInstance();
    wulfstan.setLocation(this);
    wulfstan.equipNewItem(new SharpObject("Danish Dragon Slayer Dagger", 1000.00, 60.00));
    // Adding Quest
    wulfstan.addQuest(bountyJack);

    addItem(itemManager.getItem("Basic_Healing_Potion"));
    addItem(itemManager.getItem("Basic_Healing_Potion_2"));
    
  }

  public static Overworld getOverWorld() {
    return overworld;
  }

}