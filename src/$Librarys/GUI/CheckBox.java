package src.$Librarys.GUI;

import java.awt.Container;
import javax.swing.JCheckBox;

public class CheckBox {
  /// Manages the components of TextField.
  public HStack field;
  public JCheckBox view;
  public Label label;

  public CheckBox(String Text, Container container) {
    field = new HStack(2, 1, container); // Create a HStack for holding components
    view = new JCheckBox(); // Checkbox
    field.view.add(view);
    label =  new Label(Text, field.view); // Label
  }
}
