package com.example.main;

import com.example.library.Book;
import com.example.library.Library;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();

        library.addBook(new Book("The Catcher in the Rye", "J.D. Salinger", "9780316769488", 1951));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "9780060935467", 1960));
        library.addBook(new Book("1984", "George Orwell", "9780451524935", 1949));
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", 1925));
        library.addBook(new Book("Moby-Dick", "Herman Melville", "9781503280786", 1851));
        library.addBook(new Book("Pride and Prejudice", "Jane Austen", "9780141040349", 1813));
        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien", "9780261102217", 1937));
        library.addBook(new Book("Brave New World", "Aldous Huxley", "9780060850524", 1932));
        library.addBook(new Book("Wuthering Heights", "Emily Brontë", "9781853260018", 1847));
        library.addBook(new Book("The Lord of the Rings", "J.R.R. Tolkien", "9780544003415", 1954));
        library.addBook(new Book("The Lord of the Rings", "J.R.R. Tolkien", "9780544003415", 1954));
        library.addBook(new Book("The Lord of the Rings", "J.R.R. Tolkien", "9780544003415", 1954));

        library.showBooks();

        System.out.println();
        library.printBookDetails(library.getBooks().get(3));
    }


}
