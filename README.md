# The Wheel of Fortune
## Project Overview
The Wheel of Fortune project aims to provide a playable version of the popular game show, the Wheel of Fortune. This program is executed through an interactive command-line user interface. 

The user is prompted with a hidden phrase which they are to attempt to guess, one letter at a time. The user is also granted three life-lines to get a letter wrong. The user WINS by successfully uncovering the phrase before they exhaust their three life-lines. The user will LOSE if they use up their three life-lines before the phrase if fully uncovered. 

### How to Deploy This App

To run the Wheel of Fortune game on your local machine, follow these steps:

1. **Clone the Repository:**
  - Open your terminal and run the following command to clone the repository:
    ```bash
    git clone https://github.com/your-username/wheel-of-fortune.git
    ```
  - Navigate into the project directory:
    ```bash
    cd wheel-of-fortune
    ```

2. **Compile the Code:**
  - Use the following command to compile the Java files:
    ```bash
    javac src/*.java
    ```

3. **Run the Game:**
  - To run the game, use the following command:
    ```bash
    java -cp src WheelOfFortuneMain
    ```
  - If you want to run the methods version, use:
    ```bash
    java -cp src WheelOfFortuneMethods
    ```
  - To run the object-oriented version:
    ```bash
    java -cp src WheelOfFortuneObject
    ```
  - To play against the bot, use:
    ```bash
    java -cp src WheelOfFortuneBot
    ```

4. **Interact with the Game:**
  - Follow the on-screen instructions to play the game. You will be prompted to guess letters one at a time, with the goal of uncovering the hidden phrase before running out of lives.

### Prerequisites

- Ensure that you have Java installed on your machine. You can check if Java is installed by running:
  ```bash
  java -version

### Development Process:

This project was all about creating a command-line Wheel of Fortune game, which I built in four different versions, each one a bit more complex than the previous one. Along the way, I ran into some challenges, but those really helped me learn and improve.

1. **`WheelOfFortuneMain.java`**: I started things off with everything packed into a single `main()` method. The game starts by picking a random phrase and turning it into a `hiddenPhrase` by swapping out all the letters with asterisks. The game loop keeps running as long as the player hasn’t uncovered the phrase or run out of lives. The user gets to guess one letter at a time, and I had to figure out how to check those guesses and update the `hiddenPhrase`. One tricky part was managing all the game logic within this one big method, which got a bit complicated real quickly. I also had to make sure I was handling things like empty guesses or invalid inputs, which added another layer of complexity.

2. **`WheelOfFortuneMethods.java`**: The next version was all about breaking things down into methods to make the code cleaner and easier to manage. I pulled out key operations like `randomPhrase()` for selecting the phrase, `generateHiddenPhrase()` for creating the masked phrase, `getGuess()` for handling user input, and `processGuess()` for updating the game state. This made the code way more modular, but figuring out the right return types and parameters for each method wasn’t always straightforward. Deciding where to put certain bits of logic, like input validation, was another challenge that required some trial and error.

3. **`WheelOfFortuneObject.java`**: Moving on to the third version, I shifted to an object-oriented approach. I wrapped the game’s state and logic into a class with instance variables like `phrase`, `hiddenPhrase`, `guessedLetters`, and `lives`. Refactoring the code to work within this new structure was a bit tough, especially when converting the procedural code into methods that relied on these instance variables. I also had to make sure I was initializing and updating these variables correctly, which led to some bugs—like forgetting to reinitialize the `StringBuilder` in the `generateHiddenPhrase()` method, causing a `NullPointerException`. That was a frustrating but valuable lesson in how Java handles object references.

4. **`WheelOfFortuneBot.java`**: The final version brought in a bot to play the game. I extended the `WheelOfFortuneObject` class and overrode the `getGuess()` method to have the bot make random guesses. This version really tested how flexible my object-oriented design was and required some careful tweaking to make sure the bot played by the game’s rules, like not guessing the same letter twice. Overriding the `getGuess()` method wasn’t as simple as I initially thought, and I had to get a better grasp on inheritance and method overriding to make it work smoothly.

### Summary:

This project was a great way to dig deeper into Java, especially with concepts like loops, conditional statements, data types, methods, string manipulation, and object-oriented design. Each version built on the one before it, taking the project from a simple, all-in-one method approach to a more organized, object-oriented design. Along the way, I faced a few challenges, like managing game state and refactoring the code to fit an object-oriented design. In the end, I ended up with a fully functional command-line game that can be played by both humans and a bot, showing just how powerful and flexible well-structured code can be.

## What this project completed
### Functionality
* The phrase for the game is randomly selected and read in from `phrases.txt`
* The game encrypts the randomly selected phrase to replace all letters with an asterisk *, leaving non-letters unhidden
* The game prompts the user to guess a letter in the phrase
  * If the User's guess is found to be in the phrase, all instances of the letter are uncovered from the encrypted phrase
  * If the User's guess is not found to be in the phrase, the User will lose a life-line (User starts with 3 life-lines)
* If the User gueses a letter they have already, the program will output a message
notifying them that they have already previously made that guess
  * The User is not penalized for a repeat incorrect guess
* If the user incorrectly guess a letter 3 times, the game is lost and the User is notified
* If the User correctly guesses all letters in the phrase, they win!
* This program outputs a simple easy-to-understand command-line user interface. This includes displaying...
  * How To Play Instructions at the beginning of the game
  * A prompt for the User to enter their guess
  * Record of their previous guesses
  * The number of remaining life-lines they have
  * A prompt if the User enters a previously guessed letter, absent of correctness
### Test Plan

I carried out several tests to make sure the `Wheel of Fortune` game works as expected:

1. **Starting the Game:**
    - Checked that a phrase is correctly picked from `phrases.txt` and that the `hiddenPhrase` is set up with the right number of asterisks and any unhidden characters.
    - Made sure the game starts with the correct number of lives and no previous guesses.

2. **Handling User Input:**
    - Tested different inputs, like valid letter guesses, invalid characters (like numbers and symbols), and repeated guesses. Confirmed that the game recognizes valid guesses, updates the `hiddenPhrase`, and ignores invalid inputs without messing up the game.

3. **Game Loop:**
    - Ran the game from start to finish to check that the user can keep guessing letters, with the game tracking correct and incorrect guesses, updating the hidden phrase, and taking away lives for wrong guesses.
    - Made sure the game ends correctly when the user either guesses the whole phrase or runs out of lives.

4. **Edge Cases:**
    - Tested unusual situations like inputting nothing, guessing the whole phrase correctly on the first try, and losing all lives without uncovering any letters. Ensured the game handles these situations properly.

5. **Bot Version:**
    - For the bot version, confirmed that the bot makes random guesses and the game plays out the same way as with user input, automatically running until the bot wins or loses.

6. **Cloning and Running the Game:**
    - Checked that the game works on different computers when the project is cloned, making sure `phrases.txt` loads correctly and the game runs without needing code changes.

These tests helped ensure that the game works well under different scenarios and provides a smooth experience.


## Test Video
Coming Soon...
