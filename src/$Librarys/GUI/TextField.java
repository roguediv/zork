package src.$Librarys.GUI;

import java.awt.Container;

public class TextField {
  /// Manages the components of TextField.
  public Grid field;
  public Text text;
  public Label label;

  public TextField(String Text, Container container) {
    field = new Grid(2, 1, container); // Create a HStack for holding components
    label =  new Label(Text, field.view); // Label
    text = new Text(field.view); // User editable text input
  }
}
