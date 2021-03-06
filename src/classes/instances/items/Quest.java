package src.classes.instances.items;

import src.classes.instances.entities.Enemy;
import src.classes.instances.locations.environments.Environment;

/**
 * A bounty placed on an enemy
 */
public class Quest extends Item {

  private Enemy enemy;
  private Boolean completed;
  /**
   * Creates bounty using the reward and the target
   * @param reward
   * @param enemy
   */
  public Quest(Enemy Enemy, double Reward){
    super(Enemy.getName(), Reward);
    if (Enemy == null) System.out.println("Enemy is null for quest.");
    setEnemy(Enemy);
  }
  public Quest(Enemy Enemy, double Reward, Environment instanceHolder){
    super(Enemy.getName(), Reward);
    instanceHolder.addInstance(Enemy);
    if (Enemy == null) System.out.println("Enemy is null for quest.");
    setEnemy(Enemy);
  }

  public Boolean getCompleted() {
    return completed;
  }
  public void setCompleted(Boolean completed) {
    this.completed = completed;
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
