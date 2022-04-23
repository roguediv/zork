package src.classes.instances.locations.rooms;

public class Shops extends Room {

  private String RoomName = "CourtYard";

  public Shops(String Name) {
    super(Name);
  }

  @Override
  public void getKeyWordOptions(String userTextInput) {

    switch (userTextInput.toLowerCase()) {
      case "enter tavern":
        enterTavern();
        break;
      case "enter market":
        enterMarket();
        break;
      case "enter castle":
        enterCastle();
        break;
      case "current location":
        this.getName();
        break;
      default:
        break;
    }

  }

  private void enterCastle() {
  }

  private void enterMarket() {
  }

  private void enterTavern() {
  }

}
