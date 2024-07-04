public class HanoiTowers {
    public static void main(String[] args) {
        int numDiscs = 4;
        double numMoves = Math.pow(2, numDiscs) - 1;
        System.out.printf("Number discs: %s  ---> Number of moves required: %s%n", numDiscs, (int) numMoves);
        String start = "A";
        String destination = "B";
        String auxilliary = "C";
        
        hanoi(numDiscs, start, destination, auxilliary);
    }
    
    private static void hanoi(int disk, String start, String end, String aux) {
        if (disk == 1) {
            move(disk, start, end);
        } else {
            hanoi(disk - 1, start, aux, end);
            move(disk, start, end);
            hanoi(disk -1, aux, end, start);
        }
    }
    
    private static void move(int disk, String start, String end) {
        System.out.printf("Verschiebe Scheibe %s von %s nach %s", disk, start, end);
    }
}
