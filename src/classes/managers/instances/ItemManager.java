package src.classes.managers.instances;

import src.classes.instances.items.weapons.*;
import src.classes.instances.items.Item;
import src.classes.instances.items.potions.*;

public class ItemManager {
  private static ItemManager itemManager = new ItemManager();
  private InstanceManager instanceManager = InstanceManager.getInstanceManager();

  private InstanceCollection<Item> items = new InstanceCollection<Item>();

  private ItemManager() {}

  /**
   * Get singleton class
   * @return class
   */
  public static ItemManager getItemManager() {return itemManager;}

  /**
   * Get an item from class
   * @param Name The name to be searched for
   * @return
   */
  public Item getItem(String Name) {return items.getInstance(Name);}

  /**
   * Check if item currently exists
   * @param Item
   * @return
   */
  public boolean hasItem(Item Item) {if (items.contains(Item)) return true; else return false;}
  public boolean hasItem(String Name) {if (items.getInstance(Name) != null) return true; else return false;}

  /**
   * Create an item
   * @param Item The item to be created
   */
  public boolean createItem(Item Item) {
    if (instanceManager.createInstance(Item)) 
      if (!hasItem(Item))
        {items.add(Item);return true;}
    return false;
  }

  /**
   * Remove an item using a name
   * @param Name String to be found
   */
  public void removeItem(String Name) {
    instanceManager.removeInstance(items.getInstance(Name));
    items.remove(items.getInstance(Name));
  }
  /**
   * Remove an item using object
   * @param Item The object to be removed
   */
  public void removeItem(Item Item) {
    instanceManager.removeInstance(Item);
    items.remove(Item);
  }
}
