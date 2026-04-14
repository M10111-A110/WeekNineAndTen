// Program to return all characters using a custom method and compare with toCharArray()
import java.util.Scanner;

class LevelOneProblem3 {

    // Method to return characters in a string without using toCharArray()
    public static char[] getCharacters(String text) {
        char[] chars = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            chars[i] = text.charAt(i);
        }
        return chars;
    }

    // Method to compare two char arrays and return boolean
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // Create Scanner object
        Scanner sc = new Scanner(System.in);

        // Take user input using next()
        System.out.print("Enter a string: ");
        String text = sc.next();

        // Get characters using user-defined method
        char[] customChars = getCharacters(text);

        // Get characters using built-in toCharArray()
        char[] builtInChars = text.toCharArray();

        // Compare the two arrays
        boolean match = compareCharArrays(customChars, builtInChars);

        // Display results
        System.out.print("\nCharacters using custom method   : ");
        for (char c : customChars) System.out.print(c + " ");

        System.out.print("\nCharacters using toCharArray()   : ");
        for (char c : builtInChars) System.out.print(c + " ");

        System.out.println("\nBoth results match               : " + match);

        // Close Scanner
        sc.close();
    }
}
