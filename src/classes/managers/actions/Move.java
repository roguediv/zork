package src.classes.managers.actions;

import src.classes.instances.locations.environments.Environment;
import src.classes.managers.instances.InstanceCollection;

public class Move extends Action {

  public static void newLocation(String word) {
    start();
    if (word == null) {Observe.find("location");return;}
    changeLocation(word);
    end();
  }

  private static void changeLocation(String Word) {
    String[] goBack = {"back", "return", "last location", "last"};
    InstanceCollection<Environment> rooms = location.getRooms();
    if (location.getSource() != null)
      if (Word.equals(location.getSource().getName())) player.setLocation(location.getSource());
    for (String word : goBack) {
      if (Word.equals(word)) player.setLocation(location.getSource());
    }
    for (Environment room : rooms) {
      if (Word.equals(room.getName())) player.setLocation(room);
    }
    if (location != player.getLocation()) enterLocation();
    else {
      addText("You could not find a path to " + displayName(Word)+ ".");
      addText("You are currently in the area: " + displayName(player.getLocation().getName()) + ".");
    }
  }

  private static void enterLocation() {
    addText("You entered a new area: " + displayName(player.getLocation().getName()));
    addSpace();
    /// Play enterence Dialog
    for (String text : player.getLocation().getEntranceDialog()) {
      addText(text);
    }
  }

}
