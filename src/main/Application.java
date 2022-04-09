package src.main;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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
    // potential treachery. Except the main character who was out for revenge
    // Working on 
    view.sendText("1042 London, England");
    Sleep(1);
    view.sendText("You have lived your whole in hiding, all thanks");
    view.sendText("to king Ethelred. Just because you are Danish.");
    Sleep(1);
    view.sendText("In the year 1002, King Ethelred ordered a massacre of");
    view.sendText("all Danish people in England, but he missed you.");
    Sleep(1);
    view.sendText("Now you're coming for revenge.");
    Sleep(2);
  }
  // Method to save time writing sleep time
  public static void Sleep(int i){
    try{
    TimeUnit.SECONDS.sleep(i);
    }
    catch(Exception e){}
  }
  public static void HelpButton(){
    //TO:DO code help buttons
    //Figure it should be here, due to needing to send the text
  }
}