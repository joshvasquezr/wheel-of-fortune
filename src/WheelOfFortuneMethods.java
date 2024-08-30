import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WheelOfFortuneMethods {

    // Get the phrase from a file of phrases - randomPhrase();
    public static String randomPhrase() {

        List<String> phraseList=null;

        try {
            phraseList = Files.readAllLines(Paths.get("phrases.txt"));
        } catch (IOException e) {
            System.out.println(e);
        }

        // Get a random phrase from the list
        Random rand = new Random();
        int r = rand.nextInt(phraseList.size()); // gets 0, 1, or 2
        String phrase = phraseList.get(r);
        return phrase;
    }

    public static void instructions() {
        // Greeting and Instructions
        String greeting = "WELCOME TO...%nTHE WHEEL OF FORTUNE! %n%n";
        String instructions = "HOW TO PLAY%n______________%n%nYou will be shown a Hidden Phrase that you will need to guess %nThe instructions are as follows%n\t1. You may ONLY guess one letter at a time%n\t\ta. If your guess is CORRECT, the place of the letter(s) will be revealed in the Hidden Phrase%n\t\tb. If your guess is INCORRECT, you gain ONE strike. If you gain THREE strikes. Just like in soccer, you are OUT! %n__________________________________________________________________%n%n%n";
        System.out.printf(greeting);
        System.out.printf(instructions);
    }

    public static StringBuilder generateHiddenPhrase(String phrase) {
        StringBuilder hiddenPhrase = new StringBuilder();
        for (int i = 0; i < phrase.length(); i++) {
            char ch = phrase.charAt(i);
            if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z') {
                hiddenPhrase.append('*');
            } else {
                hiddenPhrase.append(ch);
            }
        }
        System.out.println(phrase);
        return hiddenPhrase;
    }

    public static String getGuess(StringBuilder hiddenPhrase) {
        Scanner scanner =  new Scanner(System.in);
        System.out.printf("%n%n");
        System.out.println("Hidden Phrase: " + hiddenPhrase);

        // Get user guess - getGuess();
        String promptUser = "Enter your guess: ";
        System.out.printf(promptUser);
        String userGuess = scanner.nextLine();
        return userGuess;
    }

    public static void processGuess(String phrase, StringBuilder hiddenPhrase) {

        // Game-Code Starts
        boolean phraseFound = false;
        int lives = 3;
        String guessedLetters = "";

        while (!phraseFound || lives != 0) {

            String userGuess = getGuess(hiddenPhrase);

            // Check User Guess - processGuess();
            char guess = Character.toLowerCase(userGuess.charAt(0));

            if (userGuess.trim().isEmpty()) {
                System.out.println("You did not input anything. Please try again.");
                continue;
            }

            // Keep record of User Guesses
            if (guess >= 'a' && guess <= 'z') {
                if (guessedLetters.isEmpty()) {
                    guessedLetters += guess;
                } else if(guessedLetters.contains(userGuess)) {
                    System.out.println("You've already guessed '" + userGuess + "'. Please try again.");
                    System.out.println("GUESSED: " + guessedLetters);
                    continue;
                } else {
                    guessedLetters += ", " + guess;
                }
                System.out.println("GUESSED: " + guessedLetters);
            } else {
                System.out.println("This is not a valid guess. Please try again :)"); // Prompt if user enters non-letter
                continue;
            }

            if (guess >= 'a' && guess <='z') {
                int correctGuess = 0;

                for (int i = 0; i < phrase.length(); i++) {
                    char phraseChar = phrase.charAt(i);

                    // if TRUE: update hiddenPhrase, lettersFound, else check if user found the whole phrase
                    if (guess == Character.toLowerCase(phraseChar)) {
                        hiddenPhrase.setCharAt(i, phraseChar);
                        correctGuess++;
                    }
                }

                // Checks if the user a letter NOT FOUND in the Hidden Phrase and takes away ONE life
                if (correctGuess == 0) {
                    lives -= 1; // PENALTY: Minus One Life for incorrect guess
                    if (lives == 0) {
                        System.out.printf("GAME OVER. You ran out of lives :(%nTry Again!%n");
                        System.out.println("The Hidden Phrase was: '" + phrase + "'");
                        break;
                    }
                    System.out.printf("Incorrect Guess! You now have [" + lives + "] left.%n");
                }

                // Checks if user discovered the full phrase
                if (phrase.equals(hiddenPhrase.toString())) {
                    phraseFound = true;
                    System.out.println("Woohoo you won!");
                    System.out.printf("You Correctly Found the Phrase: '" + phrase + "'%n");
                    break;
                }

            } else {
                System.out.println("This is not a valid guess. Please try again :)"); // Prompt if user enters non-letter
            }

        } // end of while loop
    }

    public static void startGame() {
        instructions();
        String phrase = randomPhrase();
        StringBuilder hiddenPhrase = generateHiddenPhrase(phrase);
        processGuess(phrase, hiddenPhrase);
    }

    public static void main(String[] args) {
        System.out.println("Would you like to play a game? [ Enter 'y' OR 'n' ]");
        Scanner scanner = new Scanner(System.in);
        String playGame = scanner.nextLine();
        if (playGame.equals("y") || playGame.equals("yes")) {
            startGame();
        } else if (playGame.equals("n") || playGame.equals("no")) {
            System.out.println("Your Loss.");
        } else {
            System.out.println("Um what?");
        }
    }
}
