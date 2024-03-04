import java.util.Scanner;
// Karson Hodge, MCIS-Adv Programming Concepts, Section 34, ID: 9999-03235


/**
 * This class takes an input and then initializes the LatinString class
 *
 * @author Karson Hodge
 */
public class SixPartA {

    public static void main(String[] args) {
        Scanner scanObj = new Scanner(System.in); // create new scanner object
        System.out.println("Input a sentence, english or fake latin");
        String tmpLatin = scanObj.nextLine(); // user enters the number of rows, is a string

        LatinString latinObj = new LatinString(tmpLatin);
        latinObj.Checker(); // Function used to check if it is fake latin or english

    }

}

/**
 * Handles the conversion of latin to english or english to latin.
 * The constructor handles the original input from the user
 */
class LatinString {
    private String word; // instance variable to hold the input
    LatinString(String main) { // constructor variable to set the instance variable
        word = main;

    }

    /**
     * Internal function to check if the sentence is a latin or english one
     * return null
     */
    void Checker(){
        //int len = word.length();
        boolean latin = true; // boolean value that determines if it is fake latin
        String[] arrayS = word.split(" ");

        for (int i = 0; i < arrayS.length; i++) { // Loops through the split array
            if (arrayS[i].charAt(arrayS[i].length()-1) == 'y' && arrayS[i].charAt(arrayS[i].length()-2) == 'a'){

            }
            else{ // if it does not follow the convention, latin false, and break loop
                latin = false;
                break;
            }
        }


        if (latin){ // if latin is true

            System.out.println("latin");
            String finalWord = latinToEnglish(word); // runs the latin to english function
            System.out.println(finalWord);

        }
        else{

            System.out.println("English");
            String finalWord = englishToLatin(word); // runs the english to latin function
            System.out.println(finalWord);

        }
    }

    /**
     * Converts fake latin to english
     *
     * @param convert String inputted from the intialized variable. This holds the input given by the user.
     * @return finalHold String containing the converted sentence from fake latin to english.
     */
    static String latinToEnglish(String convert){
        String finalHold = ""; // holds the string that will be returned
        String[] latinArr = convert.split(" ");

        for (int y = 0; y < latinArr.length; y++) {
            String tmpHold = ""; // temporary string holder that will add to the final string
            for (int x = 0; x < latinArr[y].length(); x++) {
                if (x == 0){ // if zero, add the third last character then add the current x charter
                    tmpHold = tmpHold + latinArr[y].charAt(latinArr[y].length()-3);
                    tmpHold = tmpHold + latinArr[y].charAt(x);
                }
                else if (x == latinArr[y].length()-2){
                    tmpHold = tmpHold.substring(0,tmpHold.length()-1); // substring with the last character removed to create a correct string
                    break;
                }
                else{
                    tmpHold = tmpHold + latinArr[y].charAt(x); // adds the current character value to the tmpstring
                }

            }

            finalHold += tmpHold + " "; // adds temporary string to the final string value
        }

        return finalHold; // returns the final string value
    }

    /**
     * Converts an english sentence to fake latin
     *
     * @param convert String inputted from the intialized variable. This holds the input given by the user.
     * @return finalHold String containing the converted sentence from english to fake latin
     */
    static String englishToLatin(String convert){
        String finalHold = ""; // temporary string holder that will add to the final string
        String[] latinArr = convert.split(" ");

        for (int y = 0; y < latinArr.length; y++) {
            String tmpHold = ""; // temporary string holder that will add to the final string
            for (int x = 0; x < latinArr[y].length(); x++) {
                if (x == 0 && latinArr[y].length() == 1){ // if zero and length of word is 1, add 'a' and then 'y' and then break the loop
                    tmpHold = tmpHold + latinArr[y].charAt(0) + 'a' + 'y';
                    break;
                }
                else if (x == 0){ // do nothing

                }
                else if ((x+1) == latinArr[y].length()){ // final character, add 'a' and 'y'
                    tmpHold = tmpHold + latinArr[y].charAt(x) + latinArr[y].charAt(0) + 'a' + 'y';
                }
                else{ // simply adds the character with no changes
                    tmpHold = tmpHold + latinArr[y].charAt(x);
                }


            }

            finalHold += tmpHold + " "; // adds the temporary variable to the final string value
        }


        return finalHold; // returns the final string variable
    }

}
