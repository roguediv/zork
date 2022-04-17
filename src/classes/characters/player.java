package src.classes.characters;
import java.util.List;

/**
 * player class that represents the main player
 */
public class Player extends Character
{
  // Eagar initialization singleton pattern
  private static final Player mainPlayer = new Player();

  private Player() {
    super("");
  }

  public static Player getInstance() {
    return mainPlayer;
  }
  // Variable for player's money
  private double money = 0;

  // Variable for player's health
  private double health = 100.00;

  // backpack that holds items
  // This is public for easy of looping through, adding items, using items and removing items.
  public List<?> backpack;

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
