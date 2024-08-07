package de.supercode;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private static int lastID = 100001;
    private String name;
    private int memberId;
    private List<Book> borrowedBooks;

    // Konstruktoren, Getter und Setter

    public Member(String name) {
        this.name = name;
        this.memberId = lastID;
        this.borrowedBooks = new ArrayList<>();
        Member.lastID ++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    // Methoden zum Hinzufügen von Büchern und Mitgliedern

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    // Override

    @Override
    public String toString() {
        return name +", Id: " + memberId;
    }

    public void returnBook(Book book) {
        Book bookToReturn = borrowedBooks.stream()
                .filter(b -> b == book)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Book not borrowed from this member yet"));
        borrowedBooks.remove(book);
    }

    public void printBorrowedBooks() {
        System.out.println("Books borrowed from " + this.name + " ID: " + this.memberId);
        borrowedBooks.forEach(System.out::println);
        System.out.println("*************************************************************");

    }
}
