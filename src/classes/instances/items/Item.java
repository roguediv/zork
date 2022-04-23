package src.classes.instances.items;

import src.classes.instances.Instance;

public abstract class Item extends Instance {
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

  // Every item will have a name.
  private String name;

  /**
   * Gets name
   */
  public String getName() {
    return name;
  }

  public void setName(String s) {
    name = s;
  }

  public void useItem() {
    // Code that every item runs when using an item...
    // e.g: make the item disappear. 
  }
}
