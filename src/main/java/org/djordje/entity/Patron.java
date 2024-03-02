package org.djordje.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Patron {
    private String name;
    private String libraryCardNumber;
    private List<Book> borrowedBooks;

    /**
     * Creating empty and parameterized constructors, getter-setter methods and toString method for patron details
     */
    public Patron() {
        this.borrowedBooks = new ArrayList<>();
    }

    public Patron(String name, String libraryCardNumber) {
        this.name = name;
        this.libraryCardNumber = libraryCardNumber;
        this.borrowedBooks = new ArrayList<>();
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
     * equals method used to compare two Patron classes
     * @param o - the patron class to be compared
     * @return - true if they point to the same class or have the same library card number, otherwise return false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patron patron = (Patron) o;
        return Objects.equals(getLibraryCardNumber(), patron.getLibraryCardNumber());
    }

    /**
     * addBorrowedBook method for adding a borrowed book to the list. Shows a message if book is already borrowed
     * @param book - book to be borrowed
     * @return - false if book is already borrowed, true if book wasn't borrowed
     */
    public boolean addBorrowedBook(Book book){
        if(borrowedBooks.contains(book)){
            System.out.println("Book is already borrowed!");
            return false;
        }
        borrowedBooks.add(book);
        return true;
    }

    /**
     * removeBorrowedBook method for removing borrowed book from the list
     * @param book - book to be returned
     */
    public void removeBorrowedBook(Book book){
        borrowedBooks.remove(book);
    }
}
