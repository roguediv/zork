package src.classes.characters;

import java.util.List;

/**
 * A charcter that sells items
 */
public class Merchant<T> extends Character{
  // Shop of all items
  public List<T> shop;

  // Merchant constructor
  public Merchant(String name){
    super(name);
  }
}
