// Program to find character frequency using nested loops and toCharArray()
import java.util.Scanner;

class LevelThreeProblem6 {

    // Method to find frequency of characters using nested loops
    // Returns 1D String array of "char:frequency" entries for non-duplicate characters
    public static String[] findCharacterFrequency(String text) {
        // Get the character array using toCharArray()
        char[] chars = text.toCharArray();
        int length = chars.length;

        // Create frequency array to store count of each character
        int[] frequency = new int[length];

        // Nested loop: outer loop iterates through characters, inner checks duplicates
        for (int i = 0; i < length; i++) {
            // Initialize frequency of current character to 1
            frequency[i] = 1;
            for (int j = 0; j < i; j++) {
                // If duplicate found, increment frequency and mark duplicate as '0'
                if (chars[j] == chars[i] && chars[j] != '0') {
                    frequency[j]++;
                    chars[i] = '0'; // Mark as counted duplicate
                    frequency[i] = 0;
                    break;
                }
            }
        }

        // Count non-duplicate entries
        int uniqueCount = 0;
        for (int i = 0; i < length; i++) {
            if (frequency[i] > 0) uniqueCount++;
        }

        // Create 1D String array to store "char:frequency" for non-duplicates
        String[] result = new String[uniqueCount];
        int index = 0;
        // Restore original chars array for display
        char[] originalChars = text.toCharArray();
        for (int i = 0; i < length; i++) {
            if (frequency[i] > 0) {
                result[index] = "'" + originalChars[i] + "' : " + frequency[i];
                index++;
            }
        }
        return result;
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

        // Find character frequency using method
        String[] freqData = findCharacterFrequency(text);

        // Display results
        System.out.println("\n--- Character Frequency (Nested Loops + toCharArray()) ---");
        System.out.printf("%-20s%n", "Character : Frequency");
        System.out.println("-".repeat(22));
        for (String entry : freqData) {
            System.out.println(entry);
        }

        // Close Scanner
        sc.close();
    }
}
