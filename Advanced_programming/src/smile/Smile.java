// Karson Hodge, MCIS-Adv Programming Concepts, Section 34, ID: 9999-03235
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;


public class Smile {

    public static void main(String[] args) {
        Drawer drawObj = new Drawer();
        drawObj.setup();

    }

}


class Drawer extends JPanel {
    public JFrame frame = new JFrame("Smiley");
    public Graphics2D g2 = (Graphics2D)g;

    public void setup(){
        frame.setSize(500,500);
        frame.setBackground(Color.white);
        Drawer panel = new Drawer();
        frame.add(panel);
        //Set default close operation for the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.addMouseMotionListener( new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {
                System.out.println(e.getLocationOnScreen());
            }
        });


    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g2 = (Graphics2D) g;

        g2.setColor(Color.black);
        g2.drawArc(95,95,260,260,0,360);
        g2.fillArc(95,95,260,260,0,360);
        g2.setColor(Color.yellow);
        //Draw and fill the face
        g2.drawArc(100,100,250,250,0,360);
        g2.fillArc(100,100,250,250,0,360);
        //Change color to black
        g2.setColor(Color.black);
        //Draw the left eye
        g2.drawOval(170,185,25,40);
        g2.fillArc(170,185,25,40,0,360);
        //Draw the right eye
        g2.drawOval(255,185,25,40);
        g2.fillArc(255,185,25,40,0,360);
        //Draw the smile
        g2.setStroke(new BasicStroke(3));
        g2.drawArc(150,215,150,100,0,-180);

        g2.drawLine(140,265,160,265);

        g2.drawLine(290,265,310,265);




    }

}