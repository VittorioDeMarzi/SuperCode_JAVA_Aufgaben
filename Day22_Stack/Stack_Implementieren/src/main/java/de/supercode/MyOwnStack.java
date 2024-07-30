package de.supercode;
import java.util.ArrayList;
import java.util.List;

public class MyOwnStack<E> {

    private List<E> list = new ArrayList<>();

    public void push(E item) {
        if (item == null) throw new IllegalArgumentException("Illegal Argument: Null.");
        list.add(item);
    }

    public E pop() {
        if (list.isEmpty()) {
            System.out.println("Stack is empty. Pop() not possible.");
            return null;
        }
        E elementToRemove = list.getLast();
        list.remove(elementToRemove);
        return elementToRemove;
    }

    public E peek() {
        if (list.isEmpty()) throw new IllegalArgumentException("Stack is empty. Peak() not possible.");
        return list.getLast();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public void clear() {
        list.clear();
    }
}
