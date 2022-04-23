package src.classes.instances.entitys;

/**
 * Class the represents enemy
 */
public class Enemy<T> extends Entity{

  /**
   * Constructor for enemy
   * @param name - name of enemy
   * @param weapon - weapon they are carrying
   * @param health - health of enemy
   */
  public Enemy(String name, double health){
    super(name);
  }

}
