import java.util.Scanner;
// Karson Hodge, MCIS-Adv Programming Concepts, Section 34, ID: 9999-03235


/**
 * This class takes an input and then intializes the LatinString class
 *
 *
 */
public class SixPartA {

    public static void main(String[] args) {
        Scanner scanObj = new Scanner(System.in);
        System.out.println("Input a sentence");
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

    /**
     * Internal function to check if the sentence is a latin or english one
     * return null
     */
    void Checker(){
        //int len = word.length();
        boolean latin = true;
        String[] arrayS = word.split(" ");

        for (int i = 0; i < arrayS.length; i++) {
            if (arrayS[i].charAt(arrayS[i].length()-1) == 'y' && arrayS[i].charAt(arrayS[i].length()-2) == 'a'){

            }
            else{
                latin = false;
                break;
            }
        }


        if (latin){

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

    /**
     *
     * @param convert String inputted from the intialized variable. This holds the input given by the user.
     * @return finalHold String containing the converted sentence from fake latin to english.
     */
    static String latinToEnglish(String convert){
        String finalHold = "";
        String[] latinArr = convert.split(" ");

        for (int y = 0; y < latinArr.length; y++) {
            String tmpHold = "";
            for (int x = 0; x < latinArr[y].length(); x++) {
                if (x == 0){
                    tmpHold = tmpHold + latinArr[y].charAt(latinArr[y].length()-3);
                    tmpHold = tmpHold + latinArr[y].charAt(x);
                }
                else if (x == latinArr[y].length()-2){
                    tmpHold = tmpHold.substring(0,tmpHold.length()-1);
                    break;
                }
                else{
                    tmpHold = tmpHold + latinArr[y].charAt(x);
                }

            }

            finalHold += tmpHold + " ";
        }

        return finalHold;
    }

    /**
     *
     *
     * @param convert String inputted from the intialized variable. This holds the input given by the user.
     * @return finalHold String containing the converted sentence from english to fake latin
     */
    static String englishToLatin(String convert){
        String finalHold = "";
        String[] latinArr = convert.split(" ");

        for (int y = 0; y < latinArr.length; y++) {
            String tmpHold = "";
            for (int x = 0; x < latinArr[y].length(); x++) {
                if (x == 0 && latinArr[y].length() == 1){
                    tmpHold = tmpHold + latinArr[y].charAt(0) + 'a' + 'y';
                    break;
                }
                else if (x == 0){

                }
                else if ((x+1) == latinArr[y].length()){
                    tmpHold = tmpHold + latinArr[y].charAt(x) + latinArr[y].charAt(0) + 'a' + 'y';
                }
                else{
                    tmpHold = tmpHold + latinArr[y].charAt(x);
                }


            }

            finalHold += tmpHold + " ";
        }


        return finalHold;
    }

}
