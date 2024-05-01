// Karson Hodge, MCIS-Adv Programming Concepts, Section 34, ID: 9999-03235
import javax.swing.*;
import java.awt.*; // swing events
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter; // motion adapter to tell where the mouse is
import java.awt.event.MouseMotionListener;
import static java.lang.Math.abs; // for eye calculations


/**
 * This class runs the smile main function and creates the draw instance
 *
 * @author Karson Hodge
 */
public class Smile {

    public static void main(String[] args) {
        Drawer drawObj = new Drawer(); // new instance of the drawer class that builds everything

    }

}


/**
 * Draws the smile face and also moves its eyes around
 *
 * @author Karson Hodge
 */
class Drawer extends JPanel {
    public JFrame frame = new JFrame("Smiley"); // Main frame
    public Graphics2D g2;

    public int x1Val = 170; // inital x1Val
    public int y1Val = 185;
    public int x2Val = 255; // initail X2 Value
    public int y2Val = 185;
    public int originX1 = 170;
    public int originX2 = 255; // Origin for eye 2
    public int originY1 = 185;


    JPanel panel = new JPanel() { // Creates a new panel with the paint function inside
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g2 = (Graphics2D) g; // inherent graphics 2

            g2.setColor(Color.black);
            g2.drawArc(95, 95, 260, 260, 0, 360); // draw the outline
            g2.fillArc(95, 95, 260, 260, 0, 360);
            g2.setColor(Color.yellow); // set color yellow
            //Draw and fill the face
            g2.drawArc(100, 100, 250, 250, 0, 360);
            g2.fillArc(100, 100, 250, 250, 0, 360);
            //Change color to black
            g2.setColor(Color.black);
            //Draw the left eye


            //Draw the smile
            g2.setStroke(new BasicStroke(3)); // set the stroke width to 3
            g2.drawArc(150, 215, 150, 100, 0, -180);

            g2.drawLine(140, 265, 160, 265); // straight line for mouth

            g2.drawLine(290, 265, 310, 265);


            g2.drawOval(x1Val, y1Val, 25, 40); // draws the eye
            g2.fillArc(x1Val, y1Val, 25, 40, 0, 360);
            //Draw the right eye
            g2.drawOval(x2Val, y2Val, 25, 40);
            g2.fillArc(x2Val, y2Val, 25, 40, 0, 360);

            addMouseMotionListener(new MouseMotionAdapter() { // new mouse adapter to get mouse inputs
                public void mouseMoved(MouseEvent e) {
                    if (e.getX() < originX1) { // if the mouse is on the left side
                        x1Val = abs(originX1 - (originX1 - e.getX())/14);
                    }
                    else{ // elese the mouse is on the right side
                        x1Val = abs((originX1 + e.getX()/14));
                    }
                    if (e.getX() < originX2) { // if the mouse is on the left side right eye
                        x2Val = abs(originX2 - (originX2 - e.getX())/14);
                    }
                    else{ // else on the right side
                        x2Val = abs((originX2 + e.getX()/14));
                    }
                    if (e.getY() < originY1) { // y coordinate for eyes. above eyes
                        y1Val = abs(originY1 - (originY1 - e.getY())/14);
                        y2Val = abs(originY1 - (originY1 - e.getY())/14);

                    }
                    else{ // else below the eyes
                        y1Val = abs((originY1 + e.getY()/14));
                        y2Val = abs((originY1 + e.getY()/14));
                    }

                    panel.repaint(); // repaints the smiley face
                }
            });

        }
    };

    /**
     * Constructor for the drawer class. Builds the Jframe and adds the panel
     *
     * @author Karson Hodge
     */
    public Drawer(){
        frame.setSize(500,500);
        frame.setBackground(Color.white); // set background color
        frame.add(panel); // adds the panel
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close with X button
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); // Show the frame

    }

}