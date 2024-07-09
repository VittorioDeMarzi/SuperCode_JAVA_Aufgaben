import java.util.ArrayList;

public class MainBook {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        Book book1 = new Book("Harper Lee", "9780061120084", 324, "To Kill a Mockingbird");
        books.add(book1);
        Book book2 = new Book("George Orwell", "9780451524935", 328, "1984");
        books.add(book2);
        Book book3 = new Book("Jane Austen", "9781503290563", 279, "Pride and Prejudice");
        books.add(book3);
        Book book4 = new Book("F. Scott Fitzgerald", "9780743273565", 180, "The Great Gatsby");
        books.add(book4);
        Book book5 = new Book("Herman Melville", "9781503280786", 635, "Moby Dick");
        books.add(book5);

        for (Book book : books) {
            book.printDetails();
        }

        String isbnToSearch = "9780743273565";
        Book bookFound = Book.sucheNachISBN(books, isbnToSearch);

        if (bookFound != null) {
            System.out.printf("Following book with isbn(%s) was found%n", isbnToSearch);
            bookFound.printDetails();
        } else System.out.printf("Book not with isbn(%s) found, try with a another isbn!", isbnToSearch);
    
    }
}
