// Program to convert text to lowercase using charAt() and compare with toLowerCase()
import java.util.Scanner;

class LevelOneProblem10 {

    // Method to convert each uppercase character to lowercase using ASCII logic
    // ASCII: 'A'=65, 'a'=97, difference is 32
    public static String convertToLowerCase(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            // If the character is uppercase (A-Z), convert to lowercase by adding 32
            if (ch >= 'A' && ch <= 'Z') {
                result += (char) (ch + 32);
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
        System.out.print("Enter the text to convert to lowercase: ");
        String text = sc.nextLine();

        // Convert using user-defined method
        String customLowerCase = convertToLowerCase(text);

        // Convert using built-in toLowerCase()
        String builtInLowerCase = text.toLowerCase();

        // Compare the two results
        boolean match = compareStrings(customLowerCase, builtInLowerCase);

        // Display results
        System.out.println("\nOriginal Text           : " + text);
        System.out.println("Lowercase (custom)      : " + customLowerCase);
        System.out.println("Lowercase (toLowerCase): " + builtInLowerCase);
        System.out.println("Both results match      : " + match);

        // Close Scanner
        sc.close();
    }
}
