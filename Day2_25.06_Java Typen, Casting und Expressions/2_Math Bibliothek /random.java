/* 5.**Zufällige Zahl generieren:**Schreibe ein Programm,das eine zufällige Ganzzahl oder Gleitkommazahl innerhalb eines bestimmten Bereichs generiert und das Ergebnis ausgibt. */

public class random {
    public static void main(String[] args) {
        int input = Integer.parseInt(args[0]);
        int random = (int) (Math.random() * input);
        System.out.println("Random number: " + random);

    }
}
