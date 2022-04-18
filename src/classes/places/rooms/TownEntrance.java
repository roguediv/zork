package src.classes.places.rooms;

public class TownEntrance extends RoomMain{

    private String RoomName = "Town Entrance";
    
    public void getKeyWordOptions(String userTextInput) {

        switch(userTextInput.toLowerCase()){
            case "talk to guards":
                talkToGuardsOption();
                break;
            case "enter town":
                enterTheTownOption();
                break;
            case "current location":
                getRoomName();
                break;
            default:
                break;
        }
    }

    public String getRoomName() {
        return this.RoomName;
    }

    // When the user enters, "Talk to Guards".
    private String talkToGuardsOption(){
        String d = "The Guards talk Filler.";
        return d;
    }

    // When the user enters, "Enter town".
    private String enterTheTownOption(){
        String d = "The Player entered the Town Filler.";
        return d;
    }


}