// Program to demonstrate NullPointerException - generate and handle it
class LevelOneProblem4 {

    // Method to generate NullPointerException (unhandled)
    public static void generateNullPointerException() {
        // Define text as null
        String text = null;
        // Calling a String method on null will throw NullPointerException
        System.out.println("String length: " + text.length());
    }

    // Method to demonstrate NullPointerException with try-catch handling
    public static void handleNullPointerException() {
        // Define text as null
        String text = null;
        try {
            // Attempt to call a String method on null - will throw NullPointerException
            System.out.println("String length: " + text.length());
        } catch (NullPointerException e) {
            // Handle the NullPointerException
            System.out.println("NullPointerException caught: The string is null and cannot be accessed.");
            System.out.println("Exception message: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // First demonstrate the exception being generated and handled
        System.out.println("--- Demonstrating NullPointerException (Handled) ---");
        handleNullPointerException();

        System.out.println("\n--- Now generating NullPointerException (Unhandled) ---");
        System.out.println("The program will crash after this line...");
        // Call the method that generates the unhandled exception
        generateNullPointerException();
    }
}
