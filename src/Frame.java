import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;

public class Frame extends JFrame {
    public Frame() {
        super("Deed");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 600);
        this.setLayout(new BorderLayout());
        this.setBackground(Color.BLACK);

        ImageIcon icon = new ImageIcon("logo.jpg");
        this.setIconImage(icon.getImage());
        this.setTitle("Deed");
    }
}
