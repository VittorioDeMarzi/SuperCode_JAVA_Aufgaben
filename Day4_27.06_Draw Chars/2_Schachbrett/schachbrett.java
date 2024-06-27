/* Schreibe ein Java-Programm, das ein Schachbrettmuster in der Konsole ausgibt.
Die Größe vom Schachbrett soll der Benutzer beim Programmaufruf mitgeben.
Ein Schachbrett besteht aus abwechselnden Zeichen "#" und " ", wobei die oberen linken Ecke immer eine "#" ist.
java DrawChessBoard 8 
# # # # 
 # # # #
# # # # 
 # # # #
# # # # 
 # # # #
# # # # 
 # # # #
*/

public class schachbrett {
    public static void main(String[] args) {
        int größe = Integer.parseInt(args[0]);

        if (größe%2==0) {
            for (int i = 0; i < größe/2; i++) {
                for (int j = 0; j < größe / 2; j++) {
                    System.out.print("#");
                    System.out.print(" ");
                }
                System.out.println("");
                for (int j = 0; j < größe / 2; j++) {
                    System.out.print(" ");
                    System.out.print("#");
                }
                System.out.println("");
            }    
        } else {
            System.out.println("Invalid number entered. Please enter an even number and try again!");
        }

        // Version 2
        
        System.out.println("___________ Version 2____________");
        for (int i = 0; i < größe; i++) {
            for (int j = 0; j < größe; j++) {
                char symbol = (j + i) % 2 == 0 ? '#' : ' ';
                System.out.print(symbol);
            }
            System.out.println("");
        }

    }
}