import src.classes.instances.locations.environments.Environment;
import src.classes.managers.instances.InstanceCollection;

public class Help extends Action {

  public static void displayControls() {
    start();
    add("Out of battle controls:");
    add("'Look around' to look around");
    add("'Move to {room name}' to move around");
    add("'Attack {enemy name}' to attack");
    add("'Talk to {character name}' to talk to a character");
    add("'Pick up {potion name}' to pick up potion")
    add("'Swap to {weapon/armor name}' to swap primary weapon/armor");
    add("'Inventory' to view inventory");
    add("In battle controls:");
    add("'Swap to {weapon/armor name}' to swap primary weapon/armor");
    add("'Use potion {potion name}' to use a potion");
    add("'one' or button one for main attack");
    add("'two' or button three for defensive move");
    add("'three' or button three for dangerous attack");
    end();
  }