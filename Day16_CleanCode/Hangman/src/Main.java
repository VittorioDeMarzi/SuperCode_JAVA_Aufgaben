import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    // ANSI escape codes for background colors
    public static final String ANSI_BG_RED = "\u001B[41m";
    public static final String ANSI_BG_BLUE = "\u001B[44m";
    public static final String ANSI_RESET = "\u001B[0m";

    // ANSI escape codes for colors
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLACK = "\u001B[30m";

    private static int remainingAttempts = 6;
    private static ArrayList<Character> guessedLetters = new ArrayList<>();
    private static int missingLettersCounter;

    private static final String EXIT = "1";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> words = new ArrayList<>(List.of(
                "apple", "bicycle", "cat", "dog", "elephant", "flower", "guitar", "house", "ice", "jungle",
                "kangaroo", "lemon", "mountain", "night", "ocean", "piano", "queen", "river", "sun", "tree",
                "umbrella", "violin", "whale", "xylophone", "yacht", "zebra", "cloud", "drum", "fire", "garden"
        ));

        String wordToGuess = pickARandomWord(words);
        missingLettersCounter = calculateNumberOfLetters(wordToGuess);

        System.out.println(ANSI_BG_BLUE + ANSI_BLACK + "Get ready to play Hangman! It's time to guess the word before the stick figure meets its fate!"+ ANSI_RESET);
        System.out.println("At any time, press 1 to exit.");
        String hiddenWord = hideWordToGuess(wordToGuess);


        while (true) {
            System.out.println("\nWord to Guess: " + hiddenWord);
            System.out.println("Remaining Attempts: " + remainingAttempts);
            System.out.println("Guessed Letters: " + guessedLetters);
            System.out.println("Please enter a letter: ");

            String userInput = scanner.nextLine();

            if (userInput.equals(EXIT)) {
                System.out.println("The game has been ended.");
                break;
            }

            // boolean InputIsALetter = userInput.length()==1 && ((Character.isLetter(userInput)) || (userInput.indexOf(0) >= 97 && userInput.indexOf(0) <= 122));
            boolean InputIsALetter = Character.isLetter(userInput.charAt(0)) && userInput.length()==1;
            if (!InputIsALetter) {
                System.out.println(ANSI_RED + "Invalid player input" + ANSI_RESET);
                continue;
            }

            if (guessedLetters.contains(userInput.charAt(0))) {
                System.out.println(ANSI_RED + "you've already guessed this letter" + ANSI_RESET);
                continue;
            }

            guessedLetters.add(userInput.charAt(0));
            boolean letterIsInWord = isLetterInWord(wordToGuess, userInput);
            if (letterIsInWord) {
                hiddenWord = revealGuessedLetter(wordToGuess, hiddenWord, userInput);
                missingLettersCounter--;
                if (missingLettersCounter == 0) {
                    System.out.println(ANSI_GREEN + "Congratulations, you won! You saved the hangman from a sticky situation!\n\tGuessed Word: " + wordToGuess + ANSI_RESET);
                    break;
                }
                continue;
            } else remainingAttempts--;

            if (remainingAttempts == 0) {
                System.out.println(ANSI_BG_RED + "Oh no, you lost! The hangman has been hung! Better luck next time!"+ ANSI_RESET);
                break;
            }
        }
        scanner.close();
    }

    private static void isInputAccetable(String userInput) {
    }

    private static int calculateNumberOfLetters(String wordToGuess) {
        int counter = 0;
        ArrayList<Character> letters =new ArrayList<>();
        for (int i=0; i<wordToGuess.length(); i++) {
            if (!letters.contains(wordToGuess.charAt(i))) {
                counter++;
                letters.add(wordToGuess.charAt(i));
            } else {
                continue;
            }
        }
        return counter;
    }

    private static String revealGuessedLetter(String wordToGuess,String hiddenWord, String userInput) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == userInput.charAt(0)) sb.append(userInput.charAt(0));
            else sb.append(hiddenWord.charAt(i));
        }
        return sb.toString();
    }

    private static boolean isLetterInWord(String wordToGuess, String userInput) {
        return wordToGuess.contains(userInput);
    }

    private static String hideWordToGuess(String wordToGuess) {
        return "_".repeat(wordToGuess.length());
    }

    private static String pickARandomWord(ArrayList<String> words) {
        Random random = new Random();
        return words.get(random.nextInt(30));
    }
}