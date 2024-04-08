// Karson Hodge, MCIS-Adv Programming Concepts, Section 34, ID: 9999-03235
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Runs the main game and also draws the gui
 *
 * @author Karson Hodge
 */
public class AssiTen {


    public static void main(String[] args) {
        TicTacToe ticObj = new TicTacToe();

        ticObj.runTicTac();


    }
}


class TicTacToe implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private JButton[] buttons = new JButton[12];
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

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button == buttons[10]) {
            turn = "Cpu";
            System.out.println(button.getText());
            panel.removeAll();
            ticTacSetup();
            panel.revalidate();
            panel.repaint();
        }
        else if (button == buttons[11]) {
            turn = "Player";
            System.out.println(button.getText());
            panel.removeAll();
            ticTacSetup();
            panel.revalidate();
            panel.repaint();
        }
        else {
            if (xTurn) {
                button.setText("X");
            } else {
                button.setText("O");
            }
            button.setEnabled(false);
            xTurn = !xTurn;

            checkForWinner();
        }
    }

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


    public void resetGame() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setText("");
            buttons[i].setEnabled(true);
        }
        xTurn = true;
        panel.removeAll();
        starter();
    }

    public void starter(){
        buttons[10] = new JButton("CPU");
        buttons[11] = new JButton("Player");
        label = new JLabel("Who Goes First?");
        panel.add(label);
        panel.add(buttons[10]);
        panel.add(buttons[11]);
        buttons[10].addActionListener(this);
        buttons[11].addActionListener(this);
    }


}