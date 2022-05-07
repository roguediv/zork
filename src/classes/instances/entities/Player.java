package src.classes.instances.entities;
import java.util.List;

import src.classes.instances.items.Quest;
import src.classes.instances.locations.environments.Overworld;

/**
 * player class that represents the main player
 */
public class Player extends Entity
{
  // Eagar initialization singleton pattern
  private static final Player mainPlayer = new Player();

  /**
   * The current gamestate of the player represented by an int.
   * 0: Open Play
   * 1: Conversation
   * 2: Encounter
   */
  private int gameState = 0;

  // The quest the player current has
  private Quest quest = null;

  private Player() {
    super("");
  }

  /**
   * get's quest
   * @return
   */
  public Quest getQuest() {
    return quest;
  }

  /**
   * sets quest
   * @param quest
   */
  public void setQuest(Quest quest) {
    this.quest = quest;
  }

  public static Player getInstance() {
    return mainPlayer;
  }

  public int getGameState() {return gameState;}

  public void setGameState(int GameState) {gameState = GameState;}

  @Override
  public void die() {
    super.die();
    mainPlayer.setLocation(Overworld.getOverWorld());
    mainPlayer.setMoney(mainPlayer.getMoney() / 2);
    // Take away gold
  }

}
