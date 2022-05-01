package src.classes.instances.entities;

public class AI extends Entity {

  protected String[][][][] dialogue = {
    {
      {
        {"Hello, I'm a person..."},
        {"I are human."},
        {"I'm a part of the human species."}
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

  /// Mark - Encounter

  protected int[] movePercentage = {
    10, 10, 30, 50
  };

  protected String[][] fightLines = {
    {"Why would you do this?"}
  };

  public AI(String Name) {
    super(Name);
  }

  public String[][][][] getDialogue() {return dialogue;}
  public int[][][] getDialogueProperties() {return dialogueProperties;}
}
