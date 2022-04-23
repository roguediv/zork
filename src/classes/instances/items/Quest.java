package src.classes.instances.items;

import src.classes.instances.entitys.Enemy;

/**
 * A bounty placed on an enemy
 */
public class Quest extends Item {

  private double reward;
  private Enemy enemy;
  /**
   * Creates bounty using the reward and the target
   * @param reward
   * @param enemy
   */
  public Quest(double reward, Enemy enemy){
    super(-1, "Bounty");
    this.setEnemy(enemy);
    this.setReward(reward);
  }
  /**
   * Get's enemy
   * @return
   */
  public Enemy getEnemy() {
    return enemy;
  }
  /**
   * Set's enemy
   * @param enemy
   */
  public void setEnemy(Enemy enemy) {
    this.enemy = enemy;
  }
  /**
   * Get's reward
   * @return
   */
  public double getReward() {
    return reward;
  }
  /**
   * Set's reward
   * @param reward
   */
  public void setReward(double reward) { 
    this.reward = reward;
  }
}
