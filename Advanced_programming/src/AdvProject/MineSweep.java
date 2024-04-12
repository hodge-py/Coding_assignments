import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import java.util.Random;


public class MineSweep {

    public static void main(String[] args) {
        MineSetup mineObj = new MineSetup();

        mineObj.setup();


    }
}


class MineSetup implements ActionListener  {
    private JFrame frame; //established the main window
    private JPanel panel;
    private JButton[] buttons = new JButton[55]; // thirteen buttons will be used
    private static JLabel label;
    private boolean xTurn = true; // keep track of who's turn
    private String turn; // for tracking what stage

    public void setup(){


            frame = new JFrame("MineSweeper");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close the jframe when exit is clicked

            panel = new JPanel(); // adds a panel which objects will be placed on

            frame.add(panel, BorderLayout.CENTER);
            frame.setSize(400, 400); // sets the size for the window
            frame.setVisible(true);
            mode(); // temp

    }

    public void mode(){
        panel.setLayout(new GridLayout(6, 9));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (int i = 0; i < 54; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 40));
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);
        }
    }

    public void actionPerformed(ActionEvent e) {

    }

}