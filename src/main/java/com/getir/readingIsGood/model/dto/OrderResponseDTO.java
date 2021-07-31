package com.getir.readingIsGood.model.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderResponseDTO {
    private BigDecimal totalPrice;
    private Date dateCreated;
    private List<BookResponseDTO> bookList;

    @Override
    public String toString() {
        return "OrderResponseDTO{" +
                "totalPrice=" + totalPrice +
                ", dateCreated=" + dateCreated +
                ", bookList=" + bookList +
                '}';
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<BookResponseDTO> getBookList() {
        return bookList;
    }

    public void setBookList(List<BookResponseDTO> bookList) {
        this.bookList = bookList;
    }
}
