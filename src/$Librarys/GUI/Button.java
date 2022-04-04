package src.$Librarys.GUI;

import java.util.function.Consumer;
import java.awt.Component;
import java.awt.Container;
import javax.swing.JButton;

public class Button {
  public JButton view; 
  String text;

  public Button(String Text, Container container, Consumer<Integer> action) {
    JButton button = new JButton(Text);
    button.setAlignmentX(Component.CENTER_ALIGNMENT);
    button.setFocusable(false);
    button.addActionListener(e -> {action.accept(0);});
    container.add(button);

    view = button;
    text = Text;
  }
  public Button(String Text, Container container) {
    JButton button = new JButton(Text);
    button.setAlignmentX(Component.CENTER_ALIGNMENT);
    button.setFocusable(false);
    container.add(button);

    view = button;
    text = Text;
  }

  public void setText() {
    view.setText(text);
  }
  public void setText(String Text) {
    text = Text;
    view.setText(text);
  }

  public void setAction(Consumer<Integer> action) {
    view.addActionListener(e -> {action.accept(0);});
  }
}
