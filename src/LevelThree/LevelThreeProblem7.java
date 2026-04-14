// Program to check if a text is a palindrome using 3 different methods
import java.util.Scanner;

class LevelThreeProblem7 {

    // Logic 1: Compare characters from start and end using two-pointer approach
    public static boolean isPalindromeByPointers(String text) {
        int start = 0;
        int end = text.length() - 1;
        // Loop and compare characters from both ends
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Logic 2: Recursive palindrome check comparing start and end characters
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        // Base case: if start >= end, the string is a palindrome
        if (start >= end) return true;
        // If characters at start and end are not equal, not a palindrome
        if (text.charAt(start) != text.charAt(end)) return false;
        // Recursive call with start+1 and end-1
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // Logic 3: Palindrome check using character arrays
    // Helper: reverse a string using charAt() and return reversal as char array
    public static char[] reverseString(String text) {
        int length = text.length();
        char[] reversed = new char[length];
        for (int i = 0; i < length; i++) {
            reversed[i] = text.charAt(length - 1 - i);
        }
        return reversed;
    }

    public static boolean isPalindromeByCharArray(String text) {
        // Create character array using toCharArray()
        char[] original = text.toCharArray();
        // Create reverse array using user-defined method
        char[] reversed = reverseString(text);
        // Compare both arrays
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // Create Scanner object
        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string to check for palindrome: ");
        String text = sc.nextLine();

        // Validate input
        if (text.isEmpty()) {
            System.err.println("Invalid input. String cannot be empty.");
            System.exit(0);
        }

        // Check palindrome using all three methods
        boolean result1 = isPalindromeByPointers(text);
        boolean result2 = isPalindromeRecursive(text, 0, text.length() - 1);
        boolean result3 = isPalindromeByCharArray(text);

        // Display results
        System.out.println("\nString                         : \"" + text + "\"");
        System.out.println("Logic 1 (Two Pointers)         : " + (result1 ? "Palindrome" : "Not a Palindrome"));
        System.out.println("Logic 2 (Recursion)            : " + (result2 ? "Palindrome" : "Not a Palindrome"));
        System.out.println("Logic 3 (Char Array)           : " + (result3 ? "Palindrome" : "Not a Palindrome"));

        // Close Scanner
        sc.close();
    }
}
