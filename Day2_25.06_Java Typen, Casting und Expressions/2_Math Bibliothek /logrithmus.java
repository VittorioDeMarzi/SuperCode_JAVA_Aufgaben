/* 6. **Natürlicher Logarithmus berechnen:** Schreibe ein Programm, das den natürlichen Logarithmus einer gegebenen Zahl berechnet und das Ergebnis ausgibt. */

public class logrithmus {
    public static void main(String[] args) {
        double input = Double.parseDouble(args[0]);
        double output = Math.log(input);
        System.out.printf("Log %s= %s",  input, output);
    }
}
