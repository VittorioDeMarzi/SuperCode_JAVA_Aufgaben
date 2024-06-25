/* 3. **Absolute Zahl berechnen:** Schreibe ein Programm, das die absolute Zahl einer gegebenen Zahl berechnet und das Ergebnis ausgibt. */

public class Absolute {
    public static void main(String[] args) {
        int input = Integer.parseInt(args[0]);
        int output = Math.abs(input);
System.out.println(output);
    }
}