package src.classes.managers.actions;

import src.classes.instances.entities.BountyPlacer;
import src.classes.instances.entities.Player;

public class AcceptBounty extends Action {

  static void acceptBounty(String target){
    start();
    System.out.println(target);
    Player player = Player.getInstance();
    BountyPlacer wulfstan = BountyPlacer.getInstance();
    if(player.getLocation().getEntities().getInstance("Wulfstan") != null){
      try{
        if(player.getQuest() != null){
            if(player.getQuest().getEnemy().getHealth() > 0){
              wulfstan.addQuest(player.getQuest());
            }
            player.setQuest(null);
            addText("Your last bounty was removed.");
        }
        player.setQuest(wulfstan.getQuest(target));
        wulfstan.removeQuest(player.getQuest());
        addText("Bounty accepted. Time to kill " + displayName(player.getQuest().getName()));
      }
      catch(Exception e){
        addText("Bounty not found. Try using 'Accept target {target name}'");
      }
    }
    else{
      addText("Wulfstan isn't around now");
    }
    end();
  }
}
