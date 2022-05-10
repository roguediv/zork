package src.classes.instances.locations.environments.underground_environments;

import src.classes.instances.locations.environments.Environment;

public class Jail extends Environment {

  public Jail(String Name, Environment Source) {
    super(Name, Source, new String[] {"test"});

    addRoom(new Sewer("Sewer", this));
  }
}
