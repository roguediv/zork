package src.classes.managers.actions;

import src.classes.instances.entities.*;
import src.classes.managers.MasterMethods;

public class DialogueController extends Action {

  private static final DialogueController dialogueController = new DialogueController();
  /**
   * Stage of the subjects AI
   */
  private int stage = 0;
  /**
   * Part of the stage
   */
  private int part = 0;
  /**
   * Whether this convo will end in an attack from the subject
   */
  private boolean willAttack = false;
  /**
   * The person being spoken to by the user
   */
  private AI subject;

  private DialogueController() {}

  public static DialogueController getDialogueController() {
    return dialogueController;
  }

  /**
   * Opens a dialogue with a subject
   * @param Subject The entity being spoken to
   */
  public void startDialogue(Entity Subject) {
    start();
    getFirstDialog(Subject);
    end();
  }

  /**
   * Runs whenever the user takes a dialogue action
   * @param Res Response string
   */
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

  /**
   * Trys to cast a entity as an AI
   * @param Subject The entity being casted
   */
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

  /**
   * Manages the output after the user sends an input
   * @param res User input
   */
  public void catchResponse(int res) {
    userOutput(subject.getDialogue()[stage][1][res]);
    stage = subject.getDialogueProperties()[stage][1][res];
    part = res;
    subjectOutput(subject.getDialogue()[stage][0][res]);
  }

  /**
   * Manages displaying what the user says
   * @param Text The text that the user says
   */
  private void userOutput(String[] Text) {
    Text[0] = "\"" + Text[0];
    Text[Text.length - 1] = Text[Text.length - 1] + "\"";
    addText("You:");
    addText(Text);
    addSpace();
  }

  /**
   * Manages displaying what the subject says
   * @param Text What the subject says
   */
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

  /**
   * Displays the list of options that the user has to say
   */
  private void optionOutput() {
    addSpace();
    addText("Select an option...");
    appendOptions(subject.getDialogue()[stage][1]);
  }

  /**
   * Outputs the options the user has to say
   * @param Options The options the user has to say
   */
  private void appendOptions(String[][] Options) {
    int i = 1;
    for (String[] option : Options) {
      addText("- Option "+ i +":");
      addText(option);
      i++;
    }
  }

  /**
   * Takes dialogue options and returns a random option
   * @param Strings The strings to choose from
   * @return A random string
   */
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

  /**
   * Ends a dialogue with a subject
   */
  private void endDialog() {
    if (willAttack) {

    } else {
      InputWatcher.changeInput(0);
      subject = null;
    }
  }

}
