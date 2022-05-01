package src.classes.managers.instances;

import java.util.ArrayList;

import src.classes.instances.Instance;

public class InstanceCollection<T extends Instance> extends ArrayList<T> {
  public InstanceCollection() {
    super();
  }

  public T getInstance(String str) {
    for (int i = 0; i < this.size(); i++) {
      T obj = this.get(i);
      if (str.toLowerCase().replace(" ", "_").equals(obj.getName().toLowerCase().replace(" ", "_"))) {
        return obj;
      }
    }
    return null;
  }
  
}
