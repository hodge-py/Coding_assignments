// Karson Hodge, MCIS-Adv Programming Concepts, Section 34, ID: 9999-03235

/**
 * Simple class that handles the month name conversion, int to string
 * @author Karson Hodge
 */
public class MonthName {

    /**
     *
     * This method returns the corresponding
     * month as a string value from an int value
     *
     * @param month The number of the month
     * @return result string name of the month
     */
    public static String month_name( int month )
    {
        String result;

        switch (month) { // Switch to determine which int aligns with what month
            case 1:
                result = "January";
                break;
            case 2:
                result = "Feburary";
                break;
            case 3:
                result = "March";
                break;
            case 4:
                result = "April";
                break;
            case 5:
                result = "May";
                break;
            case 6:
                result = "June";
                break;
            case 7:
                result = "July"; // Assigns the int to a string value
                break;
            case 8:
                result = "August";
                break;
            case 9:
                result = "September";
                break;
            case 10:
                result = "October";
                break;
            case 11:
                result = "November";
                break;
            case 12:
                result = "December";
                break;
            default:
                result = "Error, not a valid number month";
        }

        return result; // Returns the month string value
    }


    public static void main( String[] args ) // Main function that runs when calling the class
    {
        System.out.println( "Month 1: " + month_name(1) );
        System.out.println( "Month 2: " + month_name(2) );
        System.out.println( "Month 3: " + month_name(3) );
        System.out.println( "Month 4: " + month_name(4) );
        System.out.println( "Month 5: " + month_name(5) );
        System.out.println( "Month 6: " + month_name(6) ); // Prints out the month corresponding to its int value
        System.out.println( "Month 7: " + month_name(7) );
        System.out.println( "Month 8: " + month_name(8) );
        System.out.println( "Month 9: " + month_name(9) );
        System.out.println( "Month 10: " + month_name(10) );
        System.out.println( "Month 11: " + month_name(11) );
        System.out.println( "Month 12: " + month_name(12) );
        System.out.println( "Month 43: " + month_name(43) );
    }
}