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
     *
     * @param randVal The initial random value that is used for the game
     * @return correct String value confirming correct value
     */
    public String guessingGame(int randVal){
        String correct = "";
        int newRand = randVal;
        Scanner scanObj = new Scanner(System.in);
        int guessVal = scanObj.nextInt();
        if(guessVal == newRand){
            System.out.println("correct");
            return correct;
        }
        else{
            while(newRand != guessVal){
                if(guessVal > newRand){
                    System.out.println("Too Large");
                    guessVal = scanObj.nextInt();
                }
                else if (guessVal < newRand){
                    System.out.println("Too Small");
                    guessVal = scanObj.nextInt();
                }

                System.out.println("correct");
                return "today";
            }
        }

        return " ";
    }



}