package org.djordje.library;

import org.djordje.entity.Book;
import org.djordje.entity.Patron;
import org.djordje.enums.TransactionType;

import java.util.Date;

public class LibraryTransaction {
    private Date transactionDate;
    private Book book;
    private Patron patron;
    private TransactionType type;
    /**
     * Creating empty and parameterized constructors, getters/setters and toString method for transaction details
     */
    public LibraryTransaction() {
    }

    public LibraryTransaction(Date transactionDate, Book book, Patron patron, TransactionType type) {
        this.transactionDate = transactionDate;
        this.book = book;
        this.patron = patron;
        this.type = type;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Patron getPatron() {
        return patron;
    }

    public void setPatron(Patron patron) {
        this.patron = patron;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Date of transaction: " + transactionDate + "\nBook: " + book + "\nPatron: " + patron + "\nTransaction type: " + type;
    }
}
