import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar implements ActionListener {
    JMenu fileMenu;
    JMenu editMenu;
    JMenu helpMenu;

    JMenuItem openFileItem;
    JMenuItem saveFileItem;
    JMenuItem exitItem;

    public MenuBar() {
        super();

        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        helpMenu = new JMenu("Help");

        openFileItem = new JMenuItem("Open File");
        saveFileItem = new JMenuItem("Save File");
        exitItem = new JMenuItem("Exit");

        openFileItem.addActionListener(this);
        saveFileItem.addActionListener(this);
        exitItem.addActionListener(this);

        fileMenu.add(openFileItem);
        fileMenu.add(saveFileItem);
        fileMenu.add(exitItem);

        this.add(fileMenu);
        this.add(editMenu);
        this.add(helpMenu);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == openFileItem) {
            System.out.println("Open File");
        } else if (e.getSource() == saveFileItem) {
            System.out.println("Save File");
        } else if (e.getSource() == exitItem) {
            System.out.println("Exit");
        }
    }
}
