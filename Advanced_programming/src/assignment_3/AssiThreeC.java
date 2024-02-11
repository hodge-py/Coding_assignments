import java.util.Scanner;
// Karson Hodge, MCIS-Adv Programming Concepts, Section 34, ID: 9999-03235

public class AssiThreeC {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        int number = 0;
        int range = 0;
        while(range == 0){ // Creates a loop that continues until the correct input is entered
            System.out.println("Please Enter a Number");
            number = myObj.nextInt();
            if(number < 0){ // Wrong number is less than 0.
                System.out.println("Invalid Number");
            }
            else{
                System.out.println("Valid Input");
                range = 1; // Ends the loop by changing the condition
            }
        }

        MainCount calc = new MainCount(number); // Creates a new instance of the MainCount Class.
        calc.sumValues();

    }
}


class MainCount {
    int input;

    public MainCount(int input){
        this.input = input; // Sets the input number to the initialized variable
    }

    public void sumValues(){ // function to sum the values and return the single digit
        int total = 11;
        String numbers = String.valueOf(this.input); // convert input to string
        while (total > 9){ // loop continues until the value is not greater than 9
            total = 0;
            for (int x = 0; x < numbers.length(); x++) { // loop to sum up the numbers in the current string. '0' used to change char to int.
                total += numbers.charAt(x) - '0';
            }
            numbers = String.valueOf(total);
        }
            System.out.println(total); // prints the value.

    }



}
