package src.classes.places.environments;

public class EnvTown extends EnvironmentMain{

    // Environment Variables
    private String EnvironmentName;
    private String EntranceDialog;

    // Rooms
    // Entrance, courtyard, tavern, market, castle(leads to another environment)

    public void EnvTown(){
        this.EnvironmentName = "Town Entrance";
        
    }

    @Override
    public String getEnvironmentName() {
        return this.EnvironmentName;
    }

    @Override
    public String getEntranceDialog() {
        EntranceDialog = "This will be filler text for when the Player first gets to the Town.\n"+
                         " The Player sees Two options Enter town or Talk to the guards." ;

        
        
        return EntranceDialog;
    }

}