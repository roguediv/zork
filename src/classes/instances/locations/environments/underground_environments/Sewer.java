package src.classes.instances.locations.environments.underground_environments;

import src.classes.instances.locations.environments.Environment;

public class Sewer extends Environment {

  public Sewer(String Name, Environment Source) {
    super(Name, Source, new String[] {"test"});
  }
}
