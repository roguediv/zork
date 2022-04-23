package src.classes.instances.entitys;
import java.util.List;

import src.classes.instances.items.Quest;
/**
 * The person who gives bounties
 */
public class BountyPlacer extends Entity
{  
  // Eagar initialization singleton pattern
  private static final BountyPlacer bountyPlacer = new BountyPlacer();

  private BountyPlacer() {
    // Passing nothing as it's singleton, name will be set after
    super("Wulfstan");
  }
    
  public static BountyPlacer getInstance() {
    return bountyPlacer;
  }

  public List<Quest> bounties; 
}
