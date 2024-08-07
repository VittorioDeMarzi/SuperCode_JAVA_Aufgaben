package de.supercode;

import java.util.*;
import java.util.stream.Collectors;

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
    public void  borrowBook(int memberId, Book book) {
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

    // Search Book and Member if they are registered in library
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

//  Print Methods

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

    public void printBooksFromGenre(String genre) {
        System.out.println("Books in library with genre: " + genre);
        books.stream()
                .filter(b -> b.getGenre().equals(genre))
                .forEach(System.out::println);
        System.out.println("*************************************************************");
    }

    public void printAllAuthors() {
        books.stream()
                .map(Book::getAuthor)
                .distinct()
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
        System.out.println("*************************************************************");

    }

    public void printMostFiveBorrowedBooks() {
        System.out.println("Top 5 Most Borrowed Books:");
        List<Map.Entry<Book, Long>> books = members.stream()
                .map(Member::getBorrowedBooks)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(book -> book, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingInt(b -> Math.toIntExact(b.getValue())))
                .collect(Collectors.toList()).reversed();

        books.stream()
                .limit(5)
                .forEach(b -> System.out.println(b.getKey() + ", Number Times Borrowed: " + b.getValue()));
        System.out.println("*************************************************************");

    }

    public void printAveragePublicationYear() {
        int average = (int) books.stream()
                .mapToInt(Book::getPublicationYear)
                .average().getAsDouble();
        System.out.println("Average Publication Year of the Books: " + average);
    }
}
