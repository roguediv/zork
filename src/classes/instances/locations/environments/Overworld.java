package src.classes.instances.locations.environments;

public class Overworld extends Environment {

  // Environment Variables
  private String EntranceDialog;

  // Rooms
  // Entrance, courtyard, tavern, market, castle(leads to another environment)

  public Overworld(String name) {
    super(name);

  }

  @Override
  public String getEntranceDialog() {
    EntranceDialog = "This will be filler text for when the Player first gets to the Town.\n" +
        " The Player sees Two options Enter town or Talk to the guards.";

    return EntranceDialog;
  }

}