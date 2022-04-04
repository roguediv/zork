package src.$Librarys.GUI;

import java.awt.GridLayout;
import java.awt.Container;
import javax.swing.JPanel;

public class Grid {
  public JPanel view;

  /// Mark: Constructors: 
  public Grid() {
    JPanel panel = new JPanel(new GridLayout()); // Basic Grid layout

    view = panel;
  }
  public Grid(Container container) {
    JPanel panel = new JPanel(new GridLayout()); // Basic Grid layout
    container.add(panel);

    view = panel;
  }
  public Grid(int stg1, int stg2) {
    JPanel panel = new JPanel(new GridLayout(stg1, stg2)); // Basic Grid layout with rows and cols

    view = panel;
  }
  public Grid(int stg1, int stg2, Container container) {
    JPanel panel = new JPanel(new GridLayout(stg1, stg2)); // Basic Grid layout with rows and cols
    container.add(panel);

    view = panel;
  }
  public Grid(int stg1, int stg2, int stg3, int stg4, Container container) {
    JPanel panel = new JPanel(new GridLayout(stg1, stg2, stg3, stg4)); // Basic Grid layout with rows and cols and spacing
    container.add(panel);

    view = panel;
  }
}
