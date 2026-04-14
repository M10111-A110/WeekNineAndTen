// Program to display a calendar for a given month and year using String arrays
import java.util.Scanner;

class LevelThreeProblem9 {

    // Month names array
    static String[] monthNames = {
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    };

    // Days in each month (non-leap year)
    static int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // Method to get the name of the month using the month array
    public static String getMonthName(int month) {
        return monthNames[month - 1];
    }

    // Method to check for leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Method to get the number of days in the month (handles Feb and leap year)
    public static int getNumberOfDays(int month, int year) {
        if (month == 2 && isLeapYear(year)) return 29;
        return daysInMonth[month - 1];
    }

    // Method to get the first day of the month using the Gregorian calendar algorithm
    // Returns 0=Sunday, 1=Monday, ..., 6=Saturday
    public static int getFirstDayOfMonth(int month, int year) {
        int m = month;
        int y = year;
        int d = 1;
        int y0 = y - (14 - m) / 12;
        int x  = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + 31 * m0 / 12) % 7;
        return d0;
    }

    public static void main(String[] args) {
        // Create Scanner object
        Scanner sc = new Scanner(System.in);

        // Take month and year as input
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();

        System.out.print("Enter year        : ");
        int year = sc.nextInt();

        // Validate inputs
        if (month < 1 || month > 12 || year < 1582) {
            System.err.println("Invalid input. Month must be 1-12 and year >= 1582.");
            System.exit(0);
        }

        // Get month details using methods
        String monthName   = getMonthName(month);
        int numDays        = getNumberOfDays(month, year);
        int firstDay       = getFirstDayOfMonth(month, year);

        // Display the calendar header
        System.out.println("\n" + monthName + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        // First for loop: print leading spaces for days before the first day
        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }

        // Second for loop: display days of the month
        for (int day = 1; day <= numDays; day++) {
            System.out.printf("%3d ", day);
            // Move to next line after Saturday
            if ((firstDay + day - 1) % 7 == 6) {
                System.out.println();
            }
        }
        System.out.println();

        // Close Scanner
        sc.close();
    }
}
