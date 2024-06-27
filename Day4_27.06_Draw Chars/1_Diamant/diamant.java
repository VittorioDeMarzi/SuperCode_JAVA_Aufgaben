/* Schreibe ein Programm, welches Diamanten in Form von Sternchen (*) in der Konsole ausgibt. Die Größe der Diamanten soll der Benutzer beim Programmaufruf mitgeben. */


public class diamant {
    public static void main(String[] args) {
        int größe = Integer.parseInt(args[0]);
        
        if (größe %2 == 0) {
            System.out.println("Invalid number entered. Please enter an odd number and try again!!!!");
        } else {
            int halfGröße = (int) (größe / 2);
            int offset = halfGröße;
            int symbol = 1;

            for (int i = 0; i < halfGröße; i++) {
                for (int j = 0; j < offset; j++) {
                    System.out.print(" ");
                }
                offset--;
                for (int k = 0; k < symbol; k++) {
                    System.out.print("*");
                }
                symbol += 2;
                System.out.print("\n");
            }

            for (int i = 0; i <= halfGröße; i++) {
                for (int j = 0; j < offset; j++) {
                    System.out.print(" ");
                }
                offset++;
                for (int k = 0; k < symbol; k++) {
                    System.out.print("*");
                }
                symbol -= 2;
                System.out.print("\n");

            }
        }







    }
}