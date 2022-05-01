package src.classes.managers.actions;

import src.classes.instances.entities.*;
import src.classes.managers.MasterMethods;

public class DialogueController extends Action {

  private static final DialogueController dialogueController = new DialogueController();
  private int stage = 0;
  private int part = 0;
  private boolean willAttack = false;
  private AI subject;

  private DialogueController() {}

  public static DialogueController getDialogueController() {
    return dialogueController;
  }

  public void startDialogue(Entity Subject) {
    start();
    getFirstDialog(Subject);
    end();
  }

  public void runDialogue(String Res) {
    start();
    try {
      catchResponse(Integer.parseInt(Res) - 1);
    } catch (Exception e) {
      addText("Please enter a number to select an option...");
      appendOptions(subject.getDialogue()[stage][1]);
    }
    
    end();
  }

  public void getFirstDialog(Entity Subject) {
    if (Subject == null) {
      addText("That person is not able to talk.");
      return;
    }
    try {
      subject = (AI)Subject;
    } catch (Exception e) {
      addText(displayName(displayName(subject.getName())) + " is not able to talk.");
      return;
    }
    InputWatcher.changeInput(1);
    stage = 0;
    subjectOutput(getRandomDialogueString(subject.getDialogue()[stage][0]));
  }

  public void catchResponse(int res) {
    userOutput(subject.getDialogue()[stage][1][res]);
    stage = subject.getDialogueProperties()[stage][1][res];
    part = res;
    subjectOutput(subject.getDialogue()[stage][0][res]);
  }

  private void userOutput(String[] Text) {
    Text[0] = "\"" + Text[0];
    Text[Text.length - 1] = Text[Text.length - 1] + "\"";
    addText("You:");
    addText(Text);
    addSpace();
  }

  private void subjectOutput(String[] Text) {
    Text[0] = "\"" + Text[0];
    Text[Text.length - 1] = Text[Text.length - 1] + "\"";
    addText(displayName(subject.getName()) + ":");
    addText(Text);
    if (subject.getDialogueProperties()[stage][0][part] == 1) {
      optionOutput();
    } else {
      addSpace();
      addText("The conversation with " + displayName(subject.getName()) + " has ended.");
      endDialog();
    }
  }

  private void optionOutput() {
    addSpace();
    addText("Select an option...");
    appendOptions(subject.getDialogue()[stage][1]);
  }

  private void appendOptions(String[][] Options) {
    int i = 1;
    for (String[] option : Options) {
      addText("- Option "+ i +":");
      addText(option);
      i++;
    }
  }

  private String[] getRandomDialogueString(String[][] Strings) {
    double chance = 100 / Strings.length;
    for (int i = 0; i < Strings.length; i++) {
      if (MasterMethods.getChance(chance)) {
        part = i;
        return Strings[i];
      } 
    }
    return Strings[Strings.length - 1];
  }

  private void endDialog() {
    if (willAttack) {

    } else {
      InputWatcher.changeInput(0);
      subject = null;
    }
  }

}
