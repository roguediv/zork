package src.classes.managers.actions;

import src.classes.instances.items.Item;
import src.classes.instances.locations.environments.Environment;
import src.classes.managers.MasterMethods;
import src.classes.instances.entities.*;

public class Observe extends Action {

  public static void find(String Word) {
    switch (findObservationType(Word)) {
      case 0: 
        rooms();break;
      case 1:
        entities();break;
      case 2: 
        items();break;
      default:
        view.sendText("You aren't quite sure what you're looking for...");
    }
  }

  private static int findObservationType(String word) {
    String[][] types = {
      // 0 = look in environment for doors
      {"places", "doors", "areas", "paths", "rooms", "room"},
      // 1 = look in environment for people
      {"people", "peasents", "others", "entties", "entitys"},
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
    Environment location = player.getLocation();
    view.sendText("You look around you for places you can visit...");
    int i = 0;
    for (Environment room : location.getRooms()) {
      view.sendText(room.getName());
      i++;
    }
    if (i == 0) view.sendText("Looks like this is a dead end.");
  }

  private static void entities() {
    Environment location = player.getLocation();
    view.sendText("You look around you for people...");
    int i = 0;
    for (Entity entity : location.getEntities()) {
      view.sendText(entity.getName());
      i++;
    }
    if (i == 0) view.sendText("There is no one around.");
  }

  private static void items() {
    Environment location = player.getLocation();
    //view.sendText("You look around for items...");
    int i = 0;
    for (Item item : location.getItems()) {
      System.out.println(item.getName());
      view.sendText(item.getName().replace("_", " "));
      i++;
    }
    
    if (i == 0) view.sendText("There were no items to find.");
  }

}