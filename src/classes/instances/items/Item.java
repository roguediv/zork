package src.classes.instances.items;

import src.classes.instances.entities.Entity;
import src.classes.managers.instances.ItemManager;
import src.classes.instances.Instance;

public abstract class Item extends Instance {
  protected static ItemManager itemManager = ItemManager.getItemManager();
  public Item(String Name, double Value) {
    super(Name);
    value = Value;
  }

  // Every item will have a price.
  private double value;

  /**
   * Gets price
   */
  public double getPrice() {
    return value;
  }

  /**
   * Sets price
   */
  public void setValue(double d) {
    value = d;
  }

  public void useItem(Entity Entity) {
    // Code that every item runs when using an item...
    // e.g: make the item disappear. 
    Entity.removeInventory(this.getName());
    itemManager.removeItem(this.getName());
  }
}
