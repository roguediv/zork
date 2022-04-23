package src.classes.instances.items.weapons;

import src.classes.instances.items.Item;

public abstract class Weapon extends Item{
  /**
  * Contructor for Weapon
  */
  public Weapon(double price, String name, double damage){
    // Creates abstract item
    super(price, name);
    this.damage = damage;
  }

  // How much damage the weapon does
  private double damage;

  /**
  * Gets damage
  */
  public double GetDamage(){
    return this.damage;
  }

  /**
  * Sets damage
  */
  public void SetDamage(double d){
    this.damage = d;
  }
    
      
}
