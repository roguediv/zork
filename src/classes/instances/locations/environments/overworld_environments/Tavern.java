package src.classes.instances.locations.environments.overworld_environments;

import src.classes.instances.entities.Enemy;
import src.classes.instances.entities.Merchant;
import src.classes.instances.locations.environments.Environment;

public class Tavern extends Environment {

  public Tavern(String Name, Environment Source) {
    super(Name, Source, new String[] {"Tavern Entered"});

    // "When you enter the tavern you see a crowd of villagers looking for a fight.",
    // "A bartender with the right amount of coin he could tell you somthing important."

    Enemy tavernVillager = new Enemy("villager", 10.00, 50.00, this);
    Merchant bartender = new Merchant("bartender", 50.00, 10.00);
    
    addEntity(bartender);
    bartender.addItem(itemManager.getItem("beer"));
    bartender.addItem(itemManager.getItem("broken_bottle"));
    bartender.addItem(itemManager.getItem("information"));

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
    
    tavernVillager.changeDialog(dialogueChange); 
    tavernVillager.changeProperties(propertiesChange);
 }

}