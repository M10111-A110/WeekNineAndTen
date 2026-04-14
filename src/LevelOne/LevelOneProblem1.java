// Program to compare two strings using charAt() and verify with equals()
import java.util.Scanner;

class LevelOneProblem1 {

    // Method to compare two strings using charAt() and return boolean
    public static boolean compareStrings(String str1, String str2) {
        // Strings of different lengths cannot be equal
        if (str1.length() != str2.length()) {
            return false;
        }
        // Compare each character using charAt()
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Create Scanner object
        Scanner sc = new Scanner(System.in);

        // Take user input for 2 strings using next()
        System.out.print("Enter first string: ");
        String str1 = sc.next();

        System.out.print("Enter second string: ");
        String str2 = sc.next();

        // Compare using user-defined method
        boolean customResult = compareStrings(str1, str2);

        // Compare using built-in equals() method
        boolean builtInResult = str1.equals(str2);

        // Display results
        System.out.println("\nComparison using charAt() method : " + customResult);
        System.out.println("Comparison using equals() method : " + builtInResult);
        System.out.println("Both results match               : " + (customResult == builtInResult));

        // Close Scanner
        sc.close();
    }
}
