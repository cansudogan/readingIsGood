package com.getir.readingIsGood.model.request;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class BookCreateRequest {
    @NotEmpty(message = "Book title is required")
    private String title;

    private String description;

    @NotEmpty(message = "Book's author is required")
    private String author;

    @DecimalMin(value = "0.0", inclusive = false, message = "Price can not be less than 0.")
    private BigDecimal price;

    @NotNull(message = "Stock can not be null.")
    private Long remainingStock;

    @Override
    public String toString() {
        return "BookCreateRequest{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", remainingStock=" + remainingStock +
                '}';
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
}
