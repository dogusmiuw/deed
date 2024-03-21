import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FileTree extends JPanel {
    public FileTree(JFrame f) {
        super();
        this.setBackground(new Color(0x1e1e1e));
        this.setPreferredSize(new Dimension(200, 100));
        f.add(this, BorderLayout.WEST);
    }
}
