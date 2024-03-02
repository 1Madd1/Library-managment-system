package org.djordje.entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PatronTest {

    private Patron patron;

    @Before
    public void setUp() {
        patron = new Patron();
    }

    /**
     * We are testing if two empty classes are equal
     */
    @Test
    public void checkIfTwoEmptyPatronsAreSame(){
        Patron patron2 = new Patron();
        assertEquals(patron, patron2);
    }
    /**
     * We are testing if two filled classes are equal
     */
    @Test
    public void checkIfTwoFilledPatronsAreSame(){
        patron.setName("Djordje");
        patron.setLibraryCardNumber("D345");
        Patron patron2 = new Patron("Djordje", "D345");
        assertEquals(patron, patron2);
    }
    /**
     * We are testing if two different filled patrons are not equal
     */
    @Test
    public void checkIfTwoDifferentFilledPatronsAreNotSame(){
        patron.setName("Djordje");
        patron.setLibraryCardNumber("D345");
        Patron patron2 = new Patron("Ana", "V345");
        assertNotEquals(patron, patron2);
    }
    /**
     * We are testing if two different filled patrons with same card are equal
     */
    @Test
    public void checkIfTwoDifferentFilledPatronsWithSameCardAreSame(){
        patron.setName("Djordje");
        patron.setLibraryCardNumber("D345");
        Patron patron2 = new Patron("Ana", "D345");
        assertEquals(patron, patron2);
    }
    /**
     * We are testing if patron borrowed a book
     */
    @Test
    public void checkIfPatronBorrowedABook(){
        Book book = new Book("Title1", "Author1", "978-0-06-112008-4");
        patron.setName("Djordje");
        patron.setLibraryCardNumber("D345");
        patron.addBorrowedBook(book);
        assertTrue(patron.getBorrowedBooks().contains(book));
    }
    /**
     * We are testing if patron already has the same book he tried to borrow
     */
    @Test
    public void checkIfPatronHasABorrowedBook(){
        Book book = new Book("Title1", "Author1", "978-0-06-112008-4");
        patron.setName("Djordje");
        patron.setLibraryCardNumber("D345");
        patron.addBorrowedBook(book);
        assertFalse(patron.addBorrowedBook(book));
    }
    /**
     * We are testing if patron returned a book
     */
    @Test
    public void checkIfPatronReturnedABook(){
        Book book = new Book("Title1", "Author1", "978-0-06-112008-4");
        patron.setName("Djordje");
        patron.setLibraryCardNumber("D345");
        patron.addBorrowedBook(book);
        assertTrue(patron.getBorrowedBooks().contains(book));
        patron.removeBorrowedBook(book);
        assertTrue(patron.getBorrowedBooks().isEmpty());
    }
}