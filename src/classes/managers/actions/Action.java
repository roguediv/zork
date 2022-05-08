package src.classes.managers.actions;

import java.util.ArrayList;
import java.util.List;

import src.classes.instances.entities.Player;
import src.classes.instances.items.Item;
import src.classes.instances.locations.environments.Environment;
import src.classes.managers.MasterMethods;
import src.views.ViewController;

public abstract class Action {
  protected static Player player = Player.getInstance();
  protected static Environment location = player.getLocation();
  protected static ViewController view = ViewController.getViewController();
  private static ArrayList<String> strings = new ArrayList<String>();
  public static String findWordAfter(String[] words, int phraseStart, int phraseWordNum) {
    if (words.length <= phraseStart + phraseWordNum) return null;
    return words[phraseStart + phraseWordNum];
  }
  protected static void start() {
    ViewController.setTypeSpeed(15);
    strings.clear();
    location = player.getLocation();
  }
  protected static void addText(String string) {strings.add(string);}
  protected static void addText(String[] Strings) {
    for (String string : Strings) {
      addText(string);
    }
  }
  protected static void addSpace() {addText(" ");}
  protected static ArrayList<String> getStrings() {return strings;}
  protected static void end() {view.sendText(strings);}
  protected static String displayName(String string) {return MasterMethods.displayName(string);}
  protected static int getItemType(Item Item) {return MasterMethods.getItemType(Item);}
}
