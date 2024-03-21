import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class StatusBar extends JPanel {
    public StatusBar(JFrame f) {
        super();
        this.setBackground(new Color(0x121212));
        this.setPreferredSize(new Dimension(100, 30));
        f.add(this, BorderLayout.SOUTH);
    }
}
