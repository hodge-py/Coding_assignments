// Karson Hodge, MCIS-Adv Programming Concepts, Section 34, ID: 9999-03235
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class MineSweep {

    public static void main(String[] args) {
        MineSetup mineObj = new MineSetup();

        mineObj.setup();


    }
}


class MineSetup implements ActionListener  {
    private JFrame frame; //established the main window
    private JPanel panel;
    private JButton[] buttons = new JButton[900]; // thirteen buttons will be used
    private static JLabel[] label = new JLabel[2];
    private boolean xTurn = true; // keep track of who's turn
    private String turn; // for tracking what stage
    Timer timer = new Timer();
    int timeHold = 0;

    public void setup(){


            frame = new JFrame("MineSweeper");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close the jframe when exit is clicked

            panel = new JPanel(); // adds a panel which objects will be placed on

            frame.add(panel, BorderLayout.CENTER);
            frame.setSize(600, 600); // sets the size for the window
            frame.setVisible(true);
            mainMenu();
            /*


             */

    }

    public void easyMode(){

        label[1] = new JLabel("0", JLabel.CENTER);
        label[1].setHorizontalTextPosition(JLabel.CENTER);
        frame.add(label[1],BorderLayout.NORTH);
        panel.setLayout(new GridLayout(10, 6));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        for (int i = 3; i < 57; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 40));
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);
        }
    }
    public void middleMode(){

        label[1] = new JLabel("0", JLabel.CENTER);
        label[1].setHorizontalTextPosition(JLabel.CENTER);
        frame.add(label[1],BorderLayout.NORTH);
        panel.setLayout(new GridLayout(18, 12));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        for (int i = 57; i < 273; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 40));
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);
        }
    }

    public void hardMode(){

        label[1] = new JLabel("0", JLabel.CENTER);
        label[1].setHorizontalTextPosition(JLabel.CENTER);
        frame.add(label[1],BorderLayout.NORTH);
        panel.setLayout(new GridLayout(26, 21));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        for (int i = 273; i < 819; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 40));
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);
        }
    }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        if (button == buttons[0]) {
            timeHold = 0;
            panel.removeAll();
            easyMode();
            panel.revalidate();
            panel.repaint();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    timeHold += 1;
                    label[1].setText(String.valueOf(timeHold));
                    if (timeHold == 60) {
                    JOptionPane.showMessageDialog(frame, "Game Over");
                    frame.remove(label[1]);
                    this.cancel();
                    mainMenu();
                    }
                }
            }, 1000, 1000);

        }
        else if (button == buttons[1]) {
            timeHold = 0;
            panel.removeAll();
            middleMode();
            panel.revalidate();
            panel.repaint();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    timeHold += 1;
                    label[1].setText(String.valueOf(timeHold));
                    if (timeHold == 180) {
                        JOptionPane.showMessageDialog(frame, "Game Over");
                        frame.remove(label[1]);
                        this.cancel();
                        mainMenu();
                    }
                }
            }, 1000, 1000);

        }
        else if (button == buttons[2]) {
            timeHold = 0;
            panel.removeAll();
            hardMode();
            panel.revalidate();
            panel.repaint();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    timeHold += 1;
                    label[1].setText(String.valueOf(timeHold));
                    if (timeHold == 660) {
                        JOptionPane.showMessageDialog(frame, "Game Over");
                        frame.remove(label[1]);
                        this.cancel();
                        mainMenu();
                    }
                }
            }, 1000, 1000);

        }

    }

    public void mainMenu(){
        panel.removeAll();
        panel.setLayout(new GridLayout(4, 1));
        label[0] = new JLabel("Pick a difficulty");
        panel.add(label[0]);
        buttons[0] = new JButton("Beginner");
        buttons[1] = new JButton("Intermediate");
        buttons[2] = new JButton("Advanced");
        panel.add(buttons[0]);
        panel.add(buttons[1]);
        panel.add(buttons[2]);
        buttons[0].addActionListener(this);
        buttons[1].addActionListener(this);
        buttons[2].addActionListener(this);
        panel.revalidate();
        panel.repaint();
    }

}