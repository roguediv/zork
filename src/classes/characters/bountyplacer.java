package src.classes.characters;
import java.util.List;

import src.classes.bounty;
/**
 * The person who gives bounties
 */
public class bountyplacer extends character{
  
  private static bountyplacer bountyPlacer = null;

  /**
   * Constructor
   * @param name
   */
  private bountyplacer(String name) {
    super(name);
  }
    
  public static bountyplacer makeBountyPlacer(String name) {
    if (bountyPlacer == null) {
      bountyPlacer = new bountyplacer(name);
    } 
    return bountyPlacer;
  }

  public List<bounty> bounties; 
}
