import java.util.Random;
import java.util.Scanner;

public class Hangman {
    
    private static final String[] deutscheWorte = {
        "Apfelbaum",
        "Schulbuch",
        "Wohnzimmer",
        "Autobahn",
        "Bürostuhl",
        "Küchentisch",
        "Fahrradhelm"};

    public static void main(String[] args) {
        String ratWort = randomWorld();
        System.out.println(ratWort);
        System.out.println();
    }
    
    private static String randomWorld() {
        Random random = new Random();
        int randomIndex = random.nextInt(deutscheWorte.length);
        return deutscheWorte[randomIndex];
    }

    public static String vortVerstechen(String wort) {
        int numBuchstaben = wort.length();
        String verstecht = "";
        for (int i = 0; i < numBuchstaben; i++) {
            verstecht += "_ ";
        }
        return verstecht;
    }

    private static String inputUser() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Boolean checkInput = checkInput(input);
        return input;
    }

    private static Boolean checkInput(String input) {
        boolean inputOutOfBound = userInput < 0 || userInput > 3;
        if (inputOutOfBound) {
            System.out.println("Ungültige Spielereingabe");
            continue;
        }
    }
    
}