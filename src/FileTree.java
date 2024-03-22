import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FileTree extends JPanel {
    JLabel workingDirectoryText;
    JLabel filesInCurrentDirectoryText;

    public FileTree(JFrame f) {
        super();
        this.setBackground(new Color(0x1e1e1e));
        this.setPreferredSize(new Dimension(300, 100));

        workingDirectoryText = new JLabel("");
        workingDirectoryText.setForeground(Color.WHITE);
        workingDirectoryText.setFont(new Font("Consolas", Font.BOLD, 16));

        filesInCurrentDirectoryText = new JLabel("");
        filesInCurrentDirectoryText.setForeground(Color.WHITE);
        filesInCurrentDirectoryText.setFont(new Font("Consolas", Font.BOLD, 14));

        this.add(workingDirectoryText);
        this.add(filesInCurrentDirectoryText);
        f.add(this, BorderLayout.WEST);
    }
}
