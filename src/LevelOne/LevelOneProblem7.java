// Program to demonstrate NumberFormatException - generate and handle it
import java.util.Scanner;

class LevelOneProblem7 {

    // Method to generate NumberFormatException (unhandled)
    public static void generateNumberFormatException(String text) {
        // Integer.parseInt() will throw NumberFormatException if text is not a valid number
        int number = Integer.parseInt(text);
        System.out.println("Parsed number: " + number);
    }

    // Method to demonstrate NumberFormatException with try-catch
    public static void handleNumberFormatException(String text) {
        try {
            // Attempt to parse the text as an integer
            int number = Integer.parseInt(text);
            System.out.println("Successfully parsed number: " + number);
        } catch (NumberFormatException e) {
            // Handle NumberFormatException
            System.out.println("NumberFormatException caught: \"" + text + "\" is not a valid integer.");
            System.out.println("Exception message: " + e.getMessage());
        } catch (RuntimeException e) {
            // Catch any other runtime exception
            System.out.println("Runtime Exception caught: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Create Scanner object
        Scanner sc = new Scanner(System.in);

        // Take user input as a String
        System.out.print("Enter a value (try a non-numeric string to trigger the exception): ");
        String text = sc.next();

        // First demonstrate the exception being handled
        System.out.println("\n--- Demonstrating NumberFormatException (Handled) ---");
        handleNumberFormatException(text);

        System.out.println("\n--- Now generating NumberFormatException (Unhandled) ---");
        System.out.println("The program will crash if input is non-numeric...");
        // Call the method that generates the unhandled exception
        generateNumberFormatException(text);

        // Close Scanner
        sc.close();
    }
}
