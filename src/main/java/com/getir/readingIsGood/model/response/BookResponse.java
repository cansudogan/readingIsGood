package com.getir.readingIsGood.model.response;

import com.getir.readingIsGood.domain.Book;

public class BookResponse {
    private Book book;

    @Override
    public String toString() {
        return "BookResponse{" +
                "book=" + book +
                '}';
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
