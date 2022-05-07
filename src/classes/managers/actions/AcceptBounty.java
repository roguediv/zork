package src.classes.managers.actions;

import src.classes.instances.entities.BountyPlacer;
import src.classes.instances.entities.Player;

public class AcceptBounty extends Action {

  static void acceptBounty(String target){
    start();
    Player player = Player.getInstance();
    BountyPlacer wulfstan = BountyPlacer.getInstance();
    if(player.getLocation().equals(wulfstan.getLocation())){
      try{
        player.setQuest(wulfstan.getQuest("target"));
        addText("Quest accepted. Time to kill " + player.getQuest().getName());
      }
      catch(Exception e){
        addText("Quest not found. Try using 'Accept target {target name}'");
      }
    }
    else{
      addText("Wulfstan isn't around now");
    }
    end();
  }
}
