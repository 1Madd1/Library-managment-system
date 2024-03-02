package org.djordje.entity;

import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean available;

    /**
     * Creating empty and parameterized constructors, getters/setters and toString method for book details
     */
    public Book() {
    }

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Title: " + title + "; Author: " + author + " ISBN: " + isbn + "; Availability: " + availability() + "\n";
    }
    /**
     * equals method used to compare two Book classes
     * @param o - the book class to be compared
     * @return - true if they point to the same class or have same isbn and are both available, otherwise return false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return isAvailable() == book.isAvailable() && Objects.equals(getIsbn(), book.getIsbn());
    }

    /**
     * availability method used just for toString() method use for more logical output
     * (instead of printing true or false for book availability)
     * @return - returns a string message if the book is available or not
     */
    private String availability(){
        return (available) ? "Available" : "Not available";
    }
}
