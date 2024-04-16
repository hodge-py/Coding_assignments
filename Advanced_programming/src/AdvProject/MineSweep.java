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
    boolean leftRight = false;
    ArrayList<Integer> mineLoc;
    TimerTask task1;
    TimerTask task2;
    TimerTask task3;
    String difficulty;


    public void setup(){


            frame = new JFrame("MineSweeper");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close the jframe when exit is clicked

            panel = new JPanel(); // adds a panel which objects will be placed on

            frame.add(panel, BorderLayout.CENTER);
            frame.setSize(600, 600); // sets the size for the window
            frame.setVisible(true);
            mouseAdd();
            mainMenu();


    }

    public void mouseAdd() {
            frame.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent me) {
                    System.out.println(me.getButton());
                }
            });

    }

    public void easyMode(){
        difficulty = "easy";
        label[1] = new JLabel("0", JLabel.CENTER);
        label[1].setHorizontalTextPosition(JLabel.CENTER);
        frame.add(label[1],BorderLayout.NORTH);
        panel.setLayout(new GridLayout(10, 6));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        for (int i = 3; i < 57; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 40));
            buttons[i].addActionListener(this);
            buttons[i].setActionCommand(String.valueOf(i));
            int finalI = i;
            buttons[i].addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent me) {
                    if(me.getButton() == MouseEvent.BUTTON1){
                        System.out.println("left click");
                        leftRight = true;
                    }
                    else{

                        Color colorButton = new Color(238,238,238);
                        if(Objects.equals(buttons[finalI].getBackground(), colorButton)){
                            buttons[finalI].setBackground(Color.RED);
                        }
                        else {
                            buttons[finalI].setBackground(null);
                        }
                    }
                }
            });
            panel.add(buttons[i]);
        }
    }
    public void middleMode(){
        difficulty = "medium";
        label[1] = new JLabel("0", JLabel.CENTER);
        label[1].setHorizontalTextPosition(JLabel.CENTER);
        frame.add(label[1],BorderLayout.NORTH);
        panel.setLayout(new GridLayout(18, 12));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        for (int i = 57; i < 273; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 40));
            buttons[i].addActionListener(this);
            buttons[i].setActionCommand(String.valueOf(i));
            buttons[i].addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent me) {
                    if(me.getButton() == MouseEvent.BUTTON1){
                        System.out.println("left click");
                    }
                    else{
                        System.out.println("right click");
                    }
                }
            });
            panel.add(buttons[i]);
        }
    }

    public void hardMode(){
        difficulty = "hard";
        label[1] = new JLabel("0", JLabel.CENTER);
        label[1].setHorizontalTextPosition(JLabel.CENTER);
        frame.add(label[1],BorderLayout.NORTH);
        panel.setLayout(new GridLayout(26, 21));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        for (int i = 273; i < 819; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 40));
            buttons[i].addActionListener(this);
            int finalI = i;
            buttons[i].addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent me) {
                    if(me.getButton() == MouseEvent.BUTTON1){
                        System.out.println("left click");
                    }
                    else{
                        System.out.println("right click");
                        System.out.println(buttons[finalI]);
                    }
                }
            });
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
            mineLoc = minePlacement("easy");
            timer.scheduleAtFixedRate(task1, 1000, 1000);

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
                        leftRight = false;
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
                        leftRight = false;
                        mainMenu();
                    }
                }
            }, 1000, 1000);

        }

        if (leftRight){
            if (mineLoc.contains(Integer.parseInt(button.getActionCommand()))){
                explosionMine();
                button.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("explosion-boom.gif"))));
                String soundName = "explosion.wav";
                AudioInputStream audioInputStream = null;
                try {
                    audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
                } catch (UnsupportedAudioFileException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                Clip clip = null;
                try {
                    clip = AudioSystem.getClip();
                } catch (LineUnavailableException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    clip.open(audioInputStream);
                } catch (LineUnavailableException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                clip.start();
                task1.cancel();
                JOptionPane.showMessageDialog(frame, "Game Over");
                frame.remove(label[1]);
                leftRight = false;
                mainMenu();
            }
            else{
                int value = mineCounter(button.getActionCommand());
                button.setText(String.valueOf(value));
                button.setBackground(null);
                button.setEnabled(false);
                winner();
            }

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

        task1 = new TimerTask() {
            @Override
            public void run() {
                timeHold += 1;
                label[1].setText(String.valueOf(timeHold));
                if (timeHold == 60) {
                    explosionMine();
                    JOptionPane.showMessageDialog(frame, "Game Over");
                    frame.remove(label[1]);
                    this.cancel();
                    leftRight = false;
                    mainMenu();
                }
            }
        };


    }

    public ArrayList<Integer> minePlacement(String diff){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Random rand = new Random();
        int randHold;
        int count = 0;
        if(diff == "easy"){
            while(count < 11) {
                randHold = ThreadLocalRandom.current().nextInt(3, 56 + 1);
                if (arr.contains(randHold)) {

                }
                else{
                    arr.add(randHold);
                    count += 1;
                }
            }
        }
        else if(diff == "medium"){
                while(count < 36) {
                    randHold = ThreadLocalRandom.current().nextInt(57, 272 + 1);
                    if (arr.contains(randHold)) {

                    }
                    else{
                        arr.add(randHold);
                        count += 1;
                    }
                }
        }
        else if(diff == "hard"){
                while(count < 92) {
                    randHold = ThreadLocalRandom.current().nextInt(273, 818 + 1);
                    if (arr.contains(randHold)) {

                    }
                    else{
                        arr.add(randHold);
                        count += 1;
                    }
                }
        }

        return arr;
    }


    public int mineCounter(String mineCount){
        int counter = 0;
        if(mineLoc.contains(Integer.parseInt(mineCount)-7)){
            counter += 1;
        }
        if(mineLoc.contains(Integer.parseInt(mineCount)-6)){
            counter += 1;
        }
        if(mineLoc.contains(Integer.parseInt(mineCount)-5)){
            counter += 1;
        }
        if(mineLoc.contains(Integer.parseInt(mineCount)-1)){
            counter += 1;
        }
        if(mineLoc.contains(Integer.parseInt(mineCount)+1)){
            counter += 1;
        }
        if(mineLoc.contains(Integer.parseInt(mineCount)+5)){
            counter += 1;
        }
        if(mineLoc.contains(Integer.parseInt(mineCount)+6)){
            counter += 1;
        }
        if(mineLoc.contains(Integer.parseInt(mineCount)+7)){
            counter += 1;
        }

        return counter;
    }

    public void explosionMine(){
        if(difficulty == "easy") {
            for (int i = 3; i < 57; i++) {
                if(!mineLoc.contains(Integer.parseInt(buttons[i].getActionCommand())) && buttons[i].getBackground() == Color.RED){
                    buttons[i].setBackground(null);
                    buttons[i].setForeground(Color.RED);
                    buttons[i].setText("X");
                }
                else if (mineLoc.contains(Integer.parseInt(buttons[i].getActionCommand())) && buttons[i].getBackground() == Color.RED) {
                    buttons[i].setBackground(null);
                    buttons[i].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("land-mine.png"))));
                }
                else if (mineLoc.contains(Integer.parseInt(buttons[i].getActionCommand()))) {
                    buttons[i].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("explosion-boom.gif"))));
                }

            }
        }
    }

    public void winner() {
        int countButton = 0;
        if (difficulty == "easy") {
            for (int i = 3; i < 57; i++) {
                if(buttons[i].isEnabled()){
                    countButton += 1;
                }
            }
            if(countButton == 11){
                JOptionPane.showMessageDialog(frame, "You Win");
                task1.cancel();
                frame.remove(label[1]);
                leftRight = false;
                mainMenu();
            }
        }
    }


}