
import java.util.ArrayList;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private int numberOfPages;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Book(String author, String isbn, int numberOfPages, String title) {
        this.author = author;
        this.isbn = isbn;
        this.numberOfPages = numberOfPages;
        this.title = title;
    }

    public void printDetails() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Autor: " + this.author + " Buch: " + this.author + " isbn: " + this.isbn + " Number of pages: " + this.numberOfPages;
    }

    public static Book sucheNachISBN(ArrayList<Book> books, String isbn) {
        for (Book book : books) {
            if (book.isbn.equals(isbn)) {
                return book;
            }
        }
        return null;
    }
}

