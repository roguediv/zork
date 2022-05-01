package src.classes.managers.actions;
import src.classes.instances.items.Item;
import src.classes.instances.locations.environments.Environment;
import src.classes.managers.instances.InstanceCollection;

public class Inventory extends Action {

  public static void displayInventory() {
    start();
    InstanceCollection<Item> inv = player.getInventory();
    int i = 0;
    for (Item item : inv) {
      addText("- "+item.getName().replace("_", " "));i++;
    }
    if (i == 0) addText("You have nothing in your Inventory.");
    end();
  }

  public static void retrieve(String Name) {
    start();
    if (Name == null) {
      Observe.find("item");
      return;
    }
    getItem(Name);
    end();
  }

  private static void getItem(String Name) {
    if (Name == null) return;
    Environment location = player.getLocation();
    Item item = location.retrieveItem(Name);
    if (item == null) {addText(displayName(Name) + " could not be found in " + displayName(location.getName()) + ".");return;} 
    player.addInventory(item); 
    addText(displayName(item.getName()) + " has been added to your bag.");
  }

}
