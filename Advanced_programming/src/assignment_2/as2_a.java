import java.util.Scanner;
//Karson Hodge, MCIS-Adv Programming Concepts, Section 34, ID: 9999-03235

class as2_a {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter a number between 11 and 1900");
        int number = 0;
        int range = 0;
        while(range == 0){ // Creates a loop that continues until the correct input is entered
            number = myObj.nextInt();
            if(number < 11 || number > 1900){
                System.out.println("Out of the range, please enter a number between 11 and 1900");
            }
            else{
                System.out.println("Valid Input");
                range = 1; // Ends the loop by changing the condition
            }
        }

        primeFactors(number); // Function used to obtain the prime factors

    }

    static void primeFactors(int num) {
        int i = 2;
        String total = "";
        int tmpnum = num;
        while (i <= num){ // while loop that continues until the number reaches the same value as the parameter
            if(num % i == 0){
                if (total == ""){ // Checks if total is empty and if an asterisk is needed.
                    total += String.valueOf(i);
                    num = num / i;
                }
                else {
                    total += String.valueOf("*" + i );
                    num = num / i;
                }
            }
            else{
                i = i + 1; // Increases i by one for until reaching num
            }

        }
        System.out.println(tmpnum + "=" + total);
    }

}



