import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FileTree extends JPanel {
    JLabel workingDirectory;

    public FileTree(JFrame f) {
        super();
        this.setBackground(new Color(0x1e1e1e));
        this.setPreferredSize(new Dimension(275, 100));

        workingDirectory = new JLabel("");
        workingDirectory.setForeground(Color.WHITE);
        workingDirectory.setFont(new Font("Consolas", Font.BOLD, 14));

        this.add(workingDirectory);
        f.add(this, BorderLayout.WEST);
    }
}
