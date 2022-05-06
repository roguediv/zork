package src.classes.instances.entities;
import java.util.List;

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

  private Player() {
    super("");
  }

  public static Player getInstance() {
    return mainPlayer;
  }

  public int getGameState() {return gameState;}

  public void setGameState(int GameState) {gameState = GameState;}

  @Override
  public void die() {
    super.die();
    // Display death messages
    // Send player to sewers
    // Take away gold
  }

}
