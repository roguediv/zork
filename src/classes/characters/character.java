package src.classes.characters;
/**
 * Abstract character class
 */
public abstract class Character {
  /**
  * Constructor for character class
  * @param name character's name
  */
  public Character(String name){
    this.name = name;
  }

  private String name; 

  /**
  * Gets character's name
  * @return return's name as a String
  */
  public String getName(){
    return this.name;
  }

  /**
   * Sets character's name
   * @param name character's name
  */
  public void setName(String name){
    this.name = name;
  }
}
