package org.djordje.library;

import org.djordje.entity.Book;
import org.djordje.entity.Patron;
import org.djordje.enums.TransactionType;
import org.junit.Before;
import org.junit.Test;
import java.sql.Date;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class LibraryTransactionTest {

    private LibraryTransaction libraryTransaction;

    @Before
    public void setUp() {
        libraryTransaction = new LibraryTransaction();
    }

    /**
     * We are testing if two empty classes are equal
     */
    @Test
    public  void checkIfTwoEmptyLibraryTransactionsAreSame(){
        LibraryTransaction libraryTransaction2 = new LibraryTransaction();
        assertEquals(libraryTransaction, libraryTransaction2);
    }

    /**
     * We are testing if two filled classes are equal
     */
    @Test
    public void checkIfTwoLibraryTransactionsAreSame(){
        libraryTransaction.setTransactionDate(Date.valueOf(LocalDate.now()));
        Book book1 = new Book("Title1", "Author1", "978-0-06-112008-4");
        Patron patron1 = new Patron("Alice", "A123");
        libraryTransaction.setBook(book1);
        libraryTransaction.setPatron(patron1);
        libraryTransaction.setType(TransactionType.CHECKOUT);
        LibraryTransaction libraryTransaction2 = new LibraryTransaction(Date.valueOf(LocalDate.now()), book1, patron1, TransactionType.CHECKOUT);
        assertEquals(libraryTransaction, libraryTransaction2);
    }

    /**
     * We are testing if two transactions that are same but have different dates are not same
     */
    @Test
    public void checkIfTwoLibraryTransactionsAreNotSameTest1(){
        libraryTransaction.setTransactionDate(Date.valueOf(LocalDate.now()));
        Book book1 = new Book("Title1", "Author1", "978-0-06-112008-4");
        Patron patron1 = new Patron("Alice", "A123");
        libraryTransaction.setBook(book1);
        libraryTransaction.setPatron(patron1);
        libraryTransaction.setType(TransactionType.CHECKOUT);
        LibraryTransaction libraryTransaction2 = new LibraryTransaction(Date.valueOf(LocalDate.now()), book1, patron1, TransactionType.RETURN);
        assertNotEquals(libraryTransaction, libraryTransaction2);
    }
    /**
     * We are testing if two transactions that are same but have different transaction type are not same
     */
    @Test
    public void checkIfTwoLibraryTransactionsAreNotSameTest2(){
        LocalDate date = LocalDate.now();
        LocalDate tomorrow = date.plusDays(1);
        libraryTransaction.setTransactionDate(Date.valueOf(tomorrow));
        Book book1 = new Book("Title1", "Author1", "978-0-06-112008-4");
        Patron patron1 = new Patron("Alice", "A123");
        libraryTransaction.setBook(book1);
        libraryTransaction.setPatron(patron1);
        libraryTransaction.setType(TransactionType.CHECKOUT);
        LibraryTransaction libraryTransaction2 = new LibraryTransaction(Date.valueOf(LocalDate.now()), book1, patron1, TransactionType.CHECKOUT);
        assertNotEquals(libraryTransaction, libraryTransaction2);
    }
    /**
     * We are testing if two transactions that are same but have different books are not same
     */
    @Test
    public void checkIfTwoLibraryTransactionsAreNotSameTest3(){
        libraryTransaction.setTransactionDate(Date.valueOf(LocalDate.now()));
        Book book1 = new Book("Title1", "Author1", "978-0-06-112008-4");
        Patron patron1 = new Patron("Alice", "A123");
        libraryTransaction.setBook(book1);
        libraryTransaction.setPatron(patron1);
        libraryTransaction.setType(TransactionType.CHECKOUT);
        LibraryTransaction libraryTransaction2 = new LibraryTransaction(Date.valueOf(LocalDate.now()),
                new Book("Title1", "Author1", "111-2-33-444444-5"), patron1, TransactionType.CHECKOUT);
        assertNotEquals(libraryTransaction, libraryTransaction2);
    }
    /**
     * We are testing if two transactions that are same but have different patrons are not same
     */
    @Test
    public void checkIfTwoLibraryTransactionsAreNotSameTest4(){
        libraryTransaction.setTransactionDate(Date.valueOf(LocalDate.now()));
        Book book1 = new Book("Title1", "Author1", "978-0-06-112008-4");
        Patron patron1 = new Patron("Alice", "A123");
        libraryTransaction.setBook(book1);
        libraryTransaction.setPatron(patron1);
        libraryTransaction.setType(TransactionType.CHECKOUT);
        LibraryTransaction libraryTransaction2 = new LibraryTransaction(Date.valueOf(LocalDate.now()), book1,
                new Patron("Alice", "B345"), TransactionType.CHECKOUT);
        assertNotEquals(libraryTransaction, libraryTransaction2);
    }
}