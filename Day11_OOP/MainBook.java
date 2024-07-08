import java.util.ArrayList;

public class MainBook {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        Book book1 = new Book("Harper Lee", "9780061120084", 324, "To Kill a Mockingbird");
        book1.printDetails();
        books.add(book1);
        Book book2 = new Book("George Orwell", "9780451524935", 328, "1984");
        book2.printDetails();
        books.add(book2);
        Book book3 = new Book("Jane Austen", "9781503290563", 279, "Pride and Prejudice");
        book3.printDetails();
        books.add(book3);
        Book book4 = new Book("F. Scott Fitzgerald", "9780743273565", 180, "The Great Gatsby");
        book4.printDetails();
        books.add(book4);
        Book book5 = new Book("Herman Melville", "9781503280786", 635, "Moby Dick");
        book5.printDetails();
        books.add(book5);

        String isbnToSearch = "9780743273565";
        Book bookFound = Book.sucheNachISBN(books, isbnToSearch);

        if (bookFound != null) {
            System.out.println("Following book was found");
            bookFound.printDetails();
        } else System.out.println("Book not found, try with a another isbn!");
    
    }
}
