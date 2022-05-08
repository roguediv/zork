package src.classes.instances.entities;

import javax.tools.DocumentationTool.Location;

import src.classes.instances.locations.environments.Environment;

public class AI extends Entity {

  protected String[][][][] dialogue = {
    {
      {
        {"Hello, I'm a person...", "how are you doing today?"},
        {"I are human.", "oh yeah..."},
        {"I'm a part of the human species.", "It is good."}
      },
      {
        {"I see that."},
        {"Cool story bro."},
        {"I'm a human too!"},
        {"Goodbye."}
      }
    },
    {
      {
        {"I see you."},
        {"Your story is just beginning."},
        {"What kind of human are you?"},
        {"..."}
      },
      {
        {"I'm a merchant."},
        {"I'm a prince."},
        {"I'm an assassin, here to kill the king."},
        {"Mind your own beezwax."}
      }
    },
    {
      {
        {"I won't buy what you're selling."},
        {"You aren't dessed like a prince."},
        {"Scary..."},
        {"..."}
      }
    }
  };

  protected int[][][] dialogueProperties = {
    {
      {
        1, 1, 1, 1
      }, 
      {
        1, 1, 1, 1
      }
    },
    {
      {
        0, 0, 1, 0
      }, 
      {
        2, 2, 2, 2
      }
    }, 
    {
      {
        0, 0, 0, 0
      }
    }
  };

  public String[][][][] getDialogue() {return dialogue;}
  public int[][][] getDialogueProperties() {return dialogueProperties;}

  public void changeDialog(String[][][] String, int ArrayNum) {
    dialogue[ArrayNum] = String;
  }

  public void changeProperties(int[][] Change, int ArrayNum) {
    dialogueProperties[ArrayNum] = Change;
  }

  /// Mark - Encounter

  protected int[] movePercentage = {
    10, 10, 30, 50
  };

  protected String[][] fightLines = {
    {"Why would you do this?"},
    {""},
    {"I'm getting out of here! You're crazy!"}
  };

  public AI(String Name, double Health, double money) {
    super(Name, Health, money);
  }
  public AI(String Name, double Health, double Money, Environment Location) {
    super(Name, Health, Money);
    setLocation(Location);
  }

  public void die(Environment env) {
    super.die();
    try{
      env.removeEntity(this.getName());
      this.setMoney(0);
    }
    catch(Exception e){
      System.out.println(e.toString());
    }
  }

  @Override
  public void setLocation(Environment location) {
    try {
      this.getLocation().removeEntity(this);
    } catch(Exception e) {}
    try {
      if (!location.hasEntity(this)) {
        location.addEntity(this);
      }
      super.setLocation(location);
    } catch (Exception e) {
      location.addEntity(this);
      super.setLocation(location);
    }

  }
}
