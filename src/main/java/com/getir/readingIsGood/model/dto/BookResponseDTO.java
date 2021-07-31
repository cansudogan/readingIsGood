package com.getir.readingIsGood.model.dto;

import java.math.BigDecimal;

public class BookResponseDTO {
    private String title;
    private String author;
    private BigDecimal price;

    @Override
    public String toString() {
        return "BookResponseDTO{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
