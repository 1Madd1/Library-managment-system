package org.djordje.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Library {
    private List<Book> bookInventory;
    private List<Patron> patrons;

    /**
     * Creating empty and parameterized constructors
     */
    public Library() {
        this.bookInventory = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }

    public Library(List<Book> bookInventory, List<Patron> patrons) {
        this.bookInventory = bookInventory;
        this.patrons = patrons;
    }

    /**
     * equals method used to compare two Library classes
     * @param o - the library class to be compared
     * @return - true if they point to the same class or have the same books and patrons, otherwise return false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(bookInventory, library.bookInventory) && Objects.equals(patrons, library.patrons);
    }

    /**
     * addBook method for adding a book in a library
     * @param book - Book to be added to the library
     */
    public void addBook(Book book){
        bookInventory.add(book);
    }

    /**
     * registerPatron method for registering new patrons in the library
     * @param patron - Patron to be registered in the library
     */
    public void registerPatron(Patron patron){
        patrons.add(patron);
    }

    /**
     * checkOutBook method for checking out a book from the library by a patron
     * and adding the book to patrons borrowed books list
     * @param book - book to be borrowed from the library
     * @param patron - patron that is borrowing the book from the library
     */
    public boolean checkOutBook(Book book, Patron patron){
        if (book.isAvailable()){
            if(this.patrons.contains(patron)){
                book.setAvailable(false);
                patron.addBorrowedBook(book);
                return true;
            }
            System.out.println("Patron " + patron.getName() + " is not registered in the library!");
        } else {
            System.out.println("The book" + book.getTitle() + " is not available!");
        }

        return false;
    }

    /**
     * returnBook method for returning a borrowed book from the library
     * @param book - book to be returned to the library
     * @param patron - patron that is returning the book
     */
    public boolean returnBook(Book book,Patron patron){
        if (!book.isAvailable()){
            if(this.patrons.contains(patron)){
                book.setAvailable(true);
                patron.removeBorrowedBook(book);
                return true;
            }
            System.out.println("Patron " + patron.getName() + " is not registered in the library!");
        } else {
            System.out.println("The book" + book.getTitle() + " has already been returned!");
        }

        return false;
    }

    /**
     * displayLibraryStatistics method for displaying library statistics
     */
    public void displayLibraryStatistics(){
        System.out.println("Book inventory:");
        for (Book b : bookInventory) {
            System.out.println(b);
        }
        System.out.println("Patrons:");
        for (Patron p : patrons) {
            System.out.println(p);
        }
        System.out.println("-------------------------------------");
    }

    /**
     * clearData method that is used to clear all data from the library
     */
    public void clearData(){
        bookInventory.clear();
        patrons.clear();
    }
}
