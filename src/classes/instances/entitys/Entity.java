package src.classes.instances.entitys;

import java.util.ArrayList;
import java.util.List;
import src.classes.instances.items.armor.Armor;
import src.classes.instances.items.weapons.Weapon;
import src.classes.instances.Instance;
import src.classes.instances.items.Item;

/**
 * Abstract character class
 */
public abstract class Entity extends Instance {

  // Variable for player's money
  private double money = 0;

  // Players max health
  private double maxHealth = 100.00;

  // Variable for player's health
  private double health = 100.00;

  // backpack that holds items
  // This is public for easy of looping through, adding items, using items and removing items.
  public List<Item> inventory = new ArrayList<Item>();

  public Item primary;

  public Armor[] outfit = {
    new Armor("empty_shoes", 0, 0, 0),
    new Armor("empty_leggings", 0, 0, 0),
    new Armor("empty_shrit", 0, 0, 0),
    new Armor("empty_helm", 0, 0, 0)
  };

  /**
  * Constructor for character class
  * @param name character's name
  */
  public Entity(String name){
    super(name);
  }

  /**
  * Constructor for character class
  * @param name character's name
  */
  public Entity(String Name, double Health){
    super(Name);
    this.health = Health;
    this.maxHealth = Health;
  }

  public void give(Item item) {
    inventory.add(item);
  }

  /**
   * Health getter
   * @return
   */
  public double getHealth(){
    return health;
  }

  /**
   * Health setter
   * @param health
   */
  public void heal(double Health){
    health += Health;
    health = health > maxHealth ? maxHealth : health;
  }

  public void damange(double Health) {
    health -= Health;
    if (health <= 0) die();
  }
  
  /**
   * Money getter
   * @return
   */
  public double getMoney() {
    return money;
  }

  /**
   * Money setter
   * @param money
   */
  public void setMoney(double money) {
    this.money = money;
  }

  public void equipItem(Weapon item) {
    primary = item;
  }

  public void equipItem(Armor item) {
    outfit[item.getType()] = item;
  }

  private void die() {}
}
