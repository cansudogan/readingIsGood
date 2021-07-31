package com.getir.readingIsGood.model.dto;

import javax.validation.constraints.NotNull;

public class BookDetailDTO {
    @NotNull(message = "Book id is required")
    private Long bookId;

    @NotNull(message = "Book id count required")
    private Long bookCount;

    @Override
    public String toString() {
        return "BookDetailDTO{" +
                "bookId=" + bookId +
                ", bookCount=" + bookCount +
                '}';
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getBookCount() {
        return bookCount;
    }

    public void setBookCount(Long bookCount) {
        this.bookCount = bookCount;
    }
}
