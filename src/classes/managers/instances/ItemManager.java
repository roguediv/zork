package src.classes.managers.instances;
import java.util.List;

import src.classes.instances.items.weapons.Weapon;

import java.util.ArrayList;
import src.classes.instances.items.weapons.*;
import src.classes.instances.items.Quest;
import src.classes.instances.items.potions.*;

public class ItemManager {
  private static ItemManager itemManager = new ItemManager();

  private InstanceCollection<Weapon> weapons = new InstanceCollection<Weapon>();

  private InstanceCollection<Potion> potions = new InstanceCollection<Potion>();

  private ItemManager() {
    // All weapons in game
    weapons.add(new RangedObject("hard_rock", 2, 20.00));
    weapons.add(new BluntObject("wood_club", 10, 15.00));
    weapons.add(new SharpObject("bronze_sword", 100, 32.5));
    // Maybe final boss weapon, might take some balancing
    weapons.add(new SharpObject("obsidian_sword", 1500, 50.00));

    // All potions in game
    potions.add(new HealingPotion("Basic_Healing_Potion", 40));
  }

  public static ItemManager getItemManager() {return itemManager;}

  public Weapon getWeapon(String name) {return weapons.getInstance(name);}
}
