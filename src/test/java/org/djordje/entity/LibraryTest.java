package org.djordje.entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class LibraryTest {
    private Library library;
    @Before
    public void setUp() {
        library = new Library();
    }
    /**
     * We are testing if two empty classes are equal
     */
    @Test
    public void compareTwoEmptyLibraries(){
        Library library2 = new Library();
        assertEquals(library, library2);
    }
    /**
     * We are testing if an empty and filled class are equal
     */
    @Test
    public void compareEmptyAndFilledLibrary(){
        Library library2 = new Library(List.of(new Book("Title1", "Author1", "978-0-06-112008-4")), List.of(new Patron("Alice", "A123")));
        assertNotEquals(library, library2);
    }
    /**
     * We are testing if two filled classes are equal
     */
    @Test
    public void compareTwoSameFilledLibraries(){
        library.addBook(new Book("Title1", "Author1", "978-0-06-112008-4"));
        library.registerPatron(new Patron("Alice", "A123"));
        Library library2 = new Library(List.of(new Book("Title1", "Author1", "978-0-06-112008-4")), List.of(new Patron("Alice", "A123")));
        assertEquals(library, library2);
    }
    /**
     * We are testing if two libraries with different books are not equal
     */
    @Test
    public void compareTwoFilledLibrariesWithDifferentBooks(){
        library.addBook(new Book("Title1", "Author1", "978-0-06-112008-4"));
        library.registerPatron(new Patron("Alice", "A123"));
        Library library2 = new Library(List.of(new Book("Title1", "Author1", "111-2-33-444444-5")), List.of(new Patron("Alice", "A123")));
        assertNotEquals(library, library2);
    }
    /**
     * We are testing if two libraries with different patrons are not equal
     */
    @Test
    public void compareTwoFilledLibrariesWithDifferentPatrons(){
        library.addBook(new Book("Title1", "Author1", "978-0-06-112008-4"));
        library.registerPatron(new Patron("Alice", "A123"));
        Library library2 = new Library(List.of(new Book("Title1", "Author1", "978-0-06-112008-4")), List.of(new Patron("Alice", "B345")));
        assertNotEquals(library, library2);
    }
    /**
     * We are testing if two libraries with different checkouts and same data are not equal
     */
    @Test
    public void compareTwoLibrariesWithDifferentCheckouts(){
        Book book1 = new Book("Title1", "Author1", "978-0-06-112008-4");
        Book book2 = new Book("Title1", "Author1", "978-0-06-112008-4");
        Patron patron1 = new Patron("Alice", "A123");
        Patron patron2 = new Patron("Alice", "A123");
        library.addBook(book1);
        library.registerPatron(new Patron("Alice", "A123"));
        Library library2 = new Library(List.of(book2), List.of(patron2));
        library.checkOutBook(book1, patron1);
        assertNotEquals(library, library2);
    }
    /**
     * We are testing if two libraries with same checkouts and data are equal
     */
    @Test
    public void compareTwoLibrariesWithSameCheckouts(){
        Book book1 = new Book("Title1", "Author1", "978-0-06-112008-4");
        Book book2 = new Book("Title1", "Author1", "978-0-06-112008-4");
        Patron patron1 = new Patron("Alice", "A123");
        Patron patron2 = new Patron("Alice", "A123");
        library.addBook(book1);
        library.registerPatron(patron1);
        Library library2 = new Library(List.of(book2), List.of(patron2));
        library.checkOutBook(book1, patron1);
        library2.checkOutBook(book2, patron2);
        assertEquals(library, library2);
    }
    /**
     * We are testing if a book is checked out
     */
    @Test
    public void checkIfBookIsCheckedOut(){
        Book book1 = new Book("Title1", "Author1", "978-0-06-112008-4");
        Patron patron1 = new Patron("Alice", "A123");
        library.addBook(book1);
        library.registerPatron(patron1);
        library.checkOutBook(book1, patron1);
        assertFalse(book1.isAvailable());
        assertEquals(book1, patron1.getBorrowedBooks().get(0));
    }
    /**
     * We are testing if a book is not checked out
     */
    @Test
    public void checkIfBookIsNotCheckedOut(){
        Book book1 = new Book("Title1", "Author1", "978-0-06-112008-4");
        library.addBook(book1);
        assertTrue(book1.isAvailable());
    }
    /**
     * We are testing if a non-registered patron can check out a book
     */
    @Test
    public void checkIfBookIsCheckedOutWithANonRegisterPatron(){
        Book book1 = new Book("Title1", "Author1", "978-0-06-112008-4");
        Patron patron1 = new Patron("Alice", "A123");
        library.addBook(book1);
        library.checkOutBook(book1, patron1);
        assertTrue(book1.isAvailable());
    }
    /**
     * We are testing if an unavailable book can be checked out
     */
    @Test
    public void checkIfUnavailableBookCantBeCheckedOut(){
        Book book1 = new Book("Title1", "Author1", "978-0-06-112008-4");
        book1.setAvailable(false);
        Patron patron1 = new Patron("Alice", "A123");
        library.addBook(book1);
        library.registerPatron(patron1);
        library.checkOutBook(book1, patron1);
        assertFalse(book1.isAvailable());
        assertTrue(patron1.getBorrowedBooks().isEmpty());
    }
    /**
     * We are testing if a book was returned
     */
    @Test
    public void checkIfBookIsReturned(){
        Book book1 = new Book("Title1", "Author1", "978-0-06-112008-4");
        Patron patron1 = new Patron("Alice", "A123");
        library.addBook(book1);
        library.registerPatron(patron1);
        library.checkOutBook(book1, patron1);
        assertFalse(book1.isAvailable());
        assertEquals(book1, patron1.getBorrowedBooks().get(0));
        library.returnBook(book1, patron1);
        assertTrue(book1.isAvailable());
        assertTrue(patron1.getBorrowedBooks().isEmpty());
    }

    @After
    public void tearDown() {
        library.clearData();
    }
}