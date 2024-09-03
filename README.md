# The Wheel of Fortune
## Project Overview
The Wheel of Fortune project aims to provide a playable version of the popular game show, the Wheel of Fortune. This program is executed through an interactive command-line user interface. 

The user is prompted with a hidden phrase which they are to attempt to guess, one letter at a time. The user is also granted three life-lines to get a letter wrong. The user WINS by successfully uncovering the phrase before they exhaust their three life-lines. The user will LOSE if they use up their three life-lines before the phrase if fully uncovered. 

## How To Deploy this app
## Development Process
### The Process
My first step was to get `WheelOfFortuneMain.java` working. My approach was to
1. Breakdown the logical sequence of events that I needed my code to execute
2. Start coding each step and integrating further functionality one step at a time, testing each functionality at every step
3. Test the whole program

My breakdown of the logical sequence of events for my code was as follows:

1. Get a random phrase from phrases.txt &#40;this was easy because it was already done for me... thanks Professor!
2. Encrypt the randomly selected phrase by replacing only the letters with asterisks *
3. Prompt the User to make a guess
4. Check the validity of the guess
5. Check the correctness of the guess
6. Check if the user had completely uncovered the phrase

This is not an exhaustive list of the logic for my program, but a rough draft of my
first-go at attempting to _think_ about the logic for the functionality of my 
program. I implemented the encryption of the randomly selected phrase by creating a 
new variable `StringBuilder hiddenPhrase = new StringBuilder()`. I then used a `for`
loop to iterate through the randomly selected phrase, replacing every letter with an
asterisk. One of my  "Aha!" moments was in realizing that I might want to use a 
`while` loop for this program. I could tell my program that `while` the User has not
yet uncovered the full phrase, continue prompting them to input a guess. I then 
worked on the losing aspect to this game into the `while` loop. As long as the User 
still had not uncovered the full phrase or their `lives != 0`, then they would still
get prompted to make guesses. Within the `while` loop I added the functionality that
would output text prompting the user to input a `guess`. Under that, I created the 
`if` conditional statement targeted at checking whether the guess was valid (i.e. 
only a letter). Again within the `while` loop, an `if` statement checking the 
_correctness_ of the guess was implemented. As long as the guess was correct, the 
program would edit the `StringBuilder hiddenPhrase` variable by changing the 
corresponding index of the asterisk(s) with the User's guess, otherwise the program 
took away one life from the User's remaining "life" balance. My final 
implementation, was to figure out how to keep track of the previously 
`guessedLetters` the user had already inputted. I did this by, first, initializing 
`String guessedLetters = "";`, second, checking if `guess` was a valid guess (i.e. a
letter), third, if `guessedLetters` was empty (or otherwise if this was the User's 
first guess), and if `guessedLetters` was not empty, then check whether `guess` is 
already somewhere in `guessed Letters`. 


[//]: # (I will discuss my approach to this project by taking you through my thought-process for each of my four versions.)

[//]: # (#### Version 1: WheelOfFortuneMain.java)

[//]: # (For this version of the project I began by mentally thinkng through and breaking down each individual aspect that this program needed to contain as well as the *possible* logical sequence it would require. My breakdown went as follows:)

[//]: # (1. Get a random phrase from phrases.txt &#40;this was easy because it was already done for me... thanks Professor!&#41;)

[//]: # (2. Encrypt the randomly selected phrase by replacing only the letters with asterisks *)

[//]: # (3. Prompt the user to make a guess)

[//]: # (4. Check the validity of the guess &#40;letters only&#41;)

[//]: # (5. Check the correctness of the guess &#40;is it in the hidden prhase&#41;)

[//]: # (6. Check if the user had completely uncovered the phrase)

[//]: # ()
[//]: # (This is a rough example of what my thought process for this first version of the project. My goal was simple. Make this code work and have the working code check-off all of the requirements in the project description.  &#40;add link to project description&#41;. )

[//]: # ()
[//]: # (My first step was to **encrypt the randomly selected phrase**. This was a simple process because I recall having done this in a previous lab. My algorithm to execute this was simple. I declared my `hiddenPhrase` variable to be of type `StringBuilder` because I knew I was going to need to edit `hiddenPhrase` throughout my code since the User would be uncovering and therein changing `hiddenPhrase`. The immutability of a `String` type would just add in a further complexity to this program that was unnecessary. From there, the algorithm was simple. I created a `for` loop as such: `for &#40;int i = 0; i < hiddenPhrase.length; i++&#41;`, essentially iterating through each character of the randomly selected phrase. Within the `for` loop I added a conditional `if` statement, ensuring that  )
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

