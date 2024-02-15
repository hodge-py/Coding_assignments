import java.util.Scanner;

public class Guesser {
    int times;
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