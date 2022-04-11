package src.$server.logic;

/**
 * A singleton class that manages the flow of data to and from the database.
 * 
 * @author Jake
 */
public class DatabaseManager {
  private static DatabaseManager conn = null;

  private DatabaseManager() {
    // Connect to the database
  }

  public static DatabaseManager DatabaseManager() {
    if (conn == null) {
      conn = new DatabaseManager();
    } return conn;
  }

}
