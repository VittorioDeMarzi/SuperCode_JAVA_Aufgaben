package com.example.library;

public class Loan {

    public void loanABookTo(Library library, Book book, Customer user) {
        if (!library.customers.contains(user)) {
            System.out.println(user.getLastName() + " is not registered in the library yet. Please first fill up the form and apply for the registration!");
            return;
        }

        if (!library.books.contains(book)) {
            System.out.println("******** " + book.toString() + " is not available in the library!******");
            return;
        } else {
            library.books.remove(book);
            user.getBorrowedBooks().add(book);
            System.out.println("The following book was loaned to " + user.getFirstName() + user.getLastName());
            System.out.println(book.toString());
        }


    }
}
