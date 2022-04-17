package src.classes.items;

public abstract class Item {
  public Item(double price, String name) {
    this.price = price;
    this.name = name;
  }

  // Every item will have a price.
  private double price;

  /**
   * Gets price
   */
  public double getPrice() {
    return price;
  }

  /**
   * Sets price
   */
  public void setPrice(double d) {
    this.price = d;
  }

  // Every item will have a name.
  private String name;

  /**
   * Gets name
   */
  public String getName() {
    return this.name;
  }

  public void setName(String s) {
    this.name = s;
  }

  public void useItem() {
    // Code that every item runs when using an item...
    // e.g: make the item disappear. 
  }
}
