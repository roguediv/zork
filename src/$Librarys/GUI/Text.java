package src.$Librarys.GUI;

import java.awt.Dimension;
import java.awt.Container;
import javax.swing.JTextField;

public class Text {
  public JTextField view;
  private Dimension inputSize = new Dimension(125, 25);
  public String text = "";

  public Text(Container container) {
    JTextField text = new JTextField();
    text.setPreferredSize(inputSize);
    container.add(text);

    view = text;
  }

  public void clear() {text = "";setText();}

  public void setText() {view.setText(text);}
  public void setText(String Text) {text = Text;setText();}

}
