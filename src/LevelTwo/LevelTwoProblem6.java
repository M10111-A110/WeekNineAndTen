// Program to display each character's type - Vowel, Consonant, or Not a Letter
import java.util.Scanner;

class LevelTwoProblem6 {

    // Method to check character type and return "Vowel", "Consonant", or "Not a Letter"
    public static String checkCharacterType(char ch) {
        // Convert uppercase to lowercase using ASCII difference of 32
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }

    // Method to find vowels and consonants and return character and type in a 2D array
    public static String[][] getCharacterTypes(String text) {
        String[][] result = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            result[i][0] = String.valueOf(text.charAt(i));
            result[i][1] = checkCharacterType(text.charAt(i));
        }
        return result;
    }

    // Method to display the 2D array of strings in tabular format
    public static void displayCharacterTypes(String[][] charTypes) {
        System.out.printf("%-12s %-15s%n", "Character", "Type");
        System.out.println("-".repeat(27));
        for (int i = 0; i < charTypes.length; i++) {
            System.out.printf("%-12s %-15s%n", "'" + charTypes[i][0] + "'", charTypes[i][1]);
        }
    }

    public static void main(String[] args) {
        // Create Scanner object
        Scanner sc = new Scanner(System.in);

        // Take full line input
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        // Get 2D array of character types
        String[][] charTypes = getCharacterTypes(text);

        // Display the results using the display method
        System.out.println("\n--- Character Type Analysis ---");
        displayCharacterTypes(charTypes);

        // Close Scanner
        sc.close();
    }
}
