import java.util.Scanner; //Karson Hodge, MCIS-Adv Programming Concepts, Section 34, ID: 9999-03235

class as2_b {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter a number between 11 and 1900");
        int number = 0;
        int range = 0;
        while(range == 0){
            number = myObj.nextInt();
            if(number < 11 || number > 1900){
                System.out.println("Out of the range, please enter a number between 11 and 1900");
            }
            else{
                System.out.println("Valid Input");
                range = 1;
            }
        }

        //System.out.println(number);
        primeFactors(number);

    }

    static void primeFactors(int num) {
        int i = 2;
        String total = "";
        int powCount = 0;
        int tmpnum = num;
        while (i <= num){
            if(num % i == 0){
                powCount += 1;
                num = num / i;
                if(num % i != 0){
                    if(total == ""){
                        total += "" + i + "^" + powCount;
                        powCount = 0;
                    }
                    else{
                        total += "*" + i + "^" + powCount;
                        powCount = 0;
                    }
                }
            }
            else{
                i = i + 1;
            }

        }
        System.out.println(tmpnum + "=" + total);
    }

}



