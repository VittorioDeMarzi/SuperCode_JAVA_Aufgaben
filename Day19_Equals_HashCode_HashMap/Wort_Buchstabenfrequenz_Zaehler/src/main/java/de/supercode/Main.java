package de.supercode;

/*Erstelle zwei Methoden:
        - a) eine, die die Häufigkeit jedes Buchstabens in einem String zählt
        - b) eine, die die Häufigkeit jedes Wortes in einem gegebenen Text zählt */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String string1 = "Hallo mein Name ist Vittorio";
        haeufigkeitJedesBuchstabens(string1);

        String text1 = "A HashMap HashMap HashMap in Java is a powerful powerful powerful powerful data structure used to store key-value pairs. HashMap provides fast access and and and and modification by using hashing. This hashing technique ensures efficient lookups and insertions. Although HashMap offers speed and efficiency, it does not maintain any order of its entries. Understanding the nature of HashMap is crucial for using it effectively in various applications and scenarios where order is not important.";
        haeufigkeitJedesWortes(text1);
    }

    private static void haeufigkeitJedesWortes(String text) {
        HashMap<String, Integer> wordCounter = new HashMap<>();
        String[] alleWorteInText = getWorteAusText(text);
        for (String str : alleWorteInText) {
            if (!wordCounter.containsKey(str)) wordCounter.put(str, 1);
            else wordCounter.replace(str, wordCounter.get(str)+1);
        }
        printMap(wordCounter);
    }

    private static void printMap(HashMap<String, Integer> wordCounter) {
        wordCounter.forEach((key,value) -> System.out.println(key + " " + value));
    }

    private static String[] getWorteAusText(String txt) {
        if (txt.isEmpty()) throw new IllegalArgumentException("Text is empty");
        String text = txt.toLowerCase().replaceAll("[^a-z]", " ");
        return text.split(" ");
    }

    public static void haeufigkeitJedesBuchstabens (String str) {
        String string = str.toLowerCase();
        HashMap<Character, Integer> buchstabenZahl = new HashMap<>();
        for (int i=0; i<string.length();i++) {
            if (!buchstabenZahl.containsKey(string.charAt(i))) buchstabenZahl.put(string.charAt(i),1);
            else buchstabenZahl.replace(string.charAt(i), buchstabenZahl.get(string.charAt(i))+1);
        }
        System.out.println("Häufigkeit jedes Buchstabens in the string (" + str + ")");
        buchstabenZahl.forEach((key, value) -> System.out.println(key + ": '" + value + "'"));
    }
}