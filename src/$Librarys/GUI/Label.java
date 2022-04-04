package src.$Librarys.GUI;

import java.awt.Component;
import java.awt.Container;
import javax.swing.JLabel;

public class Label {
  public JLabel view;
  public String text;

  public Label(String text, Container container) {
    JLabel label = new JLabel(text);
    label.setAlignmentX(Component.CENTER_ALIGNMENT);
    container.add(label);

    view = label;
  }

  public void setText() {
    view.setText(text);
  }
  public void setText(String Text) {
    text = Text;
    setText();
  }
}
