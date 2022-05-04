package src.classes.instances.items.potions;

import src.classes.instances.entities.Entity;

import src.classes.instances.items.Item;

/**
 * A item object called potion.
 * 
 * A <code>Potion</code> object extends the <code>Item</code> class
 * 
 * @author Tristan, Jake
 * @version 0.1.0
 */

public abstract class Potion extends Item {
  /**
   * If our character has a potion in their bag, and they drink it?
   * How will we update their health? Is this in the main method or is this in the
   * player class?
   * We could have different potions return different values, but we couldn't
   * access the player class's
   * health from the potion class.
   */

  private double points;  

  private String type;

  public Potion(String name, double value, Double points) {
    /**
     * Main constructor of the potion item.
     * 
     * 
     */
    super(name, value);
    this.points = points;
    this.setType(type);
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public void useItem(Entity Entity) {
    super.useItem(Entity); // Remove the item from player inv

    // Code that every potion runs when using a potion...

  }

  public double getPoints() {
    return points;
  }

}
