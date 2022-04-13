package src.main;


import java.util.concurrent.TimeUnit;

import src.classes.Weapon;
import src.views.*;
/**
 * Final Project: Text-based Game
 * Date: 2022-03-26
 * 
 * Class: #22569 | IT:Program: Part 4 (Java) 
 * Jacob Miranda | StudentID: 24272503
 * Tristan Butzine | StudentID: 24415685
 */
public class Application {

  public static void main(String[] args) {
    ViewController view = new ViewController();
    Start.printStart(view);
    Start.initializePlayer();
  }

  /**
   * A function to display help features, will flush out once controls are decided
   */
  public static void HelpButton(){
    //TO:DO code help buttons
  }

}