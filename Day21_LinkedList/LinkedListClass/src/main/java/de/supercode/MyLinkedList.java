package de.supercode;

public class MyLinkedList<E> {

    private int size;
    private Node<E> node;

    public MyLinkedList() {
        this.node = null;
        setSize();
    }

    private void setSize() {
        this.size = getSize();
    }

    public int getSize() {
        if (node == null) {
            return 0;
        } else {
            Node<E> current = node;
            int count = 1;
            while (current.getNext() != null) {
                current = current.getNext();
                count++;
            }
            return count;
        }
    }

    public void add(E data) {
        Node<E> newNode = new Node<>(data);
        if (node == null) {
            node = newNode;
        } else {
            Node<E> current = node;
            while (current.getNext() != null)
                current = current.getNext();
            current.setNext(newNode);
        }
    }

    public void add(int index, E data) {
        if (index < 0 || index >= getSize()) throw new IllegalArgumentException("Out of Bound. Invalid Index");
        Node<E> newNode = new Node<>(data);

        Node<E> current = node;
        for (int i=1; i<index; i++) {
            current = current.getNext();
        }
        newNode.setNext(current.getNext());
        current.setNext(newNode);
    }

    public void remove(int index) {
        if (node == null || index < 0 || index >= getSize()) throw new IndexOutOfBoundsException();
        Node<E> current = node;
        for (int i=1; i<index; i++) {
            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());
    }

    public E get(int index) {
        if (node == null || index < 0 || index >= getSize()) throw new IndexOutOfBoundsException();
        Node<E> current = node;
        for (int i=0; i<index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public void reverse() {
        if (node == null) throw new IllegalStateException("Linked List is empty");
        int index = 0;

    }

    public void printList() {
        if (node == null) System.out.println("List is Empty");
        Node<E> current = node;
        int index = 0;
        while (current != null) {
            System.out.println("Element [" + index + "] = " + current.getData());
            current = current.getNext();
            index++;
        }
    }
}
