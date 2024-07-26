package de.supercode;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String str1 = "abcdabcdabcd";
        String str2 = "dcbaadcbcabd";
        anagrammPruefen(str1, str2);
    }

    private static void anagrammPruefen(String str1, String str2) {
        HashMap<Character, Integer> str1Map = getLettersMap(str1);
        HashMap<Character, Integer> str2Map = getLettersMap(str2);

        if (str1Map.size() != str2Map.size()) {
            System.out.println("Strings are not an anagram!!");
            return;
        }
        for (Character c : str1Map.keySet()) {
            if (str1Map.get(c) != str2Map.get(c)) {
                System.out.println("Strings are not an anagram!!");
                return;
            }
        }
        System.out.println("Strings are anagrams with the following letters count:");
        printHashMap(str1Map);
    }

    private static void printHashMap(HashMap<Character, Integer> map) {
        map.forEach((key,value) -> System.out.println(key + " - " + value));
    }

    private static HashMap<Character, Integer> getLettersMap(String str) {
        HashMap<Character, Integer> buchstabenZahl = new HashMap<>();
        for (int i=0; i<str.length();i++) {
            if (!buchstabenZahl.containsKey(str.charAt(i))) buchstabenZahl.put(str.charAt(i),1);
            else buchstabenZahl.replace(str.charAt(i), buchstabenZahl.get(str.charAt(i))+1);
        }
        return buchstabenZahl;
    }
}