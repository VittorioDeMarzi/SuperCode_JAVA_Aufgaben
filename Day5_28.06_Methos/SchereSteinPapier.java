import java.util.Random;
import java.util.Scanner;

public class SchereSteinPapier {
    public static void main(String[] args) {
        System.out.println("\nSCHERE STEIN SPIEL");

        Scanner scanner = new Scanner(System.in);
        boolean wantPlayMore = true;
        
        while (wantPlayMore) {
            System.out.println("Wähle: 0 = Schere, 1 = Stein, 2 = Papier, 3 = Beenden \n");
            int wahl = scanner.nextInt();
            if (wahl == 3) {
                break; // schleife abbrechen "exit"
            }
            playSpiel(wahl);
        }

        System.out.println("Spiel wird beendet");
        scanner.close();
    }

    
    
    private static void playSpiel(int wahl) {
        Random random = new Random();

        if (wahl < 0 || wahl > 3) {
            System.out.println("Ungültige Spielereingabe\n");
        } else {
            printPlayerChoice(wahl);
            int computerWahl = random.nextInt(3);
            printComputerChoice(computerWahl);
            checkWinning(wahl, computerWahl);            
        }
    }

    private static void checkWinning(int wahl, int computerWahl) {
        if (wahl == 0) {
            switch (computerWahl) {
                case 0 -> System.out.println("Das Spiel ist unentschieden.\n");
                case 1 -> System.out.println("Der Computer hat gewonnen.\n");
                case 2 -> System.out.println("Du hast gewonnen.\n");
            }
        } else if (wahl == 1) {
            switch (computerWahl) {
                case 0 -> System.out.println("Du hast gewonnen.\n");
                case 1 -> System.out.println("Das Spiel ist unentschieden.\n");
                case 2 -> System.out.println("Der Computer hat gewonnen.\n");
            }
        } else {
            switch (computerWahl) {
                case 0 -> System.out.println("Der Computer hat gewonnen.\n");
                case 1 -> System.out.println("Du hast gewonnen.\n");
                case 2 -> System.out.println("Das Spiel ist unentschieden.\n");
            }
        }
    }

    private static void printComputerChoice(int computerWahl) {
        switch (computerWahl) {
            case 0 -> System.out.println("Wahl des Computers: Schere");
            case 1 -> System.out.println("Wahl des Computers: Stein");
            default -> System.out.println("Wahl des Computers: Papier");
        }
    }

    private static void printPlayerChoice(int wahl) {
        switch (wahl) {
            case 0 -> System.out.println("Deine Wahl: Schere");
            case 1 -> System.out.println("Deine Wahl: Stein");
            case 2 -> System.out.println("Deine Wahl: Papier");
            // default -> System.out.println("Ungültige Spielereingabe");
        }
    }
}