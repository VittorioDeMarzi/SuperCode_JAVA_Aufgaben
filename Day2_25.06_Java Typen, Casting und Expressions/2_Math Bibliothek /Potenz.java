/* 2. **Potenz berechnen:** Schreibe ein Programm, das die Potenz einer Basis zur Exponentiation berechnet und das Ergebnis ausgibt. 
*/

public class Potenz {
    public static void main(String[] args) {
        int input = Integer.parseInt(args[0]);
        int potenz = Integer.parseInt(args[1]);
        System.out.println(Math.pow(input, potenz));
    }
}
