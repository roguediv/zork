package src.$Librarys.GUI;

import java.awt.FlowLayout;
import java.awt.Container;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Flow {

  public JPanel view;
  public int[] padding;

  /// Mark: Constructors
  public Flow() {
    JPanel panel = new JPanel(new FlowLayout()); // Flow layout manager

    view = panel;
    padding = new int[] {0, 0, 0, 0};
  }
  public Flow(Container container) {
    JPanel panel = new JPanel(new FlowLayout()); // Flow layout manager
    container.add(panel);

    view = panel;
    padding = new int[] {0, 0, 0, 0};
  }
  public Flow(int paddingX, int paddingY, Container container) {
    JPanel panel = new JPanel(new FlowLayout()); // FlowLayout manager
    panel.setBorder(BorderFactory.createEmptyBorder(paddingY, paddingX, paddingY, paddingX)); // Add padding to FlowLayout.
    container.add(panel);

    view = panel;
    padding = new int[] {paddingY, paddingX, paddingY, paddingX};
  }
  public Flow(int paddingX, int paddingY) {
    JPanel panel = new JPanel(new FlowLayout()); // FlowLayout manager
    panel.setBorder(BorderFactory.createEmptyBorder(paddingY, paddingX, paddingY, paddingX)); // Add padding to FlowLayout.
    
    view = panel;
    padding = new int[] {paddingY, paddingX, paddingY, paddingX};
  }

  /// Mark: Methods
  public void setPadding() {
    view.setBorder(BorderFactory.createEmptyBorder(padding[0], padding[1], padding[2], padding[3]));
  }
  public void setPadding(int padding1, int padding2, int padding3, int padding4) {
    padding = new int[] {padding1, padding2, padding3, padding4};
    setPadding();
  }
}
