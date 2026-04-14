// Program to trim leading and trailing spaces using charAt() and compare with trim()
import java.util.Scanner;

class LevelTwoProblem7 {

    // Method to find start and end positions after trimming spaces using charAt()
    // Returns int array: [startIndex, endIndex]
    public static int[] findTrimBounds(String text) {
        int start = 0;
        int end = text.length() - 1;
        // Find leading spaces
        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }
        // Find trailing spaces
        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }
        return new int[]{start, end + 1};
    }

    // Method to create a substring using charAt() given start and end index
    public static String createSubstring(String text, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += text.charAt(i);
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

        // Take full line input including spaces
        System.out.print("Enter a string with leading/trailing spaces: ");
        String text = sc.nextLine();

        // Trim using custom method
        int[] bounds = findTrimBounds(text);
        String customTrimmed = createSubstring(text, bounds[0], bounds[1]);

        // Trim using built-in trim() method
        String builtInTrimmed = text.trim();

        // Compare the results
        boolean match = compareStrings(customTrimmed, builtInTrimmed);

        // Display results
        System.out.println("\nOriginal Text          : \"" + text + "\"");
        System.out.println("Trimmed (custom)       : \"" + customTrimmed + "\"");
        System.out.println("Trimmed (trim())       : \"" + builtInTrimmed + "\"");
        System.out.println("Both results match     : " + match);

        // Close Scanner
        sc.close();
    }
}
