package com.example.library;

public class EBook extends Book implements Readable {

    private int fileSizeMB;

    public EBook(String title, String author, String isbn, int year, int fileSizeMB) {
        super(title, author, isbn, year);
        this.fileSizeMB = fileSizeMB;
    }

    public void download() {
        System.out.println("Book is being downloaded. Wait few second before it gets ready!");
    }

    @Override
    public void read() {
        System.out.println("Kindle Papierwhite 2021 is switching on......");
        System.out.println("..." + this.toString() + " will be opened...");
        System.out.println();
        System.out.println(" *********************************************");
        System.out.println("*                                            *");
        System.out.println("        " + super.getTitle() + "          ");
        System.out.println("*                                            *");
        System.out.println("*    hvuekfzvgwefuferkfbherfjhewbgjhgblej    *");
        System.out.println("*    hvuekfzvgwefuferkfbherfjhewbgjhgblej    *");
        System.out.println("*    hvuekfzvgwefuferkfbherfjhewbgjhgblej    *");
        System.out.println("*    hvuekfzvgwefuferkfbherfjhewbgjhgblej    *");
        System.out.println("*    hvuekfzvgwefuferkfbherfjhewbgjhgblej    *");
        System.out.println("*    hvuekfzvgwefuferkfbherfjhewbgjhgblej    *");
        System.out.println("*    hvuekfzvgwefuferkfbherfjhewbgjhgblej    *");
        System.out.println("*    hvuekfzvgwefuferkfbherfjhewbgjhgblej    *");
        System.out.println("*    hvuekfzvgwefuferkfbherfjhewbgjhgblej    *");
        System.out.println("*    hvuekfzvgwefuferkfbherfjhewbgjhgblej    *");
        System.out.println("*    hvuekfzvgwefuferkfbherfjhewbgjhgblej    *");
        System.out.println("*    hvuekfzvgwefuferkfbherfjhewbgjhgblej    *");
        System.out.println("*    hvuekfzvgwefuferkfbherfjhewbgjhgblej    *");
        System.out.println("*                                            *");
        System.out.println("*    p.1  2%   40 mins to the end of cap.    *");
        System.out.println(" *********************************************");

    }

    @Override
    public String toString() {
        return super.toString() + ", fileSizeMB= " + fileSizeMB + " Mb";
    }
}
