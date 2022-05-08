package src.classes.managers.actions;

/// External Imports
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Collections;

/// Internal Imports.
import src.classes.instances.Instance;
import src.classes.instances.entities.Player;
import src.classes.managers.instances.InstanceCollection;
import src.views.ViewController;

/**
 * The <code>InputWatcher</code> object contains the intelligence 
 * behind recognising what a user types and having the program
 * properly react to it. 
 * @author Jake
 */
public class InputWatcher {
  private static Player player = Player.getInstance();

  private static int inputType = 0;

  /**
   * Max words that a phrase can be. 
   */
  private static final int maxWords = 2;

  /**
   * The actions that can be taken by the player based on an input. 
   */
  private static enum Actions {
    MOVE, OBSERVE, INVENTORY, RETRIEVE, TRIGGER, DIALOGUE,  
    ENCOUNTER, HELP, DISPLAYQUEST, ACCEPT, NOACT;
  }

  /**
   * Phrases that are recognized by the game engine
   * 
   * Phrases can include up to 2 words
   * If more than 2 words is ever needed, increase the maxWords variable within this class
   */
  private static String[][] phrases = {
    /// phrases for traversing the world
    {"go to", "enter", "through", "move", "location", "go"},
    /// phrases for viewing the world
    {"look at", "look", "observe", "view", "find", },
    /// phrases for viewing inventory
    {"inventory", "bag", "stuff", "items", "weapons", "potions", "armour", "armor"},
    /// Phrases for retrieving an item
    {"retrieve", "pick up", "take", "get", "grab"},
    /// phrases for triggering an item
    {"use", "trigger", "activate", "operate", "equip", "hold", "put on", "change weapon"},
    /// phrases for speaking with AI
    {"speak with", "talk to", "speak", "talk", "converse", "ask"},
    /// phrases for beginning an encounter with an AI
    {"attack", "fight", "assassinate", "assult", "kill", "murder", "battle"},
    // Help
    {"help", "controls", "hint"},
    // Bounty
    {"bounty", "quest", "goal", "mission"},
    // Accepting bounty
    {"accept target", "accept"}
  };

  /**
   * Filler words that don't matter to the logic and can be
   * removed from the input.
   */
  private static String[] filteredWords = {
    "a", "i", "the", "at", "for", "to", ""
  };

  /**
   * Check an input provided by the user and test it against
   * phrases.
   * @param input Input provided by the user
   */
  public static void watchUserInput(String input) {
    switch (inputType) {
      case 1:
        inputType1(input);
        break;
      case 2:
        inputType2(input);
        break;
      case 3:
        inputType3(input);
        break;
      default: 
        inputType0(input);
    }
  }

  /**
   * This runs when user is not in conversation or dialogue
   * @param Input Text the user sends
   */
  private static void inputType0(String Input) {
    /// Prepare the words array for assessment
    String[] words = filterStringArray(cleanInput(Input.toLowerCase()).split(" "), filteredWords);
    
    int phraseNum = -1; // What action the user is taking
    int wordNum = -1; // What position in the array is the phrase
    int wordsInPhrase = -1; // How many words are in the phrase
    
    /// Search through every item
    for (int i = 0; i < phrases.length; i++) {
      Object[] results = searchField(phrases[i], words);
      if ((boolean)results[0]) {
        phraseNum = i;
        wordNum = (int)results[1];
        wordsInPhrase = (int)results[2];
        break;
      }
    }

    /// Guard for errors
    if (phraseNum < 0 || wordNum < 0 || wordsInPhrase < 0) return;

    /// Run the code for each input
    runInputType(getAction(phraseNum), words, wordNum, wordsInPhrase);
  }

  /**
   * Runs whenever the user is in dialogue
   * @param Input User input
   */
  private static void inputType1(String Input) {
    Dialogue.run(Input);
  }

  /**
   * Runs whenever the user is in an encounter
   * @param Input User input
   */
  private static void inputType2(String Input) {
    /// Check if player is trying to use an item
    String[] words = filterStringArray(cleanInput(Input.toLowerCase()).split(" "), filteredWords);
    Object[] results1 = searchField(phrases[2], words);
    Object[] results2 = searchField(phrases[4], words);
    if ((boolean)results1[0]) {
      /// Use the item or swap primary weapons
      runInputType(getAction(2), words, (int)results1[1], (int)results1[2]);
      Encounter.runEncounter("-2");
    } else if ((boolean)results2[0]) {
      /// Use the item or swap primary weapons
      runInputType(getAction(4), words, (int)results2[1], (int)results2[2]);
      Encounter.runEncounter("-1");
    } else {
      /// Calls the encounter class to pick a move/run enemy move.
      Encounter.runEncounter(Input);
    }
  }

  /**
   * Runs whenever the user is in dialogue
   * @param Input User input
   */
  private static void inputType3(String Input) {
    if(Input.toLowerCase() == "exit"){
      changeInput(0);
      ViewController.getViewController().sendText("You have left the shop.");
      return;
    }
    Buy.buyShop(Input.toLowerCase().replace(' ', '_').replace("buy_", ""));
  }


  /**
   * Switch statement that runs code for each Actions enum
   * @param action Actions enum that will be used
   * @param words Full input array of words
   * @param wordNum Index where phrase starts
   * @param wordsInPhrase Num of words in the phrase
   * @param view Where output is printed
   */
  private static void runInputType(Actions action, String[] words, int wordNum, int wordsInPhrase) {
    
    switch (action) {
      case MOVE:
        Move.newLocation(Action.findWordAfter(words, wordNum, wordsInPhrase));
        break;
      case OBSERVE:
        Observe.find(Action.findWordAfter(words, wordNum, wordsInPhrase));
        break;
      case INVENTORY:
        Inventory.displayInventory();
        break;
      case RETRIEVE:
        Inventory.retrieve(Action.findWordAfter(words, wordNum, wordsInPhrase));
        break;
      case TRIGGER:
        Trigger.item(Action.findWordAfter(words, wordNum, wordsInPhrase));
        break;
      case DIALOGUE:
        Dialogue.newDialog(Action.findWordAfter(words, wordNum, wordsInPhrase));
        break;
      case ENCOUNTER:
        Encounter.StartEncounter(Action.findWordAfter(words, wordNum, wordsInPhrase));
        break;
      case HELP:
        Help.displayControls();
        break;
      case DISPLAYQUEST:
        System.out.println("this is working");
        DisplayQuest.displayQuest();
        break;
      case ACCEPT:
        AcceptBounty.acceptBounty(Action.findWordAfter(words, wordNum, wordsInPhrase));
        break;
      default: 
        Help.notFound();
    }
  }

  /**
   * Return the Actions enum based on a given index. 
   * @param i The index of the Actions enum
   * @return The actions enum associated with the given index
   */
  private static Actions getAction(int i) {
    Actions action = Actions.MOVE.ordinal() == i ? Actions.MOVE : Actions.NOACT;
    action = Actions.OBSERVE.ordinal() == i ? Actions.OBSERVE : action;
    action = Actions.INVENTORY.ordinal() == i ? Actions.INVENTORY : action;
    action = Actions.RETRIEVE.ordinal() == i ? Actions.RETRIEVE : action;
    action = Actions.TRIGGER.ordinal() == i ? Actions.TRIGGER : action;
    action = Actions.DIALOGUE.ordinal() == i ? Actions.DIALOGUE : action;
    action = Actions.ENCOUNTER.ordinal() == i ? Actions.ENCOUNTER : action;
    action = Actions.HELP.ordinal() == i ? Actions.HELP : action;
    action = Actions.DISPLAYQUEST.ordinal() == i ? Actions.DISPLAYQUEST : action;
    action = Actions.ACCEPT.ordinal() == i ? Actions.ACCEPT : action;
    return  action;
  }

  /**
   * Searches through a field of phrases to find if a phrase matches
   * a provided input. 
   * @param field Section of phrases being searched through
   * @param words words provided by the user
   * @return isFound, word num, words in phrase 
   */
  private static Object[] searchField(String[] field, String[] words) {
    /// Set words equal to an array of words from input. 
    

    /// For every phrase in field
    for (int i = 0; i < field.length; i++) {
      /// For every word in words
      for (int l = 0; l < words.length; l++) {
        /// Go through the next <code>maxWords</code> words and see if it 
        /// matches the phrase.
        Object[] result = searchWords(maxWords, l, field[i], words);
        if ((boolean)result[0]) return new Object[] {true, l, result[1]};
      }
    }

    return new Object[] {false};
  }

  /**
   * Searches through the <code>maxWords</code> and compares the input words to phrase. 
   * @param numWords checks this many words
   * @param l Place in the words array
   * @param phrase String we are comparing the words against
   * @param words Full array of words
   * @return isFound, words in phrase
   */
  private static Object[] searchWords(int numWords, int l, String phrase, String[] words) {
    for (int i = numWords; i > 0; i--) {
      try {
        if (phrase.equals(composeWords(i, l, words))) return new Object[] {true, i};
      } catch (Exception e) {}
    }

    return new Object[] {false};
  }

  /**
   * Combines an array of words to compose a string of words.
   * @param numWords number of words to include following the first word
   * @param l place in the words array
   * @param words full array of words
   * @return the string of words composed
   */
  private static String composeWords(int numWords, int l, String[] words) {
    String rtnString = "";
    for (int i = 0; i < numWords; i++) {
      rtnString = rtnString + " " + words[l + i];
    }

    return rtnString.trim();
  }

  // TODO Setup the following two methods within a generic class so that we can filter more than just string arrays.

  /**
   * Filter a list of strings from a list of strings.
   * @param array The array being filtered through
   * @param filter The filter of strings being removed from the array
   * @return The filtered array
   */
  private static String[] filterStringArray(String[] array, String[] filter) {
    List<Integer> removeInts = new ArrayList<>();
    for (int i = 0; i < filter.length; i++) {
      for (int l = 0; l < array.length; l++) {
        if (filter[i].equals(array[l])) {
          removeInts.add(l);
        }
      }
    }
    Collections.sort(removeInts, Collections.reverseOrder());
    for (int i = 0; i < removeInts.size(); i++) {
      array = removeFromArray(array, removeInts.get(i));
    }
    return array;
  }

  /**
   * Remove an object from an array.
   * @param myArray The array being chnaged
   * @param index The index of the item being removed
   * @return The array with the object removed
   */
  private static String[] removeFromArray(String[] myArray,  int index) { 
    if (myArray == null || index < 0 || index >= myArray.length) { 
      System.out.println("non-existing index"); 
      return myArray; 
    } 

    // array to arrayList
    List<String> arrayList = new LinkedList<String>(Arrays.asList(myArray));

    // Remove the specified element 
    arrayList.remove(index); 

    // return the resultant array 
    return arrayList.toArray(new String[arrayList.size()]); 
  } 

  private static String cleanInput(String input) {
    input = filterSpaces(input, player.inventory);
    input = filterSpaces(input, player.getLocation().getInstances());
    return input;
  }

  private static String filterSpaces(String input, InstanceCollection<? extends Instance> instances) {
    for (int i = 0; i < instances.size(); i++) {
      String match = instances.get(i).getName().replace("_", " ");
      if (input.contains(match)) {
        input = input.replace(match, instances.get(i).getName());
      }
    }
    return input;
  }

  /**
   * Change the input type of the class
   * @param type New input type
   */
  public static void changeInput(int type) {inputType = type;}

  /**
   * Get the input type of the class
   * @return The current input type
   */
  public static int getInputType() {return inputType;}

}
