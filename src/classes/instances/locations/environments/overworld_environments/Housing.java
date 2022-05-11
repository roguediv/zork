package src.classes.instances.locations.environments.overworld_environments;

import src.classes.instances.locations.environments.Environment;
import src.classes.instances.locations.environments.overworld_environments.*;

public class Housing extends Environment {

  public Housing(String Name, Environment Source) {
    super(Name, Source, new String[] {"You have entered the housing district."});
    addRoom(new House("jacob's_house", this));
    addItem(itemManager.getItem("Basic_Healing_Potion"));
  }

}
