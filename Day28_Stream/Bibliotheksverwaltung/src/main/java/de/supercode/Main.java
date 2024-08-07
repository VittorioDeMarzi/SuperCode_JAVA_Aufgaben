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
                new Book("Margaret Atwood", "The Handmaid's Tale", "Dystopian", 1985), new Book("Margaret Atwood", "The Handmaid's Tale", "Dystopian", 1985),
                new Book("Margaret Atwood", "Oryx and Crake", "Science Fiction", 2003),
                new Book("Margaret Atwood", "The Blind Assassin", "Fiction", 2000),
                new Book("Margaret Atwood", "Alias Grace", "Historical Fiction", 1996),
                new Book("Margaret Atwood", "The Testaments", "Dystopian", 2019),
                new Book("Stephen Hawking", "A Brief History of Time", "Science", 1988),
                new Book("Stephen Hawking", "The Universe in a Nutshell", "Science", 2001),
                new Book("Stephen Hawking", "The Grand Design", "Science", 2010),
                new Book("Stephen Hawking", "Black Holes and Baby Universes and Other Essays", "Science", 1993),
                new Book("Stephen Hawking", "Brief Answers to the Big Questions", "Science", 2018),
                new Book("Malcolm Gladwell", "The Tipping Point: How Little Things Can Make a Big Difference", "Non-Fiction", 2000),
                new Book("Malcolm Gladwell", "Blink: The Power of Thinking Without Thinking", "Non-Fiction", 2005),
                new Book("Malcolm Gladwell", "Outliers: The Story of Success", "Non-Fiction", 2008),
                new Book("Malcolm Gladwell", "What the Dog Saw: And Other Adventures", "Non-Fiction", 2009),
                new Book("Malcolm Gladwell", "David and Goliath: Underdogs, Misfits, and the Art of Battling Giants", "Non-Fiction", 2013)
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
        library.borrowBook(100002, books.get(0));
        library.borrowBook(100003, books.get(1));
        library.borrowBook(100004, books.get(3));
        library.borrowBook(100005, books.get(1));
        library.borrowBook(100001, books.get(2));
        library.borrowBook(100006, books.get(2));
        library.borrowBook(100002, books.get(3));
        library.borrowBook(100010, books.get(3));
        library.borrowBook(100009, books.get(4));
        library.borrowBook(100008, books.get(6));
        library.borrowBook(100001, books.get(6));
        library.borrowBook(100002, books.get(6));
        library.borrowBook(100003, books.get(7));
        library.borrowBook(100004, books.get(8));

//      Print books borrowed from member
        members.get(0).printBorrowedBooks();

//      Return a Book by a Member
        library.returnBook(100001, books.get(0));

//      Print books borrowed from member now is empty
        members.get(0).printBorrowedBooks();

//      List of All Books of a Specific Genre
        library.printBooksFromGenre("Fiction");

//      List of All Authors Without Duplicates
        library.printAllAuthors();

//      Top 5 Most Borrowed Books
        library.printMostFiveBorrowedBooks();

//      Average Publication Year of the Books
        library.printAveragePublicationYear();
    }

}