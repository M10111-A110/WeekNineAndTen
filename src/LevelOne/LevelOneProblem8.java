// Program to demonstrate ArrayIndexOutOfBoundsException - generate and handle it
import java.util.Scanner;

class LevelOneProblem8 {

    // Method to generate ArrayIndexOutOfBoundsException (unhandled)
    public static void generateArrayIndexOutOfBoundsException(String[] names) {
        // Access an index larger than the array length
        System.out.println("Name at index 1000: " + names[1000]);
    }

    // Method to demonstrate ArrayIndexOutOfBoundsException with try-catch
    public static void handleArrayIndexOutOfBoundsException(String[] names) {
        try {
            // Access an index larger than the array length
            System.out.println("Name at index 1000: " + names[1000]);
        } catch (ArrayIndexOutOfBoundsException e) {
            // Handle ArrayIndexOutOfBoundsException
            System.out.println("ArrayIndexOutOfBoundsException caught: Index 1000 is out of bounds for array of length " + names.length);
            System.out.println("Exception message: " + e.getMessage());
        } catch (RuntimeException e) {
            // Catch any other runtime exception
            System.out.println("Runtime Exception caught: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Create Scanner object
        Scanner sc = new Scanner(System.in);

        // Take input for the number of names
        System.out.print("Enter the number of names: ");
        int n = sc.nextInt();

        // Define an array of names and take input from user
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = sc.next();
        }

        // First demonstrate the exception being handled
        System.out.println("\n--- Demonstrating ArrayIndexOutOfBoundsException (Handled) ---");
        handleArrayIndexOutOfBoundsException(names);

        System.out.println("\n--- Now generating ArrayIndexOutOfBoundsException (Unhandled) ---");
        System.out.println("The program will crash after this line...");
        // Call the method that generates the unhandled exception
        generateArrayIndexOutOfBoundsException(names);

        // Close Scanner
        sc.close();
    }
}
