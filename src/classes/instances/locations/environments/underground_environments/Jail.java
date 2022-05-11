package src.classes.instances.locations.environments.underground_environments;

import src.classes.instances.locations.environments.Environment;

public class Jail extends Environment {

  /**
   * The jail
   * @param Name
   * @param Source
   */
  public Jail(String Name, Environment Source) {
    super(Name, Source, new String[] {"You have entered the jail"});

    addRoom(new Sewer("Sewer", this));
  }
}
