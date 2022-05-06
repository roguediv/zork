package src.classes.instances.locations.environments.overworld_environments;

import src.classes.instances.locations.environments.Environment;
import src.classes.instances.locations.environments.overworld_environments.*;

public class Housing extends Environment {

  public Housing(String Name, Environment Source) {
    super(Name, Source, new String[] {"Test"});
    addRoom(new House("jacob's_house", this));
  }

}
