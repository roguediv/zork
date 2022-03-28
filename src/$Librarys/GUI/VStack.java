package src.$Librarys.GUI;

import javax.swing.BoxLayout;
import java.awt.Container;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class VStack {
  public JPanel view;
  public int[] padding;

  /// Mark: Constructos
  public VStack() {
    JPanel panel = new JPanel(); 
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Basic BoxLayout

    view = panel;
    padding = new int[] {0, 0, 0, 0};
  }
  public VStack(Container container) {
    JPanel panel = new JPanel(); 
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Basic BoxLayout
    container.add(panel);

    view = panel;
    padding = new int[] {0, 0, 0, 0};
  }
  public VStack(int paddingX, int paddingY, Container container) {
    JPanel panel = new JPanel(); 
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Basic BoxLayout
    panel.setBorder(BorderFactory.createEmptyBorder(paddingY, paddingX, paddingY, paddingX)); // Add padding to the BoxLayout
    container.add(panel);

    view = panel;
    padding = new int[] {paddingY, paddingX, paddingY, paddingX};
  }
  public VStack(int paddingX, int paddingY) {
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Basic BoxLayout
    panel.setBorder(BorderFactory.createEmptyBorder(paddingY, paddingX, paddingY, paddingX)); // Add padding to the BoxLayout

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
