package src.classes.managers.actions;

import src.classes.instances.entities.*;

public class Dialogue extends Action {
  private static final DialogueController dialogueController = DialogueController.getDialogueController();

  public static void newDialog(String name) {
    start();
    // If the name entered is Wulfstan then he will either pay you for quests, tell you have a quest active still or let you pick a new quest.
    System.out.println(name);
    if(name.toLowerCase().equals("wulfstan")){
      System.out.println("Why");
      if(player.getQuest() == null){
        pickQuest();
      }
      else if(player.getQuest().getCompleted() == true){
        addText("Wulfstan:\"Wow, you actually killed " + player.getQuest().getName() + "!\"");
        addText("Wulfstan:\"Well, here is your reward of " + player.getQuest().getPrice() + " \"");
        addText("You now have " + player.getMoney() + " gold.");
        pickQuest();
      }
      else{
        addText("Wulfstan:\"Looks like you still have your hands full with " + player.getQuest().getName() +  "\"");
      }
      end();
    }
    else{
      Entity subject = location.getEntities().getInstance(name);
      dialogueController.startDialogue(subject);
    }
  }

  public static void run(String input) {
    start();
    dialogueController.runDialogue(input);
  }

  public static void pickQuest(){
    BountyPlacer wulfstan = BountyPlacer.getInstance();
    addText(" ");
    addText("Wulfstan: \"Here for a contract?\"");
    for(int i = 0; i < wulfstan.getQuests().size(); i++){
      addText("Bounty on: " + wulfstan.getQuests().get(i).getName() + " Reward: " + wulfstan.getQuests().get(i).getPrice());
    }
  }
}
