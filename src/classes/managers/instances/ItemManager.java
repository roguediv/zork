package src.classes.managers.instances;
import java.util.List;

import src.classes.instances.items.weapons.Weapon;

import java.util.ArrayList;
import src.classes.instances.items.weapons.*;
import src.classes.instances.items.Item;
import src.classes.instances.items.Quest;
import src.classes.instances.items.potions.*;

public class ItemManager {
  private static ItemManager itemManager = new ItemManager();
  private InstanceManager instanceManager = InstanceManager.getInstanceManager();

  private InstanceCollection<Item> items = new InstanceCollection<Item>();

  private ItemManager() {
    // All weapons in game
    createItem(new RangedObject("hard_rock", 2, 20.00));
    createItem(new BluntObject("wood_club", 10, 15.00));
    createItem(new SharpObject("bronze_sword", 100, 32.5));
    // Maybe final boss weapon, might take some balancing
    createItem(new SharpObject("obsidian_sword", 1500, 50.00));

    // All potions in game
    createItem(new HealingPotion("basic_healing_potion", 40, 30));
    createItem(new HealingPotion("basic_healing_potion_2", 80, 50));
  }

  public static ItemManager getItemManager() {return itemManager;}

  public Item getItem(String Name) {return items.getInstance(Name);}

  public void createItem(Item Item) {
    if (instanceManager.createInstance(Item)) 
      items.add(Item);
  }

  public void removeItem(Item Item) {
    instanceManager.removeInstance(Item);
    items.remove(Item);
  }
}
