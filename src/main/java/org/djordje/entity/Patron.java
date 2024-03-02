package org.djordje.entity;

import java.util.List;

public class Patron {
    private String name;
    private String libraryCardNumber;
    private List<Book> borrowedBooks;

    /**
     * Creating empty and parameterized constructors, getter-setter methods and toString method for patron details
     */
    public Patron() {
    }

    public Patron(String name, String libraryCardNumber, List<Book> borrowedBooks) {
        this.name = name;
        this.libraryCardNumber = libraryCardNumber;
        this.borrowedBooks = borrowedBooks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLibraryCardNumber() {
        return libraryCardNumber;
    }

    public void setLibraryCardNumber(String libraryCardNumber) {
        this.libraryCardNumber = libraryCardNumber;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    @Override
    public String toString() {
        return "Patron name: " + name + "; Patron library card number: " + libraryCardNumber + "\nBorrowed books: " + borrowedBooks;
    }

    /**
     * addBorrowedBook method for adding a borrowed book to the list
     * @param book - book to be borrowed
     */
    public void addBorrowedBook(Book book){
        borrowedBooks.add(book);
    }

    /**
     * removeBorrowedBook method for removing borrowed book from the list
     * @param book - book to be returned
     */
    public void removeBorrowedBook(Book book){
        borrowedBooks.remove(book);
    }
}
