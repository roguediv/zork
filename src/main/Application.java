package src.main;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import src.classes.*;
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
  
    // Story elements below, feel free to change I am not a writer
    // On Jun 8th 1042 King Ethelred died
    // In 1002 he ordered the massacre of all Danes in England to elimate
    // potential treachery. Final boss could be King Ethelred
    view.sendText("1042 London, England");
    Sleep(2);
    view.sendText("You have lived your whole in hiding, all thanks");
    view.sendText("to king Ethelred. Just because you are Danish.");
    Sleep(2);
    view.sendText("In the year 1002, King Ethelred ordered a massacre of");
    view.sendText("all Danish people in England, but he missed you.");
    Sleep(2);
    view.sendText("Now you're coming for revenge.");
    Sleep(3);
    // Testing different ways to send text
    view.sendText(new String[]{
      "All you have is a dagger, and knowledge that the", 
      "Danish king has put a bounty on high ranking members." 
    });
    Sleep(2);
    view.sendText(new String[]{
      "You must find a secret contracter to find the targets",
      "and the bounties."
    });
    Sleep(2);
    // Conversation topic: How will we handle movement
    // Maybe a each room is a grid? 


  }
  /**
   * A method to implement sleep function
   * Sleep function is to help passing of text displaying
   * @param i number of seconds to sleep for
   */
  public static void Sleep(int i){
    try{
    TimeUnit.SECONDS.sleep(i);
    }
    catch(Exception e){}
  }
  /**
   * A function to display help features, will flush out once controls are decided
   */
  public static void HelpButton(){
    //TO:DO code help buttons
  }
}