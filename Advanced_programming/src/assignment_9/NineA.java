// Karson Hodge, MCIS-Adv Programming Concepts, Section 34, ID: 9999-03235
import java.awt.*;
import javax.swing.*;

public class NineA extends Canvas {

    public static void main(String[] args) {
        var panel = new Draw();
        panel.setBackground(Color.GREEN.darker());
        var frame = new JFrame("A simple graphics program");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setVisible(true);

    }
}


class Draw extends JPanel {

    public void paintComponent(Graphics g) {
        g.drawLine(100, 100, 200, 200);
    }



}
