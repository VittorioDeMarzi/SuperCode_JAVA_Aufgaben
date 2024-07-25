package de.supercode;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Buch harryPotter1a = new Buch("Harry Potter und der Stein der Weisen", "J.K. Rowling", "978-3-551-55656-6");
        Buch harryPotter1b = new Buch("Harry Potter und der Stein der Weisen", "J.K. Rowling", "978-3-551-55657-3");
        Buch harryPotter2 = new Buch("Harry Potter und die Kammer des Schreckens", "J.K. Rowling", "978-3-551-55658-0");
        Buch harryPotter1c = new Buch("Harry Potter und der Stein der Weisen", "J.K. Rowling", "978-3-551-55656-6");
        Buch harryPotter3 = new Buch("Harry Potter und der Gefangene von Askaban", "J.K. Rowling", "978-3-551-55659-7");

        System.out.println("harryPotter1a == harryPotter1b? " + harryPotter1a.equals(harryPotter1b));
        System.out.println("harryPotter1a == harryPotter1c? " + harryPotter1a.equals(harryPotter1c));
        System.out.println("harryPotter1a == harryPotter2? " + harryPotter1a.equals(harryPotter2));
        System.out.println("harryPotter1a == harryPotter3? " + harryPotter1a.equals(harryPotter3));

        HashMap<Buch, Integer> books = new HashMap<>();

        //  **Einfügen von Büchern**: Füge `Buch`Objekte in die HashMap ein.
        //    **Bonus:** wenn ein doppeltes Buch (mit gleicher Titel und Autor, aber unterschiedlicher ISBN) hinzugefügt wird, soll der Wert (Anzahl der Exemplare) automatisch erhöht werden.

        addBooktToHashMap(harryPotter1a, books);
        System.out.println();
        addBooktToHashMap(harryPotter1a, books);
        System.out.println();
        addBooktToHashMap(harryPotter1b, books);
        System.out.println();
        addBooktToHashMap(harryPotter1c, books);
        System.out.println();
        addBooktToHashMap(harryPotter2, books);
        System.out.println();
        addBooktToHashMap(harryPotter3, books);
        System.out.println();


        printMap(books);

        // Abrufen der Anzahl eines bestimmten Buches: Rufe die Anzahl der Exemplare eines bestimmten Buches ab.
        System.out.println("Abrufen der Anzahl "+ harryPotter1a + " ____" + books.get(harryPotter1a) + "____");

        //Überprüfen der Existenz eines Buches: Überprüfe, ob ein bestimmtes Buch in der HashMap vorhanden ist.
        isTheBookInTheMap(harryPotter1a, books);

        // Entfernen eines Buches: Entferne ein Buch aus der HashMap unabhängig davon, wieviele Exemplare von dem Buch existieren
        // Bonus: entferne ein Buch aus der HashMap, verringere dabei die Anzahl an Exemplaren, wenn es kein Exemplar mehr gibt, soll das gesamte Buch aus der HashMap verschwinden
        removeBookFromMap(harryPotter1a, books);

        printMap(books);
    }

    private static void printMap(HashMap<Buch, Integer> books) {
        System.out.println("Books in the Map:");
        for (Buch i : books.keySet()) {
            System.out.println("key: " + i + " value: " + books.get(i));
        }
    }

    private static void removeBookFromMap(Buch book, HashMap<Buch, Integer> books) {
        if (books.containsKey(book)) {
            if (books.get(book) == 1) books.remove(book);
            else books.replace(book, books.get(book), books.get(book)-1);
        }
    }

    private static void isTheBookInTheMap(Buch book, HashMap<Buch, Integer> books) {
        if (books.containsKey(book)) {
            System.out.println(book + " is already in the Map");
        }
    }

    private static void addBooktToHashMap(Buch book, HashMap<Buch, Integer> books) {
        if (book == null) {
            System.out.println("Book not valid");
            return;
        }
        if (books.containsKey(book)) {
            System.out.println(book.toString() + ", is altrady in the HashMap.");
            return;
        }
        if (books.isEmpty()) {
            books.put(book, 1);
            return;
        }
        for (Buch buch : books.keySet()) {
            if (book.title.equals(buch.title) && book.author.equals(buch.author)) {
                books.replace(buch, books.get(buch), books.get(buch)+1);
                return;
            }
        }
        books.put(book, 1);
    }
}