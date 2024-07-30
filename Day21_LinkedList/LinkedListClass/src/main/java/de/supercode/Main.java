package de.supercode;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> myList = new MyLinkedList<>();
        MyLinkedList<Integer> myList2 = new MyLinkedList<>();

        myList.printList();

        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);
        myList.add(7);

        System.out.println();
        System.out.println(myList.getSize());
        System.out.println(myList2.getSize());
        System.out.println();

        myList.printList();

        System.out.println();
        System.out.println("Add element at index");
        myList.add(0, 1000);

        myList.printList();
        System.out.println();

        System.out.println("remove index 0");
        myList.remove(3);
        myList.printList();
        System.out.println();

        System.out.println(myList.get(1));
        System.out.println(myList.get(0));
        System.out.println(myList.get(6));
        System.out.println();

        System.out.println(myList.isEmpty());
        System.out.println(myList2.isEmpty());
        System.out.println();

        myList.reverse();
        myList.printList();
        System.out.println();
    }

}