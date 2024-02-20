import java.util.Scanner;
public class AsFiveB {

    public static void main(String[] args) {
        Scanner scanObj = new Scanner(System.in);
        String value = scanObj.nextLine();
        WeightCal weightObj = new WeightCal();
        String output = weightObj.wsd(value);
        System.out.println(output);
    }

}


class WeightCal {

    public String wsd(String startVal){
        String endVal;
        String holder = "";
        int placeholder = 0;
        for (int i = 0; i < startVal.length(); i++) {
            int tmp = Character.getNumericValue(startVal.charAt(i));
            placeholder += (i+1) * (tmp);
            if(i+1 == startVal.length()){
                holder += (i+1) + " * " + startVal.charAt(i) + " = ";
            }
            else{
                holder += (i+1) + " * " + startVal.charAt(i) + " + ";
            }

        }

        endVal = "wsd(" + startVal + ") = " + holder + placeholder;
        return endVal;
    }

}