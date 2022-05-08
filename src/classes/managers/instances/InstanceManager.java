package src.classes.managers.instances;

import src.classes.instances.Instance;
import src.classes.instances.entities.BountyPlacer;
import src.classes.instances.entities.Merchant;
import src.classes.instances.items.Quest;

public class InstanceManager {
  private static final InstanceManager instanceManager = new InstanceManager();



  private InstanceCollection<Instance> instances = new InstanceCollection<Instance>();

  private InstanceManager() {}

  public static InstanceManager getInstanceManager() {
    return instanceManager;
  }

  public InstanceCollection<Instance> getInstances() {return instances;}

  public boolean createInstance(Instance Instance) {
    if (instances.contains(Instance)) {return true;}
    if (Instance == null) return false;
    for (Instance instance : instances ) {
      if (Instance.getName().equals(instance.getName())) {
        System.out.println("Instance: '" + Instance.getName() + "' has another instance of the same name within the game. Could not create.");
        return false;
      }
    }
    instances.add(Instance);
    return true;
  }

  public void removeInstance(Instance Instance) {instances.remove(Instance);}
}
