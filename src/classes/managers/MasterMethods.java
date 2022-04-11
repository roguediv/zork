package src.classes.managers;

import java.util.concurrent.TimeUnit;

public class MasterMethods {
  private static MasterMethods methods = null;

  private MasterMethods() {

  }

  public static MasterMethods methods() {
    if (methods == null) {
      methods = new MasterMethods();
    } 
    return methods;
  }

  /**
   * A method to implement sleep function
   * Sleep function is to help passing of text displaying
   * @param i number of seconds to sleep for
   */
  public static void sleep(int i){
    try{
      TimeUnit.MILLISECONDS.sleep(i);
    }
    catch(Exception e){}
  }
}
