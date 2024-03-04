import java.util.Scanner;
// Karson Hodge, MCIS-Adv Programming Concepts, Section 34, ID: 9999-03235

/**
 * This classes contains the main function, and creates an instance of PascalTriangle
 *
 * @author Karson Hodge
 */
public class SixPartB {

    public static void main(String[] args) {

        Scanner scanObj = new Scanner(System.in); // new Scanner object for input
        System.out.println("Input the number of rows");
        int rows = scanObj.nextInt(); // receives the users input

        PascalTriangle pascalObj = new PascalTriangle(rows);

        String finalString = pascalObj.createPascal(); // function to create the triangle

        System.out.println(finalString);
    }

}


class PascalTriangle {
    private int mainValue; // instance variable

    PascalTriangle(int value){
        mainValue = value; // sets the instance variable from the constructor
    }

    /**
     * Factorial function
     *
     * @param fact number for factorial
     * @return factHold int value containing the factorial
     */
    static int factorial(int fact){ // simple function to calculate factorials
        int factHold = 1;
        for (int i = 0; i < fact; i++) { // loops through and adds the number of factors
            factHold *= (i+1);
        }

        return factHold; // returns the factorial
    }

    /**
     * function that creates the pascal triangle
     *
     * @return masterString String variable that holds the full pascal triangle
     */
    public String createPascal(){
        int lineAssign = 1; // sets the row number
        int numOfLines = mainValue;
        String masterString = "";
        for (int i = 0; i < numOfLines; i++) {
            int counter = 0; // this sets the column number
            String value = "";
            while(counter < lineAssign){ // continues until the column number equals row number

                value += String.valueOf(factorial(i) / (factorial(counter)*factorial((i-counter)))) + " "; // binomial coefficient function that creates the triangle values


                counter += 1; // adds one to column variable
            }

            String tmpString = "";
            for (int j = 0; j < (numOfLines-i); j++) { // adds the space needed to make the triangle
                    tmpString += " ";
            }

            masterString += tmpString + value + "\n"; // adds the space, values, and then a line break

            lineAssign += 1;

        }

        return masterString; // returns the full string

    }




}