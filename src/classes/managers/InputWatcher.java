package src.classes.managers;

import java.util.List;

/**
 * The <code>InputWatcher</code> object contains the intelligence 
 * behind recognising what a user types and having the program
 * properly react to it. 
 * @author Jake
 */
public class InputWatcher {

  /**
   * Max words that a phrase can be. 
   */
  private static int maxWords = 2;
  
  /**
   * Whether or not the player is in an encounter
   */
  private boolean isInEncounter = false;

  /**
   * The actions that can be taken by the player based on an input. 
   */
  private static enum Actions {
    MOVE, OBSERVE, INVENTORY, TRIGGER, DIALOGUE,  
    ENCOUNTER, ONE, TWO, THREE, FOUR;
  }

  /**
   * Phrases that are recognized by the game engine
   */
  private static String[][] phrases = {
    /// phrases for traversing the world
    {"go to", "enter", "through"},
    /// phrases for viewing the world
    {"look", "observe", "view"},
    /// phrases for viewing inventory
    {"inventory", "bag", "stuff", "items", "weapons", "potions", "armour", "armor"},
    /// phrases for triggering an item
    {"use", "trigger", "activate", "operate", "equip", "hold", "put on"},
    /// phrases for speaking with AI
    {"speak with", "talk to", "speak", "talk", "converse", "ask"},
    /// phrases for beginning an encounter with an AI
    {"attack", "fight", "assassinate", "assult", "kill", "murder", },
    /// Encounter "1" commands
    {"1", "one", "first"},
    /// Encounter "2" commands
    {"2", "two", "second"},
    /// Encounter "3" commands
    {"3", "three", "third"},
    /// Encounter "4" commands
    {"4", "four", "fourth"},
  };

  /**
   * Check an input provided by the user and test it against
   * phrases.
   * @param input Input provided by the user
   */
  public static void checkUserInput(String input) {
    boolean isFound = false;
    int phraseNum = -1;
    int wordNum = -1;
    int wordsInPhrase = -1;
    /// Search through every item
    for (int i = 0; i < phrases.length; i++) {
      Object[] results = searchField(phrases[i], input);
      if ((boolean)results[0]) {
        phraseNum = i;
        wordNum = (int)results[1];
        wordsInPhrase = (int)results[2];
        break;
      }
    }

  }

  /**
   * Searches through a field of phrases to find if a phrase matches
   * a provided input. 
   * @param field Section of phrases being searched through
   * @param input Input provided by the user
   * @return isFound, word num, words in phrase 
   */
  private static Object[] searchField(String[] field, String input) {
    /// Set words equal to an array of words from input. 
    String[] words = input.split(" ");

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
        if (phrase == composeWords(i, l, words)) return new Object[] {true, i};
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
    for (int i = 0; i < numWords; i--) {
      rtnString = rtnString + " " + words[l + i];
    }

    return rtnString.trim();
  }
}
