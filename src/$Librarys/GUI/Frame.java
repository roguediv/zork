package src.$Librarys.GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame {
  /// Manages the GUI of application.
  // Note: I started designing this framework
  // for use on future projects + final project. 
  public JFrame view = new JFrame();
  
  public Frame(String title) {
    /// Constructor for setting up parent frame.
    view.setTitle(title); // Name of window
    // view.setResizable(false); // User can't resize
    view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit on close
  }

  /// FRAME CONTROLLER:
  /// Controls aspects of the frame.
  public void showFrame(JPanel mainPanel) {
    /// Packs frame and makes frame visible.
    view.add(mainPanel);
    view.pack();
    view.setVisible(true);  // Make visible
  }
  public void showFrame() {
    /// Packs frame and makes frame visible.
    view.pack();
    view.setVisible(true);  // Make visible
  }
}
