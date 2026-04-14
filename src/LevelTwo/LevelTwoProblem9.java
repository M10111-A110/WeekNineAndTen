// Program to play Rock-Paper-Scissors and display game stats
import java.util.Scanner;

class LevelTwoProblem9 {

    // Choices array
    static String[] choices = {"Rock", "Paper", "Scissors"};

    // Method to get the computer's choice using Math.random()
    public static String getComputerChoice() {
        int index = (int) (Math.random() * 3);
        return choices[index];
    }

    // Method to find the winner between user and computer
    // Returns "Player", "Computer", or "Draw"
    public static String findWinner(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)) return "Draw";
        // Rock crushes Scissors, Paper covers Rock, Scissors cuts Paper
        if ((playerChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
            (playerChoice.equals("Paper") && computerChoice.equals("Rock")) ||
            (playerChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
            return "Player";
        }
        return "Computer";
    }

    // Method to calculate stats: average and percentage of wins
    // Returns 2D String array: [[playerWins, computerWins, draws, playerPct, computerPct]]
    public static String[][] calculateStats(int playerWins, int computerWins, int draws, int totalGames) {
        double playerPct = (double) playerWins / totalGames * 100;
        double computerPct = (double) computerWins / totalGames * 100;
        String[][] stats = new String[1][5];
        stats[0][0] = String.valueOf(playerWins);
        stats[0][1] = String.valueOf(computerWins);
        stats[0][2] = String.valueOf(draws);
        stats[0][3] = String.format("%.2f", playerPct);
        stats[0][4] = String.format("%.2f", computerPct);
        return stats;
    }

    // Method to display game results and stats
    public static void displayResults(String[][] gameResults, String[][] stats, int totalGames) {
        System.out.println("\n--- Game Results ---");
        System.out.printf("%-8s %-12s %-14s %-10s%n", "Game", "Player", "Computer", "Winner");
        System.out.println("-".repeat(44));
        for (int i = 0; i < gameResults.length; i++) {
            System.out.printf("%-8d %-12s %-14s %-10s%n",
                    (i + 1), gameResults[i][0], gameResults[i][1], gameResults[i][2]);
        }
        System.out.println("\n--- Summary ---");
        System.out.printf("%-20s %-10s %-15s%n", "Outcome", "Count", "Percentage");
        System.out.println("-".repeat(45));
        System.out.printf("%-20s %-10s %-15s%n", "Player Wins", stats[0][0], stats[0][3] + "%");
        System.out.printf("%-20s %-10s %-15s%n", "Computer Wins", stats[0][1], stats[0][4] + "%");
        System.out.printf("%-20s %-10s%n", "Draws", stats[0][2]);
    }

    public static void main(String[] args) {
        // Create Scanner object
        Scanner sc = new Scanner(System.in);

        // Take input for number of games
        System.out.print("Enter the number of games to play: ");
        int numberOfGames = sc.nextInt();

        // Validate input
        if (numberOfGames <= 0) {
            System.err.println("Invalid input. Number of games must be positive.");
            System.exit(0);
        }

        // Store results for each game
        String[][] gameResults = new String[numberOfGames][3];
        int playerWins = 0, computerWins = 0, draws = 0;

        // Play each game
        for (int i = 0; i < numberOfGames; i++) {
            System.out.print("\nGame " + (i + 1) + " - Enter your choice (Rock/Paper/Scissors): ");
            String playerChoice = sc.next();

            // Validate player choice
            boolean validChoice = playerChoice.equals("Rock") || playerChoice.equals("Paper") || playerChoice.equals("Scissors");
            if (!validChoice) {
                System.out.println("Invalid choice. Defaulting to Rock.");
                playerChoice = "Rock";
            }

            String computerChoice = getComputerChoice();
            String winner = findWinner(playerChoice, computerChoice);

            gameResults[i][0] = playerChoice;
            gameResults[i][1] = computerChoice;
            gameResults[i][2] = winner;

            if (winner.equals("Player")) playerWins++;
            else if (winner.equals("Computer")) computerWins++;
            else draws++;
        }

        // Calculate stats
        String[][] stats = calculateStats(playerWins, computerWins, draws, numberOfGames);

        // Display all results
        displayResults(gameResults, stats, numberOfGames);

        // Close Scanner
        sc.close();
    }
}
