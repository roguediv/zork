package src.classes.instances.entities;

import src.classes.instances.items.Item;
import src.classes.managers.instances.InstanceCollection;

/**
 * A charcter that sells items
 */
public class Merchant extends AI {
  // Shop of all items
  private InstanceCollection<Item> shop = new InstanceCollection<Item>();

  /** Set the beginning shop dialogue */
  public void setShopStartDialog(String[] ShopStartDialog){
    shopStartDialog = ShopStartDialog;
  }
  /** Get the start shop dialogue */
  public String[] getShopStartDialog(){
    return shopStartDialog;
  }
  /** Default shopstartdialogue */
  private String[] shopStartDialog = {
    "Welcome to " + this.getName() + "'s shop!",
    "This is what I have stock:"
  };

  /** Constructor for merchant */
  public Merchant(String name, double health, double money){
    super(name, health, money);
  }
  /**
   * Returns the items in shop
   * @return
   */
  public InstanceCollection<Item> getShop(){
    return shop;
  }
  /**
   * Adds an item to the shop
   * @param Item
   */
  public void addItem(Item Item) {
    shop.add(Item);
  }
  /**
   * Removes an item from the shop
   * @param Item
   */
  public void removeItem(Item Item){
    shop.remove(Item);
  }
}
