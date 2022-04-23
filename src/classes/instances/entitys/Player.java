package src.classes.instances.entitys;
import java.util.List;

/**
 * player class that represents the main player
 */
public class Player extends Entity
{
  // Eagar initialization singleton pattern
  private static final Player mainPlayer = new Player();

  private Player() {
    super("");
  }

  public static Player getInstance() {
    return mainPlayer;
  }

}
