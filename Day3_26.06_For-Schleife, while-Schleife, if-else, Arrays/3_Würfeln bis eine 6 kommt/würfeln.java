/* Schreibe ein Programm, dass so lange Zufallszahlen würfelt und ausgibt, bis eine 6 gewürfelt wurde. Benutze dafür die Methode Math.random() aus der Java Math Standardbibliothek. 

Kleiner Tip: Achte auf den Wertebereich

Bonus: Wenn beim ersten Mal würfeln direkt die 6 erreicht wurde, soll eine Zusatzausgabe ( z.B. “WOW ! Beim ersten Treffer eine 6 ! ”) erscheinen:
javac Wuerfel.java
java Wuerfel
4
3
4
4
6 Glückwunsch
java Wuerfel
Glückwunsch: Hast du ein Glück 6 */

public class würfeln {
    public static void main(String[] args) {
        int min = 1;
        int max = 6;
        int range = max - min + 1;
        int dice = 0;
        
        do {
            dice = (int) (Math.random() * max) + 1;
            System.out.println(dice);
            
        } while (dice != 6);
    }
}