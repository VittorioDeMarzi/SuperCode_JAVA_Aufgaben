package de.supercode;

//- Nutze für folgende Aufgaben eine `forEach` mit Lambda-Ausdrücken
//- Experimentiere mit verschiedenen Listen und Lambda-Ausdrücken, um ein besseres Verständnis zu erlangen

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Stream.concat;

public class Main {
    public static void main(String[] args) {

//         1 Aufgabe: Zeichenketten-Konkatenation:
//         Gegeben ist eine Liste von Zeichenketten. Konkateniere alle Zeichenketten in der Liste zu einer einzigen Zeichenkette und gebe das Ergebnis aus.

        List<String> zeichenkette = new ArrayList<>(List.of("Hi",", ", "", "mein", " ", "Name", " ", "ist", " ", "Vittorio", "!!!"));
        StringBuilder newString = new StringBuilder();

        zeichenkette.forEach(newString::append);
        System.out.println("1 Aufgabe: Zeichenketten-Konkatenation: " + newString);
        System.out.println("================================================================");

//        Aufgabe: Quadratzahlen:
//        Gegeben ist eine Liste von ganzen Zahlen. Berechnen Sie das Quadrat jeder Zahl und geben Sie die Quadratzahlen aus

        List<Integer> zahlen = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        System.out.println("2 Aufgabe: Quadratzahlen von " + zahlen);
        zahlen.forEach(num -> System.out.print(Math.pow(num, 2) + "  "));
        System.out.println();
        System.out.println("================================================================");

//        Länge der Zeichenketten:
//        Gegeben ist eine Liste von Zeichenketten. Gebe die Länge jeder Zeichenkette in der Liste aus.
        List<String> list = new ArrayList<>(List.of("Hi", "mein", "Name",  "ist", "Vittorio", "!!!"));
        System.out.println("3 Länge der Zeichenketten: " + list);
        list.forEach(str -> System.out.println("[" + str + "] - length: " + str.length()));
    }
}