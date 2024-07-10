import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random casual = new Random();
        
        // ArrayList erstellen und Elemente hinzufügen:
        ArrayList<Integer> al = new ArrayList<>(List.of(1, 2, 3, 4, 5));

        // Entferne die Zahl 3 aus der Liste.
        al.remove(3);

        // Gib die Größe der Liste aus.
        al.size();

        System.out.println(al.get(1));

        // Verwende eine Schleife, um alle Elemente in der Liste auszugeben.
        for (int i : al)
            System.out.println(i);
        
        // Füge weitere Zahlen zur Liste hinzu und sortiere die Liste in aufsteigender Reihenfolge.
        for (int i = 0; i < 10; i++) {
            al.add(casual.nextInt(30));
        }

        for (int i : al)
            System.out.print(i + " ");
        System.out.println();
        al.sort(null);
        for (int i : al)
            System.out.print(i + " ");
        System.out.println();

        // Überprüfe, ob die Liste die Zahl 4 enthält.
        System.out.println(al.contains(4));

        // Erstelle eine neue ArrayList, die nur die ersten 3 Elemente der ursprünglichen Liste enthält.
        ArrayList<Integer> newList = new ArrayList<>(al.subList(0, 3));
        System.out.println(newList.toString());

        ArrayList<Integer> newListSingleElements = new ArrayList<>();
        for (int i : al)
            if (!newListSingleElements.contains(i))
                newListSingleElements.add(i);
        
        System.out.println(newListSingleElements.toString());

        // Dir ist ein Array mit Integer Zahlen gegeben: 
        // int[] data = {1, 5, 6, 11, 3, 15, 7, 8, 12, 21, 9, 1038};
        // Teile dieses Array auf in zwei ArrayListen auf, eine für alle geraden Zahlen und eine für alle ungeraden Zahlen.

        ArrayList<Integer> gerade = new ArrayList<>();
        ArrayList<Integer> ungerade = new ArrayList<>();
        int[] data = { 1, 5, 6, 11, 3, 15, 7, 8, 12, 21, 9, 1038 };
        for (int num : data) {
            if (num % 2 == 0)
                gerade.add(num);
            else
                ungerade.add(num);
        }
        System.out.println(gerade.toString());
        System.out.println(ungerade.toString());
    }

}
