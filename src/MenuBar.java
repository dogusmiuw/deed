import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    static EditorArea editorArea;
    static StatusBar statusBar;
    FileTree fileTree;

    static File currentFile;
    static Scanner sc;

    StringBuilder filesInCurrentDirectoryText = new StringBuilder();

    public MenuBar(JFrame f, EditorArea editorArea, StatusBar statusBar, FileTree fileTree) {
        super();

        this.f = f;
        MenuBar.editorArea = editorArea;
        MenuBar.statusBar = statusBar;
        this.fileTree = fileTree;

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
            openFile();
        } else if (e.getSource() == saveFileItem) {
            saveFile();
        } else if (e.getSource() == exitItem) {
            System.out.println("Bye");
            f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
        }
    }

    public Set<String> listFilesUsingJavaIO(String dir) {
        return Stream.of(new File(dir).listFiles())
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toSet());
    }

    public void saveFile() {
        if (currentFile == null) {
            JFileChooser fc = new JFileChooser();

            int res = fc.showSaveDialog(null);

            if (res == JFileChooser.APPROVE_OPTION) {
                currentFile = fc.getSelectedFile();

                try {
                    FileWriter fw = new FileWriter(currentFile);

                    fw.write(editorArea.getText());

                    fw.close();

                    filesInCurrentDirectoryText.append("<html><p style='width: 200px'>");

                    for (String e : listFilesUsingJavaIO(currentFile.getParent().toString())) {
                        if (e.contains(".")) {
                            if (e.length() > 20) {
                                filesInCurrentDirectoryText
                                        .append(e.substring(0, 22) + "..." + e.substring(e.length() - 4, e.length())
                                                + "<br/>");
                            } else {
                                filesInCurrentDirectoryText.append(e + "<br/>");
                            }
                        }
                    }

                    filesInCurrentDirectoryText.append("</p></html>");

                    fileTree.filesInCurrentDirectoryText.setText(filesInCurrentDirectoryText.toString());

                    String[] dirPath = currentFile.getParent().toString().replace("\\", "/").split("/");

                    fileTree.workingDirectoryText
                            .setText(
                                    dirPath[dirPath.length - 2] + " / " + dirPath[dirPath.length - 1] + " / "
                                            + currentFile.getName());
                    statusBar.setMessage("File saved. => " + currentFile.getName());
                } catch (IOException e1) {
                    statusBar.setMessage("Save operation failed. => " + currentFile.getName());
                }
            }
        } else {
            try {
                FileWriter fw = new FileWriter(currentFile);

                fw.write(editorArea.getText());

                fw.close();

                statusBar.setMessage("File saved. => " + currentFile.getName());
            } catch (IOException e1) {
                statusBar.setMessage("Save operation failed. => " + currentFile.getName());
            }
        }
    }

    public void openFile() {
        JFileChooser fc = new JFileChooser();

        int res = fc.showOpenDialog(null);

        if (res == JFileChooser.APPROVE_OPTION) {
            currentFile = fc.getSelectedFile();

            filesInCurrentDirectoryText.append("<html><p style='width: 200px'>");

            for (String e : listFilesUsingJavaIO(currentFile.getParent().toString())) {
                if (e.contains(".")) {
                    if (e.length() > 20) {
                        filesInCurrentDirectoryText
                                .append(e.substring(0, 22) + "..." + e.substring(e.length() - 4, e.length()) + "<br/>");
                    } else {
                        filesInCurrentDirectoryText.append(e + "<br/>");
                    }
                }
            }

            filesInCurrentDirectoryText.append("</p></html>");

            fileTree.filesInCurrentDirectoryText.setText(filesInCurrentDirectoryText.toString());

            insertFileContentIntoEditorArea();

            String[] dirPath = currentFile.getParent().toString().replace("\\", "/").split("/");

            fileTree.workingDirectoryText
                    .setText(
                            dirPath[dirPath.length - 2] + " / " + dirPath[dirPath.length - 1] + " / "
                                    + currentFile.getName());
        }
    }

    public static void insertFileContentIntoEditorArea() {
        try {
            sc = new Scanner(currentFile);
            editorArea.setText("");

            while (sc.hasNextLine()) {
                editorArea.append(sc.nextLine() + "\n");
            }

        } catch (FileNotFoundException e1) {
            statusBar.setMessage("File not found. => " + currentFile.getAbsolutePath());
        }
    }
}
