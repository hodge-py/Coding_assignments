// Karson Hodge, MCIS-Adv Programming Concepts, Section 34, ID: 9999-03235
import java.awt.*;
import javax.swing.*;
import java.util.Random;

/**
 * Class that builds the JFrame and displays the drawing
 *
 * @author Karson Hodge
 */
public class NineB extends Canvas {

    /**
     * Runs everything to draw the frame and triangles.
     *
     * @param args
     * @author Karson Hodge
     */
    public static void main(String[] args) {
            var panel = new SierTriangle(); // class being used to draw
            var frame = new JFrame("Triangles"); // makes the jframe and puts a title
            frame.setSize(1024, 768); // sets the width and height of the screen
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // closes the program
            frame.getContentPane().add(panel, BorderLayout.CENTER);
            frame.setVisible(true); // show the frame

}


/**
 * Class that draws the triangle and extends the JPanel class
 *
 * @author Karson Hodge
 */
static class SierTriangle extends JPanel {

    /**
     * paint component that will draw the sierpinski Triangle.
     *
     * @param g the <code>Graphics</code> object to protect
     * @author Karson Hodge
     */
    public void paintComponent(Graphics g) {
        int x1 = 512; // sets the starting x1 pair
        int y1 = 109;
        int x2 = 146; // sets the starting x2 pair
        int y2 = 654;
        int x3 = 876; // sets the starting x3 pair
        int y3 = 654;

        int x = 512; // starting coordinates for the drawing
        int y = 382;

        Random rand = new Random(); // Creates the random object

        for (int i = 0; i < 50000; i++) { // loops through the steps 50000 times
            g.drawLine(x,y,x,y); // draws the line

            int rando = rand.nextInt(3) + 1;
            int dx; // holds the distance
            int dy;
            if (rando == 1){ // if random is 1, use x1
                dx = x - x1;
                dy = y - y1;
            }
            else if (rando == 2){ // if random is 2, use x2
                dx = x - x2;
                dy = y - y2;
            }
            else{ // else use x3
                dx = x - x3;
                dy = y - y3;
            }

            x = x - dx/2; // distance halved and then minus from the original coordinates
            y = y - dy/2;

        }

        g.drawString("Sierpinski Triangle", 462,484); // draw the string of Sierpinski Triangle

    }

    }
}
