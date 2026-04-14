// Program to find count of vowels and consonants in a string
import java.util.Scanner;

class LevelTwoProblem5 {

    // Method to check if a character is a vowel, consonant, or not a letter
    // Returns "Vowel", "Consonant", or "Not a Letter"
    public static String checkCharacterType(char ch) {
        // Convert uppercase to lowercase using ASCII (difference of 32)
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }
        // Check if it's a letter
        if (ch >= 'a' && ch <= 'z') {
            // Check if it's a vowel
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }

    // Method to find vowels and consonants and return their counts
    // Returns int array: [vowelCount, consonantCount]
    public static int[] countVowelsAndConsonants(String text) {
        int vowelCount = 0;
        int consonantCount = 0;
        for (int i = 0; i < text.length(); i++) {
            String type = checkCharacterType(text.charAt(i));
            if (type.equals("Vowel")) vowelCount++;
            else if (type.equals("Consonant")) consonantCount++;
        }
        return new int[]{vowelCount, consonantCount};
    }

    public static void main(String[] args) {
        // Create Scanner object
        Scanner sc = new Scanner(System.in);

        // Take full line input
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        // Get vowel and consonant counts
        int[] counts = countVowelsAndConsonants(text);

        // Display results
        System.out.println("\nText            : \"" + text + "\"");
        System.out.println("Vowel Count     : " + counts[0]);
        System.out.println("Consonant Count : " + counts[1]);

        // Close Scanner
        sc.close();
    }
}
