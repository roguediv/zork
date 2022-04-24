package src.classes.managers.actions;

import src.classes.instances.entities.Player;
import src.views.ViewController;

public abstract class Action {
  protected static Player player = Player.getInstance();
  protected static ViewController view = ViewController.getViewController();
  public static String findWordAfter(String[] words, int phraseStart, int phraseWordNum) {
    return words[phraseStart + phraseWordNum];
  }
}
