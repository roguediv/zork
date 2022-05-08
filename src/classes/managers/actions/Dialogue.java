package src.classes.managers.actions;

import src.classes.instances.entities.*;
import src.classes.instances.items.Item;
import src.classes.managers.MasterMethods;

public class Dialogue extends Action {
  private static final DialogueController dialogueController = DialogueController.getDialogueController();

  public static void newDialog(String name) {
    start();
    Entity subject = location.getEntities().getInstance(name);
    // If the name entered is Wulfstan then he will either pay you for quests, tell you have a quest active still or let you pick a new quest.
    if(name.toLowerCase().equals("wulfstan")){
      if(player.getLocation().getEntities().getInstance("Wulfstan") != null){
      if(player.getQuest() == null){
        pickQuest();
      }
      else if(player.getQuest().getEnemy().getHealth() <= 0.00){
        addText("Wulfstan:\"Wow, you actually killed " + player.getQuest().getName() + "!\"");
        addText("Wulfstan:\"Well, here is your reward of " + player.getQuest().getValue() + "\"");
        player.payMoney(player.getQuest().getValue());
        addText("You now have " + player.getMoney() + " gold.");
        pickQuest();
      }
      else{
        addText("Wulfstan:\"Looks like you still have your hands full with " + player.getQuest().getName() +  "\"");
        addText("Wulfstan:\"Would you like to exchange it?\"");
        pickQuest();
      }
      end();
    }
    else{
      addText("Wulfstan is not around.");
      end();
    }
    }
    else if(MasterMethods.getMerchant(subject) != null){
      InputWatcher.changeInput(3);
      Merchant merchant = MasterMethods.getMerchant(subject);
      Buy.setMerchant(merchant);
      for(String s: merchant.getShopStartDialog()){
        addText(s);
      }
      for(Item i: merchant.getShop()){
        addText(displayName(i.getName()) + " | Price: " + i.getValue());
      }
      addText("- 'Exit' Leave Shop");
      end();
    }
    else{
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
      addText("Bounty on: " + wulfstan.getQuests().get(i).getName() + " Reward: " + wulfstan.getQuests().get(i).getValue());
    }
  }
}
