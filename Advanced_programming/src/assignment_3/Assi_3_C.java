import java.util.Scanner;
// Karson Hodge, MCIS-Adv Programming Concepts, Section 34, ID: 9999-03235

public class Assi_3_C {
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

        MainCount calc = new MainCount(number);
        calc.sumValues();

    }
}


class MainCount {
    int input;

    public MainCount(int input){
        this.input = input; // Sets the input number to the initialized variable
    }

    public void sumValues(){
        int total = 11;
        String numbers = String.valueOf(this.input);
        while (total > 9){
            total = 0;
            for (int x = 0; x < numbers.length(); x++) {
                total += numbers.charAt(x) - '0';
            }
            numbers = String.valueOf(total);
        }
            System.out.println(total);

    }



}
