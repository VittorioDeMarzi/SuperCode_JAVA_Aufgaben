package de.supercode;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /* 1. **Liste von Zahlen filtern**
            - Gegeben: Eine Liste von ganzen Zahlen.
            - Aufgabe: Filter alle geraden Zahlen aus der Liste.*/

        List<Integer> gerade = List.of(1,2,3,4,5,6,7,8,9,10,11,23,45,46,47,48,34,46,67,89,90,89,78,67,56,45,34,23,12,12).stream()
                .filter(n -> n%2 == 0)
                .toList();

        /* 2. **Liste von Zeichenketten in Großbuchstaben umwandeln**
            - Gegeben: Eine Liste von Zeichenketten.
            - Aufgabe: Wandele alle Zeichenketten in der Liste in Großbuchstaben um.*/

        List<String> listOfStrings = List.of("haus", "baum", "hund", "katze", "auto", "buch", "stuhl", "tisch", "fenster", "tür", "blume", "wasser", "feuer", "erde", "luft", "himmel", "sonne", "mond", "stern", "wolke");

        List<String> upperCase = listOfStrings.stream()
                .map(String::toUpperCase)
                .toList();

        /* 3. **Summe einer Liste von Zahlen berechnen**
            - Gegeben: Eine Liste von ganzen Zahlen.
            - Aufgabe: Berechne die Summe aller Zahlen in der Liste.*/

        List<Integer> listInteger = List.of(1,1,1,1,5,5,5, 5,9,5,11,23,45,5,47,48,34,46,67,5,90,5,78,5,56,45,5,23,12,12);
        long sum = listInteger.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum);

        /* 4. **Duplikate aus einer Liste entfernen**
            - Gegeben: Eine Liste von ganzen Zahlen mit Duplikaten.
            - Aufgabe: Entferne alle Duplikate aus der Liste.*/

        List<Integer> noDupicates = listInteger.stream()
                .distinct()
                .toList();
        // noDupicates.forEach(System.out::println);

        /* 5. **Durchschnitt einer Liste von Zahlen berechnen**
            - Gegeben: Eine Liste von ganzen Zahlen.
            - Aufgabe: Berechne den Durchschnittswert der Zahlen in der Liste.*/

        Double average = listInteger.stream()
                .mapToInt(Integer::intValue)
                .average().getAsDouble();
        System.out.println(average);

        /* 1. **Zeichenketten nach Länge sortieren**
            - Gegeben: Eine Liste von Zeichenketten.
            - Aufgabe: Sortiere die Zeichenketten nach ihrer Länge.*/

        List<String> stringList = List.of(
                "a", "auto", "hund", "baum", "haus", "buch", "stuhl", "tisch",
                "blume", "wasser", "feuer", "erde", "luft", "himmel", "sonne",
                "mond", "stern", "wolke", "fenster", "kuchen", "telefon"
        );

        List<String> ordered = stringList.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
        ordered.forEach(System.out::println);
    }
}