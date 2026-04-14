// Program to check voting eligibility of students using random 2-digit ages
import java.util.Scanner;

class LevelTwoProblem8 {

    // Method to generate random 2-digit ages for n students
    public static int[] generateRandomAges(int numberOfStudents) {
        int[] ages = new int[numberOfStudents];
        for (int i = 0; i < numberOfStudents; i++) {
            // Random 2-digit age: 10 to 99
            ages[i] = (int) (Math.random() * 90) + 10;
        }
        return ages;
    }

    // Method that takes age array and returns 2D String array of [age, canVote]
    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            // Validate: negative age cannot vote; 18+ can vote
            if (ages[i] < 0) {
                result[i][1] = "false"; // Invalid negative age
            } else if (ages[i] >= 18) {
                result[i][1] = "true";  // Can vote
            } else {
                result[i][1] = "false"; // Cannot vote
            }
        }
        return result;
    }

    // Method to display the 2D array in tabular format
    public static void displayResults(String[][] data) {
        System.out.printf("%-12s %-10s %-15s%n", "Student", "Age", "Can Vote");
        System.out.println("-".repeat(37));
        for (int i = 0; i < data.length; i++) {
            String status = data[i][1].equals("true") ? "Yes" : "No";
            System.out.printf("%-12d %-10s %-15s%n", (i + 1), data[i][0], status);
        }
    }

    public static void main(String[] args) {
        // Create Scanner object
        Scanner sc = new Scanner(System.in);

        // Take input for number of students
        System.out.print("Enter the number of students: ");
        int numberOfStudents = sc.nextInt();

        // Generate random 2-digit ages
        int[] ages = generateRandomAges(numberOfStudents);

        // Check voting eligibility
        String[][] votingData = checkVotingEligibility(ages);

        // Display results
        System.out.println("\n--- Student Voting Eligibility Report ---");
        displayResults(votingData);

        // Close Scanner
        sc.close();
    }
}
