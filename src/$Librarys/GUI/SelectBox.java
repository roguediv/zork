package src.$Librarys.GUI;

import java.awt.Container;
import javax.swing.JComboBox;

public class SelectBox {
  public JComboBox<String> view;
  public SelectBox(String[] options, Container container) {
    view = new JComboBox<String>(options); 
    container.add(view);
  }
}
