// Program to find unique characters in a string using charAt() method
import java.util.Scanner;

class LevelThreeProblem2 {

    // Method to find the length of text without using length()
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) { text.charAt(count); count++; }
        } catch (StringIndexOutOfBoundsException e) {}
        return count;
    }

    // Method to find unique characters using charAt() and return them as a 1D char array
    public static char[] findUniqueCharacters(String text) {
        int length = findLength(text);

        // Create array to store unique characters - size is the length of the text
        char[] uniqueTemp = new char[length];
        int uniqueCount = 0;

        // Outer loop: iterate through each character
        for (int i = 0; i < length; i++) {
            char current = text.charAt(i);
            boolean isUnique = true;

            // Inner loop: check if character already appeared before index i
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == current) {
                    isUnique = false;
                    break;
                }
            }

            // If character is unique, store it in the array
            if (isUnique) {
                uniqueTemp[uniqueCount] = current;
                uniqueCount++;
            }
        }

        // Create a new array of exact size to store the unique characters
        char[] uniqueChars = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            uniqueChars[i] = uniqueTemp[i];
        }
        return uniqueChars;
    }

    public static void main(String[] args) {
        // Create Scanner object
        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        // Find unique characters using the method
        char[] uniqueChars = findUniqueCharacters(text);

        // Display results
        System.out.println("\nOriginal String    : \"" + text + "\"");
        System.out.println("String Length      : " + findLength(text));
        System.out.print("Unique Characters  : ");
        for (char c : uniqueChars) System.out.print("'" + c + "' ");
        System.out.println("\nUnique Char Count  : " + uniqueChars.length);

        // Close Scanner
        sc.close();
    }
}
