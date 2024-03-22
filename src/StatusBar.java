import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;

public class StatusBar extends JPanel {
    JLabel message;
    JTextField cmd;

    public StatusBar(JFrame f) {
        super();
        this.setBackground(new Color(0x121212));
        this.setPreferredSize(new Dimension(100, 50));

        this.setLayout(new BorderLayout(0, 5));

        cmd = new JTextField();
        cmd.setBackground(new Color(0x121212));
        cmd.setForeground(Color.GREEN);
        cmd.setFont(new Font("Consolas", Font.PLAIN, 16));
        cmd.setCaretColor(Color.GREEN);
        cmd.setBorder(BorderFactory.createCompoundBorder(
                cmd.getBorder(),
                BorderFactory.createEmptyBorder(2, 2, 2, 2)));

        cmd.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                cmd.requestFocus();
                Hotkeys.isCmdFocused = true;
                Hotkeys.isEditorAreaFocused = false;
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

        message = new JLabel("...");
        message.setForeground(Color.WHITE);
        message.setHorizontalAlignment(JLabel.CENTER);

        this.add(cmd, BorderLayout.CENTER);
        this.add(message, BorderLayout.NORTH);
        f.add(this, BorderLayout.SOUTH);
    }

    public void setMessage(String msg) {
        message.setText(msg);
    }
}
