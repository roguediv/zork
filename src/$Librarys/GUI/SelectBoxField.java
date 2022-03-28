package src.$Librarys.GUI;

import java.awt.Container;

public class SelectBoxField {
  /// Manages the components of TextField.
  public Grid field;
  public SelectBox sbx;
  public Label lbl;

  public SelectBoxField(String Text, String[] options, Container container) {
    field = new Grid(2, 1, container); // Create a HStack for holding components
    lbl =  new Label(Text, field.view); // Label
    sbx = new SelectBox(options, field.view); // User editable text input
  }
}

