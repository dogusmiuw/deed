import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EditorArea extends JTextArea {
    public EditorArea() {
        super("Welcome to Deed!\n" +
                "=> Open a new file\n" +
                "=> or Edit this file and save!");
        JTextArea ref = this;

        // set caret position to the end of the text
        this.setCaretPosition(this.getText().length());
        this.setForeground(Color.WHITE);
        this.setCaretColor(Color.WHITE);
        this.setBackground(new Color(0x2d2d2d));
        this.setFont(new Font("Consolas", Font.PLAIN, 18));
        this.setTabSize(4);
        // set padding
        this.setBorder(BorderFactory.createCompoundBorder(
                this.getBorder(),
                BorderFactory.createEmptyBorder(8, 8, 8, 8)));

        this.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                ref.requestFocus();
                Hotkeys.isCmdFocused = false;
                Hotkeys.isEditorAreaFocused = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });
    }
}

class ScrollPane extends JScrollPane {
    public ScrollPane(Editor editor) {
        super(editor);
        this.getVerticalScrollBar().setBackground(new Color(0x2e2e2e));
        this.setBorder(null);
    }
}
