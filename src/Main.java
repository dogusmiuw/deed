import java.io.IOException;

/**
 * @author dous
 * @since 1.0
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Frame f = new Frame();

        FileTree fileTree = new FileTree(f);
        EditorArea editorArea = new EditorArea();
        Editor editor = new Editor(f, editorArea);
        StatusBar statusBar = new StatusBar(f);

        f.setVisible(true);
    }
}
