// Program to create, shuffle, and distribute a deck of cards to players
import java.util.Scanner;

class LevelThreeProblem10 {

    // Card suits and ranks
    static String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    static String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10",
                             "Jack", "Queen", "King", "Ace"};

    // Method to initialize the deck of cards with suits and ranks
    // Each card is represented as "rank of suit" e.g., "2 of Hearts"
    public static String[] initializeDeck() {
        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];
        int index = 0;
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[index] = ranks[j] + " of " + suits[i];
                index++;
            }
        }
        return deck;
    }

    // Method to shuffle the deck of cards and return the shuffled deck
    public static String[] shuffleDeck(String[] deck) {
        int n = deck.length;
        // Iterate over the deck and swap each card with a random card
        for (int i = 0; i < n; i++) {
            // Generate a random card number between i and n
            int randomCardNumber = i + (int) (Math.random() * (n - i));
            // Swap the current card with the random card
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
        return deck;
    }

    // Method to distribute n cards to x players
    // Returns 2D String array [player][cards], or null if not evenly distributable
    public static String[][] distributeCards(String[] deck, int numCards, int numPlayers) {
        // Check if n cards can be distributed to x players evenly
        if (numCards > deck.length || numCards % numPlayers != 0) {
            System.out.println("Cannot distribute " + numCards + " cards evenly to " + numPlayers + " players.");
            return null;
        }
        int cardsPerPlayer = numCards / numPlayers;
        String[][] players = new String[numPlayers][cardsPerPlayer];
        int cardIndex = 0;
        for (int i = 0; i < numPlayers; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                players[i][j] = deck[cardIndex];
                cardIndex++;
            }
        }
        return players;
    }

    // Method to print each player and their cards
    public static void printPlayersAndCards(String[][] players) {
        System.out.println("\n--- Cards Dealt to Players ---");
        for (int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i + 1) + ":");
            for (int j = 0; j < players[i].length; j++) {
                System.out.println("  " + players[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        // Create Scanner object
        Scanner sc = new Scanner(System.in);

        // Initialize and shuffle the deck
        String[] deck = initializeDeck();
        deck = shuffleDeck(deck);

        System.out.println("Deck initialized and shuffled. Total cards: " + deck.length);

        // Take user input for number of cards and players
        System.out.print("\nEnter the number of cards to distribute (max " + deck.length + "): ");
        int numCards = sc.nextInt();

        System.out.print("Enter the number of players: ");
        int numPlayers = sc.nextInt();

        // Validate inputs
        if (numCards <= 0 || numPlayers <= 0) {
            System.err.println("Invalid input. Both values must be positive.");
            System.exit(0);
        }

        // Distribute the cards using the method
        String[][] players = distributeCards(deck, numCards, numPlayers);

        // Print players and their cards if distribution was successful
        if (players != null) {
            printPlayersAndCards(players);
        }

        // Close Scanner
        sc.close();
    }
}
