package src.main;

import src.classes.instances.entities.*;
import src.classes.instances.items.potions.HealingPotion;
import src.classes.instances.items.weapons.BluntObject;
import src.classes.instances.items.weapons.RangedObject;
import src.classes.instances.items.weapons.SharpObject;
import src.classes.instances.items.weapons.Weapon;
/// Project Imports:
//import src.classes.items.weapons.Weapon;
import src.classes.managers.MasterMethods;
import src.classes.managers.instances.ItemManager;
import src.views.*;
import src.classes.instances.locations.environments.Overworld;



public class Start {

  private static ItemManager im = ItemManager.getItemManager();

  public static void startGame(ViewController view) {
    printStart(view);
    initializeGame();
  }

  /**
   * Prints the backstory of the game. 
   * 
   * @param view The viewcontroller of the main application.
   */
  private static void printStart(ViewController view) {
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
    // view.sendText(new String[] {
    //   "In the year 1002, King Ethelred ordered a massacre of",
    //   "all Danish people in England, but he missed you."
    // });
    // MasterMethods.sleep(200);
    // view.sendText("Now you're coming for revenge.");
    // MasterMethods.sleep(3);
    // // Testing different ways to send text
    // view.sendText(new String[] {
    //   "All you have is a dagger, and knowledge that the", 
    //   "Danish king has put a bounty on high ranking members." 
    // });
    // MasterMethods.sleep(200);
    // view.sendText(new String[] {
    //   "You must find a secret contracter to find the targets",
    //   "and the bounties."
    // });
    view.setStoryMode(false);
    // Conversation topic: How will we handle movement
    // Maybe a each room is a grid? 
  }

    /**
   * Set up method creates rooms, weapons, characters, assigns weapons to merchants, bounties to contracters.
   */
  private static Player initializeGame(){
    // All weapons in game
    new RangedObject("hard_rock", 50.00, 11.00);
    new BluntObject("wood_club", 100.00, 15.00);
    new SharpObject("bronze_sword", 100, 32.5);
    new SharpObject("Dagger", 39.99, 10.00);
    
    // Maybe final boss weapon, might take some balancing
    new SharpObject("obsidian_sword", 1500, 50.00);
  
    // All potions in game
    new HealingPotion("basic_healing_potion", 40, 30);
    new HealingPotion("basic_healing_potion_2", 80, 50);

    // Creating enemies
    new Enemy("grunt", 50.00, 20.00);
    new Enemy("edrik", 100.00, 50.00);
    new Enemy("king_ethelred", 250.00, 200.00);
    new Peasant("james", 50.00, 10.00);
    new Merchant("john", 50.00, 10.00);
    new Merchant("johnson", 50.00, 10.00);
    
    // Creating player
    Player player = Player.getInstance();
    player.inventory.add(im.getItem("Dagger"));
    player.equipItem((Weapon)player.getInventory().getInstance("Dagger"));
    player.setLocation(Overworld.getOverWorld());
    return player;
  }

}
