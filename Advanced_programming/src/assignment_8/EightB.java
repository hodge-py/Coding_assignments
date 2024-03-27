// Karson Hodge, MCIS-Adv Programming Concepts, Section 34, ID: 9999-03235
import java.io.File;  // Import the File class
import java.io.FileWriter;   // Import the FileWriter class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.IOException;
import java.util.Scanner; // Import the Scanner class to read text files


/**
 * The main class that runs the file and initializes the other class.
 *
 * @author Karson Hodge
 */
public class EightB {

    public static void main(String[] args) throws IOException {
        Scanner scanObj = new Scanner(System.in); // Creates the user input
        System.out.print("Enter a password: ");
        String password = scanObj.nextLine(); // takes the user input
        System.out.print("Enter an option. 1: Save, 2: Load - ");
        int value = Integer.parseInt(scanObj.nextLine()); // converts to int for comparison
        FileEncrypt encryptObj = new FileEncrypt();

        if(value == 1){ // checks if option 1 is chosen
            encryptObj.fileSave(password);
        }
        else if (value == 2){ // checks if option 2 is chosen
            encryptObj.fileLoad(password);
        }
        else{
            System.out.println("Not a valid option"); // prints if invalid option
        }
    }
}


/**
 * This class performs both the encryption and decryption of the file.
 *
 * @author Karson Hodge
 */
class FileEncrypt {

    /**
     * This method save and writes the encrypted file to memory.
     *
     * @param password The user entered password that will be used.
     * @throws IOException if file already exist
     *
     * @author Karson Hodge
     */
    public void fileSave(String password) throws IOException {
        Scanner scanObj = new Scanner(System.in);
        System.out.print("Please enter your name: "); // tells user to enter a name
        String name = scanObj.nextLine();
        System.out.print("Enter a filename: "); //tells user to enter a file
        String fileName = scanObj.nextLine();
        int length = name.length(); // length is needed for looping through the string
        int hold;
        String valueHold = "";
        if (password.length() > length){ // find the bigger string
            length = password.length();
        }

        FileWriter writeFile = new FileWriter(fileName + ".txt");

        int i = 0;
        while(i < length){ // loops through and then performs an XOR to create the encryption
            int tmp1 = i % password.length();
            int tmp2 = i % name.length(); // modulo to prevent the string from being out of range

            hold = password.charAt(tmp1) ^ name.charAt(tmp2); // XOR

            valueHold += hold + " "; // add value to empty string

            i += 1;
        }

        writeFile.write(valueHold); // write the value and the close the file
        writeFile.close();
    }

    /**
     * This method decrypts the saved file and returns the unencrypted string.
     *
     * @param password The user entered password
     * @throws FileNotFoundException if the file does not exist
     *
     * @author Karson Hodge
     */
    public void fileLoad(String password) throws FileNotFoundException {
        Scanner scanObj = new Scanner(System.in);
        System.out.print("Please enter a filename: "); // ask the user to enter a filename
        String filename = scanObj.nextLine();
        filename += ".txt"; // appends the extension to the end
        String[] newValue = new String[0];
        String outString = "";

        File fileObj = new File(filename); // creates the file reader
        Scanner myReader = new Scanner(fileObj);
        while (myReader.hasNextLine()) { // while loop for reading each line of the file.
            String data = myReader.nextLine();
            newValue = data.split(" "); // splits at each space
        }

        int i = 0;
        while(i < newValue.length){ // loop for decrypting the file
            int tmp1 = i % password.length();

            int xOr = password.charAt(tmp1) ^ Integer.parseInt(newValue[i]); // XOR for finding the correct value

            outString += Character.toString((char) xOr);

            i += 1; // next step in the loop
        }

        System.out.println(outString); // prints the end value
                
        }


}