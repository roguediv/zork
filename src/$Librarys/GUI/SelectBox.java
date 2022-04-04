package src.$Librarys.GUI;

import java.awt.Container;
import javax.swing.JComboBox;

public class SelectBox {
  public JComboBox view;
  public SelectBox(String[] options, Container container) {
    view = new JComboBox(options); 
    container.add(view);
  }
}
