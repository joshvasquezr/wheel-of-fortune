# The Wheel of Fortune
## Project Overview
The Wheel of Fortune project aims to provide a playable version of the popular game show, the Wheel of Fortune. This program is executed through an interactive command-line user interface. 

The user is prompted with a hidden phrase which they are to attempt to guess, one letter at a time. The user is also granted three life-lines to get a letter wrong. The user WINS by successfully uncovering the phrase before they exhaust their three life-lines. The user will LOSE if they use up their three life-lines before the phrase if fully uncovered. 

## How To Deploy this app
### Development Process:

This project was all about creating a command-line Wheel of Fortune game, which I built in four different versions, each one a bit more complex than the last. Along the way, I ran into some challenges, but those really helped me learn and improve.

1. **`WheelOfFortuneMain.java`**: I kicked things off with everything packed into a single `main()` method. The game starts by picking a random phrase and turning it into a `hiddenPhrase` by swapping out all the letters with asterisks. The game loop keeps running as long as the player hasn’t uncovered the phrase or run out of lives. The user gets to guess one letter at a time, and I had to figure out how to check those guesses and update the `hiddenPhrase`. One tricky part was managing all the game logic within this one big method, which got messy fast. I also had to make sure I was handling things like empty guesses or invalid inputs, which added another layer of complexity.

2. **`WheelOfFortuneMethods.java`**: The next version was all about breaking things down into methods to make the code cleaner and easier to manage. I pulled out key operations like `randomPhrase()` for selecting the phrase, `generateHiddenPhrase()` for creating the masked phrase, `getGuess()` for handling user input, and `processGuess()` for updating the game state. This made the code way more modular, but figuring out the right return types and parameters for each method wasn’t always straightforward. Deciding where to put certain bits of logic, like input validation, was another challenge that required some trial and error.

3. **`WheelOfFortuneObject.java`**: Moving on to the third version, I shifted to an object-oriented approach. I wrapped the game’s state and logic into a class with instance variables like `phrase`, `hiddenPhrase`, `guessedLetters`, and `lives`. Refactoring the code to work within this new structure was a bit tough, especially when converting the procedural code into methods that relied on these instance variables. I also had to make sure I was initializing and updating these variables correctly, which led to some bugs—like forgetting to reinitialize the `StringBuilder` in the `generateHiddenPhrase()` method, causing a `NullPointerException`. That was a frustrating but valuable lesson in how Java handles object references.

4. **`WheelOfFortuneBot.java`**: The final version brought in a bot to play the game. I extended the `WheelOfFortuneObject` class and overrode the `getGuess()` method to have the bot make random guesses. This version really tested how flexible my object-oriented design was and required some careful tweaking to make sure the bot played by the game’s rules, like not guessing the same letter twice. Overriding the `getGuess()` method wasn’t as simple as I initially thought, and I had to get a better grasp on inheritance and method overriding to make it work smoothly.

### Summary:

This project was a great way to dig deeper into Java, especially with concepts like control structures, string manipulation, and object-oriented design. Each version built on the one before it, taking the project from a simple, all-in-one method approach to a more organized, object-oriented design. Along the way, I faced a few challenges, like managing game state and refactoring the code to fit an object-oriented framework, but those challenges were key to improving my understanding of Java. In the end, I ended up with a fully functional command-line game that can be played by both humans and a bot, showing just how powerful and flexible well-structured code can be.

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
## Test Plan
## Test Video

