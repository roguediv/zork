package src.classes.managers.actions;

import src.classes.instances.items.Item;
import src.classes.instances.items.armor.Armor;
import src.classes.instances.items.potions.*;
import src.classes.instances.items.weapons.*;

public class Trigger extends Action {
  /**
   * Equips, dequips, and uses item based on word
   * @param Word The item being searched for
   */
  public static void item(String Word) {
    start();
    Item item = player.getInventory().getInstance(Word);
    if (item == null) {addText("There is no " + Word + " in your inventory.");end();return;}
    switch (getItemType(item)) {
      case 1:
        if (player.primary != null) 
          addText("You dequiped the " + displayName(player.primary.getName()) + " from your priamry weapon slot.");
        player.equipItem((Weapon)item);
        addText("You equiped the " + displayName(item.getName()) + " as your primary weapon.");
        break;
      case 2:
        if (player.outfit[((Armor)item).getType()] != null)
          addText("You took off the " + player.outfit[((Armor)item).getType()].getName() + " from your " + ((Armor)item).getType(((Armor)item).getType()));
        player.equipItem((Armor)item);
        addText("You equiped the " + displayName(item.getName()) + " to your " + ((Armor)item).getType(((Armor)item).getType()));
        break;
      case 3:
        Potion potion = (Potion)item;
        double health1 = player.getHealth();
        potion.useItem(player);
        double health2 = player.getHealth();
        addText("You used the " + displayName(potion.getName()) + " and it restored " + (health2 - health1) + " points of health.");
        break;
    }
    end();
  }
}
