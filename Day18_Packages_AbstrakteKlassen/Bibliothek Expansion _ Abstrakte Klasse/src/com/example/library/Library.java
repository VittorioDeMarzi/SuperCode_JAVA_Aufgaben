package com.example.library;

import java.util.ArrayList;

public class Library {

    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Customer> customers = new ArrayList<>();

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void showBooks() {
        System.out.println("**********************************************************************");
        System.out.println("*********************BOOKS AVAILABLE IN THE LIBRARY*******************");
        System.out.println("**********************************************************************");
        for (Book book : books) {
            System.out.println("\t" + book.toString());
        }
    }

    public void addBook(Book book) {
        if (books.contains(book)) {
            System.out.println("__The following book was already in the list. Not added to the library__");
            printBookDetails(book);
            return;
        } else {
            books.add(book);
            System.out.println("__The following book was added to the library__");
            printBookDetails(book);
        }
    }

    public void printBookDetails(Book book) {
        System.out.println("\t" + book.toString());
    }

    public void findBooksByAuthor(String author) {
        ArrayList<Book> booksByAuthor = new ArrayList<>();
        for (Book book : books) {
            if (book.author.contains(author)) {
                booksByAuthor.add(book);
            }
        }
        if (booksByAuthor.isEmpty()) System.out.println("*****No books available for the writer " + author + " ******");
        else {
            System.out.println("Available books for the author " + author + ":");
            for (Book book : booksByAuthor) {
                System.out.println("\t" + book.toString());
            }
        }
    }

    public void addKunde(Customer vittorio) {
        if (customers.contains(vittorio)) {
            System.out.println("*****Customer " + vittorio.getLastName() + " already registered!******");
            return;
        } else customers.add(vittorio);
    }
}
