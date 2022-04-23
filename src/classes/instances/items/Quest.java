package src.classes.instances.items;

import src.classes.instances.entitys.Enemy;

/**
 * A bounty placed on an enemy
 */
public class Quest extends Item {

  private Enemy enemy;
  /**
   * Creates bounty using the reward and the target
   * @param reward
   * @param enemy
   */
  public Quest(Enemy Enemy, double Reward){
    super(Enemy.getName()+"_bounty", Reward);
    setEnemy(Enemy);
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
}
