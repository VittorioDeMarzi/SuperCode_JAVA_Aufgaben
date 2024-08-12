package de.supercode;

import java.util.List;
import java.util.Objects;

class Book {
    private String title;
    private int publicationYear;
    private int pages;
    private List<Author> authors;

    public Book(String title, int publicationYear, int pages, List<Author> authors) {
        this.title = title;
        this.publicationYear = publicationYear;
        this.pages = pages;
        this.authors = authors;
    }

    public String getTitle() { return title; }
    public int getPublicationYear() { return publicationYear; }
    public int getPages() { return pages; }
    public List<Author> getAuthors() { return authors; }

    @Override
    public String toString() {
        return title + " (" + publicationYear + "), " + pages + " Seiten, Autoren: " + authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return publicationYear == book.publicationYear && pages == book.pages && Objects.equals(title, book.title) && Objects.equals(authors, book.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, publicationYear, pages, authors);
    }
}