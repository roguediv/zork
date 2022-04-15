package src.views;

/// JAVA Imports:
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.font.LineBreakMeasurer;
import javax.swing.JScrollBar;
import javax.swing.Timer;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

/// LOCAL Imports:
import src.$Librarys.GUI.*;
import src.classes.managers.*;

/*
 * Final Project: Text-based Game
 * Date: 2022-03-26
 * 
 * Class: #22569   | IT:Program: Part 4 (Java) 
 * Jacob Miranda   | StudentID: 24272503
 * Tristan Butzine | StudentID: 24415685
 * Brian Herman    | StudentID: 00000000
 */

public class ViewController {
  /// padding is used as a default measure for gaps between sections
  private static int padding = 25;
  /// gap is the length between elements in the same section
  private static int gap = 15;
  /// The speed that strings are written to the console. 
  private static int typeSpeed = 15;
  /// frame stores the main viewport for the game
  private Frame frame;
  /// stkText is where new labels are passed to the game
  private VStack stkText;
  /// txtInput is how user input is read through the main textbox
  private Text txtInput;
  /// bar controls scrolling within stkText
  private JScrollBar bar;

  private Button btnEnter;

  private Button[] numButtons;

  private boolean storyMode = false;

  private Timer timer;

  private int index = 0;

  private String loadString;

  public ViewController() {
    /// Constructor generates the view window and displays it to the user.
    ///
    /// Main Window:
    frame = new Frame("Zork");
    ZStack stkMain = new ZStack(frame.view);
    HStack stkHorizontalPadding = new HStack(stkMain.view);
    new HSpacer(padding, stkHorizontalPadding.view);
    VStack stkContent = new VStack(stkHorizontalPadding.view); // Main content of project
    new HSpacer(padding, stkHorizontalPadding.view);
    new VSpacer(padding, stkContent.view);

    /// The text are where game history is stored and outputs are displayed.
    HStack stkTextHldr = new HStack(); 
    stkTextHldr.view.setBackground(Color.white);
    new VSpacer(gap, stkTextHldr.view);
    stkText = new VStack(stkTextHldr.view); // Where text is stored
    stkText.view.setBackground(Color.white);
    new HSpacer(gap, stkText.view);
    ScrollView svwScroll = new ScrollView(stkTextHldr.view, stkContent.view); // Make text scrollable
    svwScroll.view.setPreferredSize(new Dimension(500, 300));
    bar = svwScroll.view.getVerticalScrollBar();
    //sendText("Welcome to Zork!");
    new VSpacer(gap, stkContent.view);

    /// The input section where the user can interact with the game. 
    HStack stkMainInput = new HStack(stkContent.view);
    txtInput = new Text (stkMainInput.view); // Main Text Box
    txtInput.view.setPreferredSize(new Dimension(300, 25));
    new HSpacer((gap / 2), stkMainInput.view);
    btnEnter = new Button("Enter", stkMainInput.view, e-> InputWatcher.watchUserInput(txtInput.view.getText(), this));
    new VSpacer(gap, stkContent.view);
    Grid grdQuickActions = new Grid(1, 4, gap, gap, stkContent.view);
    numButtons = new Button[] {
      new Button("1", grdQuickActions.view, e -> sendText("1 Pressed")),
      new Button("2", grdQuickActions.view, e -> sendText("2 Pressed")),
      new Button("3", grdQuickActions.view, e -> sendText("3 Pressed")),
      new Button("4", grdQuickActions.view, e -> sendText("4 Pressed"))
    };
    new VSpacer(padding, stkContent.view);

    /// The buttons on the bottom that control key aspects of the game. 
    Grid grdBottomActions = new Grid(1, 3, gap, gap, stkContent.view);
    Button btnSave = new Button("Save", grdBottomActions.view, e -> sendText("Save Game"));
    Button btnSettings = new Button("Settings", grdBottomActions.view, e -> sendText("Open Settings"));
    Button btnExit = new Button("Exit", grdBottomActions.view, e -> System.exit(0));
    new VSpacer(padding, stkContent.view);

    /// Show the window to the user
    frame.showFrame();
  }

  /// sendText(): Method for sending text for the game to display
  public void sendText(String string) {
    /// Sends a line of text to the text stack.
    // TODO: Figure out how to calculate line breaks. [3/26]
    //
    // NOTES: 1. When a line is too long, a horizontal bar is created and text is disaligned.
    //           To fix this, we need to have some sort of code that calculates line breaks. [3/26]
    //        2. I found a solution that works decently using the HTML tag. We can keep it or
    //           come up with a better idea. [3/27] 
    //
    // TRIED:
    // * Using html tags -> new Label("<html><p>"+string+"</p></html>", stkText.view) [3/26]
    // * Using setSize -> temp.view.setPreferredSize(new Dimension(50,50));
    //   This causes a bug where if the vert size isn't exact, it affects scrolling.  [3/26]
    //
    // IDEAS:
    // * LineBreakMeasurer -> I'm not sure how to use this properly. I've included it in imports. [3/26]
    //   Documentation: https://docs.oracle.com/javase/7/docs/api/java/awt/font/LineBreakMeasurer.html
    // * Deal with how bad <html> looks and have the user use horizontal scroll to see text. [3/26]
    //Label temp = new Label(string, stkText.view);
    createMessageLabel(string);
    reload();
  }
  public void sendText(String[] strings) {
    /// Allows for you to send multiple lines of text... like this: 
    ///
    /// sendText(new String[] {
    ///   "adding 2 or more different lines", 
    ///   "of strings so there is no spacing between them!"
    /// });
    for (int i = 0; i < strings.length; i++) {
      createMessageLabel(strings[i]);
    }
    reload();
  }

  /**
   * Set whether the controls are enabled.
   * @param state True, if enabled
   */
  public void setControls(boolean state) {
    txtInput.view.setEnabled(state);
    btnEnter.view.setEnabled(state);
    for (int i = 0; i < numButtons.length; i++) {
      numButtons[i].view.setEnabled(state);
    }
  }

  /**
   * Set how text is written.
   * @param state True, if writing in story mode
   */
  public void setStoryMode(boolean state) {
    setControls(!state);
    storyMode = state;
  }
  
  private void createMessageLabel(String string) {
    loadString = "";
    Label lblTemp = new Label("<html><p>"+loadString+"</p></html>", stkText.view);
    if (storyMode) {
      for (int i = 0; i < string.length(); i++) {
        MasterMethods.sleep(typeSpeed);
        loadString = loadString + string.charAt(i);
        lblTemp.setText("<html><p>"+loadString+"</p></html>");
      }
    } else {
      /// Guard against a timer in use. 
      if(timer != null && timer.isRunning()) return;

      /// Set the default value of the lbl and index
      setControls(false);
      index = 0;
    
      timer = new javax.swing.Timer(typeSpeed, new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
          loadString = loadString + String.valueOf(string.charAt(index));
          lblTemp.setText("<html><p>"+loadString+"</p></html>");
          index++;
          if (index >= string.length()) {
            timer.stop();
            setControls(true);
          }
        }
      });
      timer.start();
    }

  }

  private void reload() {
    /// Reloads the textbox after text is added. 
    ///
    /// Add some spacing
    new VSpacer(gap, stkText.view);
      
    /// Repaint the frame
    frame.view.validate();
    frame.view.repaint();

    /// Scroll to bottom of svwScroll
    bar.setValue(bar.getMaximum());
  }
}