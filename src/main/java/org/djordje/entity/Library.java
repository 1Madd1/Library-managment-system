package org.djordje.entity;

import java.util.List;

public class Library {
    private List<Book> bookInventory;
    private List<Patron> patrons;

    /**
     * Creating empty and parameterized constructors
     */
    public Library() {
    }

    public Library(List<Book> bookInventory, List<Patron> patrons) {
        this.bookInventory = bookInventory;
        this.patrons = patrons;
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
            book.setAvailable(false);
            patron.addBorrowedBook(book);
            return true;
        }
        System.out.println("The book" + book.getTitle() + " is not available!");

        return false;
    }

    /**
     * returnBook method for returning a borrowed book from the library
     * @param book - book to be returned to the library
     * @param patron - patron that is returning the book
     */
    public boolean returnBook(Book book,Patron patron){
        if (!book.isAvailable()){
            book.setAvailable(true);
            patron.removeBorrowedBook(book);
            return true;
        }
        System.out.println("The book" + book.getTitle() + " has already been returned!");

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
    }
}
