/* Schreibe ein Programm:

- das die Summe der Zahlen von 1 bis 100 berechnet und ausgibt */

public class zahlen {
    public static void main(String[] args) {
        int summe = 0;
        for (int i = 1; i <= 100; i++) {
            summe += i;
            System.out.println(summe);
        }
    }
}