import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {
    public MenuBar() {
        super();

        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu helpMenu = new JMenu("Help");

        JMenuItem newFile = new JMenuItem("New File");
        JMenuItem openFile = new JMenuItem("Open File");
        JMenuItem saveFile = new JMenuItem("Save File");
        JMenuItem exit = new JMenuItem("Exit");

        fileMenu.add(newFile);
        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        fileMenu.add(exit);

        this.add(fileMenu);
        this.add(editMenu);
        this.add(helpMenu);
    }
}
