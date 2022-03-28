package src.$Librarys.GUI;
import java.awt.Container;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Table {
  public JTable view;
  public Table(String[][] data, String[] cols, Container container) {
    view = new JTable(data, cols);
    container.add(view);
  }
  public Table(DefaultTableModel table, Container container) {
    view = new JTable(table);
    container.add(view);
  }
}
