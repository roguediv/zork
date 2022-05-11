package src.classes.managers.actions;

/**
 * Displays the controls to view controller.
 */
public class Help extends Action {

  /**
   * Displays the controls
   */
  public static void displayControls() {
    start();
    addText("Out of battle controls:");
    addText("-'Look around' to look around");
    addText("-'Move to {room name}' to move around");
    addText("-'Go back' to go back to last room or if stuck in a dead end");
    addText("-'Attack {enemy name}' to attack");
    addText("-'Talk to {character name}' to talk to a character");
    addText("-'Pick up {potion name}' to pick up potion");
    addText("-'Swap to {weapon/armor name}' to swap primary weapon/armor");
    addText("-'Inventory' to view inventory");
    addText("-'Bounty' to view current bounty");
    addText("-'Accept Target {bounty name}' to accept a bounty");
    addText("-'Buy {item name}' to buy an item");
    addSpace();
    addText("In battle controls:");
    addText("-'Swap to {weapon/armor name}' to swap primary weapon/armor");
    addText("-'Use potion {potion name}' to use a potion");
    addText("-'1' or button one for main attack");
    addText("-'2' or button two for defensive move");
    addText("-'3' or button three for reckless attack");
    addText("-'4' or button four for to flee");
    end();
  }

  /**
   * Displays when command isn't found.
   */
  public static void notFound() {
    start();
    addText("The wind blows and there is silence (that is not a valid command, type 'help' if you're confused).");
    end();
  }

}