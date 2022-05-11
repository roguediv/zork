package src.classes.instances.locations.environments.overworld_environments;

import src.classes.instances.entities.Enemy;
import src.classes.instances.entities.Player;
import src.classes.instances.items.weapons.SharpObject;
import src.classes.instances.locations.environments.Environment;
import src.classes.instances.locations.environments.underground_environments.Jail;

public class Palace extends Environment {

  public Palace(String Name, Environment Source) {
    super(Name, Source, new String[] {"You have entered the royal palace.",
    "You get closer to the Palace and are approached by a guard."});

    // Create a new enemy and a new weapon. Equip the weapon to the enemy.
    Enemy palaceGuard = new Enemy("guard", 100.00, 50.00, this);
    SharpObject ironSword = new SharpObject("iron_sword", 100.00, 13);
    palaceGuard.equipNewItem(ironSword);

    // Get the king and change his location. create a new weapon and equip it to the King.
    Enemy king = entityManager.getEnemies().getInstance("king_ethelred");
    king.setLocation(this);
    SharpObject dagger = new SharpObject("King's sword", 0.00, 25.00);
    king.equipNewItem(dagger);

    Player player = (Player) entityManager.getEntity("player");

    // Create new dialogue and passes into a ChangeDialgoue method.
    String[][][][] dialogueChange = {
    {
      {
          {"Hault, what is your reason for entering the palace?"}
      },
      {
          {"I'm curious to see what the inside looks like."},
          {"I'm here to kill the King!"},
          {"Leave"}
      }
    },
    {
      {
        {
          "What a bad reason, I'll gladly show you the inside of a cell.",
         "*Start Combat with guard*",
          "(Type attack guard when conversation is over.)"
        }
      }
    },
    {
      {
        {
          "The king happends to be close by and is eager for a challenge",
          "(Type attack king ethelred conversation is over.)"
        },{
          "The king happends to be close by and is eager for a challenge",
          "(Type attack king ethelred conversation is over.)"
        },{
          "The king happends to be close by and is eager for a challenge",
          "(Type attack king ethelred conversation is over.)"
        }
      }
    },
    {
      {
        {"Fine leave!"},
        {"Fine leave!"},
        {"Fine leave!"}
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
        1,2,3
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
  palaceGuard.changeDialog(dialogueChange); 
  palaceGuard.changeProperties(propertiesChange);

    // Send the player to Jail
    //addRoom(new Jail("jail", this));
    //player.setLocation(Environment Jail);
  }
}
