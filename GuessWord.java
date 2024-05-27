
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GuessWord {

    private Gallows gallow;
    public static final String[] WORDS = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel", "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer", "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat", "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose", "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", "python", "rabbit", "ram", "rat", "raven", "rhino", "salmon", "seal", "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan", "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf", "wombat", "zebra"};
    public final Scanner INPUT_SCANNER = new Scanner(System.in);
    public static final int MAX_GUESS_TRIES = 6; // hangman game ends after 6 wrong tries

    public final String guessWord = generateRandomWord(); // generate a random word
    public int wrongGuessCounter = 0; // keep track of what gallows to print
    public boolean userWon = false; // used to check winner

    public GuessWord() {
        gallow = new Gallows(this);
    }

    public String generateRandomWord() {
        int randomNumber = (int) (Math.random() * WORDS.length);
        return WORDS[randomNumber];
    }

    // make an array of the word letters
    public final String[] GUESS_WORD_LETTERS = guessWord.split("");
    // create a list for the word placeholder
    public ArrayList<String> guessPlaceHolder = new ArrayList<>();
    // create a list for the wrong letter guesses
    public ArrayList<String> missedLetterList = new ArrayList<>(MAX_GUESS_TRIES);

    // method to fill the place holder list with empty underscores
    public void fillPlaceHolders() {
        for (int i = 0; i < guessWord.length(); i++) {
            this.guessPlaceHolder.add("_");
        }
        gallow.printGallows(); // print the default gallows
    }

    // method to print shit
    public void printDetails() {
        System.out.println("Word Letters:" + guessPlaceHolder);
        System.out.println("Missed Letters: " + missedLetterList);
        System.out.println("Guess Letter: ");

    }

    public void runGame() {
        fillPlaceHolders();
        printDetails();
        for (int i = 0; i < MAX_GUESS_TRIES; i++) {
            String guessLetter = INPUT_SCANNER.next(); // get user letter guess

            // make sure user only provides one letter
            while (guessLetter.length() != 1) {
                System.out.println("Invalid Input, please only type ONE letter");
                guessLetter = INPUT_SCANNER.next();
            }

            // check if the word includes the guess letter
            if (Arrays.asList(GUESS_WORD_LETTERS).contains(guessLetter)) {
                System.out.println("Correct guess ");
                --i; // if the user has a correct guess he keeps going so we decrement i by one

                // loop over the letters array and check if it includes the guess letter
                for (int j = 0; j < GUESS_WORD_LETTERS.length; j++) {
                    if (GUESS_WORD_LETTERS[j].equals(guessLetter)) {
                        guessPlaceHolder.set(j, guessLetter); // replace the underscore with the letter
                    }
                }
                printDetails();// print the updated list
                if (isWinner()) {
                    userWon = true;
                    break;
                }// check if user won then end game
            }
            else {
                ++wrongGuessCounter; // increment the counter by one
                gallow.printGallows(); // print the gallows
                missedLetterList.add(guessLetter); // if wrong guess add letter to wrong list
                printDetails(); // print the updated list
            }
        }
        if (!userWon) { // check if user lost and display message
            System.out.println("You Have Been Hnaged! The word was " + guessWord);
        }
    }

    // method to check if the user wins
    public boolean isWinner() {
        // check if they are same size
        if (guessPlaceHolder.size() != GUESS_WORD_LETTERS.length) {
            return false;
        }

        // Compare each element if it does not equal in the other array
        for (int i = 0; i < guessPlaceHolder.size(); i++) {
            if (!guessPlaceHolder.get(i).equals(GUESS_WORD_LETTERS[i])) {
                return false;
            }
        }
        System.out.println("Congrats You Guessed The Word! " + guessWord);
        // All elements are equal return true
        return true;
    }
}



