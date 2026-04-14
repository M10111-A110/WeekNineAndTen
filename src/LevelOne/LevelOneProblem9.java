// Program to convert text to uppercase using charAt() and compare with toUpperCase()
import java.util.Scanner;

class LevelOneProblem9 {

    // Method to convert each lowercase character to uppercase using ASCII logic
    // ASCII: 'a'=97, 'A'=65, difference is 32
    public static String convertToUpperCase(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            // If the character is lowercase (a-z), convert to uppercase by subtracting 32
            if (ch >= 'a' && ch <= 'z') {
                result += (char) (ch - 32);
            } else {
                result += ch;
            }
        }
        return result;
    }

    // Method to compare two strings using charAt()
    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // Create Scanner object
        Scanner sc = new Scanner(System.in);

        // Take complete text input using nextLine()
        System.out.print("Enter the text to convert to uppercase: ");
        String text = sc.nextLine();

        // Convert using user-defined method
        String customUpperCase = convertToUpperCase(text);

        // Convert using built-in toUpperCase()
        String builtInUpperCase = text.toUpperCase();

        // Compare the two results
        boolean match = compareStrings(customUpperCase, builtInUpperCase);

        // Display results
        System.out.println("\nOriginal Text           : " + text);
        System.out.println("Uppercase (custom)      : " + customUpperCase);
        System.out.println("Uppercase (toUpperCase): " + builtInUpperCase);
        System.out.println("Both results match      : " + match);

        // Close Scanner
        sc.close();
    }
}
