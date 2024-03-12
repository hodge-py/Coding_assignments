import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
// Karson Hodge, MCIS-Adv Programming Concepts, Section 34, ID: 9999-03235

/**
 * The class instatiates the objects and takes the users input
 *
 * @author Karson Hodge
 */
public class AsSeven {

    public static void main(String[] args) {
        Scanner scanObj = new Scanner(System.in); // new instance of the scanner object

        String quitter = "";
        while(quitter != "quit") {
            System.out.print("Enter a Roman Numerical (type 'quit' to exit the program): ");
            String romanPlace = scanObj.nextLine();
            if (Objects.equals(romanPlace, "quit")){
                break;
            }
            RomanConversion romanObj = new RomanConversion(romanPlace);

            int finalNum = romanObj.romanToArabic();

            System.out.println(finalNum);
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

    static HashMap<String,Integer> romanMap = new HashMap<String, Integer>();


    RomanConversion (String object){
        roman = object;

        romanMap.put("M",1000);
        romanMap.put("CM",900);
        romanMap.put("D",500);
        romanMap.put("CD",400);
        romanMap.put("C",100);
        romanMap.put("XC", 90);
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
    public int romanToArabic(){
        int totalValue = 0;
        String inputVal = roman.toUpperCase();
        boolean valid;

        valid = romanChecker(inputVal);

        System.out.println(valid);

        if (valid){
            totalValue = romanChange(inputVal);
        }
        else{
            System.out.println("Invalid Input");
        }

        return totalValue;
    }


    /**
     * Function checks if the roman numerals are valid, if not then false is returned
     *
     * @param romanValid The imput string from the user
     * @return validString The variable is returned if true, otherwise false is returned
     */
    public static boolean romanChecker(String romanValid){ // Rule 1
        boolean validString = true;
        System.out.println(romanValid);
        for (int i = 0; i < romanValid.length(); i++) {
                if(romanMap.get(String.valueOf(romanValid.charAt(i))) == null) {
                    System.out.println(romanMap.get(romanValid.charAt(i)));
                    return false;
                }

        }


        int numCheck = 0; // Rule 2
        /*
        while (numCheck < romanValid.length()-1) {
            if ((romanMap.get(String.valueOf(romanValid.charAt(numCheck))) < romanMap.get(String.valueOf(romanValid.charAt(numCheck+1)))) && romanMap.get(String.valueOf(romanValid.charAt(numCheck))) % 5 == 0 ){
                System.out.println("2222");
                return false;
                }
            numCheck += 2;
            }
        */

        numCheck = 0;
        int tmper = 999999;
        while (numCheck < romanValid.length()){ // Rule 4

            if((numCheck+1) != romanValid.length()) {
                if (romanMap.get(String.valueOf(romanValid.charAt(numCheck)) + String.valueOf(romanValid.charAt(numCheck + 1))) != null) {
                    if (romanMap.get(String.valueOf(romanValid.charAt(numCheck)) + String.valueOf(romanValid.charAt(numCheck + 1))) > tmper) {
                        System.out.println("okkk");
                        return false;
                    } else {
                        tmper = romanMap.get(String.valueOf(romanValid.charAt(numCheck)) + String.valueOf(romanValid.charAt(numCheck + 1)));
                        numCheck += 2;
                    }
                } else {
                    if (romanMap.get(String.valueOf(romanValid.charAt(numCheck))) > tmper) {
                        System.out.println("444");
                        return false;
                    } else {
                        tmper = romanMap.get(String.valueOf(romanValid.charAt(numCheck)));
                        numCheck += 1;
                    }

                }
            }
            else{
                if (romanMap.get(String.valueOf(romanValid.charAt(numCheck))) > tmper){
                    System.out.println("444");
                    return false;
                }
                else{
                    tmper = romanMap.get(String.valueOf(romanValid.charAt(numCheck)));
                    numCheck += 1;
                }
            }

        }


        long count = romanValid.chars().filter(ch -> ch == 'V').count(); // Rule 5
        if (count > 1){
            System.out.println("443333");
            return false;
        }
        long count2 = romanValid.chars().filter(ch -> ch == 'D').count();
        if (count2 > 1){
            System.out.println("4www");
            return false;
        }
        long count3 = romanValid.chars().filter(ch -> ch == 'L').count();
        if (count3 > 1){
            System.out.println("4sdsd");
            return false;
        }



        for (int x = 0; x < romanValid.length(); x++) { // rule 6
            count = 0;
            for (int y = 0; y < romanValid.length(); y++) {
                if(count > 2){
                    System.out.println("rule6");
                    return false;
                }
                if(romanValid.charAt(x) == romanValid.charAt(y)){
                    count += 1;
                }
                else{
                    count = 0;
                }
            }
        }


        return validString;
    }

    /**
     * Calculates and returns the total amount of the roman numerals
     *
     * @param romanC The string value from the user
     * @return holder A tmp variable to hold the value
     */
    public static int romanChange(String romanC){
        int holder = 0;
        int counter = 0;
        while (counter < romanC.length()) {
            if((counter+1) != romanC.length()) {
                if ((romanMap.get(String.valueOf(romanC.charAt(counter)) + String.valueOf(romanC.charAt(counter + 1))) != null)) {
                    holder += romanMap.get(String.valueOf(romanC.charAt(counter)) + String.valueOf(romanC.charAt(counter + 1)));
                    counter += 2;
                } else {
                    holder += romanMap.get(String.valueOf(romanC.charAt(counter)));
                    counter += 1;
                }
            }
            else{
                holder += romanMap.get(String.valueOf(romanC.charAt(counter)));
                counter += 1;
            }



        }

        return holder;
    }


}