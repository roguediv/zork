package src.classes.instances.locations.environments.overworld_environments;

import src.classes.instances.entities.Enemy;
import src.classes.instances.entities.Player;
import src.classes.instances.items.weapons.SharpObject;
import src.classes.instances.locations.environments.Environment;
import src.classes.instances.locations.environments.underground_environments.Jail;

public class Palace extends Environment {

  public Palace(String Name, Environment Source) {
    super(Name, Source, new String[] {"test"});

    // You get closer to the Palace and are approached by a guard.
    // "Hault, what is your reason for entering the palace?"

    Enemy palaceGuard = new Enemy("guard", 100.00, 50.00, this);
    SharpObject ironSword = new SharpObject("iron_sword", 100.00, 20);
    palaceGuard.equipNewItem(ironSword);

    Enemy kingEtherlred = entityManager.getEnemies().getInstance("king_ethelred");

    Player player = (Player) entityManager.getEntity("player");

    String[][][][] dialogueChange = {
    {
      {
          {"Hault, what is your reason for entering the palace?"}
      },
      {
          {"I'm curious to see what the inside looks like."},
          {"Leave"}
      }
    },
    {
      // After option 1 is picked
      {
        {"What a bad reason, I'll gladly show you the inside of a cell."}
      },
      {
        {"*Start Combat with guard*",
          "(Type attack guard)"}
      }
    },
    {
      {
        {"Fine leave!"}
      }
    }
  };

  int[][][] propertiesChange = {
    {
      {
        1,1,0,0
      },
      {
        1,2,2,2
      }
    },
    {
      {
        1,1,0,0
      },
      {
        2,2,2,2
      }
    },
    {
      {
        0,0,0,0
      }
    }
  };
  palaceGuard.changeDialog(dialogueChange); 
  palaceGuard.changeProperties(propertiesChange);

    // Send the player to Jail
    //addRoom(new Jail("jail", this));
    //player.setLocation(Environment Jail);
  }
}
