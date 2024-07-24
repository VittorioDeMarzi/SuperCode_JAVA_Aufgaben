package com.example.library;

import java.util.ArrayList;

public class Library {

    ArrayList<Book> books = new ArrayList<>();

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

}
