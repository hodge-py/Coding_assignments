import java.util.Scanner;
// Karson Hodge, MCIS-Adv Programming Concepts, Section 34, ID: 9999-03235

public class Assi_3_B {
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

        MainReverse calc = new MainReverse(number);
        calc.reverseString();

    }
}


class MainReverse {
    int input;

    public MainReverse(int input){
        this.input = input; // Sets the input number to the initialized variable
    }

    public void reverseString(){ // Converts Decimal to Octal
        String total = String.valueOf(this.input);
        String finalString = "";
        for (int i = total.length()-1; -1 < i; i--) {
            finalString += total.charAt(i);

        }
        String nonZero = "";
        for (int y = 0; y < finalString.length(); y++) {
            if(finalString.charAt(y) == '0'){

            }
            else{
                nonZero += finalString.charAt(y);
            }
        }



        System.out.println(nonZero);
    }



}
