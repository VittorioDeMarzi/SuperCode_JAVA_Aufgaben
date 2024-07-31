package de.supercode;

//Write a program that reads a list of numbers and removes all duplicates by using a set.

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 2, 2, 3, 4, 3, 5, 3, 5, 4, 3, 2, 1 , 4, 6, 6));

        System.out.println("List1: " + list1);
        System.out.println("List1 after all duplicates were rempoved: " + removeDuplicates(list1));
    }

    private static List<Integer> removeDuplicates(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        return new ArrayList<>(set);
    }
}