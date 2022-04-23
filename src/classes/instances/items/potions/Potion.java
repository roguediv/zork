package src.classes.instances.items.potions;

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

  public Potion(String name, double value) {
    /**
     * Main constructor of the potion item.
     * 
     * 
     */
    super(name, value);
  }

  @Override
  public void useItem() {
    // Runs code for every potion that is used. 

    super.useItem(); // Remove the item from player inv

    // Code that every potion runs when using a potion...
  }

}
