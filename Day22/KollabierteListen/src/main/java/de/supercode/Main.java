package de.supercode;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> original = new LinkedList(List.of(1,1,1,2,2,2,3,3,3,4,4,4,1,2));

        System.out.println("Original List: " + original);
        LinkedList<Integer> collapsed = collapseDuplicates(original);
        System.out.println("Collapsed List: " + collapsed);
    }

    private static LinkedList<Integer> collapseDuplicates(LinkedList<Integer> original) {
        if (original.isEmpty()) throw new IllegalStateException();
        LinkedList<Integer> newList = new LinkedList<>();
        newList.add(original.getFirst());
        for (int k=0; k<original.size();k++) {
            if (newList.getLast() != original.get(k)) newList.add(original.get(k));
        }
        return newList;
    }
}