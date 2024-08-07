package de.supercode;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

//      Add books to the library
        List<Book> books = new ArrayList<>(List.of(
                new Book("Harper Lee", "To Kill a Mockingbird", "Fiction", 1960),
                new Book("George Orwell", "1984", "Dystopian", 1949),
                new Book("J.K. Rowling", "Harry Potter and the Sorcerer's Stone", "Fantasy", 1997),
                new Book("J.R.R. Tolkien", "The Lord of the Rings", "Fantasy", 1954),
                new Book("Malcolm Gladwell", "Outliers", "Non-Fiction", 2008),
                new Book("Yuval Noah Harari", "Sapiens: A Brief History of Humankind", "Non-Fiction", 2011),
                new Book("Jane Austen", "Pride and Prejudice", "Romance", 1813),
                new Book("F. Scott Fitzgerald", "The Great Gatsby", "Fiction", 1925),
                new Book("Stephen Hawking", "A Brief History of Time", "Science", 1988),
                new Book("Margaret Atwood", "The Handmaid's Tale", "Dystopian", 1985)
        ));
        library.setBooks(books);
//      Print all books from library
        library.printAllBooks();


//      Add members to the library
        List<Member> members = new ArrayList<>(List.of(
                new Member("Alice Johnson"),
                new Member("Bob Smith"),
                new Member("Charlie Brown"),
                new Member("Diana Ross"),
                new Member("Ethan Hunt"),
                new Member("Fiona Green"),
                new Member("George Martin"),
                new Member("Hannah Davis"),
                new Member("Isaac Newton"),
                new Member("Julia Roberts")
        ));
        library.setMembers(members);

//      Print all members
        library.printMembers();

//      Ein Buch an ein Mitglied ausleihen.
        library.borrowBook(100001, books.get(0));

//      Print books borrowed from member
        members.get(0).printBorrowedBooks();

//      Ein Buch von einem Mitglied zurückgeben.
        library.returnBook(100001, books.get(0));

        //      Print books borrowed from member now is empty
        members.get(0).printBorrowedBooks();
    }
}