// Program to check if two strings are anagrams
import java.util.Scanner;

class LevelThreeProblem8 {

    // Method to check if two texts are anagrams using ASCII frequency arrays
    public static boolean areAnagrams(String text1, String text2) {
        // Anagrams must have the same length
        if (text1.length() != text2.length()) return false;

        // Create frequency arrays for both strings (256 ASCII characters)
        int[] frequency1 = new int[256];
        int[] frequency2 = new int[256];

        // Find the frequency of characters in text1
        for (int i = 0; i < text1.length(); i++) {
            frequency1[text1.charAt(i)]++;
        }

        // Find the frequency of characters in text2
        for (int i = 0; i < text2.length(); i++) {
            frequency2[text2.charAt(i)]++;
        }

        // Compare the frequency arrays - if all frequencies match, they are anagrams
        for (int i = 0; i < 256; i++) {
            if (frequency1[i] != frequency2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // Create Scanner object
        Scanner sc = new Scanner(System.in);

        // Take user input for two strings
        System.out.print("Enter the first string : ");
        String text1 = sc.nextLine();

        System.out.print("Enter the second string: ");
        String text2 = sc.nextLine();

        // Validate inputs
        if (text1.isEmpty() || text2.isEmpty()) {
            System.err.println("Invalid input. Strings cannot be empty.");
            System.exit(0);
        }

        // Check if the two strings are anagrams
        boolean result = areAnagrams(text1, text2);

        // Display result
        System.out.println("\nString 1 : \"" + text1 + "\"");
        System.out.println("String 2 : \"" + text2 + "\"");
        System.out.println("Are Anagrams: " + result);

        // Close Scanner
        sc.close();
    }
}
