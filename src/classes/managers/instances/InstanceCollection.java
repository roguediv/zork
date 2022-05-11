package src.classes.managers.instances;

import java.util.ArrayList;
import src.classes.instances.Instance;

/**
 * Uses arraylist to store instances with added code
 */
public class InstanceCollection<T extends Instance> extends ArrayList<T> {

  /**
   * Run default code on construction
   */
  public InstanceCollection() {super();}

  /**
   * Use a name to get an instance from arraylist
   * @param str Name of the entity
   * @return The object once found or null if not found
   */
  public T getInstance(String str) {
    for (int i = 0; i < this.size(); i++) {
      T obj = this.get(i);
      if (str.toLowerCase().replace(" ", "_").trim().equals(obj.getName().toLowerCase().replace(" ", "_").trim())) {
        return obj;
      }
    }
    return null;
  }
  
}
