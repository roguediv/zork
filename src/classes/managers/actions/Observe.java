package src.classes.managers.actions;

import src.classes.instances.items.Item;
import src.classes.instances.locations.environments.Environment;
import src.classes.instances.entities.*;

public class Observe extends Action {

  public static void find(String Word) {
    start();
    switch (findObservationType(Word)) {
      case 0: 
        rooms();break;
      case 1:
        entities();break;
      case 2: 
        items();break;
      default:
        rooms();addSpace();entities();addSpace();items();
    }
    end();
  }

  private static int findObservationType(String word) {
    if (word == null) return -1;
    String[][] types = {
      // 0 = look in environment for doors
      {"places", "doors", "areas", "paths", "rooms", "room", "location", "locations"},
      // 1 = look in environment for people
      {"people", "peasents", "others", "entities", "entitys"},
      // 2 = look in environment for items
      {"items", "item", "stuff"},
    };
    int i = 0;
    for (String[] array : types) {
      for (String target : array) {
        if (word.equals(target)) {
          return i;
        }
      }
      i++;
    }
    return -1;
  }

  private static void rooms() {
    addText("You are currently in the area: " + displayName(location.getName()) + ".");
    addText("You look around you for places you can visit...");
    int i = 0;
    for (Environment room : location.getRooms()) {
      addText("- " + displayName(room.getName()));
      i++;
    }
    if (i == 0) addText("Looks like this is a dead end.");
  }

  private static void entities() {
    Environment location = player.getLocation();
    addText("You look around you for people...");
    int i = 0;
    for (Entity entity : location.getEntities()) {
      addText("- " + displayName(entity.getName()));
      i++;
    }
    if (i == 0) addText("You don't see any people.");
  }

  private static void items() {
    Environment location = player.getLocation();
    addText("You look around for items...");
    int i = 0;
    for (Item item : location.getItems()) {
      addText("- " + displayName(item.getName()));
      i++;
    }
    if (i == 0) addText("You don't see any items.");
  }

}