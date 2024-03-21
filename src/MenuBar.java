import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
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

    JFrame f;
    EditorArea editorArea;
    StatusBar statusBar;

    File file;
    Scanner sc;

    public MenuBar(JFrame f, EditorArea editorArea, StatusBar statusBar) {
        super();

        this.f = f;
        this.editorArea = editorArea;
        this.statusBar = statusBar;

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

            JFileChooser fc = new JFileChooser();

            int res = fc.showOpenDialog(null);

            if (res == JFileChooser.APPROVE_OPTION) {
                file = fc.getSelectedFile();

                try {
                    sc = new Scanner(file);
                    editorArea.setText("");

                    while (sc.hasNextLine()) {
                        editorArea.append(sc.nextLine() + "\n");
                    }

                    statusBar.setMessage(file.getName());
                } catch (FileNotFoundException e1) {
                    statusBar.setMessage("File not found. => " + file.getAbsolutePath());
                }
            }
        } else if (e.getSource() == saveFileItem) {
            System.out.println("Save File");

            JFileChooser fc = new JFileChooser();

            int res = fc.showSaveDialog(null);

            if (res == JFileChooser.APPROVE_OPTION) {
                file = fc.getSelectedFile();
                System.out.println(file.getAbsolutePath());

                try {
                    FileWriter fw = new FileWriter(file);

                    fw.write(editorArea.getText());

                    fw.close();

                    statusBar.setMessage("File saved. => " + file.getName());
                } catch (IOException e1) {
                    statusBar.setMessage("Save operation failed. => " + file.getName());
                }
            }
        } else if (e.getSource() == exitItem) {
            System.out.println("Bye");
            f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
        }
    }
}
