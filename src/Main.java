/**
 * @author dous
 * @since 1.0
 */
public class Main {
    public static void main(String[] args) {
        Frame f = new Frame();

        FileTree fileTree = new FileTree(f);
        EditorArea editorArea = new EditorArea();
        Editor editor = new Editor(f, editorArea);
        StatusBar statusBar = new StatusBar(f);
        ScrollPane scrollPane = new ScrollPane(editor);

        f.add(scrollPane);
        f.setVisible(true);
    }
}
