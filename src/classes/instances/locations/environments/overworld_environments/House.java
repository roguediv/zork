package src.classes.instances.locations.environments.overworld_environments;

import src.classes.instances.locations.environments.Environment;

public class House extends Environment{
  public House(String Name, Environment Source) {
    super(Name, Source, new String[] {"test"});
    addItem(itemManager.getItem("Great Healing Potion"));
  }
}
