import javax.swing.JFrame;

/**
 * @author dous
 * @since 1.0
 */
public class Main {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        JFrame f = new Frame();

        EditorArea editorArea = new EditorArea();
        Editor editor = new Editor(f, editorArea);
        ScrollPane scrollPane = new ScrollPane(editor);

        FileTree fileTree = new FileTree(f);
        StatusBar statusBar = new StatusBar(f);

        MenuBar menuBar = new MenuBar(f, editorArea, statusBar);

        f.setJMenuBar(menuBar);
        f.add(scrollPane);
        f.setVisible(true);
    }
}
