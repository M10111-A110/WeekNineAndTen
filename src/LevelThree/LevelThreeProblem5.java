// Program to find frequency of characters using unique characters and ASCII frequency array
import java.util.Scanner;

class LevelThreeProblem5 {

    // Method to find unique characters using charAt() with nested loops
    public static char[] findUniqueCharacters(String text) {
        int length = text.length();
        char[] uniqueTemp = new char[length];
        int uniqueCount = 0;
        for (int i = 0; i < length; i++) {
            char current = text.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == current) { isUnique = false; break; }
            }
            if (isUnique) { uniqueTemp[uniqueCount] = current; uniqueCount++; }
        }
        char[] uniqueChars = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) uniqueChars[i] = uniqueTemp[i];
        return uniqueChars;
    }

    // Method to find frequency of characters and return 2D String array [char, frequency]
    // Uses ASCII array for frequency and uniqueCharacters() for unique chars
    public static String[][] findCharacterFrequency(String text) {
        // Create frequency array using ASCII values as indexes (256 ASCII characters)
        int[] frequency = new int[256];

        // Loop through text to find frequency of each character
        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }

        // Call uniqueCharacters() method to get unique characters
        char[] uniqueChars = findUniqueCharacters(text);

        // Create 2D String array to store unique characters and their frequencies
        String[][] result = new String[uniqueChars.length][2];

        // Loop through unique characters and store with their frequencies
        for (int i = 0; i < uniqueChars.length; i++) {
            result[i][0] = String.valueOf(uniqueChars[i]);
            result[i][1] = String.valueOf(frequency[uniqueChars[i]]);
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

        // Display results
        System.out.println("\n--- Character Frequency (using uniqueCharacters + ASCII) ---");
        System.out.printf("%-12s %-10s%n", "Character", "Frequency");
        System.out.println("-".repeat(22));
        for (int i = 0; i < freqData.length; i++) {
            System.out.printf("%-12s %-10s%n", "'" + freqData[i][0] + "'", freqData[i][1]);
        }

        // Close Scanner
        sc.close();
    }
}
