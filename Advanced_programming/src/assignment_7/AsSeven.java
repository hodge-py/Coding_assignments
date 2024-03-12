import java.util.HashMap;
import java.util.Scanner;
// Karson Hodge, MCIS-Adv Programming Concepts, Section 34, ID: 9999-03235
public class AsSeven {

    public static void main(String[] args) {
        Scanner scanObj = new Scanner(System.in);
        System.out.print("Enter a Roman Numerical (type 'quit' to exit the program): ");
        String romanPlace = scanObj.nextLine();

        RomanConversion romanObj = new RomanConversion(romanPlace);

        int finalNum = romanObj.romanToArabic();

        System.out.println(finalNum);
    }

}



class RomanConversion {

    private String roman;
    private int[] numberArr = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    private String[] romanL = {"M",  "CM",  "D",  "CD", "C",  "XC", "L",  "XL",  "X",  "IX", "V",  "IV", "I"};

    static HashMap<String,Integer> romanMap = new HashMap<String, Integer>();






    RomanConversion (String object){
        roman = object;

        romanMap.put("M",1000);
        romanMap.put("CM",900);
        romanMap.put("D",500);
        romanMap.put("CD",400);
        romanMap.put("C",100);
        romanMap.put("XC", 90);
        romanMap.put("L",50);
        romanMap.put("XL",40);
        romanMap.put("X",10);
        romanMap.put("IX",9);
        romanMap.put("V",5);
        romanMap.put("IV",4);
        romanMap.put("I",1);

    }


    public int romanToArabic(){
        int totalValue = 0;
        String inputVal = roman;
        boolean valid;

        valid = romanChecker(inputVal);

        System.out.println(valid);


        return totalValue;
    }




    public static boolean romanChecker(String romanValid){
        boolean validString = true;
        System.out.println(romanValid);
        for (int i = 0; i < romanValid.length(); i++) {
                if(romanMap.get(String.valueOf(romanValid.charAt(i))) == null) {
                    System.out.println(romanMap.get(romanValid.charAt(i)));
                    return false;
                }

        }

        int numCheck = 0;
        while (numCheck < romanValid.length()-1) {
            if ((romanMap.get(String.valueOf(romanValid.charAt(numCheck))) < romanMap.get(String.valueOf(romanValid.charAt(numCheck+1)))) && romanMap.get(String.valueOf(romanValid.charAt(numCheck))) % 5 == 0 ){
                return false;
                }
            numCheck += 2;
            }


        numCheck = 0;
        int tmper = 0;
        while (numCheck < romanValid.length()-1){

            if (romanMap.get(String.valueOf(romanValid.charAt(numCheck)) + String.valueOf(romanValid.charAt(numCheck+1))) != null){
                    tmper = romanMap.get(String.valueOf(romanValid.charAt(numCheck)) + String.valueOf(romanValid.charAt(numCheck+1)));
            }
            else{
                tmper = romanMap.get(String.valueOf(romanValid.charAt(numCheck)));
            }

        }








        return validString;
    }


}