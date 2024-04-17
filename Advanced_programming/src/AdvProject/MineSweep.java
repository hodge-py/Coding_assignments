// Karson Hodge, MCIS-Adv Programming Concepts, Section 34, ID: 9999-03235
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.awt.event.MouseAdapter;
import java.util.Timer;
import java.util.concurrent.ThreadLocalRandom;


/**
 * main class that provides the instance for the game class and then runs the main program to build it
 *
 * @author
 */
public class MineSweep {

    public static void main(String[] args) {
        MineSetup mineObj = new MineSetup();

        mineObj.setup();


    }
}

/**
 * The class that builds the frame and then all the other parts of the game
 *
 * @author Karson Hodge
 */
class MineSetup implements ActionListener  {
    private JFrame frame; //established the main window
    private JPanel panel;
    private JButton[] buttons = new JButton[900]; // 900 buttons will be used
    private static JLabel[] label = new JLabel[2]; // Labels used in the game
    Timer timer = new Timer(); // timer instance for timing
    int timeHold = 0;
    boolean leftRight = false; // for keeping track of left click
    ArrayList<Integer> mineLoc; // array for mines
    TimerTask task1;
    TimerTask task2; // Timer task for each second check
    TimerTask task3;
    String difficulty; // The difficulty chosen

    /**
     * Builds the main window and then runs the mainMenu function
     *
     * @author Karson Hodge
     */
    public void setup(){


            frame = new JFrame("MineSweeper");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close the jframe when exit is clicked

            panel = new JPanel(); // adds a panel which objects will be placed on

            frame.add(panel, BorderLayout.CENTER);
            frame.setSize(600, 600); // sets the size for the window
            frame.setVisible(true);
            frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH); // maximizes the frame
            mainMenu(); // builds the main menu


    }

    /**
     * easy mode function, 60 seconds, 11 mines
     *
     * @author Karson Hodge
     */
    public void easyMode(){
        difficulty = "easy"; // sets difficulty variable
        label[1] = new JLabel("0", JLabel.CENTER);
        label[1].setHorizontalTextPosition(JLabel.CENTER); // Location of label
        frame.add(label[1],BorderLayout.NORTH);
        panel.setLayout(new GridLayout(10, 6)); // uses the grid layout
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        for (int i = 3; i < 57; i++) { // loops through the 54 buttons needed
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 40)); // font and size
            buttons[i].addActionListener(this);
            buttons[i].setActionCommand(String.valueOf(i)); // string index used for later
            int finalI = i;
            buttons[i].addMouseListener(new MouseAdapter() { // controls the mouse events
                public void mousePressed(MouseEvent me) {
                    if(me.getButton() == MouseEvent.BUTTON1){ // left click is pressed
                        leftRight = true;
                    }
                    else{

                        Color colorButton = new Color(238,238,238); // color of standard button
                        if(Objects.equals(buttons[finalI].getBackground(), colorButton)){
                            buttons[finalI].setBackground(Color.RED); // sets the button red with right click
                        }
                        else {
                            buttons[finalI].setBackground(null); // sets the button to the default
                        }
                    }
                }
            });
            panel.add(buttons[i]); // finally adds the button to the panel
        }
    }

    /**
     * middle mode setting, 180 seconds, 36 mines
     *
     * @author Karson Hodge
     */
    public void middleMode(){
        difficulty = "medium"; // difficulty set
        label[1] = new JLabel("0", JLabel.CENTER);
        label[1].setHorizontalTextPosition(JLabel.CENTER); // sets the label to the center
        frame.add(label[1],BorderLayout.NORTH);
        panel.setLayout(new GridLayout(18, 12)); // grid layout
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        for (int i = 57; i < 273; i++) { // adds the 216 buttons
            buttons[i] = new JButton(); // creates the button object
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 40));
            buttons[i].addActionListener(this); // adds a listener to the button
            buttons[i].setActionCommand(String.valueOf(i));
            int finalI = i; // needed to access in the mouse function
            buttons[i].addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent me) {
                    if(me.getButton() == MouseEvent.BUTTON1){ // controls the left click
                        leftRight = true;
                    }
                    else{

                        Color colorButton = new Color(238,238,238);
                        if(Objects.equals(buttons[finalI].getBackground(), colorButton)){
                            buttons[finalI].setBackground(Color.RED); // sets the button to a red background
                        }
                        else {
                            buttons[finalI].setBackground(null); // sets the button to the default
                        }
                    }
                }
            });
            panel.add(buttons[i]); // adds the button to the panel
        }
    }


    /**
     * hard mode setting, 660 seconds 92 mines
     *
     * @author Karson Hodge
     */
    public void hardMode(){
        difficulty = "hard";
        label[1] = new JLabel("0", JLabel.CENTER); // creates a new label
        label[1].setHorizontalTextPosition(JLabel.CENTER);
        frame.add(label[1],BorderLayout.NORTH); // sets the label to the top
        panel.setLayout(new GridLayout(26, 21));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // adds space around the border
        for (int i = 273; i < 819; i++) { // adds the buttons needed for hard mode
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 40)); // sets a default font
            buttons[i].addActionListener(this);
            buttons[i].setActionCommand(String.valueOf(i)); // index for the button
            int finalI = i;
            buttons[i].addMouseListener(new MouseAdapter() { // tracks mouse events
                public void mousePressed(MouseEvent me) {
                    if(me.getButton() == MouseEvent.BUTTON1){ // if left click is pressed
                        leftRight = true;
                    }
                    else{

                        Color colorButton = new Color(238,238,238);
                        if(Objects.equals(buttons[finalI].getBackground(), colorButton)){ // sets the button red if true
                            buttons[finalI].setBackground(Color.RED);
                        }
                        else {
                            buttons[finalI].setBackground(null); // sets the button to default if pressed again
                        }
                    }
                }
            });
            panel.add(buttons[i]); // add button to the panel
        }
    }

    /**
     * keeps track of button presses and runs the corresponding functions
     *
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource(); // get the button that was clicked

        if (button == buttons[0]) { // easy mode button
            timeHold = 0;
            panel.removeAll(); // clears preexisting objects
            easyMode(); // runs the easymode function
            panel.revalidate();
            panel.repaint(); // draws everything
            mineLoc = minePlacement("easy"); // sets the mine placement for easy
            timer.scheduleAtFixedRate(task1, 1000, 1000); // set the timer to run

        }
        else if (button == buttons[1]) { // medium mode
            timeHold = 0; // sets timer to zero
            panel.removeAll();
            middleMode(); // runs the medium mode
            panel.revalidate();
            panel.repaint(); // draws graphics
            mineLoc = minePlacement("medium"); // mine placement medium
            timer.scheduleAtFixedRate(task2, 1000, 1000); // timer for every second

        }
        else if (button == buttons[2]) { // hard mode button
            timeHold = 0;
            panel.removeAll(); // removes the existing items
            hardMode(); // runs hard mode
            panel.revalidate();
            panel.repaint(); // draws graphics
            mineLoc = minePlacement("hard"); // places mines
            timer.scheduleAtFixedRate(task3, 1000, 1000); // sets the timer for 1 second

        }

        if (leftRight){ // if left click is true
            if (mineLoc.contains(Integer.parseInt(button.getActionCommand()))){ // checks if the button is in the mine location
                explosionMine(); // sets off the mines
                button.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("explosion-boom.gif")))); // runs the mine gif

                task1.cancel();
                task2.cancel(); // stops all timers
                task3.cancel();
                JOptionPane.showMessageDialog(frame, "Game Over"); // game over message
                frame.remove(label[1]);
                leftRight = false; // set left click false
                mainMenu(); // return to mainmenu
            }
            else{
                int value = mineCounter(button.getActionCommand(),difficulty); // get the index
                button.setText(String.valueOf(value));
                button.setBackground(null); // set value to null
                button.setEnabled(false);
                winner(); // check if it is a winner
            }

        }

    }


    /**
     * function that builds the main menu for use
     *
     * @author Karson Hodge
     */
    public void mainMenu(){
        panel.removeAll(); // resets panel
        panel.setLayout(new GridLayout(4, 1));
        label[0] = new JLabel("Pick a difficulty"); // label with description
        label[0].setHorizontalTextPosition(JLabel.CENTER);
        panel.add(label[0]); // add label to panel
        buttons[0] = new JButton("Beginner");
        buttons[1] = new JButton("Intermediate"); // three buttons for difficulty
        buttons[2] = new JButton("Advanced");
        panel.add(buttons[0]);
        panel.add(buttons[1]); // adds each button the panel
        panel.add(buttons[2]);
        buttons[0].addActionListener(this);
        buttons[1].addActionListener(this); // adds a listener for each button
        buttons[2].addActionListener(this);
        panel.revalidate();
        panel.repaint(); // draws everything

        task1 = new TimerTask() { // timer task for easy mode
            @Override
            public void run() {
                timeHold += 1; // increase by one
                label[1].setText(String.valueOf(timeHold));
                if (timeHold == 60) { // if 60 then run this
                    explosionMine(); // explode mines
                    JOptionPane.showMessageDialog(frame, "Game Over");
                    frame.remove(label[1]); //remove label
                    this.cancel();
                    leftRight = false; // set left click false
                    mainMenu(); // mainmenu function
                }
            }
        };

        task2 = new TimerTask() { // timer for medium
            @Override
            public void run() {
                timeHold += 1; // add one to timer
                label[1].setText(String.valueOf(timeHold));
                if (timeHold == 180) { // if time reaches 180
                    explosionMine();
                    JOptionPane.showMessageDialog(frame, "Game Over");
                    frame.remove(label[1]); // remove the label
                    this.cancel();
                    leftRight = false; //  sets left click to false
                    mainMenu();
                }
            }
        };

        task3 = new TimerTask() { // timer for hard mode
            @Override
            public void run() {
                timeHold += 1; // adds 1 to the time
                label[1].setText(String.valueOf(timeHold));
                if (timeHold == 660) { // if timer hits 660
                    explosionMine();
                    JOptionPane.showMessageDialog(frame, "Game Over");
                    frame.remove(label[1]); // removes the label
                    this.cancel(); // cancel timer
                    leftRight = false;
                    mainMenu(); // return to main menu
                }
            }
        };


    }


    /**
     * Places the mines in an array for reference later
     *
     * @param diff mine placement difficulty
     * @return arraylist with the mine locations
     */
    public ArrayList<Integer> minePlacement(String diff){
        ArrayList<Integer> arr = new ArrayList<Integer>(); // arraylist for mines
        int randHold; // holds the random int
        int count = 0;
        if(diff == "easy"){ // easy setting
            while(count < 11) {
                randHold = ThreadLocalRandom.current().nextInt(3, 56 + 1); // placement on button number
                if (arr.contains(randHold)) {

                }
                else{ // if the arr doesnt contain the random number add it
                    arr.add(randHold);
                    count += 1;
                }
            }
        }
        else if(diff == "medium"){ // medium difficult
                while(count < 36) {
                    randHold = ThreadLocalRandom.current().nextInt(57, 272 + 1); // random value
                    if (arr.contains(randHold)) {

                    }
                    else{ // add if doesnt exist
                        arr.add(randHold);
                        count += 1;
                    }
                }
        }
        else if(diff == "hard"){ // hard difficult
                while(count < 92) {
                    randHold = ThreadLocalRandom.current().nextInt(273, 818 + 1); // random value
                    if (arr.contains(randHold)) {

                    }
                    else{ // adds 92 random values
                        arr.add(randHold);
                        count += 1;
                    }
                }
        }

        return arr; // return the array for use
    }

    /**
     * Counts how many mines are nearby
     *
     * @param mineCount the array number of the button
     * @return counter, the amount of mines nearby
     */
    public int mineCounter(String mineCount, String diff){ // checks for mines around
        int counter = 0;
        System.out.println(mineCount);
        if(diff == "easy") {
            if (mineLoc.contains(Integer.parseInt(mineCount) - 7)) { // in the left hand corner
                if (Integer.parseInt(mineCount) < 9) {
                    counter += 0;
                }
                else if((Integer.parseInt(mineCount)-3) % 6 == 0) { // checks if left exist
                    counter += 0;
                }
                else {
                    counter += 1;
                }
            }
            if (mineLoc.contains(Integer.parseInt(mineCount) - 6)) {
                if (Integer.parseInt(mineCount) < 9) { // dont count top if on the first row
                    counter += 0;
                }
                else {
                    counter += 1;
                }
            }
            if (mineLoc.contains(Integer.parseInt(mineCount) - 5)) { // right hand corner
                if ((Integer.parseInt(mineCount)-2) % 6 == 0) {
                    counter += 0;
                }
                else if (Integer.parseInt(mineCount) < 9) { // checks if it is on the first row
                    counter += 0;
                }
                else {
                    counter += 1;
                }
            }
            if (mineLoc.contains(Integer.parseInt(mineCount) - 1)) {
                if((Integer.parseInt(mineCount)-3) % 6 == 0) { // checks if it is in the first column
                    counter += 0;
                }
                else {
                    counter += 1;
                }
            }
            if (mineLoc.contains(Integer.parseInt(mineCount) + 1)) { // left hand bottom corner
                if ((Integer.parseInt(mineCount)-2) % 6 == 0) {
                    counter += 0; // add zero if it is on the last column
                }
                else {
                    counter += 1;
                }
            }
            if (mineLoc.contains(Integer.parseInt(mineCount) + 5)) {
                if(Integer.parseInt(mineCount) > 50 && Integer.parseInt(mineCount) < 57) { // checks if it is on the last row
                    counter += 0;
                }
                else if((Integer.parseInt(mineCount)-3) % 6 == 0) { // and first column
                    counter += 0;
                }
                else{
                    counter += 1;
                }
            }
            if (mineLoc.contains(Integer.parseInt(mineCount) + 6)) { // right hand bottom corner
                if(Integer.parseInt(mineCount) > 50 && Integer.parseInt(mineCount) < 57) { // checks if it is on the last row
                    counter += 0;
                }
                else{
                    counter += 1;
                }
            }
            if (mineLoc.contains(Integer.parseInt(mineCount) + 7)) {
                if ((Integer.parseInt(mineCount)-2) % 6 == 0) { // check if it is on the last column
                    counter += 0;
                    System.out.println("end");
                }
                else if(Integer.parseInt(mineCount) > 50 && Integer.parseInt(mineCount) < 57) { // checks if it is the last row
                    counter += 0;
                }
                else {
                    counter += 1;
                }

            }
        }

        else if(diff == "medium") {
            if (mineLoc.contains(Integer.parseInt(mineCount) - 13)) { // in the left hand corner
                if (Integer.parseInt(mineCount) < 69) {
                    counter += 0;
                }
                else if((Integer.parseInt(mineCount)-9) % 12 == 0) { // checks if left exist
                    counter += 0;
                }
                else {
                    counter += 1;
                }
            }
            if (mineLoc.contains(Integer.parseInt(mineCount) - 12)) {
                if (Integer.parseInt(mineCount) < 69) { // checks if it is on the first row
                    counter += 0;
                }
                else {
                    counter += 1;
                }
            }
            if (mineLoc.contains(Integer.parseInt(mineCount) - 11)) { // right hand corner
                if ((Integer.parseInt(mineCount)-8) % 12 == 0) {
                    counter += 0;
                }
                else if (Integer.parseInt(mineCount) < 69) {  // checks if it is on the first row
                    counter += 0;
                }
                else {
                    counter += 1;
                }
            }
            if (mineLoc.contains(Integer.parseInt(mineCount) - 1)) {
                if((Integer.parseInt(mineCount)-9) % 12 == 0) { // checks if it is on the first column
                    counter += 0;
                }
                else {
                    counter += 1;
                }
            }
            if (mineLoc.contains(Integer.parseInt(mineCount) + 1)) { // right side corner
                if ((Integer.parseInt(mineCount)-8) % 12 == 0) { // checks if it is on the last column
                    counter += 0;
                }
                else {
                    counter += 1;
                }
            }
            if (mineLoc.contains(Integer.parseInt(mineCount) + 11)) {
                if(Integer.parseInt(mineCount) > 260 && Integer.parseInt(mineCount) < 273) { // checks if it is on the last row
                    counter += 0;
                }
                else if((Integer.parseInt(mineCount)-9) % 12 == 0) { // checks if it is the first column
                    counter += 0;
                }
                else{
                    counter += 1;
                }
            }
            if (mineLoc.contains(Integer.parseInt(mineCount) + 12)) { // right hand bottom corner
                if(Integer.parseInt(mineCount) > 260 && Integer.parseInt(mineCount) < 273) { // last row check
                    counter += 0;
                }
                else{
                    counter += 1;
                }
            }
            if (mineLoc.contains(Integer.parseInt(mineCount) + 13)) {
                if ((Integer.parseInt(mineCount)-8) % 12 == 0) { // last column check
                    counter += 0;
                    System.out.println("end");
                }
                else if(Integer.parseInt(mineCount) > 260 && Integer.parseInt(mineCount) < 273) { // last row check
                    counter += 0;
                }
                else {
                    counter += 1;
                }
            }
        }

        else if(diff == "hard") {
            if (mineLoc.contains(Integer.parseInt(mineCount) - 22)) { // in the left hand corner
                if (Integer.parseInt(mineCount) < 294) {
                    counter += 0;
                }
                else if((Integer.parseInt(mineCount)) % 21 == 0) { // checks first column
                    counter += 0;
                }
                else {
                    counter += 1;
                }
            }
            if (mineLoc.contains(Integer.parseInt(mineCount) - 21)) {
                if (Integer.parseInt(mineCount) < 295) { //checks if first row
                    counter += 0;
                }
                else {
                    counter += 1;
                }
            }
            if (mineLoc.contains(Integer.parseInt(mineCount) - 20)) { // right hand corner
                if ((Integer.parseInt(mineCount)+1) % 21 == 0) {
                    counter += 0;
                }
                else if (Integer.parseInt(mineCount) < 295) { // checks if first row
                    counter += 0;
                }
                else {
                    counter += 1;
                }
            }
            if (mineLoc.contains(Integer.parseInt(mineCount) - 1)) {
                if((Integer.parseInt(mineCount)) % 21 == 0) { // checks if first row
                    counter += 0;
                }
                else {
                    counter += 1;
                }
            }
            if (mineLoc.contains(Integer.parseInt(mineCount) + 1)) { // left hand bottom corner
                if ((Integer.parseInt(mineCount)+1) % 21 == 0) { // checks if last column
                    counter += 0;
                }
                else {
                    counter += 1;
                }
            }
            if (mineLoc.contains(Integer.parseInt(mineCount) + 20)) {
                if(Integer.parseInt(mineCount) > 797 && Integer.parseInt(mineCount) < 819) { // checks last row
                    counter += 0;
                }
                else if((Integer.parseInt(mineCount)) % 21 == 0) { // checks first column
                    counter += 0;
                }
                else{
                    counter += 1;
                }
            }
            if (mineLoc.contains(Integer.parseInt(mineCount) + 21)) { // right hand bottom corner
                if(Integer.parseInt(mineCount) > 797 && Integer.parseInt(mineCount) < 819) { // checks last row
                    counter += 0;
                }
                else{
                    counter += 1;
                }
            }
            if (mineLoc.contains(Integer.parseInt(mineCount) + 22)) {
                if ((Integer.parseInt(mineCount)+1) % 21 == 0) { // checks last column
                    counter += 0;
                }
                else if(Integer.parseInt(mineCount) > 797 && Integer.parseInt(mineCount) < 819) { // checks last row
                    counter += 0;
                }
                else {
                    counter += 1;
                }
            }
        }



        return counter; // return the amount
    }


    /**
     * function that is ran when a mine exploded. red X's for missed mines, mines if marked correctly and explosion sound and animation
     *
     * @author Karson Hodge
     */
    public void explosionMine(){
        if(difficulty == "easy") { // difficulty setting
            for (int i = 3; i < 57; i++) { // loop how many buttons
                if(!mineLoc.contains(Integer.parseInt(buttons[i].getActionCommand())) && buttons[i].getBackground() == Color.RED){
                    buttons[i].setBackground(null);
                    buttons[i].setForeground(Color.RED); // change to red
                    buttons[i].setText("X"); // set X if user missed a mine
                }
                else if (mineLoc.contains(Integer.parseInt(buttons[i].getActionCommand())) && buttons[i].getBackground() == Color.RED) {
                    buttons[i].setBackground(null); // set to default
                    buttons[i].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("land-mine.png")))); // show landmine image
                }
                else if (mineLoc.contains(Integer.parseInt(buttons[i].getActionCommand()))) {
                    buttons[i].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("explosion-boom.gif")))); // play explosion gif for rest
                }

            }
        }

        else if(difficulty == "medium"){ // medium button
            for (int i = 57; i < 273; i++) { // loop through medium button amount
                if(!mineLoc.contains(Integer.parseInt(buttons[i].getActionCommand())) && buttons[i].getBackground() == Color.RED){
                    buttons[i].setBackground(null); // set background to default
                    buttons[i].setForeground(Color.RED);
                    buttons[i].setText("X"); // set X for missed mines
                }
                else if (mineLoc.contains(Integer.parseInt(buttons[i].getActionCommand())) && buttons[i].getBackground() == Color.RED) {
                    buttons[i].setBackground(null); // default button
                    buttons[i].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("land-mine.png")))); // image of landmine
                }
                else if (mineLoc.contains(Integer.parseInt(buttons[i].getActionCommand()))) {
                    buttons[i].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("explosion-boom.gif")))); // play the landmine gif
                }

            }
        }

        else if(difficulty == "hard"){
            for (int i = 273; i < 819; i++) { // loop through hard mode buttons
                if(!mineLoc.contains(Integer.parseInt(buttons[i].getActionCommand())) && buttons[i].getBackground() == Color.RED){
                    buttons[i].setBackground(null);
                    buttons[i].setForeground(Color.RED); // change foreground to red
                    buttons[i].setText("X"); // set X as text
                }
                else if (mineLoc.contains(Integer.parseInt(buttons[i].getActionCommand())) && buttons[i].getBackground() == Color.RED) {
                    buttons[i].setBackground(null); // background default
                    buttons[i].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("land-mine.png")))); // landmine png
                }
                else if (mineLoc.contains(Integer.parseInt(buttons[i].getActionCommand()))) {
                    buttons[i].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("explosion-boom.gif")))); // play explosion gif
                }

            }
        }


        String soundName = "explosion.wav"; // explosion file
        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile()); // creates an audio stream
        } catch (UnsupportedAudioFileException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex); // exception if there is an error
        }
        Clip clip = null;
        try {
            clip = AudioSystem.getClip(); // gets the clip
        } catch (LineUnavailableException ex) {
            throw new RuntimeException(ex);
        }
        try {
            clip.open(audioInputStream); // opens the clip
        } catch (LineUnavailableException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) { // catch exception
            throw new RuntimeException(ex);
        }
        clip.start(); // run the clip

    }

    /**
     * Checks if the winner has won by seeing if the remaining buttons match the mine count.
     *
     * @author Karson Hodge
     */
    public void winner() {
        int countButton = 0;
        if (difficulty == "easy") { // difficulty level
            for (int i = 3; i < 57; i++) { // loop through enabled buttons
                if(buttons[i].isEnabled()){
                    countButton += 1;
                }
            }
            if(countButton == 11){ // if 11 remain, user wins
                JOptionPane.showMessageDialog(frame, "You Win");
                task1.cancel();
                task2.cancel(); // cancel timers
                task3.cancel();
                frame.remove(label[1]); // remove the label from frame
                leftRight = false;
                mainMenu(); // run the mainmenu function
            }
        }
        else if(difficulty == "medium"){ // difficulty level
            for (int i = 57; i < 273; i++) {
                if(buttons[i].isEnabled()){ // checks if the button is enabled
                    countButton += 1;
                }
            }
            if(countButton == 36){ // if 36, user wins
                JOptionPane.showMessageDialog(frame, "You Win");
                task1.cancel();
                task2.cancel(); // cancel timers
                task3.cancel();
                frame.remove(label[1]);
                leftRight = false; // left click false
                mainMenu(); // return mainmenu
            }
        }
        else if(difficulty == "hard"){
            for (int i = 273; i < 819; i++) { // loops through hard mode buttons
                if(buttons[i].isEnabled()){
                    countButton += 1;
                }
            }
            if(countButton == 92){ // if 92 remain, user wins
                JOptionPane.showMessageDialog(frame, "You Win");
                task1.cancel();
                task2.cancel(); // timer canceled
                task3.cancel();
                frame.remove(label[1]); // remove label
                leftRight = false;
                mainMenu(); // return the mainMenu function
            }
        }


    }


}