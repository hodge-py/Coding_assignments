// Karson Hodge, MCIS-Adv Programming Concepts, Section 34, ID: 9999-03235
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import java.util.Random;

/**
 * Runs the TicTacToe class which draws the gui and runs the game
 *
 * @author Karson Hodge
 */
public class AssiTen {


    public static void main(String[] args) {
        TicTacToe ticObj = new TicTacToe();

        ticObj.runTicTac();


    }
}


/**
 * Main class that builds the GUI and then also runs the tic-tac-toe game
 *
 * @author Karson Hodge
 */
class TicTacToe implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private JButton[] buttons = new JButton[13];
    private static JLabel label;
    private boolean xTurn = true;
    private String turn;

    public void runTicTac(){
        frame = new JFrame("Tic-Tac-Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();

        starter();

        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }


    /**
     * Setup the tictactoe game to be played
     *
     */
    public void ticTacSetup(){
        panel.setLayout(new GridLayout(3, 3));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 40));
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);
        }
        System.out.println("ggegegege");
    }

    /**
     * Listener that waits for a button press
     *
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button == buttons[10]) {
            turn = "Cpu";
            System.out.println(button.getText());
            panel.removeAll();
            ticTacSetup();
            panel.revalidate();
            panel.repaint();
            computer();

        }
        else if (button == buttons[11]) {
            turn = "Player";
            xTurn = true;
            System.out.println(button.getText());
            panel.removeAll();
            ticTacSetup();
            panel.revalidate();
            panel.repaint();
        }
        else if (button == buttons[12]) {
            JOptionPane.showMessageDialog(frame, "Karson Hodge. \nTic-Tac-Toe, win by getting the X's or O's in a row of three. Either in a row, column or diagonal \nApril 9th, 2024.");
        }
        else {
            if (turn == "Cpu"){

                if (xTurn) {
                    button.setText("X");
                } else {
                    button.setText("O");
                }
                button.setEnabled(false);
                xTurn = !xTurn;

                computer();

                checkForWinner();
            }
            else{
                if (xTurn) {
                    button.setText("X");
                } else {
                    button.setText("O");
                }
                button.setEnabled(false);
                xTurn = !xTurn;

                checkForWinner();

                computer();

                checkForWinner();
            }

        }
    }


    /**
     * This function checks for the winner, row column or diagonal.
     *
     */
    public void checkForWinner() {
        // Check rows
        for (int i = 0; i < 9; i += 3) {
            if (buttons[i].getText().equals(buttons[i+1].getText()) && buttons[i].getText().equals(buttons[i+2].getText()) && !buttons[i].isEnabled()) {
                JOptionPane.showMessageDialog(frame, buttons[i].getText() + " wins!");
                resetGame();
                return;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (buttons[i].getText().equals(buttons[i+3].getText()) && buttons[i].getText().equals(buttons[i+6].getText()) && !buttons[i].isEnabled()) {
                JOptionPane.showMessageDialog(frame, buttons[i].getText() + " wins!");
                resetGame();
                return;
            }
        }

        // Check diagonals
        if (buttons[0].getText().equals(buttons[4].getText()) && buttons[0].getText().equals(buttons[8].getText()) && !buttons[0].isEnabled()) {
            JOptionPane.showMessageDialog(frame, buttons[0].getText() + " wins!");
            resetGame();
            return;
        }
        if (buttons[2].getText().equals(buttons[4].getText()) && buttons[2].getText().equals(buttons[6].getText()) && !buttons[2].isEnabled()) {
            JOptionPane.showMessageDialog(frame, buttons[2].getText() + " wins!");
            resetGame();
            return;
        }

        // Check for tie
        boolean tie = true;
        for (int i = 0; i < 9; i++) {
            if (buttons[i].isEnabled()) {
                tie = false;
                break;
            }
        }
        if (tie) {
            JOptionPane.showMessageDialog(frame, "Tie game!");
            resetGame();
        }
    }

    /**
     * Resets the game and sends the user back to the main menu
     *
     */
    public void resetGame() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setText("");
            buttons[i].setEnabled(true);
        }
        xTurn = true;
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        starter();
    }

    /**
     * Main menu for the user, pick who goes first or open the help button.
     *
     */
    public void starter(){
        panel.setLayout(new GridLayout(4, 1));
        buttons[10] = new JButton("CPU");
        buttons[11] = new JButton("Player");
        buttons[12] = new JButton("Help");
        label = new JLabel("Who Goes First?");
        panel.add(label);
        panel.add(buttons[10]);
        panel.add(buttons[11]);
        panel.add((buttons[12]));
        buttons[10].addActionListener(this);
        buttons[11].addActionListener(this);
        buttons[12].addActionListener(this);

    }

    /**
     * controls the actions of the computer and makes a selection.
     *
     */
    public void computer() {
        System.out.println("ff");
        boolean looper = true;
        Random rand = new Random();


        while (looper) {
            int tryRand = rand.nextInt(9);
            System.out.println(tryRand);
            if (buttons[tryRand].getText() == "X" || buttons[tryRand].getText() == "O") {

            }
            else {
                if (xTurn) {
                    buttons[tryRand].setText("X");
                } else {
                    buttons[tryRand].setText("O");
                }

                buttons[tryRand].setEnabled(false);
                xTurn = !xTurn;
                looper = false;
            }


        }


        checkForWinner();


    }


}