package com.example.main;
import com.example.library.*;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();
        Customer vittorio = new Customer("Vittorio", "De Marzi", "Musterstraße");
        Loan loan = new Loan();

        EBook eBook1 = new EBook("Digital Fortress", "Dan Brown", "9780552149483", 1998, 1);
        EBook eBook2 = new EBook("The Da Vinci Code", "Dan Brown", "9780385504201", 2003, 2);
        EBook eBook3 = new EBook("Inferno", "Dan Brown", "9780385537858", 2013, 3);
        EBook eBook4 = new EBook("Angels & Demons", "Dan Brown", "9780743486224", 2000, 2);
        EBook eBook5 = new EBook("Wild Symphony", "Dan Brown", "9780593448800", 2021, 4);
        PrintedBook printedBook1 = new PrintedBook("The Catcher in the Rye", "J.D. Salinger", "9780316769488", 1951, 300);
        PrintedBook printedBook2 = new PrintedBook("To Kill a Mockingbird", "Harper Lee", "9780060935467", 1960, 320);
        PrintedBook printedBook3 = new PrintedBook("1984", "George Orwell", "9780451524935", 1949, 280);
        PrintedBook printedBook4 = new PrintedBook("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", 1925, 350);
        PrintedBook printedBook5 = new PrintedBook("Moby-Dick", "Herman Melville", "9781503280786", 1851, 400);
        System.out.println();

        library.addBook(eBook1);
        library.addBook(eBook2);
        library.addBook(eBook3);
        library.addBook(eBook4);
        library.addBook(eBook5);
        library.addBook(printedBook1);
        library.addBook(printedBook2);
        library.addBook(printedBook3);
        library.addBook(printedBook4);
        library.addBook(printedBook4);
        library.addBook(printedBook4);
        library.addBook(printedBook4);
        System.out.println();

        library.showBooks();

        System.out.println();
//        library.printBookDetails(library.getBooks().get(3));

        library.findBooksByAuthor("Brown");
        System.out.println();

//        eBook3.read();
//        System.out.println();
//        printedBook4.read();
//        System.out.println();

        loan.loanABookTo(library, eBook1, vittorio);
        library.addKunde(vittorio);
        System.out.println();
        loan.loanABookTo(library, printedBook5, vittorio);
        System.out.println();
        loan.loanABookTo(library, printedBook4, vittorio);
        System.out.println();
        loan.loanABookTo(library, eBook1, vittorio);
        System.out.println();
        vittorio.read(eBook2);
        System.out.println();
        vittorio.read(eBook1);

    }
}
