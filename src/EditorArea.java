import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextArea;

public class EditorArea extends JTextArea {
    public EditorArea() {
        super();
        this.setForeground(Color.WHITE);
        this.setCaretColor(Color.WHITE);
        this.setBackground(new Color(0x2d2d2d));
        this.setLineWrap(true);
        this.setFont(new Font("Consolas", Font.PLAIN, 18));
        this.setTabSize(4);
    }
}
