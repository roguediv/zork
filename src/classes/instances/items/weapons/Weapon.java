package src.classes.instances.items.weapons;

import src.classes.instances.items.Item;

public abstract class Weapon extends Item{
  /**
  * Contructor for Weapon
  */
  public Weapon(String name, double value, double damage){
    // Creates abstract item
    super(name, value);
    this.damage = damage;
  }

  // How much damage the weapon does
  private double damage;

  /**
  * Gets damage
  */
  public double getDamage(){
    return this.damage;
  }

  /**
  * Sets damage
  */
  public void setDamage(double d){
    this.damage = d;
  }
    
      
}
