import java.util.Scanner;
// Karson Hodge, MCIS-Adv Programming Concepts, Section 34, ID: 9999-03235

/**
 * The secondary class used in this question. Solves the issue regarding the guessing game
 *
 * @author Karson Hodge
 */
public class Guesser {
    int times;

    /**
     * Function that plays the guessing game, will not return a value until the game is over.
     * No return since value is printed
     *
     * @param randVal The initial random value that is used for the game
     */
    public void guessingGame(int randVal){
        int newRand = randVal; // set parameter as local variable
        int tmpVal = 0; // holds the last guessed number
        int totalGuess = 0; // count the number of guesses
        Scanner scanObj = new Scanner(System.in);
        int guessVal = scanObj.nextInt(); // user inputted number
        if(guessVal == newRand){
            System.out.println("YOU GUESSED IT in 1 Step!"); // If user gets it first guess
        }
        else{
            while(newRand != guessVal){
                if (tmpVal == guessVal){ // if same guess consecutively remove count
                    totalGuess -= 1;
                }

                if(guessVal > newRand){ // if guess is bigger than the random number
                    tmpVal = guessVal;
                    System.out.println("Too Large");
                    totalGuess += 1; // adds 1 to the guess counter
                    guessVal = scanObj.nextInt(); // new guess
                }
                else if (guessVal < newRand){ // guess is less than the random variable
                    tmpVal = guessVal;
                    System.out.println("Too Small");
                    totalGuess += 1; // add 1 to the guess counter
                    guessVal = scanObj.nextInt();
                }

            }
            totalGuess += 1; // last counter add for last guess
            System.out.println("YOU GUESSED IT in " + totalGuess + " steps!"); // print the total number of guesses
        }


    }



}