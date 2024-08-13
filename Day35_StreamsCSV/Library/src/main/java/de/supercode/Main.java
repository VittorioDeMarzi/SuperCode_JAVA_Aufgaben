package de.supercode;

import org.w3c.dom.ls.LSOutput;

import javax.swing.text.html.Option;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws Exception {
        Library library = new Library();

        // Autoren erstellen
        Author author1 = new Author("J.K. Rowling", 1965);
        Author author2 = new Author("George R.R. Martin", 1948);
        Author author3 = new Author("J.R.R. Tolkien", 1892);
        Author author4 = new Author("Agatha Christie", 1890);
        Author author5 = new Author("Stephen King", 1947);

        // Bücher erstellen
        Book book1 = new Book("Harry Potter and the Philosopher's Stone", 1997, 223, List.of(author1));
        Book book2 = new Book("A Game of Thrones", 1996, 835, List.of(author2));
        Book book3 = new Book("The Lord of the Rings", 1954, 1200, List.of(author3));
        Book book4 = new Book("Murder on the Orient Express", 1934, 256, List.of(author4));
        Book book5 = new Book("The Shining", 1977, 447, List.of(author5));
        Book book6 = new Book("Harry Potter and the Chamber of Secrets", 1998, 251, List.of(author1));
        Book book7 = new Book("The Hobbit", 1937, 310, List.of(author3));
        Book book8 = new Book("The Winds of Winter", 2024, 900, List.of(author2)); // Zukunftsbeispiel

        // Bücher zur Bibliothek hinzufügen
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);
        library.addBook(book7);
        library.addBook(book8);

        // Datumformatierer
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");

        // Ausleihen erstellen
        library.loanBook(book1, dateFormatter.parse("01.06.2023"), dateFormatter.parse("15.06.2023"));
        library.loanBook(book2, dateFormatter.parse("05.07.2023"), dateFormatter.parse("20.07.2023"));
        library.loanBook(book2, dateFormatter.parse("05.07.2023"), dateFormatter.parse("20.07.2023"));
        library.loanBook(book2, dateFormatter.parse("05.07.2023"), dateFormatter.parse("20.07.2023"));
        library.loanBook(book3, dateFormatter.parse("10.08.2023"), dateFormatter.parse("01.09.2023"));
        library.loanBook(book3, dateFormatter.parse("10.08.2023"), dateFormatter.parse("01.09.2023"));
        library.loanBook(book3, dateFormatter.parse("10.08.2023"), dateFormatter.parse("01.09.2023"));
        library.loanBook(book1, dateFormatter.parse("20.08.2023"), dateFormatter.parse("05.09.2023"));
        library.loanBook(book4, dateFormatter.parse("01.09.2023"), dateFormatter.parse("10.09.2023"));
        library.loanBook(book4, dateFormatter.parse("01.09.2023"), dateFormatter.parse("10.09.2023"));
        library.loanBook(book5, dateFormatter.parse("15.09.2023"), dateFormatter.parse("30.09.2023"));
        library.loanBook(book6, dateFormatter.parse("01.10.2023"), dateFormatter.parse("15.10.2023"));
        library.loanBook(book7, dateFormatter.parse("10.10.2023"), dateFormatter.parse("25.10.2023"));
        library.loanBook(book8, dateFormatter.parse("01.11.2023"), dateFormatter.parse("15.11.2023"));
        library.loanBook(book3, dateFormatter.parse("20.11.2023"), dateFormatter.parse("05.12.2023"));
        library.loanBook(book3, dateFormatter.parse("20.11.2023"), dateFormatter.parse("05.12.2023"));
        library.loanBook(book3, dateFormatter.parse("20.11.2023"), dateFormatter.parse("05.12.2023"));
        library.loanBook(book3, dateFormatter.parse("20.11.2023"), dateFormatter.parse("05.12.2023"));
        library.loanBook(book3, dateFormatter.parse("20.11.2023"), dateFormatter.parse("05.12.2023"));
        library.loanBook(book3, dateFormatter.parse("20.11.2023"), dateFormatter.parse("05.12.2023"));
        library.loanBook(book3, dateFormatter.parse("20.11.2023"), dateFormatter.parse("05.12.2023"));
        library.loanBook(book3, dateFormatter.parse("20.11.2023"), dateFormatter.parse("05.12.2023"));
        library.loanBook(book3, dateFormatter.parse("20.11.2023"), dateFormatter.parse("05.12.2023"));
        library.loanBook(book3, dateFormatter.parse("20.11.2023"), dateFormatter.parse("05.12.2023"));
        library.loanBook(book3, dateFormatter.parse("20.11.2023"), dateFormatter.parse("05.12.2023"));
        library.loanBook(book3, dateFormatter.parse("20.11.2023"), dateFormatter.parse("05.12.2023"));
        library.loanBook(book3, dateFormatter.parse("20.11.2023"), dateFormatter.parse("05.12.2023"));


    // Aufgaben

        List<Book> booksSortedByPublicationYear = library.getBooksSortedByPublicationYear();
//        booksSortedByPublicationYear.forEach(System.out::println);

        List<Author> getAuthorsSortedByBirthYear = library.getAuthorsSortedByBirthYear();
//        getAuthorsSortedByBirthYear.forEach(System.out::println);

        List<Book> filterBooksByPageCount = library.filterBooksByPageCount(500, 1200);
//        filterBooksByPageCount.forEach(System.out::println);

        Map<Author, List<Book>>  groupBooksByAuthor = library.groupBooksByAuthor();
//        groupBooksByAuthor.forEach((k,v) -> {
//            System.out.println(k);
//            v.forEach(book -> System.out.println("\t" + book));
//        });

        Optional<Author> oldestAuthor = library.getOldestAuthor();
//        if(oldestAuthor.isEmpty()) System.out.println("Not found");
//        else System.out.println(oldestAuthor.get());

        List<Book> booksByTitleKeyword = library.getBooksByTitleKeyword("potter");
//        booksByTitleKeyword.forEach(System.out::println);

        List<Book> mostLoanedBooks = library.getMostLoanedBooks();
//        mostLoanedBooks.forEach(System.out::println);

        Map<Book, Long> loanCountPerBook = library.getLoanCountPerBook();
//        loanCountPerBook.forEach((k,v) -> System.out.println(k + ", times borrowed:  " + v));

        List<Book> booksLoanedByAuthor = library.getBooksLoanedByAuthor(author1);
//        booksLoanedByAuthor.forEach(System.out::println);

        String mostPopularAuthorByBorrowedBooksCount = library.getMostPopularAuthorByBorrowedBooksCount();
//        System.out.println("Most Popular Author By Borrowed Books Count" + mostPopularAuthorByBorrowedBooksCount);
    }
}
