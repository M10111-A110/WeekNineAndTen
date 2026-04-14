// Program to find string length without using length() method
import java.util.Scanner;

class LevelTwoProblem1 {

    // Method to find string length without using length()
    // Uses an infinite loop and charAt() until StringIndexOutOfBoundsException is thrown
    public static int findLength(String text) {
        int count = 0;
        try {
            // Infinite loop - counts characters until charAt() throws an exception
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Exception means we've gone past the end - count is the length
        }
        return count;
    }

    public static void main(String[] args) {
        // Create Scanner object
        Scanner sc = new Scanner(System.in);

        // Take user input using next()
        System.out.print("Enter a string: ");
        String text = sc.next();

        // Call user-defined method to get length
        int customLength = findLength(text);

        // Get length using built-in length() method
        int builtInLength = text.length();

        // Display and compare both results
        System.out.println("\nLength using custom method  : " + customLength);
        System.out.println("Length using length() method: " + builtInLength);
        System.out.println("Both results match          : " + (customLength == builtInLength));

        // Close Scanner
        sc.close();
    }
}
