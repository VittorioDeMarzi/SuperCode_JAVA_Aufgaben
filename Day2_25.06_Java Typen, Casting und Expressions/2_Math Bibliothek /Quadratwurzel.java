/* Hier sind einige Übungsaufgaben, um die Verwendung der Klasse **`java.lang.Math`** in Java zu üben:

1. **Quadratwurzel berechnen:** Schreibe ein Programm, das die Quadratwurzel einer gegebenen Zahl berechnet und das Ergebnis ausgibt.

6. **Natürlicher Logarithmus berechnen:** Schreibe ein Programm, das den natürlichen Logarithmus einer gegebenen Zahl berechnet und das Ergebnis ausgibt. */

public class Quadratwurzel {
 public static void main(String[] args) {
     double input = Double.parseDouble(args[0]);
     double quadratwurzel = Math.sqrt(input);
     System.out.println(quadratwurzel);
 }
}