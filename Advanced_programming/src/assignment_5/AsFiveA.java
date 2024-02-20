import java.util.Random;
// Karson Hodge, MCIS-Adv Programming Concepts, Section 34, ID: 9999-03235

/**
 * Main class used for this part of the assignment. Just runs its main function.
 *
 * @author
 */
public class AsFiveA {

    public static void main(String[] args) { // Main class that runs the guesser object

        Random random = new Random();
        int randomValue = random.nextInt(10000000+1 - 20) + 20;
        //System.out.println(randomValue);
        Guesser guessObj = new Guesser(); // New Instance of the Guesser Classs
        guessObj.guessingGame(randomValue); // Function that runs the guessing game
    }

}