package src.classes.instances.entities;

import src.classes.instances.items.Item;
import src.classes.managers.instances.InstanceCollection;

/**
 * A charcter that sells items
 */
public class Merchant extends AI {
  // Shop of all items
  private InstanceCollection<Item> shop = new InstanceCollection<Item>();

  public void setShopStartDialog(String[] ShopStartDialog){
    shopStartDialog = ShopStartDialog;
  }

  public String[] getShopStartDialog(){
    return shopStartDialog;
  }

  private String[] shopStartDialog = {
    "Welcome to " + this.getName() + "'s shop!",
    "This is what I have stock:"
  };

  // Merchant constructor
  public Merchant(String name, double health, double money){
    super(name, health, money);
  }

  public InstanceCollection<Item> getShop(){
    return shop;
  }

  public void addItem(Item Item) {
    shop.add(Item);
  }

  public void removeItem(Item Item){
    shop.remove(Item);
  }
}
