// Program to split text into words using charAt() and compare with split()
import java.util.Scanner;

class LevelTwoProblem2 {

    // Method to find string length without using length()
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) { text.charAt(count); count++; }
        } catch (StringIndexOutOfBoundsException e) {}
        return count;
    }

    // Method to split the text into words using charAt() without using split()
    public static String[] splitIntoWords(String text) {
        int length = findLength(text);

        // Count the number of words (words are separated by spaces)
        int wordCount = 0;
        boolean inWord = false;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) != ' ' && !inWord) {
                wordCount++;
                inWord = true;
            } else if (text.charAt(i) == ' ') {
                inWord = false;
            }
        }

        // Create an array to store the words
        String[] words = new String[wordCount];
        int wordIndex = 0;
        int start = -1;

        for (int i = 0; i < length; i++) {
            if (text.charAt(i) != ' ' && start == -1) {
                start = i; // Start of a new word
            }
            if ((text.charAt(i) == ' ' || i == length - 1) && start != -1) {
                int end = (text.charAt(i) == ' ') ? i : i + 1;
                // Extract the word using substring via charAt
                String word = "";
                for (int j = start; j < end; j++) {
                    word += text.charAt(j);
                }
                words[wordIndex++] = word;
                start = -1;
            }
        }
        return words;
    }

    // Method to compare two String arrays and return boolean
    public static boolean compareStringArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // Create Scanner object
        Scanner sc = new Scanner(System.in);

        // Take full line input using nextLine()
        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();

        // Split using custom method
        String[] customWords = splitIntoWords(text);

        // Split using built-in split() method
        String[] builtInWords = text.split(" ");

        // Compare the two results
        boolean match = compareStringArrays(customWords, builtInWords);

        // Display custom split results
        System.out.println("\nWords using custom method:");
        for (String w : customWords) System.out.println("  \"" + w + "\"");

        System.out.println("\nWords using split() method:");
        for (String w : builtInWords) System.out.println("  \"" + w + "\"");

        System.out.println("\nBoth results match: " + match);

        // Close Scanner
        sc.close();
    }
}
