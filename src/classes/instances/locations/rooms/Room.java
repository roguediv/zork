package src.classes.instances.locations.rooms;

import src.classes.instances.Instance;

public abstract class Room extends Instance {

  /**
   * When the user tries to enter keyword this method will turn everything
   * lowercase
   * and check if the users word matches any in the current room.
   * 
   * @param userTextInput
   */

  public Room(String name) {
    super(name);
  }


}