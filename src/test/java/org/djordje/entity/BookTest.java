package org.djordje.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    private Book emptyBook;
    private Book filledBook;

    @Before
    public void setUp() {
        emptyBook = new Book();
        filledBook = new Book("Title1", "Author1", "978-0-06-112008-4");
    }
    /**
     * We are testing if two empty classes are equal
     */
    @Test
    public void compareTwoEmptyBooks(){
        Book book2 = new Book();
        assertEquals(emptyBook,book2);
    }
    /**
     * We are testing if a filled and empty class are not equal
     */
    @Test
    public void compareEmptyAndFilledBooks(){
        Book book2 = new Book("Title1", "Author1", "978-0-06-112008-4");
        assertNotEquals(emptyBook,book2);
    }
    /**
     * We are testing if two filled books are equal
     */
    @Test
    public void compareTwoSameFilledBooks(){
        Book book2 = new Book("Title1", "Author1", "978-0-06-112008-4");
        assertEquals(filledBook,book2);
    }
    /**
     * We are testing if two same filled books with different isbn are not equal
     */
    @Test
    public void compareTwoSameFilledBooksWithDifferentIsbn(){
        Book book2 = new Book("Title1", "Author1", "111-2-33-444444-5");
        assertNotEquals(filledBook,book2);
    }
    /**
     * We are testing if two different filled books with same isbn are equal
     */
    @Test
    public void compareTwoDifferentFilledBooksWithSameIsbn(){
        Book book2 = new Book("Title2", "Author2", "978-0-06-112008-4");
        assertEquals(filledBook,book2);
    }
    /**
     * We are testing if two libraries with different checkouts are not equal
     */
    @Test
    public void compareTwoDifferentFilledBooksWithDifferentIsbn(){
        Book book2 = new Book("Title2", "Author2", "111-2-33-444444-5");
        assertNotEquals(filledBook,book2);
    }
    /**
     * We are testing if two books with same data but with different availability are not equal
     */
    @Test
    public void compareTwoBooksWithDifferentAvailability(){
        Book book2 = new Book("Title2", "Author2", "111-2-33-444444-5");
        book2.setAvailable(false);
        assertNotEquals(filledBook,book2);
    }
}