import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Editor extends JPanel {
    JTextArea textArea;
    RowNumbers rowNumbers;

    public Editor(JFrame f, JTextArea textArea) {
        super();
        this.setBackground(new Color(0x2e2e2e));
        // this.setPreferredSize(new Dimension(100, 100));
        this.setLayout(new BorderLayout());

        rowNumbers = new RowNumbers();

        this.add(rowNumbers, BorderLayout.WEST);
        this.add(textArea, BorderLayout.CENTER);

        f.add(this, BorderLayout.CENTER);
    }
}

class RowNumbers extends JPanel {
    public RowNumbers() {
        super();
        this.setBackground(new Color(0x2f2f2f));
        // this.setBackground(Color.GREEN);
        this.setPreferredSize(new Dimension(30, 100));
    }
}