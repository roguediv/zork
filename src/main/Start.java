package src.main;

/// Project Imports:
//import src.classes.items.weapons.Weapon;
import src.classes.managers.MasterMethods;
import src.views.*;

public class Start {

  /**
   * Prints the backstory of the game. 
   * 
   * @param view The viewcontroller of the main application.
   */
  public static void printStart(ViewController view) {
    // Story elements below, feel free to change I am not a writer
    // On Jun 8th 1042 King Ethelred died
    // In 1002 he ordered the massacre of all Danes in England to elimate
    // potential treachery. Final boss could be King Ethelred
    view.setStoryMode(true);
    view.sendText("1042 London, England");
    //MasterMethods.sleep(200);
    view.sendText(new String[] {
      "You have lived your whole life in hiding, all thanks",
      "to king Ethelred. Just because you are Danish."
    });
    //MasterMethods.sleep(200);
    view.sendText(new String[] {
      "In the year 1002, King Ethelred ordered a massacre of",
      "all Danish people in England, but he missed you."
    });
    MasterMethods.sleep(200);
    view.sendText("Now you're coming for revenge.");
    MasterMethods.sleep(3);
    // Testing different ways to send text
    view.sendText(new String[] {
      "All you have is a dagger, and knowledge that the", 
      "Danish king has put a bounty on high ranking members." 
    });
    MasterMethods.sleep(200);
    view.sendText(new String[] {
      "You must find a secret contracter to find the targets",
      "and the bounties."
    });
    view.setStoryMode(false);
    // Conversation topic: How will we handle movement
    // Maybe a each room is a grid? 
  }

    /**
   * Set up method creates rooms, weapons, characters, assigns weapons to merchants, bounties to contracters.
   */
  public static void initializePlayer(){
    //Weapon dagger = new Weapon(39.99, "Dagger");
  }

}
