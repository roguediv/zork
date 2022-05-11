package src.classes.instances.locations.environments.underground_environments;

import src.classes.instances.locations.environments.Environment;

public class Sewer extends Environment {

  /**
   * The sewer
   * @param Name
   * @param Source
   */
  public Sewer(String Name, Environment Source) {
    super(Name, Source, new String[] {"You have entered the Sewer, it smells."});
  }
}
