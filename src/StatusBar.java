import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBar extends JPanel {
    JLabel message;

    public StatusBar(JFrame f) {
        super();
        this.setBackground(new Color(0x121212));
        this.setPreferredSize(new Dimension(100, 30));

        message = new JLabel("message");
        message.setForeground(Color.WHITE);

        this.add(message);
        f.add(this, BorderLayout.SOUTH);
    }
}
