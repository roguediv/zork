package src.classes.managers;

import java.util.concurrent.TimeUnit;

import src.classes.instances.items.Item;
import src.classes.instances.items.armor.Armor;
import src.classes.instances.items.potions.Potion;
import src.classes.instances.items.weapons.Weapon;
import java.util.Random;

public class MasterMethods {
  private static MasterMethods methods = null;

  private MasterMethods() {

  }

  public static MasterMethods methods() {
    if (methods == null) {
      methods = new MasterMethods();
    } 
    return methods;
  }

  /**
   * A method to implement sleep function
   * Sleep function is to help passing of text displaying
   * @param i number of seconds to sleep for
   */
  public static void sleep(int i){
    try{
      TimeUnit.MILLISECONDS.sleep(i);
    }
    catch(Exception e){}
  }

  /**
   * Converts all "_" to " " and each first letter of every word to a capital
   * @param string The string from the database
   * @return The string as should be displayed to the user
   */
  public static String displayName(String string) {
    String[] words = string.split("_");
    String rtn = "";
    for (String word : words) {
      rtn += word.substring(0, 1).toUpperCase() + word.substring(1, word.length()) + " ";
    }
    return rtn.trim();
  }

  public static int getItemType(Item Item) {
    int rtn = 0;
    try {
      Weapon item = (Weapon)Item;
      rtn = 1;
    } catch(Exception e) {}
    try {
      Armor item = (Armor)Item;
      rtn = 2;
    } catch(Exception e) {}
    try {
      Potion item = (Potion)Item;
      rtn = 3;
    } catch(Exception e) {}

    return rtn;
  }

  /**
   * Generates a random number between 1 and 100, then compares it to a percentage
   * @param Percentage Number compared with random number
   * @return If random number is within percentage, returns true
   */
  public static boolean getChance(double Percentage) {
    Random rand = new Random();
    if ((rand.nextInt(100) + 1) <= Percentage) return true;
    return false;
  }

}
