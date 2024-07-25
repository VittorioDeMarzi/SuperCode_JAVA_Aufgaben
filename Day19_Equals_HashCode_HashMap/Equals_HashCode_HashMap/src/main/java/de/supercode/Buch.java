package de.supercode;

import java.util.Objects;

public class Buch {

    String title;
    String author;
    String isbn;

    public Buch(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

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

    @Override
    public String toString() {
        return "Buch{" +
                "Author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", ISBN='" + isbn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buch buch = (Buch) o;
        return Objects.equals(title, buch.title) && Objects.equals(author, buch.author) && Objects.equals(isbn, buch.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, isbn);
    }
}
