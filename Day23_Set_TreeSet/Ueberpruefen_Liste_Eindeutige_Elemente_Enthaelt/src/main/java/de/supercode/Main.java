package de.supercode;

// Schreibe ein Programm, das überprüft, ob eine Liste nur eindeutige Elemente enthält.

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 2, 2, 3, 4, 3, 5, 3, 5, 4, 3, 2, 1 , 4, 6, 6));
        List<Integer> list2 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

        System.out.println("List1: " + list1);
        System.out.println("Does list1 contains only unique elements? " + hasListUniqueElements(list1));
        System.out.println("List2: " + list2);
        System.out.println("Does list2 contains only unique elements? " + hasListUniqueElements(list2));
    }

    private static boolean hasListUniqueElements(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        return set.size() == list.size();
    }
}