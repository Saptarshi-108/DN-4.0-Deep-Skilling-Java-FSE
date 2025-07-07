package com.library.repository;

public class BookRepository {

    public void saveBook(String bookName) {
        System.out.println("Book saved: " + bookName);
    }

    // You can optionally add more methods for demonstration:
    public void deleteBook(String bookName) {
        System.out.println("Book deleted: " + bookName);
    }

    public void findBook(String bookName) {
        System.out.println("Searching for book: " + bookName);
    }
}