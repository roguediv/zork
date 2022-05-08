package src.classes.instances.entities;

import src.classes.instances.locations.environments.Environment;

/**
 * Class the represents enemy
 */
public class Enemy extends AI {

  /**
   * Constructor for enemy
   * @param name - name of enemy
   * @param weapon - weapon they are carrying
   * @param health - health of enemy
   */
  public Enemy(String name, double health, double money){
    super(name, health, money);
  }
  public Enemy(String name, double health, double money, Environment location){
    super(name, health, money, location);
  }

}
