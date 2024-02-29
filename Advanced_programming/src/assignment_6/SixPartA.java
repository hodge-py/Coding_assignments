import java.util.Scanner;
// Karson Hodge, MCIS-Adv Programming Concepts, Section 34, ID: 9999-03235

public class SixPartA {

    public static void main(String[] args) {
        Scanner scanObj = new Scanner(System.in);
        String tmpLatin = scanObj.nextLine();

        LatinString latinObj = new LatinString(tmpLatin);
        latinObj.Checker();

    }

}


class LatinString {
    private String word;
    LatinString(String main) {
        word = main;
    }

    void Checker(){
        int len = word.length();

        if (word.charAt(len-1) == 'y' && word.charAt(len-2) == 'a'){
            System.out.println("latin");
            String finalWord = latinToEnglish(word);
            System.out.println(finalWord);

        }
        else{
            System.out.println("English");
            String finalWord = englishToLatin(word);
            System.out.println(finalWord);
        }
    }

    static String latinToEnglish(String convert){
        String tmpHold = "";



        return "ww";
    }

    static String englishToLatin(String convert){



        return "";
    }

}
