import java.util.Scanner;

public class ErweiterungSchereSteinPapier {

    public static final int SCHERE = 0;
    public static final int STEIN = 1;
    public static final int PAPIER = 2;
    public static final int BEENDEN = 3;

    public static int computerPoint = 0;
    public static int userPoint = 0;
    private static int unentschieden = 0;

    public static void main(String[] args) {
        System.out.println("\nSCHERE STEIN SPIEL");

        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Wähle: 0 = Schere, 1 = Stein, 2 = Papier, 3 = Beenden \n");

            int userInput = scanner.nextInt();

            if (userInput == BEENDEN) {
                System.out.println("Spiel wird beendet");
            System.out.println("_ENDESTAND_");
                printCurrentStand(userPoint, computerPoint, unentschieden);
                break; // schleife abbrechen "exit"
            }
            boolean inputOutOfBound = userInput < 0 || userInput > 3;
            if (inputOutOfBound) {
                System.out.println("Ungültige Spielereingabe");
                continue;
            }
            int computerChoice = (int) (Math.random() * 3);
            printChoices(userInput, computerChoice);
            checkWinner(userInput, computerChoice);
            printCurrentStand(userPoint, computerPoint, unentschieden);
        }       
        scanner.close();
    }

    private static void printCurrentStand(int userPoint, int computerPoint, int unentschieden) {
        System.out.printf("Spieler: %s; Computer: %s; unentschieden: %s%n%n", userPoint, computerPoint, unentschieden);
    }

    private static void checkWinner (int userInput, int computerChoice) {
        if (userInput == computerChoice) {
            System.out.println("Das Spiel ist unentschieden.\n");
            unentschieden += 1;
        }
        else if  (userInput == STEIN && computerChoice == SCHERE || userInput == PAPIER && computerChoice == STEIN || userInput == SCHERE && computerChoice == PAPIER) {
            System.out.println("Du hast gewonnen.\n");
            userPoint += 1;
        } else {
            System.out.println("Der Computer hat gewonnen.\n");
            computerPoint += 1;
        }
    }
    
    private static void printChoices(int userInput, int computerChoice) {
        System.out.println("Dein choice: " + choiceToString(userInput));
        System.out.println("Computer choice: " + choiceToString(computerChoice));
    }

    private static String choiceToString(int input) {
        String[] choices = { "Schere", "Stein", "Papier" };
        return choices[input];
    }
}