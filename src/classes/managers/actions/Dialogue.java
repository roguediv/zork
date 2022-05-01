package src.classes.managers.actions;

import src.classes.instances.entities.*;

public class Dialogue extends Action {
  private static final DialogueController dialogueController = DialogueController.getDialogueController();

  public static void newDialog(String word) {
    start();
    Entity subject = location.getEntities().getInstance(word);
    dialogueController.startDialogue(subject);
  }

  public static void run(String input) {
    dialogueController.runDialogue(input);
  }

}
