package src.classes.characters;
import java.util.List;

import src.classes.Bounty;
/**
 * The person who gives bounties
 */
public class BountyPlacer extends Character
{  
  // Eagar initialization singleton pattern
  private static final BountyPlacer bountyPlacer = new BountyPlacer();

  private BountyPlacer() {
    // Passing nothing as it's singleton, name will be set after
    super("");
  }
    
  public static BountyPlacer getInstance() {
    return bountyPlacer;
  }

  public List<Bounty> bounties; 
}
