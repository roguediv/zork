package src.classes.managers.actions;
import src.classes.instances.entities.Player;
import src.classes.instances.items.Item;
import src.classes.instances.locations.environments.Environment;
import src.classes.managers.instances.InstanceCollection;
import src.views.ViewController;

public class Inventory extends Action {

  public static void displayInventory() {
    InstanceCollection<Item> inv = player.getInventory();
    int i = 0;
    for (Item item : inv) {
      view.sendText(item.getName().replace("_", " "));i++;
    }
    if (i == 0) view.sendText("You have nothing in your Inventory.");
  }

  public static void retrieve(String Name) {
    Environment location = player.getLocation();
    Item item = location.retrieveItem(Name);
    if (item == null) {view.sendText(Name + " could not be found in " + location.getName() + ".");return;} 
    player.addInventory(item); 
    view.sendText(item.getName().replace("_", " ") + " has been added to your bag.");
  }

}
