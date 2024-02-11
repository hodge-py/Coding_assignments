import java.util.Scanner;
// Karson Hodge, MCIS-Adv Programming Concepts, Section 34, ID: 9999-03235

public class AssiThreeB { // main class that runs the functions
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        int number = 0;
        int range = 0;
        while(range == 0){ // Creates a loop that continues until the correct input is entered
            System.out.println("Please Enter a Number");
            number = myObj.nextInt();
            if(number < 0){
                System.out.println("Invalid Number");
            }
            else{
                System.out.println("Valid Input");
                range = 1; // Ends the loop by changing the condition
            }
        }

        MainReverse calc = new MainReverse(number); // New instance of MainReverse Class
        calc.reverseString();

    }
}


class MainReverse {
    int input; // instance variable

    public MainReverse(int input){
        this.input = input; // Sets the input number to the initialized variable
    }

    public void reverseString(){ // Function to reverse the string
        String total = String.valueOf(this.input);
        String finalString = "";
        for (int i = total.length()-1; -1 < i; i--) { // reverses the string by decrement
            finalString += total.charAt(i);

        }
        String nonZero = "";
        boolean placeHolder = true;
        for (int y = 0; y < finalString.length(); y++) { // removes leading zeros from the string
            if(finalString.charAt(y) == '0' && placeHolder){

            }
            else{
                nonZero += finalString.charAt(y);
                placeHolder = false; // This changes the boolean to false to stop any more zeros from being removed after the leading ones.
            }
        }

        System.out.println(nonZero); // Prints the output
    }



}
