package src.main;

import src.views.*;

/**
 * Final Project: Text-based Game
 * Date: 2022-03-26
 * 
 * Class: #22569 | IT:Program: Part 4 (Java) 
 * Jacob Miranda | StudentID: 24272503
 */

public class Application {
  public static void main(String[] args) {
    ViewController view = new ViewController();
    // On Jun 8th 1042 King Ethelred died
    // In 1002 he ordered the massacre of all Danes in England to elimate
    // potential treachery. Except the main character who was out for revege 
    view.sendText("1042 London, England");
    view.sendText("");
  }
  public static void HelpButton(){
    //TO:DO code help buttons
    //Figure it should be here, due to needing to send the text
  }
}