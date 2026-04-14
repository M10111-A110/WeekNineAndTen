// Program to demonstrate StringIndexOutOfBoundsException - generate and handle it
import java.util.Scanner;

class LevelOneProblem5 {

    // Method to generate StringIndexOutOfBoundsException (unhandled)
    public static void generateStringIndexOutOfBoundsException(String text) {
        // Access an index beyond the length of the string using charAt()
        System.out.println("Character at index 1000: " + text.charAt(1000));
    }

    // Method to demonstrate StringIndexOutOfBoundsException with try-catch
    public static void handleStringIndexOutOfBoundsException(String text) {
        try {
            // Access an index beyond the length of the string using charAt()
            System.out.println("Character at index 1000: " + text.charAt(1000));
        } catch (StringIndexOutOfBoundsException e) {
            // Handle the StringIndexOutOfBoundsException
            System.out.println("StringIndexOutOfBoundsException caught: Index 1000 is out of bounds for string of length " + text.length());
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
        System.out.print("Enter a string: ");
        String text = sc.next();

        // First demonstrate the exception being handled
        System.out.println("\n--- Demonstrating StringIndexOutOfBoundsException (Handled) ---");
        handleStringIndexOutOfBoundsException(text);

        System.out.println("\n--- Now generating StringIndexOutOfBoundsException (Unhandled) ---");
        System.out.println("The program will crash after this line...");
        // Call the method that generates the unhandled exception
        generateStringIndexOutOfBoundsException(text);

        // Close Scanner
        sc.close();
    }
}
