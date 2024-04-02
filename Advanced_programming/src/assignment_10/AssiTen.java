// Karson Hodge, MCIS-Adv Programming Concepts, Section 34, ID: 9999-03235
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Runs the main game and also draws the gui
 *
 * @author Karson Hodge
 */
public class AssiTen {

    public static void main(String[] args) {
        TicTacToe ticTacObj = new TicTacToe();

        JFrame f=new JFrame();//creating instance of JFrame

        JButton b=new JButton("click");//creating instance of JButton
        b.setBounds(130,100,100, 40);//x axis, y axis, width, height

        f.add(b);//adding button in JFrame

        f.setSize(400,500);//400 width and 500 height
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible


    }
}


class TicTacToe {



}