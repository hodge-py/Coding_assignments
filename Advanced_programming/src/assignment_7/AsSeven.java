import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
// Karson Hodge, MCIS-Adv Programming Concepts, Section 34, ID: 9999-03235

/**
 * The class instantiates the objects and takes the users input
 *
 * @author Karson Hodge
 */
public class AsSeven {

    public static void main(String[] args) {
        Scanner scanObj = new Scanner(System.in); // new instance of the scanner object

        String quitter = "";
        while(quitter != "quit") { // placeholder to keep the loop going
            System.out.print("Enter a Roman Numerical (type 'quit' to exit the program): ");
            String romanPlace = scanObj.nextLine(); // user entered input
            if (Objects.equals(romanPlace, "quit")){
                break;
            }
            RomanConversion romanObj = new RomanConversion(romanPlace); // initializes the class

            int finalNum = romanObj.romanToArabic();
            if (finalNum == 0){ // if invalid, then zero is returned and nothing prints

            }
            else{ // value is returned if valid
                System.out.println(finalNum); // Prints the final output
            }

        }
    }

}


/**
 * This class handles the conversion from roman numerical to arabic numbers
 *
 * @author Karson Hodge
 */
class RomanConversion {

    private String roman; // instance variable to hold the input
    private int[] numberArr = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    private String[] romanL = {"M",  "CM",  "D",  "CD", "C",  "XC", "L",  "XL",  "X",  "IX", "V",  "IV", "I"};

    static HashMap<String,Integer> romanMap = new HashMap<String, Integer>(); // HashMap created to house the roman numerals


    RomanConversion (String object){ // The constructor for the class
        roman = object; // adding a value for the instance variable

        romanMap.put("M",1000);
        romanMap.put("CM",900);
        romanMap.put("D",500);
        romanMap.put("CD",400);
        romanMap.put("C",100);
        romanMap.put("XC", 90); // Set the hashmap key and value
        romanMap.put("L",50);
        romanMap.put("XL",40);
        romanMap.put("X",10);
        romanMap.put("IX",9);
        romanMap.put("V",5);
        romanMap.put("IV",4);
        romanMap.put("I",1);

    }

    /**
     * function in which the string is checked as valid and then is converted
     *
     * @return totalValue The total value of the roman numerals
     */
    public int romanToArabic(){ // main function that runs the other two, to check if it is valid and the total count
        int totalValue = 0;
        String inputVal = roman.toUpperCase(); // Roman Numerals need to be uppercase
        boolean valid;

        valid = romanChecker(inputVal); // checks the validity of the input

        if (valid){ // checks the boolean value to see if it is true
            totalValue = romanChange(inputVal); // runs the total count
        }
        else{
            System.out.println("Invalid Input"); // if wrong the invalid input is printed
        }

        return totalValue; // returns the total value
    }


    /**
     * Function checks if the roman numerals are valid, if not then false is returned
     *
     * @param romanValid The input string from the user
     * @return validString The variable is returned if true, otherwise false is returned
     */
    public static boolean romanChecker(String romanValid){ // Rule 1
        boolean validString = true;
        for (int i = 0; i < romanValid.length(); i++) { // loops through the string and looks for invalid characters
                if(romanMap.get(String.valueOf(romanValid.charAt(i))) == null) { // the hashmap will return null if the key doesn't exist
                    return false;
                }

        }

        int numCheck = 0;

        int tmper = 999999;
        while (numCheck < romanValid.length()){ // Rule 4 and others

            if((numCheck+1) != romanValid.length()) { // if at the last character than skip this if value
                if (romanMap.get(String.valueOf(romanValid.charAt(numCheck)) + String.valueOf(romanValid.charAt(numCheck + 1))) != null) { // checks if the key-value pair exist
                    if (romanMap.get(String.valueOf(romanValid.charAt(numCheck)) + String.valueOf(romanValid.charAt(numCheck + 1))) > tmper) { // if greater than then the last value return false
                        return false;
                    } else {
                        tmper = romanMap.get(String.valueOf(romanValid.charAt(numCheck)) + String.valueOf(romanValid.charAt(numCheck + 1))); // adds the double string
                        numCheck += 2;
                    }
                } else {
                    if (romanMap.get(String.valueOf(romanValid.charAt(numCheck))) > tmper) { // if value is greater than the last one return false
                        return false;
                    } else {
                        tmper = romanMap.get(String.valueOf(romanValid.charAt(numCheck))); // adds value to temper for the next loop comparison
                        numCheck += 1;
                    }

                }
            }
            else{
                if (romanMap.get(String.valueOf(romanValid.charAt(numCheck))) > tmper){ // returns false if greater than tmper
                    return false;
                }
                else{
                    tmper = romanMap.get(String.valueOf(romanValid.charAt(numCheck))); // this is used when it is the last character in the string
                    numCheck += 1;
                }
            }

        }


        long count = romanValid.chars().filter(ch -> ch == 'V').count(); // Counts the number of 'V' in string
        if (count > 1){ // Returns false if greater than one
            return false;
        }
        long count2 = romanValid.chars().filter(ch -> ch == 'D').count(); // Counts the number of 'D' in string
        if (count2 > 1){ // Returns false if greater than one
            return false;
        }
        long count3 = romanValid.chars().filter(ch -> ch == 'L').count(); // Counts the number of 'L' in string
        if (count3 > 1){ // Returns false if greater than one
            return false;
        }



        for (int x = 0; x < romanValid.length(); x++) { // loops to count the consecutive numbers
            count = 0;
            for (int y = 0; y < romanValid.length(); y++) {
                if(count > 2){ // if greater than 2 (3 repetitions) return false
                    return false;
                }
                if(romanValid.charAt(x) == romanValid.charAt(y)){ // add to the count if the number repeats
                    count += 1;
                }
                else{ // set to zero if it doesn't
                    count = 0;
                }
            }
        }


        return validString; // returns true if the string doesn't fail any of the test
    }

    /**
     * Calculates and returns the total amount of the roman numerals
     *
     * @param romanC The string value from the user
     * @return holder A tmp variable to hold the value
     */
    public static int romanChange(String romanC){ // counts the total
        int holder = 0;
        int counter = 0; // loop counter
        while (counter < romanC.length()) {
            if((counter+1) != romanC.length()) { // for when the character is the last in the string
                if ((romanMap.get(String.valueOf(romanC.charAt(counter)) + String.valueOf(romanC.charAt(counter + 1))) != null)) { // adds two strings and gets the key-value pair
                    holder += romanMap.get(String.valueOf(romanC.charAt(counter)) + String.valueOf(romanC.charAt(counter + 1)));
                    counter += 2; // adds two if valid
                } else {
                    holder += romanMap.get(String.valueOf(romanC.charAt(counter)));
                    counter += 1; // else one if it is only the singular one
                }
            }
            else{
                holder += romanMap.get(String.valueOf(romanC.charAt(counter))); // this comes into effect when it is the last character
                counter += 1;
            }



        }

        return holder; // return the total value
    }


}