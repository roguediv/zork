package src.classes.managers.instances;

import src.classes.instances.locations.environments.Environment;
import src.classes.instances.locations.environments.Overworld;

public class LocationManager {
  private static final LocationManager locationManager = new LocationManager();

  private InstanceCollection<Environment> environments = new InstanceCollection<Environment>();

  private LocationManager() {
    Overworld world = Overworld.getOverWorld();
  }

  public static LocationManager getLocationManager() {
    return locationManager;
  }
}
