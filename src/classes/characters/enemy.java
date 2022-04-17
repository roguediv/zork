package src.classes.characters;

/**
 * Class the represents enemy
 */
public class Enemy<T> extends Character{
  // Generic due to different kinds of weapons
  private T weapon;

  // Health of enemy
  private double health;

  /**
   * Constructor for enemy
   * @param name - name of enemy
   * @param weapon - weapon they are carrying
   * @param health - health of enemy
   */
  public Enemy(String name, T weapon, double health){
    super(name);
    this.weapon = weapon;
    this.health = health;
  }

  public T getWeapon() {
    return weapon;
  }

  public double getHealth() {
    return health;
  }

  public void setHealth(double health) {
    this.health = health;
  }

  public void setWeapon(T weapon) {
    this.weapon = weapon;
  }

  
}
