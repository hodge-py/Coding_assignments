import java.util.Scanner;

public class AsFourPartB {

    public static void main( String[] args )
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to MCIS5103's fantastic birth-o-meter!");
        System.out.println();
        System.out.println("All you have to do is enter your birth date, and it will");
        System.out.println("tell you the day of the week on which you were born.");
        System.out.println();
        System.out.println("Some automatic tests....");

        System.out.println("12 10 2003 => " + weekday(12,10,2003));
        System.out.println(" 2 13 1976 => " + weekday(2,13,1976));
        System.out.println(" 2 13 1977 => " + weekday(2,13,1977));
        System.out.println(" 7  2 1974 => " + weekday(7,2,1974));
        System.out.println(" 1 15 2003 => " + weekday(1,15,2003));
        System.out.println("10 13 2000 => " + weekday(10,13,2000));
        System.out.println();

        System.out.println("Now it's your turn!  What's your birthday?");
        System.out.print("Birth date (mm dd yyyy): ");
        int mm = keyboard.nextInt();
        int dd = keyboard.nextInt();
        int yyyy = keyboard.nextInt();

        // put a function call for weekday() here
        System.out.println("You were born on ");
    }


    public static String weekday( int mm, int dd, int yyyy )
    {
        int yy, total;
        String date = "";
        AsFourPartA weekObj = new AsFourPartA();

        // bunch of calculations go here

        date = weekObj.month_name(mm) + ", " + yyyy;

        return date;
    }


    // paste your functions from MonthName, WeekdayName, and MonthOffset here

    public static String month_offset(int yrValue){
        String dateOffset;
        int total;
        total = yrValue - 1900;
        total = (yrValue / 4) - ((yrValue % 4) / 4);
        total = total + yrValue;


        return dateOffset;
    }

    public static String WeekdayName(int dd){
        String weekday;




        return weekday;
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


