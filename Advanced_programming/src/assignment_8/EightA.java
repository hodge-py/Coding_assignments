// Karson Hodge, MCIS-Adv Programming Concepts, Section 34, ID: 9999-03235
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files



/**
 * Class runs the program and also uses the other class.
 *
 * @author Karson Hodge
 */
public class EightA {

    public static void main(String[] args) throws FileNotFoundException {
        File fileObj = new File("3nums.txt"); // opens the 3nums file
        String end = " ";
        Scanner readObj = new Scanner(fileObj); // puts the file object in the scanner class
        FileReader filer = new FileReader();
        while (readObj.hasNextLine()){ // while loop for reading each line of the file
            String data = readObj.nextLine();
            end = filer.addFile(data); // uses the file line as the parameter for adding the value
            System.out.println(end); // prints the completed string
        }

    }
}


/**
 * This class reads the numbers and then sums them.
 *
 * @author Karson Hodge
 */
class FileReader{


    /**
     * This class takes the line from the file and adds the sum up and returns a complete string
     *
     * @param input the line from the file
     * @return
     */
    public String addFile(String input){
        String output = ""; // string used to hold the final output
        int total = 0;
        String[] splitter = input.split(" "); // used to split the input at each space

        System.out.println("Reading numbers from file \"3nums.txt\"... done."); // print before summing
        for (int i = 0; i < splitter.length; i++) {
            total += Integer.parseInt(splitter[i]); // adds the value from the file to a total
            if((i+1) == splitter.length){
                output += splitter[i] + " = "; // joins the string values to make a complete form
            }
            else {
                output += splitter[i] + " + "; // adds a plus if not the final number
            }

        }


        return output + String.valueOf(total); // returns the complete string
    }

}