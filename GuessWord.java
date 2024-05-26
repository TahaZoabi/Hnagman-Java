
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GuessWord {
    public static final String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel", "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer", "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat", "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose", "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", "python", "rabbit", "ram", "rat", "raven", "rhino", "salmon", "seal", "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan", "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf", "wombat", "zebra"};

    public static final Scanner INPUT_SCANNER = new Scanner(System.in);
    public static final int randomNumber = (int) (Math.random() * words.length);

    public static final String guessWord = words[randomNumber]; // generate a random word
    public static final int guessWordLength = guessWord.length(); // get length of word
    public static final int maxGuessTries = 6; // hangman game ends after 6 wrong tries
    public static int wrongGuessCounter = 0; // keep track of what gallows to print

    public static boolean userWon = false; // used to check winner

    // make an array of the word letters
    public static final String[] guessWordLetters = guessWord.split("");
    // create a list for the word placeholder
    public static ArrayList<String> guessPlaceHolder = new ArrayList<String>();
    // create a list for the wrong letter guesses
    static ArrayList<String> missedLetterList = new ArrayList<String>(maxGuessTries);

    // method to fill the place holder list with empty underscores
    public static void fillPlaceHolders() {
        for (int i = 0; i < guessWordLength; i++) {
            guessPlaceHolder.add("_");
        }
        Gallows.printGallows(); // print the default gallows
    }

    // method to print shit
    public static void printDetails() {
        System.out.println(STR."Word Letters: \{guessPlaceHolder}");
        System.out.println(STR."Missed Letters: \{missedLetterList}");
        System.out.println("Guess Letter: ");

    }

    public static void checkGuess() {
        for (int i = 0; i < maxGuessTries; i++) {
            String guessLetter = INPUT_SCANNER.next(); // get user letter guess

            // check if the word includes the guess letter
            if (Arrays.asList(guessWordLetters).contains(guessLetter)) {
                System.out.println("Correct guess ");
                --i; // if the user has a correct guess he keeps going so we decrement i by one

                // loop over the letters array and check if it includes the guess letter
                for (int j = 0; j < guessWordLetters.length; j++) {
                    if (guessWordLetters[j].equals(guessLetter)) {
                        guessPlaceHolder.set(j, guessLetter); // replace the underscore with the letter
                    }
                }
                printDetails();// print the updated list
                if (isWinner()) {
                    userWon =true;
                    break;
                }// check if user won then end game
            }
            else {
                ++wrongGuessCounter; // increment the counter by one
                Gallows.printGallows(); // print the gallows
                missedLetterList.add(guessLetter); // if wrong guess add letter to wrong list
                printDetails(); // print the updated list
            }
        }
        if (!userWon) { // check if user lost and display message
            System.out.println("Game Over! The word was " + guessWord);
        }
    }

    // method to check if the user wins
    public static boolean isWinner() {
        // check if they are same size
        if (guessPlaceHolder.size() != guessWordLetters.length) {
            return false;
        }

        // Compare each element if it does not equal in the other array
        for (int i = 0; i < guessPlaceHolder.size(); i++) {
            if (!guessPlaceHolder.get(i).equals(guessWordLetters[i])) {
                return false;
            }
        }
        System.out.println("Congrats You Guessed The Word! "+ guessWord);
        // All elements are equal return true
        return true;
    }
}



