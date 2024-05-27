public class Gallows {
    private GuessWord guessWord;

    public Gallows(GuessWord guessWord) {
        this.guessWord = guessWord;
    }

    public void printGallows() {
        switch (guessWord.wrongGuessCounter) {
            case 0:
                System.out.println("+---+\n" +
                        "|   |\n" +
                        "    |\n" +
                        "    |\n" +   //if the user didn't miss any guesses.
                        "    |\n" +
                        "    |\n" +
                        "=========\n");
                break;
            case 1:
                System.out.println("+---+\n" +
                        "|   |\n" +
                        "O   |\n" +   //if the user missed one guess.
                        "    |\n" +
                        "    |\n" +
                        "    |\n" +
                        "=========\n");
                break;
            case 2:
                System.out.println("+---+\n" +
                        "|   |\n" +
                        "O   |\n" +    //if the user missed two guesses.
                        "|   |\n" +
                        "    |\n" +
                        "    |\n" +
                        "=========\n");
                break;
            case 3:
                System.out.println(" +---+\n" +
                        " |   |\n" +
                        " O   |\n" +   //if the user missed three guesses.
                        "/|   |\n" +
                        "     |\n" +
                        "     |\n" +
                        " =========\n");
                break;
            case 4:
                System.out.println(" +---+\n" +
                        " |   |\n" +
                        " O   |\n" +
                        "/|\\  |\n" +   //if the user missed four guesses.
                        "     |\n" +
                        "     |\n" +
                        " =========\n");
                break;
            case 5:
                System.out.println(" +---+\n" +
                        " |   |\n" +
                        " O   |\n" +
                        "/|\\  |\n" +  //if the user missed five guesses.
                        "/    |\n" +
                        "     |\n" +
                        " =========\n");
                break;
            case 6:
                System.out.println(" +---+\n" +
                        " |   |\n" +
                        " O   |\n" +
                        "/|\\  |\n" +   //if the user missed six guesses.
                        "/ \\  |\n" +
                        "     |\n" +
                        " =========\n");
                break;
        }
    }

}
