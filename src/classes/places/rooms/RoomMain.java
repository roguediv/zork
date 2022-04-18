package src.classes.places.rooms;

public abstract class RoomMain{

    /**
     * When the user tries to enter keyword this method will turn everything lowercase
    *  and check if the users word matches any in the current room.
    * @param userTextInput
    */
    public abstract void getKeyWordOptions(String userTextInput);

    public abstract String getRoomName();

}