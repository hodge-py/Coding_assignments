import java.util.Scanner;
// Karson Hodge, MCIS-Adv Programming Concepts, Section 34, ID: 9999-03235
public class SixPartB {

    public static void main(String[] args) {

        Scanner scanObj = new Scanner(System.in);

        int rows = scanObj.nextInt();

        PascalTriangle pascalObj = new PascalTriangle(rows);

        String finalString = pascalObj.createPascal();

        System.out.println(finalString);
    }

}


class PascalTriangle {
    private int mainValue;

    PascalTriangle(int value){
        mainValue = value;
    }


    static int factorial(int fact){
        int factHold = 1;
        for (int i = 0; i < fact; i++) {
            factHold *= (i+1);
        }

        return factHold;
    }


    public String createPascal(){
        int lineAssign = 1;
        int numOfLines = mainValue;
        String masterString = "";
        for (int i = 0; i < numOfLines; i++) {
            int counter = 0;
            String value = "";
            while(counter < lineAssign){

                value += String.valueOf(factorial(i) / (factorial(counter)*factorial((i-counter)))) + " ";


                counter += 1;
            }

            String tmpString = "";
            for (int j = 0; j < (numOfLines-i); j++) {
                    tmpString += " ";
            }

            masterString += tmpString + value + "\n";

            lineAssign += 1;

        }

        return masterString;

    }




}