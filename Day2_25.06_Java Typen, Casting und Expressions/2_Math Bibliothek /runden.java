/* 4. **Runden:** Schreibe ein Programm, das eine Gleitkommazahl auf eine bestimmte Anzahl von Dezimalstellen rundet und das Ergebnis ausgibt. */

public class runden {
    public static void main(String[] args) {
        double input = Double.parseDouble(args[0]);
        double output = Math.round(input);
        System.out.println(output);
    }
}
