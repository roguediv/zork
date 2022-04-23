package src.classes.managers.instances;

import java.util.ArrayList;

import src.classes.instances.Instance;

public class InstanceContainer<T extends Instance> extends ArrayList<T> {
  public InstanceContainer() {
    super();
  }

  public T getInstance(String str) {
    for (int i = 0; i < this.size(); i++) {
      T obj = this.get(i);
      if (str.toLowerCase().equals(obj.getName().toLowerCase())) {
        return obj;
      }
    }
    return this.get(0);
  }
  
}
