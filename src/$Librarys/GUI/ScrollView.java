package src.$Librarys.GUI;

import java.awt.Dimension;
import java.awt.Container;
import javax.swing.JScrollPane;

public class ScrollView {
  public JScrollPane view;
  public int size[];

  public ScrollView(Container inside) {
    //size = Size;
    JScrollPane panel = new JScrollPane(inside);
    panel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    panel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    //panel.setViewportview(container);

    view = panel;
  }
  public ScrollView(Container inside, Container container) {
    //size = Size;
    JScrollPane panel = new JScrollPane(inside);
    panel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    panel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    //panel.setViewportview(container);
    container.add(panel);
    view = panel;
  }
  public ScrollView(int Size[], Container container) {
    size = Size;
    JScrollPane panel = new JScrollPane();
    panel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    panel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    panel.setPreferredSize(new Dimension(size[0], size[1]));
    container.add(panel);

    view = panel;
  }

  public void setSize(int Size[]) {
    size = Size;
    setSize();
  }
  public void setSize() {
    view.setPreferredSize(new Dimension(size[0], size[1]));
  }
}
