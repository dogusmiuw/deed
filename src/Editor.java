import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Editor extends JPanel {
    EditorArea textArea;
    RowNumbers rowNumbers;

    public Editor(JFrame f, EditorArea textArea) {
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
        this.setPreferredSize(new Dimension(40, 100));

        StringBuilder sb = new StringBuilder("<html><center>");
        for (int i = 1; i <= 100; i++) {
            sb.append(i).append("<br/>");
        }
        sb.append("</center></html>");

        JLabel label = new JLabel(sb.toString());
        label.setFont(new Font("Consolas", Font.PLAIN, 18));
        label.setForeground(Color.WHITE);
        this.add(label);
    }
}
