package de.supercode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        /* 1. **Liste von Listen zu einer einzigen Liste “flach machen”**
            - Gegeben: Eine Liste von Listen von ganzen Zahlen.
            - Aufgabe: Verwende `flatMap`, um eine flache Liste zu erstellen, die alle Zahlen enthält.*/

        List<List<Integer>> listOfLists = new ArrayList<>();
        List<Integer> lista1 = List.of(1, 2, 3, 4, 5);
        List<Integer> lista2 = List.of(6, 7, 8, 9, 10);
        List<Integer> lista3 = List.of(11, 12, 13, 14, 15);

        listOfLists.add(lista1);
        listOfLists.add(lista2);
        listOfLists.add(lista3);

        listOfLists.forEach(System.out::println);

        List<Integer> singleList = listOfLists.stream()
                .flatMap(Collection::stream)
                .toList();
        System.out.println(singleList);


        /* 2. **Zeichenketten in eine Liste von Wörtern aufteilen**
            - Gegeben: Eine Liste von Sätzen (Zeichenketten).
            - Aufgabe: Verwende `flatMap`, um eine Liste von einzelnen Wörtern zu erstellen.*/

        List<String> sentences = Arrays.asList(
                "Ich liebe es, neue Sprachen zu lernen.",
                "Der Himmel ist heute besonders klar.",
                "Kannst du mir bitte die Richtung zum Bahnhof zeigen?",
                "Wir gehen morgen ins Kino.",
                "Das Buch, das du mir empfohlen hast, war sehr interessant."
        );
        sentences.forEach(System.out::println);

        List<String> words = sentences.stream()
                .flatMap(str -> Arrays.stream(str.split(" ")))
                .toList();
        System.out.println(words);

        /* 3. **Filtern und flach machen einer Liste von Listen**
            - Gegeben: Eine Liste von Listen von ganzen Zahlen.
            - Aufgabe: Filter alle Zahlen, die größer als 5 sind.*/

        List<Integer> underFive = listOfLists.stream()
                .flatMap(Collection::stream)
                .filter(num -> num<=5)
                .toList();
        System.out.println(underFive);
    }
}