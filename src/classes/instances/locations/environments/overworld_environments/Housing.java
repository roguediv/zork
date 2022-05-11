package src.classes.instances.locations.environments.overworld_environments;

import src.classes.instances.locations.environments.Environment;
import src.classes.instances.locations.environments.overworld_environments.*;

/**
 * This housing district
 */
public class Housing extends Environment {

  public Housing(String Name, Environment Source) {
    super(Name, Source, new String[] {"You have entered the Housing District."});
    addRoom(new House("jacob's_house", this));
    addItem(itemManager.getItem("Great_Healing_Potion"));
  }

}
