package src.classes.instances.locations.environments.overworld_environments;

import src.classes.instances.entities.Enemy;
import src.classes.instances.items.weapons.BluntObject;
import src.classes.instances.items.weapons.SharpObject;
import src.classes.instances.locations.environments.Environment;

public class House extends Environment{
  public House(String Name, Environment Source) {
    super(Name, Source, new String[] {"You have entered Jacob's house"});
    
    // This is the process of creating an enemy, creating a weapon, and giving it to the enemy.
    Enemy jacobsMom = new Enemy("Jacob's mom", 10000.00, 50.00, this);
    BluntObject shiv = new BluntObject("Slap", 10.00, 33.00);
    jacobsMom.equipNewItem(shiv);
  }
}
