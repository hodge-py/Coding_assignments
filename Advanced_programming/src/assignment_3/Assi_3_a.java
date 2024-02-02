import java.util.Scanner;
// Karson Hodge, MCIS-Adv Programming Concepts, Section 34, ID: 9999-03235

public class Assi_3_a {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        int number = 0;
        int range = 0;
        while(range == 0){ // Creates a loop that continues until the correct input is entered
            number = myObj.nextInt();
            if(number < 0){
                System.out.println("Out of the range, please enter a number between 11 and 1900");
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
        this.input = input;
    }

    public void convertDec(){
        String total = "";
        while(this.input > 0){
            int firstT = this.input % 8;
            this.input = (this.input / 8) - ((this.input % 8) / 8);
            System.out.println(this.input);
            total += firstT;
        }
        System.out.println(total);
        String finalString = "";
        for (int i = total.length()-1; -1 < i; i--) {
            finalString += total.charAt(i);

        }

        System.out.println(finalString);
    }



}
