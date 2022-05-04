package src.classes.instances.items.potions;

import src.classes.instances.entities.Entity;

public class HealingPotion extends Potion{
  public HealingPotion(String Name, double Value, double Points){
    super(Name, Value, Points);
  }

  @Override
  public void useItem(Entity Entity){
    super.useItem(Entity);
    Entity.heal(getPoints());
  }
}
