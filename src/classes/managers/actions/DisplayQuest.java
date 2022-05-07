package src.classes.managers.actions;

public class DisplayQuest extends Action {

  public static void displayQuest() {
    start();
    addSpace();
    try{
      addText("Your current bounty:");
      addText("Target: " + player.getQuest().getEnemy().getName());
      addText("Reward: " + player.getQuest().getPrice());
      addText("When complete talk to Wulfstan to redeem reward.");
    }
    catch(Exception e){
      addText("No current bounty found.");
      addText("Talk to Wulfstan to get a quest.");
    }
    end();
  }
}
  