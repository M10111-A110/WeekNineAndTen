// Program to demonstrate IllegalArgumentException - generate and handle it
import java.util.Scanner;

class LevelOneProblem6 {

    // Method to generate IllegalArgumentException (unhandled)
    // Setting start index greater than end index in substring() causes this
    public static void generateIllegalArgumentException(String text) {
        // start > end causes IllegalArgumentException
        System.out.println("Substring: " + text.substring(10, 2));
    }

    // Method to demonstrate IllegalArgumentException with try-catch
    public static void handleIllegalArgumentException(String text) {
        try {
            // start > end causes IllegalArgumentException
            System.out.println("Substring: " + text.substring(10, 2));
        } catch (IllegalArgumentException e) {
            // Handle IllegalArgumentException
            System.out.println("IllegalArgumentException caught: Start index cannot be greater than end index.");
            System.out.println("Exception message: " + e.getMessage());
        } catch (RuntimeException e) {
            // Catch any other runtime exception
            System.out.println("Runtime Exception caught: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Create Scanner object
        Scanner sc = new Scanner(System.in);

        // Take user input for the string
        System.out.print("Enter a string (at least 10 characters): ");
        String text = sc.next();

        // First demonstrate the exception being handled
        System.out.println("\n--- Demonstrating IllegalArgumentException (Handled) ---");
        handleIllegalArgumentException(text);

        System.out.println("\n--- Now generating IllegalArgumentException (Unhandled) ---");
        System.out.println("The program will crash after this line...");
        // Call the method that generates the unhandled exception
        generateIllegalArgumentException(text);

        // Close Scanner
        sc.close();
    }
}
