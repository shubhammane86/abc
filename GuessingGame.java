package javaproject;
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    private static final int MAX_ATTEMPTS = 10;
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;

        while (true) {
            int attempts = 0;
            int numberToGuess = random.nextInt(RANGE_END - RANGE_START + 1) + RANGE_START;

            while (attempts < MAX_ATTEMPTS) {
                System.out.println("Enter your guess:");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    System.out.println("Correct! You've guessed the number.");
                    score += MAX_ATTEMPTS - attempts + 1;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (attempts == MAX_ATTEMPTS) {
                System.out.println("Sorry, you didn't guess the number. The number was " + numberToGuess);
            }

            System.out.println("Your score is: " + score);
            System.out.println("Do you want to play again? (yes/no)");

            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        scanner.close();
    }
}
