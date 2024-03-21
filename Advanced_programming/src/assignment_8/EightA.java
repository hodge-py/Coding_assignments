import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
// Karson Hodge, MCIS-Adv Programming Concepts, Section 34, ID: 9999-03235

public class EightA {

    public static void main(String[] args) throws FileNotFoundException {
        File fileObj = new File("3nums.txt");
        String end = " ";
        Scanner readObj = new Scanner(fileObj);
        FileReader filer = new FileReader();
        while (readObj.hasNextLine()){
            String data = readObj.nextLine();
            end = filer.addFile(data);
            System.out.println(end);
        }

    }
}


class FileReader{


    public String addFile(String input){
        String output = "";
        int total = 0;
        String[] splitter = input.split(" ");

        System.out.println(splitter[0]);

        for (int i = 0; i < splitter.length; i++) {
            total += Integer.parseInt(splitter[i]);
            if((i+1) == splitter.length){
                output += splitter[i] + " = ";
            }
            else {
                output += splitter[i] + " + ";
            }

        }

        System.out.println(total);
        return output + String.valueOf(total);
    }

}