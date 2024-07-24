package com.example.library;

public class PrintedBook extends Book implements Readable {

    private int weightInGramm;

    public PrintedBook(String title, String author, String isbn, int year, int weightInGramm) {
        super(title, author, isbn, year);
        this.weightInGramm = weightInGramm;
    }

    public void ship() {
        System.out.println("Book: " + this.toString() + "will be shipped");
    }

    @Override
    public void read() {
        System.out.println("Nothing is better than the smell of a real book.");
        System.out.println();
        System.out.println(" ____________________________________________");
        System.out.println("|                                            |");
        System.out.println("      " + super.getTitle() + "          ");
        System.out.println("|                                            |");
        System.out.println("|    hvuekfzvgwefuferkfbherfjhewbgjhgblej    |");
        System.out.println("|    hvuekfzvgwefuferkfbherfjhewbgjhgblej    |");
        System.out.println("|    hvuekfzvgwefuferkfbherfjhewbgjhgblej    |");
        System.out.println("|    hvuekfzvgwefuferkfbherfjhewbgjhgblej    |");
        System.out.println("|    hvuekfzvgwefuferkfbherfjhewbgjhgblej    |");
        System.out.println("|    hvuekfzvgwefuferkfbherfjhewbgjhgblej    |");
        System.out.println("|    hvuekfzvgwefuferkfbherfjhewbgjhgblej    |");
        System.out.println("|    hvuekfzvgwefuferkfbherfjhewbgjhgblej    |");
        System.out.println("|    hvuekfzvgwefuferkfbherfjhewbgjhgblej    |");
        System.out.println("|    hvuekfzvgwefuferkfbherfjhewbgjhgblej    |");
        System.out.println("|    hvuekfzvgwefuferkfbherfjhewbgjhgblej    |");
        System.out.println("|    hvuekfzvgwefuferkfbherfjhewbgjhgblej    |");
        System.out.println("|    hvuekfzvgwefuferkfbherfjhewbgjhgblej    |");
        System.out.println("|                                            |");
        System.out.println("|    p.1                                     |");
        System.out.println("|____________________________________________|");
    }

    @Override
    public String toString() {
        return super.toString() + ", weight= " + weightInGramm + "gr";
    }
}
