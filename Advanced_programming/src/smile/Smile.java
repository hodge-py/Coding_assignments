// Karson Hodge, MCIS-Adv Programming Concepts, Section 34, ID: 9999-03235
import javax.swing.*;
import java.awt.*;


public class Smile {

    public static void main(String[] args) {
        Drawer drawObj = new Drawer();
        drawObj.setup();

    }

}


class Drawer extends JPanel {

    public void setup(){
        JFrame frame=new JFrame("Smiley");
        frame.setSize(500,500);
        frame.setBackground(Color.white);
        Drawer panel = new Drawer();
        frame.add(panel);
        //Set default close operation for the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g){
        g.setColor(Color.black);
        g.drawArc(95,95,260,260,0,360);
        g.fillArc(95,95,260,260,0,360);
        g.setColor(Color.yellow);
        //Draw and fill the face
        g.drawArc(100,100,250,250,0,360);
        g.fillArc(100,100,250,250,0,360);
        //Change color to black
        g.setColor(Color.black);
        //Draw the left eye
        g.drawOval(170,185,25,40);
        g.fillArc(170,185,25,40,0,360);
        //Draw the right eye
        g.drawOval(255,185,25,40);
        g.fillArc(255,185,25,40,0,360);
        //Draw the smile
        g.drawArc(150,215,150,100,0,-180);

        g.drawLine(140,265,160,265);
    }

}