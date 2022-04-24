package src.classes.instances.locations.environments;

import src.classes.instances.locations.environments.overworld_environments.*;
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
    addItem(itemManager.getPotion("Basic_Healing_Potion"));
  }

  public static OverWorld getOverWorld() {
    return overworld;
  }

}