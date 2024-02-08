import java.util.Scanner;
// Karson Hodge, MCIS-Adv Programming Concepts, Section 34, ID: 9999-03235

public class AssiThreeA {
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

        Main calc = new Main(number);
        calc.convertDec();

    }
}


class Main {
    int input;

    public Main(int input){
        this.input = input; // Sets the input number to the initialized variable
    }

    public void convertDec(){ // Converts Decimal to Octal
        String total = "";
        while(this.input > 0){
            int firstT = this.input % 8;
            this.input = (this.input / 8) - ((this.input % 8) / 8);
            total += firstT;
        }
        String finalString = "";
        for (int i = total.length()-1; -1 < i; i--) {
            finalString += total.charAt(i);

        }

        System.out.println(finalString);
    }



}
