package src.classes.managers.actions;

public class Help extends Action {

  public static void displayControls() {
    start();
    addText(" ");
    addText("Out of battle controls:");
    addText("-'Look around' to look around");
    addText("-'Move to {room name}' to move around");
    addText("-'Attack {enemy name}' to attack");
    addText("-'Talk to {character name}' to talk to a character");
    addText("-'Pick up {potion name}' to pick up potion");
    addText("-'Swap to {weapon/armor name}' to swap primary weapon/armor");
    addText("-'Inventory' to view inventory");
    addText("-'Bounty' to view current bounty");
    addText("|");
    addText("In battle controls:");
    addText("-'Swap to {weapon/armor name}' to swap primary weapon/armor");
    addText("-'Use potion {potion name}' to use a potion");
    addText("-'1' or button one for main attack");
    addText("-'2' or button three for defensive move");
    addText("-'3' or button three for reckless attack");
    addText("-'4' or button three for to flee");
    addText(" ");
    end();
  }

  public static void notFound() {
    start();
    addText("The wind blows and there is silence (that is not a valid command, type 'help' if you're confused).");
    end();
  }

}