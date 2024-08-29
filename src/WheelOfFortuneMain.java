import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WheelOfFortuneMain {
    public static void main(String[] args) {

        WheelOfFortuneMain wheelOfFortune = new WheelOfFortuneMain();

        List<String> phraseList=null;
        // Get the phrase from a file of phrases
        try {
            phraseList = Files.readAllLines(Paths.get("phrases.txt"));
        } catch (IOException e) {
            System.out.println(e);
        }

        // Get a random phrase from the list
        Random rand = new Random();
        int r = rand.nextInt(3); // gets 0, 1, or 2
        String phrase = phraseList.get(r);
        System.out.println(phrase);

        // Create the Hidden Phrase
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
        String greeting = "Hello! Welcome to... (*drum roll*)... THE WHEEL OF FORTUNE!";
        String instructions = "You will be shown a Hidden Phrase that you will need to guess %nThe instructions are as follows%n\t1. You may ONLY guess one letter at a time%n\t\ta. If your guess is CORRECT, the place of the letter(s) will be revealed in the Hidden Phrase%n\t\tb. If your guess is INCORRECT, you gain ONE strike. If you gain THREE strikes. Just like in soccer, you are OUT! ";
        System.out.println(greeting);
        System.out.printf(instructions);
////        boolean phraseFound = false;
////        int totalLettersFound = 0;
////        while (!phraseFound) {
////            System.out.println("Hidden Phrase: " + hiddenPhrase);
////
////            // Prompt user to start guessing letter by letter
////            String promptUser = "Enter your guess: ";
////            System.out.println(promptUser);
////            Scanner scanner =  new Scanner(System.in);
////            String userGuess = scanner.next();
////            System.out.println("You Guessed: " + userGuess);
////
////            // Check User Guess
////            int lettersFound = 0;
////            for (int i = 0; i < phrase.length(); i++) {
////                char guess = userGuess.charAt(0);
////                guess = Character.toLowerCase(guess);
////                char phraseChar = phrase.charAt(i);
////
////                // if TRUE: update hiddenPhrase, lettersFound, else check if user found the whole phrase
////                if (guess == Character.toLowerCase(phraseChar)) {
////                    lettersFound++;
////                    hiddenPhrase.setCharAt(i, phraseChar);
////                } else if (phrase.equals(hiddenPhrase.toString())) {
////                    phraseFound = true;
////                }
////            }
////            // add to the total letters found
////            totalLettersFound += lettersFound;
////            System.out.println("Letters Found: " + lettersFound);
////            System.out.println("Total Letters Found: " + totalLettersFound);
////            System.out.println();
////        }
//        System.out.println("Woohoo you won! It only took you " + totalLettersFound + " guesses.");
    }
}