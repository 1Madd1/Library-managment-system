package org.djordje;

import org.djordje.entity.Book;
import org.djordje.entity.Library;
import org.djordje.entity.Patron;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Add books to the inventory
        Book book1 = new Book("The Catcher in the Rye", "J.D. Salinger", "978-0-316-76948-0");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "978-0-06-112008-4");
        library.addBook(book1);
        library.addBook(book2);
        library.displayLibraryStatistics();

        // Register patrons
        Patron patron1 = new Patron("Alice", "A123");
        Patron patron2 = new Patron("Bob", "B456");
        library.registerPatron(patron1);
        library.registerPatron(patron2);
        library.displayLibraryStatistics();

        // Check out and return books
        library.checkOutBook(book1, patron1);
        library.displayLibraryStatistics();
        library.returnBook(book1, patron1);

        // Display library statistics
        library.displayLibraryStatistics();
    }
}