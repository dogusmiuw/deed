import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

public class Hotkeys {
    Action saveAction;
    Action openFileAction;
    Action swapBetween;

    JFrame f;
    EditorArea editorArea;
    MenuBar menuBar;
    StatusBar statusBar;

    static boolean isCmdFocused = false;
    static boolean isEditorAreaFocused = true;

    public Hotkeys(JFrame f, EditorArea editorArea, MenuBar menuBar, StatusBar statusBar) {
        this.f = f;
        this.editorArea = editorArea;
        this.menuBar = menuBar;
        this.statusBar = statusBar;

        this.saveAction = new saveAction();
        this.openFileAction = new openFileAction();
        this.swapBetween = new swapBetween();

        editorArea.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK), "saveAction");
        editorArea.getActionMap().put("saveAction", saveAction);
        editorArea.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK), "openFileAction");
        editorArea.getActionMap().put("openFileAction", openFileAction);

        editorArea.getInputMap().put(KeyStroke.getKeyStroke("ESCAPE"), "swapBetween");
        editorArea.getActionMap().put("swapBetween", swapBetween);

        statusBar.cmd.getInputMap().put(KeyStroke.getKeyStroke("ESCAPE"), "swapBetween");
        statusBar.cmd.getActionMap().put("swapBetween", swapBetween);
    }

    public class saveAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            menuBar.saveFile();
        }

    }

    public class openFileAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            menuBar.openFile();
        }

    }

    public class swapBetween extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            swapBetween();
        }

    }

    public void swapBetween() {
        if (isEditorAreaFocused)
            statusBar.cmd.requestFocus();
        else
            editorArea.requestFocus();

        isCmdFocused = !isCmdFocused;
        isEditorAreaFocused = !isEditorAreaFocused;
    }
}
