// Program to find BMI of 10 team members and display using 2D String arrays
import java.util.Scanner;

class LevelThreeProblem1 {

    // Define team size
    static int teamSize = 10;

    // Method to find BMI and status for a single person and return a 2D String array row
    // Returns String array: [height, weight, BMI, status]
    public static String[] calculateBMIAndStatus(double weightKg, double heightCm) {
        // Convert height from cm to meters
        double heightM = heightCm / 100.0;
        // BMI formula: weight / (height in meters)^2
        double bmi = weightKg / (heightM * heightM);

        // Determine BMI status
        String status;
        if (bmi <= 18.4)       status = "Underweight";
        else if (bmi <= 24.9)  status = "Normal";
        else if (bmi <= 39.9)  status = "Overweight";
        else                   status = "Obese";

        return new String[]{
            String.format("%.2f", heightCm),
            String.format("%.2f", weightKg),
            String.format("%.2f", bmi),
            status
        };
    }

    // Method that takes 2D array of [weight, height] and returns 2D String array
    // of [height, weight, BMI, status] for all persons
    public static String[][] buildBMIReport(double[][] personData) {
        String[][] report = new String[personData.length][4];
        for (int i = 0; i < personData.length; i++) {
            double weight = personData[i][0];
            double height = personData[i][1];
            report[i] = calculateBMIAndStatus(weight, height);
        }
        return report;
    }

    // Method to display the 2D String array in tabular format
    public static void displayBMIReport(String[][] report) {
        System.out.println("\n--- BMI Report ---");
        System.out.printf("%-10s %-14s %-14s %-10s %-15s%n",
                "Person", "Height (cm)", "Weight (kg)", "BMI", "Status");
        System.out.println("-".repeat(63));
        for (int i = 0; i < report.length; i++) {
            System.out.printf("%-10d %-14s %-14s %-10s %-15s%n",
                    (i + 1), report[i][0], report[i][1], report[i][2], report[i][3]);
        }
    }

    public static void main(String[] args) {
        // Create Scanner object
        Scanner sc = new Scanner(System.in);

        // 2D array: 10 rows, 2 columns [weight(kg), height(cm)]
        double[][] personData = new double[teamSize][2];

        // Take user input for weight and height of each person
        System.out.println("Enter weight (kg) and height (cm) for each team member:");
        for (int i = 0; i < teamSize; i++) {
            System.out.print("\nPerson " + (i + 1) + " - Weight (kg): ");
            personData[i][0] = sc.nextDouble();
            if (personData[i][0] <= 0) {
                System.out.println("Invalid weight. Please enter a positive value.");
                i--;
                continue;
            }
            System.out.print("Person " + (i + 1) + " - Height (cm): ");
            personData[i][1] = sc.nextDouble();
            if (personData[i][1] <= 0) {
                System.out.println("Invalid height. Please enter a positive value.");
                i--;
            }
        }

        // Build BMI report using method
        String[][] bmiReport = buildBMIReport(personData);

        // Display the report using method
        displayBMIReport(bmiReport);

        // Close Scanner
        sc.close();
    }
}
