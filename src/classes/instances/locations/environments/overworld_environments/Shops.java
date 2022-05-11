package src.classes.instances.locations.environments.overworld_environments;

import src.classes.instances.entities.BountyPlacer;
import src.classes.instances.entities.Merchant;
import src.classes.instances.items.Quest;
import src.classes.instances.items.weapons.SharpObject;
import src.classes.instances.locations.environments.Environment;

public class Shops extends Environment {

  public Shops(String Name, Environment Source) {
    super(Name, Source, new String[] {"Welcome to the shopping district", "There are people around who will let you purchase items.", "Look around for shop owners."});

    /// Merchant that sells items
    Merchant john = entityManager.getMerchants().getInstance("john");
    john.addItem(itemManager.getItem("bronze_sword"));
    john.addItem(itemManager.getItem("wood_club"));
    john.addItem(itemManager.getItem("hard_rock"));
    john.addItem(itemManager.getItem("obsidian_sword"));
    addEntity(john);

    Merchant johnson = entityManager.getMerchants().getInstance("johnson");
    addEntity(johnson);
    johnson.addItem(itemManager.getItem("basic_healing_potion"));
    johnson.addItem(new SharpObject("fakeitem", 1000, 50000));
  }

}
