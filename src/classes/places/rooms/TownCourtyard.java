package src.classes.places.rooms;

public class TownCourtyard extends RoomMain{

    private String RoomName = "CourtYard";

    @Override
    public void getKeyWordOptions(String userTextInput) {

        switch(userTextInput.toLowerCase()){
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
                getRoomName();
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

    @Override
    public String getRoomName() {
        return this.RoomName;
    }
    
}
