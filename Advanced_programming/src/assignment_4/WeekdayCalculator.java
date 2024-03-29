import java.util.Scanner;
// Karson Hodge, MCIS-Adv Programming Concepts, Section 34, ID: 9999-03235

/**
 * Main classes used for execution. Initializes MonthName
 * class for use of its month_name function
 * default constructor is used.
 * @author Karson Hodge
 */
public class WeekdayCalculator {

    public static void main( String[] args )
    {
        Scanner keyboard = new Scanner(System.in); // Creates the input object
        String output = "";

        System.out.println("Welcome to MCIS5103's fantastic birth-o-meter!");
        System.out.println();
        System.out.println("All you have to do is enter your birth date, and it will");
        System.out.println("tell you the day of the week on which you were born.");
        System.out.println();
        System.out.println("Some automatic tests....");

        System.out.println("12 10 2003 => " + weekday(12,10,2003));
        System.out.println(" 2 13 1976 => " + weekday(2,13,1976)); // Will test a bunch of values to see if the function is workings
        System.out.println(" 2 13 1977 => " + weekday(2,13,1977));
        System.out.println(" 7  2 1974 => " + weekday(7,2,1974));
        System.out.println(" 1 15 2003 => " + weekday(1,15,2003));
        System.out.println("10 13 2000 => " + weekday(10,13,2000));
        System.out.println();

        System.out.println("Now it's your turn!  What's your birthday?");
        System.out.print("Birth date (mm dd yyyy): ");
        int mm = keyboard.nextInt(); // int input
        int dd = keyboard.nextInt();
        int yyyy = keyboard.nextInt();

        // put a function call for weekday() here
        System.out.println("You were born on ");
        output = weekday(mm,dd,yyyy);
        System.out.println(output); // Prints the weekday the user was born
    }

    /**
     * Handles the users inserted birthday values for month, day and year
     * and outputs the correct day of the week they were born.
     *
     * @param mm month value as an int
     * @param dd day value as an int
     * @param yyyy year value as an int
     * @return date, a string combination of day, month and year
     */
    public static String weekday( int mm, int dd, int yyyy )
    {
        int yy, total;
        String date;
        String dateOffset;
        MonthName weekObj = new MonthName(); // creates a new instance of the MonthName class

        total = yyyy - 1900;
        total = (total / 4) - ((total % 4) / 4);
        total = total + (yyyy-1901) + dd; // Calculations need to get the correct total

        dateOffset = month_offset(total,mm,yyyy);

        date = dateOffset + ", " + weekObj.month_name(mm) + " " + dd + ", " + yyyy; // The combined string for the output

        return date;
    }


    // paste your functions from MonthName, WeekdayName, and MonthOffset here

    /**
     * Determines the offset needed for the total, and then gets the correct day.
     * @param yrTotal the total at the point after the first few steps
     * @param month The month of the birth
     * @param yearFinal The year entered for the birthday
     * @return dateOffset
     */
    public static String month_offset(int yrTotal, int month, int yearFinal){
        String dateOffset;
        int totalHold = 0;

        switch (month){ // Switch to determine how much to offset the total
            case 1:
                totalHold = yrTotal + 1;
                break;
            case 2:
                totalHold = yrTotal + 4;
                break;
            case 3:
                totalHold = yrTotal + 4;
                break;
            case 4:
                totalHold = yrTotal;
                break;
            case 5:
                totalHold = yrTotal + 2; // in this case, if May, offset by 2
                break;
            case 6:
                totalHold = yrTotal + 5;
                break;
            case 7:
                totalHold = yrTotal;
                break;
            case 8:
                totalHold = yrTotal + 3;
                break;
            case 9:
                totalHold = yrTotal + 6;
                break;
            case 10:
                totalHold = yrTotal + 1;
                break;
            case 11:
                totalHold = yrTotal + 4;
                break;
            case 12:
                totalHold = yrTotal + 6;
                break;
        }

        if((month == 1 || month == 2) && is_leap(yearFinal)){ // Checks if the month is a leap year
            totalHold = totalHold - 1;
        }

        totalHold = totalHold % 7; // find the weekday number 0-6

        dateOffset = weekday_name(totalHold);

        return dateOffset; // returns weekday as String
    }

    /**
     * Function determines the string of weekday from an int
     *
     * @param dd Remainder from total, 0-6
     * @return weekday Returns a string with weekday value
     */
    public static String weekday_name(int dd){ // function to calculate the weekday from day number
        String weekday = "";

        switch(dd) { // switch to determine which remainder from 7 corresponds to which day
            case 0:
                weekday = "Sunday";
                break;
            case 1:
                weekday = "Monday";
                break;
            case 2:
                weekday = "Tuesday";
                break;
            case 3:
                weekday = "Wednesday"; // 3 = "Wednesday"
                break;
            case 4:
                weekday = "Thursday";
                break;
            case 5:
                weekday = "Friday";
                break;
            case 6:
                weekday = "Saturday";
                break;
        }


        return weekday; // Returns the weekday String
    }

    public static boolean is_leap( int year )
    {
        // years which are evenly divisible by 4 are leap years,
        // but years divisible by 100 are not leap years,
        // though years divisible by 400 are leap years
        boolean result;

        if ( year%400 == 0 )
            result = true;
        else if ( year%100 == 0 )
            result = false;
        else if ( year%4 == 0 )
            result = true;
        else
            result = false;

        return result;
    }


}


