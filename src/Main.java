import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author dous
 */

public class Main {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(900, 600);
        f.setLayout(new BorderLayout());

        ImageIcon icon = new ImageIcon("logo.jpg");
        f.setIconImage(icon.getImage());
        f.setTitle("Deed");

        f.setVisible(true);

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();

        p1.setBackground(Color.RED);
        p2.setBackground(Color.GREEN);
        p3.setBackground(Color.YELLOW);
        p4.setBackground(Color.MAGENTA);
        p5.setBackground(Color.BLUE);

        p1.setPreferredSize(new Dimension(100, 100));
        p2.setPreferredSize(new Dimension(100, 100));
        p3.setPreferredSize(new Dimension(100, 100));
        p4.setPreferredSize(new Dimension(100, 100));
        p5.setPreferredSize(new Dimension(100, 100));

        f.add(p1, BorderLayout.NORTH);
        f.add(p2, BorderLayout.WEST);
        f.add(p3, BorderLayout.CENTER);
        f.add(p4, BorderLayout.EAST);
        f.add(p5, BorderLayout.SOUTH);
    }
}
