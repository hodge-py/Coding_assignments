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
     *
     * @param randVal The initial random value that is used for the game
     */
    public void guessingGame(int randVal){
        String correct = "";
        int newRand = randVal;
        int tmpVal = 0;
        int totalGuess = 0;
        Scanner scanObj = new Scanner(System.in);
        int guessVal = scanObj.nextInt();
        if(guessVal == newRand){
            System.out.println("YOU GUESSED IT in 1 Step!");
        }
        else{
            while(newRand != guessVal){
                if (tmpVal == guessVal){
                    totalGuess -= 1;
                }

                if(guessVal > newRand){
                    tmpVal = guessVal;
                    System.out.println("Too Large");
                    totalGuess += 1;
                    guessVal = scanObj.nextInt();
                }
                else if (guessVal < newRand){
                    tmpVal = guessVal;
                    System.out.println("Too Small");
                    totalGuess += 1;
                    guessVal = scanObj.nextInt();
                }

            }
            totalGuess += 1;
            System.out.println("YOU GUESSED IT in " + totalGuess + " steps!");
        }


    }



}