// Karson Hodge, MCIS-Adv Programming Concepts, Section 34, ID: 9999-03235
import java.awt.*;
import javax.swing.*;
import java.util.Random;

/**
 * This class defines the window that the triangles will be drawn on
 *
 * @author Karson Hodge
 */
public class NineA extends Canvas {

    public static void main(String[] args) {
        var panel = new Draw(); // class being used to draw
        var frame = new JFrame("Triangles"); // makes the jframe and puts a title
        frame.setSize(1024, 1000); // sets the width and height of the screen
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setVisible(true); // show the frame

    }
}


/**
 * Handles the drawing of the 500 triangles. Inherits the JPanel class.
 *
 * @author Karson Hodge
 */
class Draw extends JPanel {

    /**
     * This function draws the triangles. It does so by using the graphics library
     *
     * @param g the <code>Graphics</code> object to protect
     * @author Karson Hodge
     */
    public void paintComponent(Graphics g) {

        Random rand = new Random(); // Creates the random object

        for (int i = 0; i < 500; i++) { // loop 500 times to make triangles

            Color c = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)); // randomly chooses a color
            int height1 = rand.nextInt(1000)+1;
            int width1 = rand.nextInt(1000)+1;
            int height2 = rand.nextInt(1000)+1; // each of these deals with a random width or height
            int width2 = rand.nextInt(1000)+1;
            int height3 = rand.nextInt(1000)+1;
            int width3 = rand.nextInt(1000)+1;
            g.setColor(c); // sets the color
            g.drawPolygon(new int[] {width1,width2,width3}, new int[] {height1,height2,height3}, 3); // draws the triangle onto the frame.
        }




    }



}
