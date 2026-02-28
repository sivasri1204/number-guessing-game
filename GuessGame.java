import java.util.*;  // Importing utility classes like Scanner and Random

public class GuessGame {

    public static void main(String[] args) {

        // Create Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Create Random object to generate random numbers
        Random rand = new Random();

        char playAgain;        // Stores user's choice to continue game
        int totalScore = 0;    // Tracks total score across all rounds
        int round = 1;         // Keeps track of round number

        // Loop to allow multiple rounds
        do {

            // Generate random number between 1 and 100
            int number = rand.nextInt(100) + 1;

            int guess = 0;              // Stores user's guess
            int attempts = 0;           // Counts number of attempts used
            boolean guessedCorrectly = false;  // Checks if user guessed correctly

            // Display round information
            System.out.println("\n=== Round " + round + " ===");
            System.out.println("Guess a number between 1 and 100");
            System.out.println("You have ONLY 5 attempts!");

            // Allow maximum 5 attempts
            while (attempts < 5) {

                System.out.print("Enter your guess: ");
                guess = sc.nextInt();  // Take user input
                attempts++;            // Increase attempt count

                // Check if guess is lower than actual number
                if (guess < number) {
                    System.out.println("Too low!");
                } 
                // Check if guess is higher than actual number
                else if (guess > number) {
                    System.out.println("Too high!");
                } 
                // If guess is correct
                else {
                    System.out.println("✅ Correct!");
                    guessedCorrectly = true;
                    break;  // Exit loop if correct
                }
            }

            int points = 0;  // Points earned in current round

            // Calculate score only if guessed correctly
            if (guessedCorrectly) {

                // More points for fewer attempts
                if (attempts == 1) points = 50;
                else if (attempts == 2) points = 40;
                else if (attempts == 3) points = 30;
                else if (attempts == 4) points = 20;
                else points = 10;

                System.out.println("Points earned: " + points);
            } 
            // If user fails to guess within 5 attempts
            else {
                System.out.println("❌ Attempts Over!");
                System.out.println("Correct number was: " + number);
            }

            // Add round points to total score
            totalScore += points;

            // Display round summary
            System.out.println("Attempts used: " + attempts);
            System.out.println("Total Score: " + totalScore);

            // Ask user if they want to continue
            System.out.print("Play next round? (y/n): ");
            playAgain = sc.next().charAt(0);

            round++;  // Move to next round

        } while (playAgain == 'y' || playAgain == 'Y');

        // Close scanner (resource cleanup)
        sc.close();

        // Final game summary
        System.out.println("\n=== Game Over ===");
        System.out.println("Final Score: " + totalScore);
        System.out.println("Thanks for playing!");
    }
}
