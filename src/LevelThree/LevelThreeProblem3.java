// Program to find the first non-repeating character in a string
import java.util.Scanner;

class LevelThreeProblem3 {

    // Method to find the first non-repeating character using ASCII frequency array
    // Returns the character, or '\0' if none found
    public static char findFirstNonRepeating(String text) {
        // Create a frequency array using ASCII values as indexes (256 ASCII characters)
        int[] frequency = new int[256];

        // First loop: find the frequency of each character using ASCII value as index
        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }

        // Second loop: find the first character with frequency of 1 (non-repeating)
        for (int i = 0; i < text.length(); i++) {
            if (frequency[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }

        // Return null character if no non-repeating character found
        return '\0';
    }

    public static void main(String[] args) {
        // Create Scanner object
        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        // Validate input
        if (text.isEmpty()) {
            System.err.println("Invalid input. String cannot be empty.");
            System.exit(0);
        }

        // Find the first non-repeating character
        char result = findFirstNonRepeating(text);

        // Display result
        System.out.println("\nString                         : \"" + text + "\"");
        if (result == '\0') {
            System.out.println("First Non-Repeating Character  : None found (all characters repeat)");
        } else {
            System.out.println("First Non-Repeating Character  : '" + result + "'");
        }

        // Close Scanner
        sc.close();
    }
}
