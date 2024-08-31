import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WheelOfFortuneObject {

    // define instance variable
    private String phrase;
    private StringBuilder hiddenPhrase;
    private String guessedLetters;
    private int lives;

    // create constructor to initialize instance variables
    public WheelOfFortuneObject() {
        this.phrase = randomPhrase();
        this.hiddenPhrase = generateHiddenPhrase();
        this.guessedLetters = "";
        this.lives = 3;
    }

    public String randomPhrase(){
        List<String> phraseList=null;

        try {
            phraseList = Files.readAllLines(Paths.get("phrases.txt"));
        } catch (IOException e) {
            System.out.println(e);
        }

        // Get a random phrase from the list
        Random rand = new Random();
        int r = rand.nextInt(phraseList.size()); // gets 0, 1, or 2
        return phraseList.get(r);
    }

    public StringBuilder generateHiddenPhrase() {
        hiddenPhrase = new StringBuilder();
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

    public String getGuess() {
        Scanner scanner =  new Scanner(System.in);
        System.out.printf("%n%n");
        System.out.println("Hidden Phrase: " + hiddenPhrase);

        // Get user guess - getGuess();
        String promptUser = "Enter your guess: ";
        System.out.printf(promptUser);
        String userGuess = scanner.nextLine();
        return userGuess;
    }

    public void processGuess(char guess) {

        // Keep record of User Guesses
        if (guess >= 'a' && guess <= 'z') {
            if (guessedLetters.isEmpty()) {
                guessedLetters += guess;
            } else if(guessedLetters.indexOf(guess) != -1) {
                System.out.println("You've already guessed '" + guess + "'. Please try again.");
                System.out.println("GUESSED: " + guessedLetters);
                return;
            } else {
                guessedLetters += ", " + guess;
            }
            System.out.println("GUESSED: " + guessedLetters);
        } else {
            System.out.println("This is not a valid guess. Please try again :)"); // Prompt if user enters non-letter
            return;
        }

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
            System.out.printf("Incorrect Guess! You now have [" + lives + "] left.%n");
        }

    }

    // Game-Code Starts
    public void startGame() {

        boolean phraseFound = false;

        while (!phraseFound) {
            String userGuess = getGuess();

            // Check User Guess - processGuess();
            if (userGuess.trim().isEmpty()) {
                System.out.println("You did not input anything. Please try again.");
                return;
            }
            char guess = Character.toLowerCase(userGuess.charAt(0));
            processGuess(guess);

            // checks if you won or lost
            if (phrase.equals(hiddenPhrase.toString())) {
                phraseFound = true;
                System.out.println("Woohoo you won!");
                System.out.printf("You Correctly Found the Phrase: '" + phrase + "'%n");
                break;
            } else if (lives == 0) {
                System.out.printf("GAME OVER. You ran out of lives :(%nTry Again!%n");
                System.out.println("The Hidden Phrase was: '" + phrase + "'");
                break;
            }
        } // end of while loop
    }

    public static void main(String[] args) {

        WheelOfFortuneObject game = new WheelOfFortuneObject();
        game.startGame();
    }
}
