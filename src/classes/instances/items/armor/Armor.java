package src.classes.instances.items.armor;

import src.classes.instances.items.Item;

public class Armor extends Item {
  private double durability = 100.00;
  private double condition = 100.00;
  private double defense = 100.00;
  private int type = 0;
  private String[] types = {
    "shoes", "leggings", "chest", "helm"
  };


  public Armor(String Name, double Price,  double Defense, int Type) {
    super(Name, Price);
    defense = Defense;
    type = Type;
  }

  public int getType() {
    return type;
  }

  public String getType(int type) {
    return types[type];
  }
}
