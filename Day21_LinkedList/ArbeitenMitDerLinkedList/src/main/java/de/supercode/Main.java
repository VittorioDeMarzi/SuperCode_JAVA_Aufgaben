package de.supercode;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> students = new LinkedList<>(List.of("Alice", "Bob", "Charlie", "Diana", "Eva"));

        students.addFirst("Zara");

        students.addLast("fred");

        System.out.println(students.getFirst());
        System.out.println(students.getLast());
        System.out.println(students.get(2));

        students.removeFirst();
        students.removeLast();
        students.remove(1);

        System.out.println(students.contains("Alice"));
        System.out.println(students.contains("Eva"));
        System.out.println(students.indexOf("Charlie"));

        for (String str : students) {
            System.out.println(str);
        }

        LinkedList<String> newStudents = new LinkedList<>(List.of("George", "Hanna"));

        students.addAll(newStudents);
        students.sort(null);
        System.out.println(students);

        int k = 5;
        String kthElementFromEnd = getKthElementFromEnd(students, k);

        System.out.println(kthElementFromEnd);

    }

    private static String getKthElementFromEnd(LinkedList<String> linkedList, int k) {
        if (k > linkedList.size() || k<=0 || linkedList.isEmpty()) throw new IllegalArgumentException("Index out of bound");

        return linkedList.get(linkedList.size() - k);
    }
}