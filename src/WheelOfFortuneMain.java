import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WheelOfFortuneMain {
    public static void main(String[] args) {

        WheelOfFortuneMain wheelOfFortune = new WheelOfFortuneMain();

        // Get the phrase from a file of phrases - randomPhrase();
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
//        System.out.println(phrase);

        // Create the Hidden Phrase - generateHiddenPhrase()
        StringBuilder hiddenPhrase = new StringBuilder();
        for (int i = 0; i < phrase.length(); i++) {
                char ch = phrase.charAt(i);
                if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z') {
                    hiddenPhrase.append('*');
                } else {
                    hiddenPhrase.append(ch);
                }
        }

        // Greeting and Instructions
        String greeting = "🎉 WELCOME TO... THE WHEEL OF FORTUNE! 🎉%n%n";
        String instructions = "📝 HOW TO PLAY 📝%n" +
                "_____________________________________________%n%n" +
                "Your challenge is to guess the Hidden Phrase, one letter at a time.%n%n" +
                "⚙️ Rules of the Game:%n" +
                "  1️⃣ You may ONLY guess one letter at a time.%n" +
                "  2️⃣ If your guess is CORRECT, all instances of the letter will be revealed in the Hidden Phrase.%n" +
                "  3️⃣ If your guess is INCORRECT, you receive one strike.%n" +
                "  4️⃣ Three strikes, and you're OUT! Just like in baseball!%n%n" +
                "_____________________________________________%n%n";
        System.out.printf(greeting);
        System.out.printf(instructions);


        // Game-Code Starts
        boolean phraseFound = false;
        int totalLettersFound = 0;
        int strikes = 0;
        String guessedLetters = "";
        Scanner scanner =  new Scanner(System.in);
        String missedGuesses = "";
        while (!phraseFound || strikes < 3) {
            System.out.printf("%n%n");
            System.out.println("Hidden Phrase: " + hiddenPhrase);

            // Get user guess - getGuess();
            String promptUser = "Enter your guess: ";
            System.out.printf(promptUser);
            String userGuess = scanner.nextLine();

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
                    strikes += 1; // PENALTY: Minus One Life for incorrect guess
                    missedGuesses += guess + " ";
                    if (strikes == 3) {
                        System.out.printf("STRIKE THREE! YOU'REEEEE OUT!%n");
                        System.out.println("The Hidden Phrase was: '" + phrase + "'");
                        break;
                    }
                    if (strikes == 1) {
                        System.out.printf("STRIKE ONE!%n");
                    } else if(strikes == 2) {
                        System.out.printf("STEEE-RIKE TWO!!%n");
                    } else if(strikes == 3) {
                    }
                    System.out.printf("Wrong Guesses: " + missedGuesses);
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
}