import java.util.Random;
// Karson Hodge, MCIS-Adv Programming Concepts, Section 34, ID: 9999-03235


public class AsFiveA {

    public static void main(String[] args) {

        Random random = new Random();
        int randomValue = random.nextInt(10000000+1 - 20) + 20;
        System.out.println(randomValue);
        Guesser guessObj = new Guesser();
        guessObj.guessingGame(randomValue);
    }

}