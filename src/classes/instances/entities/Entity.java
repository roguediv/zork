package src.classes.instances.entities;

import java.util.ArrayList;
import java.util.List;
import src.classes.instances.items.armor.Armor;
import src.classes.instances.items.weapons.Weapon;
import src.classes.instances.locations.environments.Environment;
import src.classes.managers.instances.EntityManager;
import src.classes.managers.instances.InstanceCollection;
import src.classes.instances.Instance;
import src.classes.instances.items.Item;

/**
 * Abstract character class
 */
public abstract class Entity extends Instance {

  // Variable for player's money
  private double money = 0;

  // Players max health
  private double maxHealth;

  // Variable for player's health
  protected double health = 100.00;

  protected double maxStamina = 100;

  protected double stamina = 100;

  protected double critChance = 12;
  protected double defaultCritChance = 12;

  private Environment location;

  // backpack that holds items
  // This is public for easy of looping through, adding items, using items and removing items.
  public InstanceCollection<Item> inventory = new InstanceCollection<Item>();

  public Weapon primary;

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
    this.maxHealth = 100.00;
  }

  /**
  * Constructor for character class
  * @param name character's name
  */
  public Entity(String Name, double Health, double money){
    super(Name);
    this.health = Health;
    this.money = money;
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
  public void heal(double amount){
    health += amount;
    health = health > maxHealth ? maxHealth : health;
  }

  public void damage(double amount) {
    health -= amount;
    if (health <= 0) die();
  }

  public void riseStamina(double Value){
    stamina += Value;
    stamina = stamina > maxStamina ? maxStamina : stamina;
  }

  /**
   * Lowers the stamina of the entity
   * If stamina is less than zero, 
   * entity is damaged by half of the negative stamina value
   * Stamina is set back to zero
   * @param Value How much stamina is lowered
   */
  public void lowerStamina(double Value) {
    stamina -= Value;
    if (stamina < 0) {
      damage((stamina * -1) / 2);
      stamina = 0;
    }
  }

  /**
   * Get the crit chance
   * @return
   */
  public double getCritChance() {
    return critChance;
  }

  /**
   * Increases crit chance
   * @param Num by this number
   */
  public void increaseCritChance(double Num) {
    critChance += Num;
    critChance = critChance > 51 ? 50 : critChance;
  }

  /**
   * Resets the critchance back to it's standard
   */
  public void resetCritChance() {
    critChance = defaultCritChance;
  }
  
  /**
   * Money getter
   * @return
   */
  public double getMoney() {
    return money;
  }

  /**
   * 
   * @param Money
   * @return
   */
  public void setMoney(double money){
    this.money = money;
  }
  /**
   * Spend an entity's money
   * @param Money The money being taken from the entity
   * @return True if purchase was successful 
   */
  public boolean spendMoney(double Money) {
    if (money > Money) {
      money -= Money;
      return true;
    }
    return false;
  }

  public void payMoney(double Money) {
    money += Money;
  }

  public Environment getLocation() {return location;}
  public void setLocation(Environment Location) {location = Location;}

  public InstanceCollection<Item> getInventory() {return inventory;}
  public void addInventory(Item Item) {inventory.add(Item);}
  public void removeInventory(String Name) {inventory.remove(inventory.getInstance(Name));}

  public void dequipItem() {
    if (primary != null) {
      addInventory(primary);
      primary = null;
    }
  }
  public void dequipItem(int Type) {
    if (outfit[Type] != null) {
      addInventory(outfit[Type]);
      outfit[Type] = null;
    }
  }
  public void equipItem(Weapon item) {
    dequipItem();
    primary = item;
  }
  public void equipItem(Armor item) {
    dequipItem(item.getType());
    outfit[item.getType()] = item;
  }

  public void die() {
    EntityManager.getEntityManager().removeEntity(this);
  }

  public double getMaxHealth(){
    return this.maxHealth;
  }
}
