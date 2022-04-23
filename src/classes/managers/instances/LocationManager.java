package src.classes.managers.instances;

public class LocationManager {
  private static final LocationManager locationManager = new LocationManager();

  private LocationManager() {

  }

  public static LocationManager getLocationManager() {
    return locationManager;
  }
}
