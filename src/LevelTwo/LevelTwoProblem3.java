// Program to split text into words and return them with their lengths in a 2D array
import java.util.Scanner;

class LevelTwoProblem3 {

    // Method to find string length without using length()
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) { text.charAt(count); count++; }
        } catch (StringIndexOutOfBoundsException e) {}
        return count;
    }

    // Method to split text into words using charAt() without split()
    public static String[] splitIntoWords(String text) {
        int length = findLength(text);
        int wordCount = 0;
        boolean inWord = false;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) != ' ' && !inWord) { wordCount++; inWord = true; }
            else if (text.charAt(i) == ' ') { inWord = false; }
        }
        String[] words = new String[wordCount];
        int wordIndex = 0;
        int start = -1;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) != ' ' && start == -1) start = i;
            if ((text.charAt(i) == ' ' || i == length - 1) && start != -1) {
                int end = (text.charAt(i) == ' ') ? i : i + 1;
                String word = "";
                for (int j = start; j < end; j++) word += text.charAt(j);
                words[wordIndex++] = word;
                start = -1;
            }
        }
        return words;
    }

    // Method to take word array and return a 2D String array of [word, length]
    public static String[][] getWordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            // Use String.valueOf() to convert length integer to String
            result[i][1] = String.valueOf(findLength(words[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        // Create Scanner object
        Scanner sc = new Scanner(System.in);

        // Take full line input using nextLine()
        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();

        // Split into words using custom method
        String[] words = splitIntoWords(text);

        // Get 2D array of words with their lengths
        String[][] wordsWithLengths = getWordsWithLengths(words);

        // Display results in tabular format
        System.out.println("\n--- Words and Their Lengths ---");
        System.out.printf("%-5s %-20s %-10s%n", "No.", "Word", "Length");
        System.out.println("-".repeat(35));
        for (int i = 0; i < wordsWithLengths.length; i++) {
            // Convert length from String back to Integer for display
            int wordLength = Integer.parseInt(wordsWithLengths[i][1]);
            System.out.printf("%-5d %-20s %-10d%n", (i + 1), wordsWithLengths[i][0], wordLength);
        }

        // Close Scanner
        sc.close();
    }
}
