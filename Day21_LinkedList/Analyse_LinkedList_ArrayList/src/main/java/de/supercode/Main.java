package de.supercode;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        long startTime;
        long endTime;
        int numElements = 10000000;

        /* 1_Warm-Up: Füge eine große Anzahl von Elementen zu beiden Listen hinzu, um eine "Warm-Up"-Phase zu simulieren. Dies dient dazu, den JIT-Compiler zu aktivieren und sicherzustellen, dass die Messungen nicht durch Initialisierungszeiten beeinflusst werden.*/
        warmUp(arrayList,linkedList);

        /* 2_Hinzufügen von Elementen: Füge eine große Anzahl von Elementen (mind. 1000000) zu beiden Listen hinzu und messe die Zeit, die für diese Operation benötigt wird.*/

        System.out.println("Hinzufügen von Songs...");

        // LinkedList hinzufügen
        startTime = System.currentTimeMillis();
        for (int i = 0; i < numElements; i++) {
            linkedList.add("Song " + i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("LinkedList - Hinzufügen von " + numElements + " Songs: " + (endTime - startTime) + " ms");

        // ArrayList hinzufügen
        startTime = System.currentTimeMillis();
        for (int i = 0; i < numElements; i++) {
            arrayList.add("Song " + i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("ArrayList - Hinzufügen von " + numElements + " Songs: " + (endTime - startTime) + " ms");

        /* 3_Hinzufügen eines Elements am Anfang: Füge ein Element am Anfang der Liste hinzu und messe die Zeit für diese Operation.*/
        startTime = System.currentTimeMillis();
        linkedList.addFirst("First Song");
        endTime = System.currentTimeMillis();
        System.out.println("LinkedList - Hinzufügen eines Elements am Anfang: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        arrayList.addFirst("First Song");
        endTime = System.currentTimeMillis();
        System.out.println("ArrayListList - Hinzufügen eines Elements am Anfang: " + (endTime - startTime) + " ms");

        /* 4_Entfernen eines Elements aus der Mitte: Entferne ein Element aus der Mitte der Liste und messe die Zeit für diese Operation.*/
        startTime = System.currentTimeMillis();
        linkedList.remove(70000);
        endTime = System.currentTimeMillis();
        System.out.println("LinkedList - Entferne ein Element aus der Mitte: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        arrayList.remove(70000);
        endTime = System.currentTimeMillis();
        System.out.println("ArrayListList - Entferne ein Element aus der Mitte: " + (endTime - startTime) + " ms");

        /* 5_Zugriff auf ein bestimmtes Element: Greife auf ein Element in der Mitte der Liste zu und messe die Zeit für diese Operation.*/
        startTime = System.currentTimeMillis();
        linkedList.get(70000);
        endTime = System.currentTimeMillis();
        System.out.println("LinkedList - Greife auf ein Element in der Mitte: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        arrayList.get(70000);
        endTime = System.currentTimeMillis();
        System.out.println("ArrayListList - Entferne ein Element aus der Mitte: " + (endTime - startTime) + " ms");

        /* 6_Iterieren durch die Liste: Iteriere durch alle Elemente der Liste und messe die Zeit für diese Operation.*/
        startTime = System.currentTimeMillis();
        for (int i = 0; i < numElements; i++) {
        }
        endTime = System.currentTimeMillis();
        System.out.println("LinkedList - Iteriere durch alle Elemente der Liste: " + (endTime - startTime) + " ms");

        // ArrayList hinzufügen
        startTime = System.currentTimeMillis();
        for (int i = 0; i < numElements; i++) {
        }
        endTime = System.currentTimeMillis();
        System.out.println("ArrayList - Iteriere durch alle Elemente der Liste: " + (endTime - startTime) + " ms");

        /* 7_Entfernen des ersten Elements: Entferne das erste Element der Liste und messe die Zeit für diese Operation.*/
        startTime = System.currentTimeMillis();
        linkedList.removeFirst();
        endTime = System.currentTimeMillis();
        System.out.println("LinkedList - Entferne das erste Element der Liste: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        arrayList.removeFirst();
        endTime = System.currentTimeMillis();
        System.out.println("ArrayListList - Entferne das erste Element der Liste: " + (endTime - startTime) + " ms");
    }



    private static void warmUp(ArrayList<String> arrayList, LinkedList<String> linkedList) {
        for (int i = 0; i < 10000; i++) {
            arrayList.add("Song " + i);
            linkedList.add("Song " + i);
        }
        arrayList.clear();
        linkedList.clear();
    }
}