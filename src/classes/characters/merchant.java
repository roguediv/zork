package src.classes.characters;

import java.util.List;

/**
 * A charcter that sells items
 */
public class merchant<T> extends character{
  // Shop of all items
  public List<T> shop;

  // Merchant constructor
  public merchant(String name){
    super(name);
  }
}
