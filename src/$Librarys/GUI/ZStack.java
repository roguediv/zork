package src.$Librarys.GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class ZStack {
  public JPanel view;
  public int[] padding;

  /// Mark: Constructos
  public ZStack(Container container) {
    JPanel panel = new JPanel(); 
    panel.setLayout(new BorderLayout(8, 6)); // Basic BorderLayout
    container.add(panel);

    view = panel;
    padding = new int[] {0, 0, 0, 0};
  }
  public ZStack(int paddingX, int paddingY, Container container) {
    JPanel panel = new JPanel(); 
    panel.setLayout(new BorderLayout(8, 6)); // Basic BorderLayout
    panel.setBorder(BorderFactory.createEmptyBorder(paddingY, paddingX, paddingY, paddingX)); // Add padding to the BorderLayout
    container.add(panel);

    view = panel;
    padding = new int[] {paddingY, paddingX, paddingY, paddingX};
  }
  public ZStack(int paddingX, int paddingY) {
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout(8, 6)); // Basic BorderLayout
    panel.setBorder(BorderFactory.createEmptyBorder(paddingY, paddingX, paddingY, paddingX)); // Add padding to the BorderLayout

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
