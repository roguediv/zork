package src.classes.characters;
import java.util.Collections;
import java.util.List;

import src.classes.items.*;

/**
 * player class that represents the main player
 */
public class player<T> extends character
{
  private static player mainPlayer = null;

  private player(String name) {
    super(name);
    }
  
  public static player makePlayer(String name) {
    if (mainPlayer == null) {
      mainPlayer = new player(name);
    } 
    return mainPlayer;
  }
  // Variable for player's money
  private double money = 0;

  // Variable for player's health
  private double health = 100.00;

  // backpack that holds items
  // This is public for easy of looping through, adding items, using items and removing items.
  public List<T> backpack;

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

}
