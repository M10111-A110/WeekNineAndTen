// Program to create a substring using charAt() and compare with built-in substring()
import java.util.Scanner;

class LevelOneProblem2 {

    // Method to create a substring using charAt() with start and end index
    public static String createSubstring(String text, int start, int end) {
        // Build the substring character by character
        String result = "";
        for (int i = start; i < end; i++) {
            result += text.charAt(i);
        }
        return result;
    }

    // Method to compare two strings using charAt() and return boolean
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

        // Take user input for the string, start index, and end index using next()
        System.out.print("Enter a string: ");
        String text = sc.next();

        System.out.print("Enter the start index: ");
        int start = sc.nextInt();

        System.out.print("Enter the end index: ");
        int end = sc.nextInt();

        // Validate indices
        if (start < 0 || end > text.length() || start > end) {
            System.err.println("Invalid indices. Ensure 0 <= start <= end <= string length.");
            System.exit(0);
        }

        // Get substring using user-defined method
        String customSubstring = createSubstring(text, start, end);

        // Get substring using built-in substring() method
        String builtInSubstring = text.substring(start, end);

        // Compare the two substrings
        boolean match = compareStrings(customSubstring, builtInSubstring);

        // Display results
        System.out.println("\nSubstring using charAt()     : " + customSubstring);
        System.out.println("Substring using substring()  : " + builtInSubstring);
        System.out.println("Both results match           : " + match);

        // Close Scanner
        sc.close();
    }
}
