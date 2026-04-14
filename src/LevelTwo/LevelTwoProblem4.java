// Program to split text into words and find the shortest and longest words
import java.util.Scanner;

class LevelTwoProblem4 {

    // Method to find string length without using length()
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) { text.charAt(count); count++; }
        } catch (StringIndexOutOfBoundsException e) {}
        return count;
    }

    // Method to split text into words using charAt()
    public static String[] splitIntoWords(String text) {
        int length = findLength(text);
        int wordCount = 0;
        boolean inWord = false;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) != ' ' && !inWord) { wordCount++; inWord = true; }
            else if (text.charAt(i) == ' ') { inWord = false; }
        }
        String[] words = new String[wordCount];
        int wordIndex = 0, start = -1;
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

    // Method to create 2D array of [word, length]
    public static String[][] getWordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }
        return result;
    }

    // Method to find indexes of shortest and longest words from 2D array
    // Returns int array: [shortestIndex, longestIndex]
    public static int[] findShortestAndLongest(String[][] wordsWithLengths) {
        int shortestIndex = 0;
        int longestIndex = 0;
        for (int i = 1; i < wordsWithLengths.length; i++) {
            int currentLength = Integer.parseInt(wordsWithLengths[i][1]);
            int shortestLength = Integer.parseInt(wordsWithLengths[shortestIndex][1]);
            int longestLength = Integer.parseInt(wordsWithLengths[longestIndex][1]);
            if (currentLength < shortestLength) shortestIndex = i;
            if (currentLength > longestLength) longestIndex = i;
        }
        return new int[]{shortestIndex, longestIndex};
    }

    public static void main(String[] args) {
        // Create Scanner object
        Scanner sc = new Scanner(System.in);

        // Take full line input using nextLine()
        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();

        // Split into words
        String[] words = splitIntoWords(text);

        // Get 2D array with lengths
        String[][] wordsWithLengths = getWordsWithLengths(words);

        // Find shortest and longest
        int[] result = findShortestAndLongest(wordsWithLengths);

        // Display all words and their lengths
        System.out.println("\n--- Words and Their Lengths ---");
        for (int i = 0; i < wordsWithLengths.length; i++) {
            System.out.println("  \"" + wordsWithLengths[i][0] + "\" -> Length: " + wordsWithLengths[i][1]);
        }

        // Display shortest and longest
        System.out.println("\nShortest Word : \"" + wordsWithLengths[result[0]][0] + "\" (Length: " + wordsWithLengths[result[0]][1] + ")");
        System.out.println("Longest Word  : \"" + wordsWithLengths[result[1]][0] + "\" (Length: " + wordsWithLengths[result[1]][1] + ")");

        // Close Scanner
        sc.close();
    }
}
