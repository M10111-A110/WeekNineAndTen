// Program to generate random PCM scores, compute stats, calculate grades, and display scorecard
import java.util.Scanner;

class LevelTwoProblem10 {

    // Method to generate random 2-digit scores for Physics, Chemistry, and Math
    // Returns 2D array: rows = students, columns = [Physics, Chemistry, Maths]
    public static int[][] generatePCMScores(int numberOfStudents) {
        int[][] scores = new int[numberOfStudents][3];
        for (int i = 0; i < numberOfStudents; i++) {
            scores[i][0] = (int) (Math.random() * 90) + 10; // Physics
            scores[i][1] = (int) (Math.random() * 90) + 10; // Chemistry
            scores[i][2] = (int) (Math.random() * 90) + 10; // Maths
        }
        return scores;
    }

    // Method to calculate total, average, and percentage for each student
    // Returns 2D array: [total, average, percentage] per student rounded to 2 digits
    public static double[][] calculateStats(int[][] scores) {
        int maxMarksPerSubject = 100;
        int numberOfSubjects = 3;
        double[][] stats = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = (double) total / numberOfSubjects;
            double percentage = (double) total / (maxMarksPerSubject * numberOfSubjects) * 100;
            stats[i][0] = total;
            stats[i][1] = Math.round(average * 100.0) / 100.0;
            stats[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return stats;
    }

    // Method to calculate grade based on percentage and return 2D array of grades
    public static String[][] calculateGrades(double[][] stats) {
        String[][] grades = new String[stats.length][1];
        for (int i = 0; i < stats.length; i++) {
            double percentage = stats[i][2];
            if (percentage >= 80)      grades[i][0] = "A";
            else if (percentage >= 70) grades[i][0] = "B";
            else if (percentage >= 60) grades[i][0] = "C";
            else if (percentage >= 50) grades[i][0] = "D";
            else if (percentage >= 40) grades[i][0] = "E";
            else                       grades[i][0] = "R";
        }
        return grades;
    }

    // Method to display the full scorecard in tabular format
    public static void displayScoreCard(int[][] scores, double[][] stats, String[][] grades) {
        System.out.println("\n--- Student Scorecard ---");
        System.out.printf("%-8s %-10s %-10s %-8s %-8s %-10s %-12s %-6s%n",
                "Student", "Physics", "Chemistry", "Maths", "Total", "Average", "Percentage", "Grade");
        System.out.println("-".repeat(72));
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-8d %-10d %-10d %-8d %-8.0f %-10.2f %-12.2f %-6s%n",
                    (i + 1), scores[i][0], scores[i][1], scores[i][2],
                    stats[i][0], stats[i][1], stats[i][2], grades[i][0]);
        }
    }

    public static void main(String[] args) {
        // Create Scanner object
        Scanner sc = new Scanner(System.in);

        // Take input for number of students
        System.out.print("Enter the number of students: ");
        int numberOfStudents = sc.nextInt();

        // Validate input
        if (numberOfStudents <= 0) {
            System.err.println("Invalid input. Number of students must be positive.");
            System.exit(0);
        }

        // Generate random PCM scores
        int[][] scores = generatePCMScores(numberOfStudents);

        // Calculate stats
        double[][] stats = calculateStats(scores);

        // Calculate grades
        String[][] grades = calculateGrades(stats);

        // Display scorecard
        displayScoreCard(scores, stats, grades);

        // Close Scanner
        sc.close();
    }
}
