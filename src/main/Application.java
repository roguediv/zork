package src.main;

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
    ViewController view = ViewController.getViewController();
    Start.startGame(view);
  }

}