package de.supercode;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Erstellen eines neuen HashSets
        Set<Integer> set = new HashSet<>();

        // Elemente zum Set hinzufügen
        set.add(5);
        set.add(10);
        set.add(15);
        set.add(5); // Duplikate werden nicht hinzugefügt

        // Überprüfen, ob das Set leer ist
        System.out.println("Ist das Set leer? " + set.isEmpty());

        // Anzeigen der Elemente des Sets
        System.out.println("Elemente im Set: " + set);

        // Überprüfen, ob ein bestimmtes Element im Set enthalten ist
        System.out.println("Enthält das Set die Zahl 10? " + set.contains(10));

        // Entfernen eines Elements aus dem Set
        set.remove(10);
        System.out.println("Enthält das Set die Zahl 10 nach dem Entfernen? " + set.contains(10));

        // Anzeigen der Größe des Sets
        System.out.println("Größe des Sets: " + set.size());

        // Iterieren über die Elemente des Sets
        System.out.println("Iterieren über die Elemente des Sets:");
        for (Integer num : set) {
            System.out.println(num);
        }

        // Löschen des Sets
        set.clear();
        System.out.println("Ist das Set leer nach dem Löschen? " + set.isEmpty());


        // Arbeiten mit einem zweiten Set und der retainAll-Methode
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);

        // Behalte nur die gemeinsamen Elemente in set1
        set1.retainAll(set2);
        System.out.println("Set 1: " + set1);

    }
}