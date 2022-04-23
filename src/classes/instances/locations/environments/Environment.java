package src.classes.instances.locations.environments;

import java.util.List;

import src.classes.instances.Instance;
import src.classes.instances.locations.rooms.Room;

public abstract class Environment extends Instance{

  private List<? extends Room> rooms;

  public Environment(String name) {
    super(name);
  }


  /**
   * Dialog that will be displayed every time the Player Enters a location
   */
  public abstract String getEntranceDialog();

}