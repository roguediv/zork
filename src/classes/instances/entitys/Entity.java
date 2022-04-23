package src.classes.instances.entitys;

import java.util.List;

import src.classes.instances.items.Item;

/**
 * Abstract character class
 */
public abstract class Entity {
  /**
  * Constructor for character class
  * @param name character's name
  */
  public Entity(String name){
    this.name = name;
  }

  private String name; 
  // Variable for player's money
  private double money = 0;

  // Variable for player's health
  private double health = 100.00;

  // backpack that holds items
  // This is public for easy of looping through, adding items, using items and removing items.
  public List<? extends Item> inventory;

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
  public void setHealth(Double health){
    this.health = health;
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

  /**
  * Gets character's name
  * @return return's name as a String
  */
  public String getName(){
    return this.name;
  }

  /**
   * Sets character's name
   * @param name character's name
  */
  public void setName(String name){
    this.name = name;
  }
}
