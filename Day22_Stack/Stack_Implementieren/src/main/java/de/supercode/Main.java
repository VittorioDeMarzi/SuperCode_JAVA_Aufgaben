package de.supercode;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        // Erstellen eines neuen Stacks
        MyOwnStack<Integer> myStack = new MyOwnStack<>();
        Stack<Integer> stack = new Stack<>();

        // Elemente zum Stack hinzufügen
        myStack.push(5);
        myStack.push(10);
        myStack.push(15);

        // Überprüfen, ob der Stack leer ist
        System.out.println("Ist der Stack leer? " + myStack.isEmpty());

        // Anzeigen des obersten Elements des Stacks, ohne es zu entfernen
        System.out.println("Oberstes Element des Stacks: " + myStack.peek());

        // Entfernen und Rückgabe des obersten Elements des Stacks
        int poppedElement = myStack.pop();
        System.out.println("Entferntes Element: " + poppedElement);

        // Anzeigen der Größe des Stacks
        System.out.println("Größe des Stacks: " + myStack.size());

        // Löschen des Stacks
        myStack.clear();
        System.out.println("Ist der Stack leer nach dem Löschen? " + myStack.isEmpty());
    }
}