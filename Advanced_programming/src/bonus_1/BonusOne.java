// Karson Hodge, MCIS-Adv Programming Concepts, Section 34, ID: 9999-03235
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom; // generating random numbers
import java.util.Scanner;

/**
 * Handles the two objects generated and then displays the results
 *
 * @author Karson Hodge
 */
public class BonusOne {

    public static void main(String[] args) {
        RandomValue ranObj = new RandomValue(); // creates the random object
        int[] valueHold;

        valueHold = ranObj.randomReturn(); // generates the random array val

        System.out.println(Arrays.toString(valueHold)); // print the array out

        Searcher searchObj = new Searcher(); // create the searcher object
        String userValue;

        userValue = searchObj.userCheck(); // get user input
        int counter;
        counter = compareCount(valueHold,userValue);

        System.out.println(counter); // print out the compared values
    }

    /**
     * function compares the user input and values in the array
     *
     * @param arr the random array
     * @param user the user input
     * @return count an int value of how many times the value showed up.
     */
    static int compareCount(int[] arr, String user) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) { // loops 10 times
            if (arr[i] == Integer.parseInt(user)) { // compares the values
                count += 1;
            }
        }

        return count; // return how many times the value shows up
    }

}

/**
 * Creates the random array of ints
 *
 * @author Karson Hodge
 */
class RandomValue {

    /**
     * function to generate the random array
     *
     * @return result a random array of 10 numbers
     */
    public int[] randomReturn() {
        int[] result = new int[10]; // create an array of 10
        int min = 7;
        int max = 123; // max value of 123
        for (int i = 0; i < result.length; i++) {
            result[i] = (int) (ThreadLocalRandom.current().nextInt(min, max + 1)); // generate a random value between 7-123
        }

        return result; // return the array
    }
}

/**
 * takes the users input to be used later
 *
 * @author Karson Hodge
 */
class Searcher{

    /**
     * Takes the users input
     *
     * @return userVal a string input
     */
    public String userCheck(){
        Scanner scanObj = new Scanner(System.in); // new scanner object
        System.out.println("Please enter a number between 7 and 123: ");
        String userVal = scanObj.nextLine(); // user input

        return userVal; // return user input

    }

}