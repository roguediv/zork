package src.classes.characters;
/**
 * Class to represent peasant which may give clues or side quests (if time)
 */
public class Peasant extends Character{
  // Information the peasent is holding
  private String information;

  /**
   * Constructor
   * @param info - information the peasant holds
   * @param name
   */
  public Peasant(String info, String name){
    super(name);
    this.information = info;
  }

  /**
   * Set information
   * @param info
   */
  public void setInfo(String info){
    this.information = info;
  }

  /**
   * Get information
   * @return
   */
  public String getInfo(){
    return this.information;
  }
}
