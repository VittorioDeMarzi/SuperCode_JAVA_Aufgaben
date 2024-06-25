/* In einem Bekleidungsgeschäft gibt es aktuell 40 % auf alles. Schreibe ein Programm, welches 40% vom Preis abzieht. Ausgegeben werden soll der neue Preis als double mit nur zwei Nachkommastellen.
Einen möglichen Programmaufruf siehst du hier:
 - javac Rabatt.java
 - java Rabatt 119.99
 - Rabattierter Preis: 71.99 €     // nicht 71.994 */

public class bekleidungsgeschäft {
    public static void main(String[] args) {
        double input = Double.parseDouble(args[0]);
        double discount = input / 100 * 40;
        double output = input - discount;
        System.out.printf("Rabattierter Preis: %.2f €", output);

    }
 }