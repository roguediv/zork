package src.classes.instances.locations.environments.overworld_environments;

import src.classes.instances.entities.BountyPlacer;
import src.classes.instances.entities.Merchant;
import src.classes.instances.items.Quest;
import src.classes.instances.locations.environments.Environment;

public class Shops extends Environment {

  public Shops(String Name, Environment Source) {
    super(Name, Source, new String[] {"test"});

    /// Merchant that sells items
    Merchant john = entityManager.getMerchants().getInstance("john");
    john.addItem(itemManager.getItem("bronze_sword"));
    john.addItem(itemManager.getItem("wood_club"));
    john.addItem(itemManager.getItem("hard_rock"));
    john.addItem(itemManager.getItem("basic_healing_potion"));
    john.addItem(itemManager.getItem("obsidian_sword"));
  
    /// Creating bounty placer and adding bounties
    BountyPlacer wulfstan = BountyPlacer.getInstance();
    wulfstan.addQuest(new Quest(entityManager.getEnemies().getInstance("grunt"), 25));
    wulfstan.addQuest(new Quest(entityManager.getEnemies().getInstance("edrik"), 100));
    wulfstan.addQuest(new Quest(entityManager.getEnemies().getInstance("king_ethelred"), 1000000.00));
  }

}