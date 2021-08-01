package com.getir.readingIsGood.domain;


import com.getir.readingIsGood.model.dto.BookDTO;
import com.getir.readingIsGood.model.dto.BookResponseDTO;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Title is required.")
    private String title;

    private String description;

    @NotEmpty(message = "Author is required.")
    private String author;

    @DecimalMin(value = "0.0", inclusive = false, message = "Price can not be less than 0.")
    private BigDecimal price;

    @NotNull(message = "Stock is required.")
    private Long remainingStock;

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", remainingStock=" + remainingStock +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Long getRemainingStock() {
        return remainingStock;
    }

    public void setRemainingStock(Long remainingStock) {
        this.remainingStock = remainingStock;
    }

    public BookDTO bookDTO(Book book) {
        BookDTO dto = new BookDTO();
        dto.setId(getId());
        dto.setTitle(getTitle());
        dto.setAuthor(getAuthor());
        dto.setDescription(getDescription());
        dto.setPrice(getPrice().doubleValue());
        dto.setRemainingStock(getRemainingStock());

        return dto;
    }

    public BookResponseDTO responseDTO(Book book) {
        BookResponseDTO bookResponseDTO = new BookResponseDTO();
        bookResponseDTO.setTitle(book.getTitle());
        bookResponseDTO.setAuthor(book.getAuthor());
        bookResponseDTO.setPrice(book.getPrice());

        return bookResponseDTO;
    }
}
