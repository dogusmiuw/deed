import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EditorArea extends JTextArea {

    public EditorArea() {
        super("Welcome to Deed!\nEdit me!\n");
        // set caret position to the end of the text
        this.setCaretPosition(this.getText().length());
        this.setForeground(Color.WHITE);
        this.setCaretColor(Color.WHITE);
        this.setBackground(new Color(0x2d2d2d));
        this.setLineWrap(true);
        this.setFont(new Font("Consolas", Font.PLAIN, 18));
        this.setTabSize(4);
        // set padding
        this.setBorder(BorderFactory.createCompoundBorder(
                this.getBorder(),
                BorderFactory.createEmptyBorder(8, 8, 8, 8)));
    }
}

class ScrollPane extends JScrollPane {
    public ScrollPane(Editor editor) {
        super(editor);
        this.getVerticalScrollBar().setBackground(new Color(0x2e2e2e));
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.setBorder(null);
    }
}
