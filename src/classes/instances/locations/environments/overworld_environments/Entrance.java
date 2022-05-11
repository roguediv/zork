package src.classes.instances.locations.environments.overworld_environments;

import src.classes.instances.entities.Enemy;
import src.classes.instances.items.weapons.SharpObject;
import src.classes.instances.locations.environments.Environment;

public class Entrance extends Environment {

  public Entrance(String Name, Environment Source) {
    super(Name, Source, new String[] {"You have entered the castle entrance."});
    
    Enemy edrik = entityManager.getEnemies().getInstance("edrik");
    edrik.setLocation(this);
    SharpObject dagger = new SharpObject("edrik's sword", 0.00, 15.00);
    edrik.equipNewItem(dagger);
  }

}