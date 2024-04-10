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
        TicTacToe ticObj = new TicTacToe(); // creates the TicTacToe instance

        ticObj.runTicTac(); // runs the game loop


    }
}


/**
 * Main class that builds the GUI and then also runs the tic-tac-toe game
 *
 * @author Karson Hodge
 */
class TicTacToe implements ActionListener {

    private JFrame frame; //established the main window
    private JPanel panel;
    private JButton[] buttons = new JButton[13]; // thirteen buttons will be used
    private static JLabel label;
    private boolean xTurn = true; // keep track of who's turn
    private String turn; // for tracking what stage

    /**
     * Runs the whole game
     *
     * @author Karson Hodge
     */
    public void runTicTac(){
        frame = new JFrame("Tic-Tac-Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close the jframe when exit is clicked

        panel = new JPanel(); // adds a panel which objects will be placed on

        starter(); // builds the main menu

        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(400, 400); // sets the size for the window
        frame.setVisible(true);
    }


    /**
     * Setup the tictactoe game to be played
     *
     * @author Karson Hodge
     */
    public void ticTacSetup(){
        panel.setLayout(new GridLayout(3, 3)); // grid layout for tictactoe
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (int i = 0; i < 9; i++) { // loop through and assign each button
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 40));
            buttons[i].addActionListener(this); // adds a listener for when the button is clicked
            panel.add(buttons[i]);
        }

    }

    /**
     * Listener that waits for a button press
     *
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button == buttons[10]) { // if cpu is clicked this will fire
            turn = "Cpu"; // set it to cpu turn
            panel.removeAll();
            ticTacSetup(); // builds the game
            panel.revalidate();
            panel.repaint(); // need to reset the panels graphics
            computer();

        }
        else if (button == buttons[11]) { // if player is chosen in the menu
            turn = "Player";
            xTurn = true; // set player turn tru
            panel.removeAll();
            ticTacSetup(); // setup the game for the user
            panel.revalidate();
            panel.repaint(); // used to paint the graphics
        }
        else if (button == buttons[12]) { // help button
            JOptionPane.showMessageDialog(frame, "Karson Hodge. \nTic-Tac-Toe, win by getting the X's or O's in a row of three. Either in a row, column or diagonal \nApril 10th, 2024.");
        }
        else {
            if (turn == "Cpu"){ // if cpu was clicked, this is the game loop

                if (xTurn) {
                    button.setText("X"); // set to x if cpu's turn
                } else {
                    button.setText("O");
                }
                button.setEnabled(false); // disable the button from being clicked
                xTurn = !xTurn;

                computer(); // computers turn now

                checkForWinner();

            }
            else{
                if (xTurn) { // user goes first
                    button.setText("X");
                } else {
                    button.setText("O");
                } // set the letter clicked
                button.setEnabled(false);
                xTurn = !xTurn; // switch turns

                checkForWinner(); // check if user has won

                computer();

                checkForWinner(); //check if computer has won
            }

        }
    }


    /**
     * This function checks for the winner, row column or diagonal.
     *
     * @author Karson Hodge
     */
    public void checkForWinner() {
        // Check rows
        for (int i = 0; i < 9; i += 3) {
            if (buttons[i].getText().equals(buttons[i+1].getText()) && buttons[i].getText().equals(buttons[i+2].getText()) && !buttons[i].isEnabled()) {
                JOptionPane.showMessageDialog(frame, buttons[i].getText() + " wins!"); // displays the character that won
                resetGame();
                return;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (buttons[i].getText().equals(buttons[i+3].getText()) && buttons[i].getText().equals(buttons[i+6].getText()) && !buttons[i].isEnabled()) {
                JOptionPane.showMessageDialog(frame, buttons[i].getText() + " wins!");
                resetGame(); // resets the game
                return;
            }
        }

        // Check diagonals
        if (buttons[0].getText().equals(buttons[4].getText()) && buttons[0].getText().equals(buttons[8].getText()) && !buttons[0].isEnabled()) {
            JOptionPane.showMessageDialog(frame, buttons[0].getText() + " wins!");
            resetGame(); // resets the game
            return;
        }
        if (buttons[2].getText().equals(buttons[4].getText()) && buttons[2].getText().equals(buttons[6].getText()) && !buttons[2].isEnabled()) {
            JOptionPane.showMessageDialog(frame, buttons[2].getText() + " wins!");
            resetGame(); //resets the game
            return;
        }

        // Check for tie
        boolean tie = true;
        for (int i = 0; i < 9; i++) { // loops through all the buttons checking if any are enabled
            if (buttons[i].isEnabled()) {
                tie = false;
                break;
            }
        }
        if (tie) { // show tie message
            JOptionPane.showMessageDialog(frame, "Tie game!");
            resetGame();
        }
    }

    /**
     * Resets the game and sends the user back to the main menu
     *
     * @author Karson Hodge
     */
    public void resetGame() {
        for (int i = 0; i < 9; i++) { // resets all the buttons
            buttons[i].setText("");
            buttons[i].setEnabled(true);
        }
        xTurn = true;
        panel.removeAll(); // remove the current graphics
        panel.revalidate();
        panel.repaint();
        starter(); // run the main menu
    }

    /**
     * Main menu for the user, pick who goes first or open the help button.
     *
     * @author Karson Hodge
     */
    public void starter(){
        panel.setLayout(new GridLayout(4, 1)); //grid layout for the panel
        buttons[10] = new JButton("CPU");
        buttons[11] = new JButton("Player");
        buttons[12] = new JButton("Help"); // help button with text
        label = new JLabel("Who Goes First?");
        panel.add(label); // adds the label to the panel
        panel.add(buttons[10]);
        panel.add(buttons[11]);
        panel.add((buttons[12])); // adds the button to the panel
        buttons[10].addActionListener(this);
        buttons[11].addActionListener(this); // adds a listener to the button
        buttons[12].addActionListener(this);

    }

    /**
     * controls the actions of the computer and makes a selection.
     *
     * @author Karson Hodge
     */
    public void computer() {
        boolean looper = true;
        Random rand = new Random(); // create a new instance of Random
        if(buttons[4].getText() == ""){ // center is empty pick it
            if (xTurn) {
                buttons[4].setText("X"); // set the character
            } else {
                buttons[4].setText("O");
            }

            buttons[4].setEnabled(false); // disable the button
            xTurn = !xTurn;
            looper = false;
        }
        else if(buttons[0].getText() == ""){  // all the ELSE IF statements including this one picks a corner
            if (xTurn) {
                buttons[0].setText("X"); // set character
            } else {
                buttons[0].setText("O");
            }

            buttons[0].setEnabled(false); // disable button
            xTurn = !xTurn;
            looper = false;
        }
        else if(buttons[2].getText() == ""){
            if (xTurn) {
                buttons[2].setText("X"); // set character
            } else {
                buttons[2].setText("O");
            }

            buttons[2].setEnabled(false);// disable button
            xTurn = !xTurn;
            looper = false;
        }
        else if(buttons[6].getText() == ""){
            if (xTurn) {
                buttons[6].setText("X");// set character
            } else {
                buttons[6].setText("O");
            }

            buttons[6].setEnabled(false);// disable button
            xTurn = !xTurn;
            looper = false;
        }
        else{
        while (looper) { // loop until an open spot is found
                int tryRand = rand.nextInt(9); // picks a random number 0-8
                if (buttons[tryRand].getText() == "X" || buttons[tryRand].getText() == "O") { // if already played do nothing

                } else {
                    if (xTurn) {
                        buttons[tryRand].setText("X"); // set the character
                    } else {
                        buttons[tryRand].setText("O");
                    }

                    buttons[tryRand].setEnabled(false); // disable the button
                    xTurn = !xTurn; // switch turn
                    looper = false; // end loop
                }
            }
        }

        checkForWinner(); // check if computer won.


    }


}