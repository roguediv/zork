package src.classes;

import src.classes.characters.enemy;

/**
 * A bounty placed on an enemy
 */
public class bounty {

  private double reward;
  private enemy enemy;
  /**
   * Creates bounty using the reward and the target
   * @param reward
   * @param enemy
   */
  public bounty(double reward, enemy enemy){
    this.setEnemy(enemy);
    this.setReward(reward);
  }
  /**
   * Get's enemy
   * @return
   */
  public enemy getEnemy() {
    return enemy;
  }
  /**
   * Set's enemy
   * @param enemy
   */
  public void setEnemy(enemy enemy) {
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
