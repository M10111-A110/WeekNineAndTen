// Program to find the frequency of characters in a string using charAt() and ASCII indexing
import java.util.Scanner;

class LevelThreeProblem4 {

    // Method to find frequency of characters using charAt() and return in a 2D array
    // Returns 2D String array: [character, frequency]
    public static String[][] findCharacterFrequency(String text) {
        // Create frequency array using ASCII values as indexes (256 ASCII characters)
        int[] frequency = new int[256];

        // Loop through the text to find the frequency of each character
        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }

        // Count unique characters (those with frequency > 0)
        int uniqueCount = 0;
        for (int i = 0; i < text.length(); i++) {
            // Check if this is the first occurrence of the character
            boolean firstOccurrence = true;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == text.charAt(i)) {
                    firstOccurrence = false;
                    break;
                }
            }
            if (firstOccurrence) uniqueCount++;
        }

        // Create 2D String array to store characters and their frequencies
        String[][] result = new String[uniqueCount][2];
        int index = 0;

        // Loop through the text and store unique characters and their frequencies
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            // Only store first occurrence of each character
            boolean firstOccurrence = true;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == ch) {
                    firstOccurrence = false;
                    break;
                }
            }
            if (firstOccurrence) {
                result[index][0] = String.valueOf(ch);
                result[index][1] = String.valueOf(frequency[ch]);
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
        String[][] freqData = findCharacterFrequency(text);

        // Display results in tabular format
        System.out.println("\n--- Character Frequency (using charAt() + ASCII) ---");
        System.out.printf("%-12s %-10s%n", "Character", "Frequency");
        System.out.println("-".repeat(22));
        for (int i = 0; i < freqData.length; i++) {
            System.out.printf("%-12s %-10s%n", "'" + freqData[i][0] + "'", freqData[i][1]);
        }

        // Close Scanner
        sc.close();
    }
}
