package de.supercode;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;
    private List<Member> members;

    // Konstruktoren, Getter und Setter

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    // Methoden zum Hinzufügen von Büchern und Mitgliedern

    public void addBooks(Book book) {
        this.books.add(book);
    }

    public void addMember(Member member) {
        this.members.add(member);
    }

    // Ein Buch an ein Mitglied ausleihen.
    public void borrowBook(int memberId, Book book) {
        Member member = getLibraryMember(memberId);
        Book bookToBorrow = getBookFromLibraryList(book);
        member.borrowBook(book);
    }

    //  Ein Buch von einem Mitglied zurückgeben.
    public void returnBook(int memberID, Book book) {
        Member member = getLibraryMember(memberID);
        Book bookToReturn = getBookFromLibraryList(book);
        member.returnBook(book);
    }

    private Book getBookFromLibraryList(Book book) {
        return books.stream()
                .filter(b -> b == book)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));
    }

    private Member getLibraryMember(int memberId) {
        return members.stream()
                .filter(m -> m.getMemberId() == memberId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
    }

    public void printMembers() {
        System.out.println("Current members of the library:");
        members.forEach(System.out::println);
        System.out.println("*************************************************************");
    }

    public void printAllBooks() {
        System.out.println("Current books in the library:");
        books.forEach(System.out::println);
        System.out.println("*************************************************************");

    }

}
