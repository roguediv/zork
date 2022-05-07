package src.classes.instances.entities;

import src.classes.instances.items.Item;
import src.classes.managers.instances.InstanceCollection;

/**
 * A charcter that sells items
 */
public class Merchant<T> extends AI {
  // Shop of all items
  private InstanceCollection<Item> shop = new InstanceCollection<Item>();

  // Merchant constructor
  public Merchant(String name, double health, double money){
    super(name, health, money);
  }

  public void addItem(Item Item) {
    shop.add(Item);
  }
}
