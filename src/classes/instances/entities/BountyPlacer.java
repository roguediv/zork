package src.classes.instances.entities;
import java.util.List;

import src.classes.instances.items.Quest;
import src.classes.managers.instances.InstanceCollection;
/**
 * The person who gives bounties
 */
public class BountyPlacer extends Entity {
  // Eagar initialization singleton pattern
  private static final BountyPlacer bountyPlacer = new BountyPlacer();

  private InstanceCollection<Quest> quests = new InstanceCollection<Quest>();

  private BountyPlacer() {
    // Passing nothing as it's singleton, name will be set after
    super("Wulfstan");
  }
    
  public static BountyPlacer getInstance() {
    return bountyPlacer;
  }

  public Quest getQuest(String String) {
    return quests.getInstance(String);
  }

  public void addQuest(Quest Quest) {
    quests.add(Quest);
  }

}
