import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    
    private static final int MAX_ATTEMPTS = 5; // Maximum number of attempts per round
    private static int roundsWon = 0; // Counter for rounds won
    private static int totalRounds = 0; // Counter for total rounds played
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        
        while (playAgain) {
            int numberToGuess = generateRandomNumber(1, 100);
            int attempts = 0;
            boolean correctGuess = false;
            
            System.out.println("Welcome to Guess the Number Game!");
            System.out.println("I have selected a number between 1 and 100. Try to guess it!");
            
            while (attempts < MAX_ATTEMPTS && !correctGuess) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                
                if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    correctGuess = true;
                    System.out.println("Congratulations! You guessed the number!");
                }
            }
            
            if (!correctGuess) {
                System.out.println("Sorry, you've used all your attempts. The number was " + numberToGuess + ".");
            } else {
                roundsWon++;
            }
            
            totalRounds++;
            System.out.println("You have won " + roundsWon + " out of " + totalRounds + " rounds.");
            
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");
        }
        
        System.out.println("Thank you for playing! You won " + roundsWon + " rounds out of " + totalRounds + ".");
        scanner.close();
    }
    
    private static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
