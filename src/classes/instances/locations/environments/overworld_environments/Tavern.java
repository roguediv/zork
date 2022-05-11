package src.classes.instances.locations.environments.overworld_environments;

import java.time.LocalTime;

import src.classes.instances.entities.Enemy;
import src.classes.instances.entities.Merchant;
import src.classes.instances.locations.environments.Environment;

public class Tavern extends Environment {

  public Tavern(String Name, Environment Source) {
    super(Name, Source, new String[] {"When you enter the tavern you see a crowd of villagers looking for a fight.",
    "A bartender with the right amount of coin he could tell you somthing important."});
    
    // Create a villager enemy and a bartender merchant
    Enemy tavernVillager = new Enemy("villager", 10.00, 50.00, this);
    Merchant bartender = new Merchant("bartender", 50.00, 10.00);
    
    // Populate the Bartenders shop
    addEntity(bartender);
    bartender.addItem(itemManager.getItem("beer"));
    bartender.addItem(itemManager.getItem("broken_bottle"));
    bartender.addItem(itemManager.getItem("information"));

    // Create new dialogue and passes into a ChangeDialgoue method.
    String[][][][] dialogueChange = {
        {
            {
                {"Are you here to fight?"},
            },
            {
                {"I'm here to fight."},
                {"Just watching."},
                {"Leave"}
            }
        },
        {
            {
                {"Lets fight then!",
                 "(Type attack villager after the conversation ends.)"}
            }
        },
        {
            {
                {"Quit wasting my time."},
                {"Quit wasting my time."},
                {"Quit wasting my time."}
            }
        }
    };

    // Change the properties for the new dialogue options.
    int[][][] propertiesChange = {
        {
            {
              1
            },
            {
              1,2,2,2
            }
          },
          {
            {
              0, 0, 0, 0
            },
            {
              0
            }
          },  
          {
            {
              0, 0, 0, 0
            }
          }
    };
    
    // Use the dialogue and properties variable created above and change the
    // the new enemys dialogue and properties.
    tavernVillager.changeDialog(dialogueChange); 
    tavernVillager.changeProperties(propertiesChange);
 }

}