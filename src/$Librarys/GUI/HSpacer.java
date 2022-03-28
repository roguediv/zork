package src.$Librarys.GUI;

import java.awt.Dimension;
import java.awt.Container;
import javax.swing.Box;

public class HSpacer {
  public HSpacer(int size, Container container) {
    /// Used to add spacing between components.
    container.add(Box.createRigidArea(new Dimension(size, 0)));
  }
}
