package src.classes.characters;
/**
 * Class to represent peasant which may give clues or side quests (if time)
 */
public class peasant extends character{
  // Information the peasent is holding
  private String information;

  /**
   * Constructor
   * @param info - information the peasant holds
   * @param name
   */
  public peasant(String info, String name){
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
