import java.util.Scanner;
// Karson Hodge, MCIS-Adv Programming Concepts, Section 34, ID: 9999-03235

/**
 * Main class that initializes the WeightCal class and calculates the weighted sum
 *
 * @author Karson Hodge
 */
public class AsFiveB {

    public static void main(String[] args) {
        Scanner scanObj = new Scanner(System.in); // new instance of the scanner class
        String value = scanObj.nextLine();
        WeightCal weightObj = new WeightCal();
        String output = weightObj.wsd(value); // return the results
        System.out.println(output);
    }

}


class WeightCal {

    /**
     * Function calculates the weighted sum of a number inputted by the user
     *
     * @param startVal The string number in which the weighted sum will be based off
     * @return endVal String containing the weighted sum
     */
    public String wsd(String startVal){
        String endVal;
        String holder = ""; // holders the values
        int placeholder = 0;
        for (int i = 0; i < startVal.length(); i++) { // loops through each char in the string
            int tmp = Character.getNumericValue(startVal.charAt(i));
            placeholder += (i+1) * (tmp);
            if(i+1 == startVal.length()){ // if last value add equals
                holder += startVal.charAt(i) + " * " + (i+1) + " = ";
            }
            else{ // if not then addition sign
                holder += startVal.charAt(i) + " * " + (i+1) + " + ";
            }

        }

        endVal = "wsd(" + startVal + ") = " + holder + placeholder; // combines all the string factors into one
        return endVal;
    }

}