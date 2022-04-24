package src.classes.managers.instances;

import src.classes.instances.locations.environments.Environment;
import src.classes.instances.locations.environments.OverWorld;

public class LocationManager {
  private static final LocationManager locationManager = new LocationManager();

  private InstanceCollection<Environment> environments = new InstanceCollection<Environment>();

  private LocationManager() {
    OverWorld world = OverWorld.getOverWorld();
  }

  public static LocationManager getLocationManager() {
    return locationManager;
  }
}
