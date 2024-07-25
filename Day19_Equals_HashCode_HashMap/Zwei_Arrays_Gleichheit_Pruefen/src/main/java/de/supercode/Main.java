package de.supercode;

// Überprüfe, ob zwei Arrays von Ganzzahlen die gleichen Elemente in derselben Häufigkeit enthalten, unabhängig von der Reihenfolge.

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] list1 = {1,1,1,1,1,3,3,3,4,4,4,4,5,5,5,5,5,6,6,6,6,6};
        int[] list2 = {1,1,1,1,1,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,6};

        System.out.println(haeufigkeitPruefen(list1, list2));
    }

    private static boolean haeufigkeitPruefen(int[] list1, int[] list2) {
        HashMap<Integer, Integer> list1Map = getCount(list1);
        HashMap<Integer, Integer> list2Map = getCount(list2);
        boolean result = true;
        for (Integer key : list1Map.keySet())
            if (list1Map.get(key) != list2Map.get(key)) {
                return false;
            }
        return true;
    }

    private static HashMap<Integer, Integer> getCount(int[] list) {
        HashMap<Integer, Integer> listMap = new HashMap<>();
        for (Integer num : list) {
            if (listMap.containsKey(num)) listMap.replace(num, listMap.get(num)+1);
            else listMap.put(num,1);
        }
        return listMap;
    }
}