package com.getir.readingIsGood.model.request;

import javax.validation.constraints.NotNull;

public class BookStockUpdateRequest {
    @NotNull(message = "Book id can not be blank")
    private Long id;

    @NotNull(message = "Stock information is required")
    private Long remainingStock;

    @Override
    public String toString() {
        return "BookStockUpdateRequest{" +
                "id=" + id +
                ", remainingStock=" + remainingStock +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRemainingStock() {
        return remainingStock;
    }

    public void setRemainingStock(Long remainingStock) {
        this.remainingStock = remainingStock;
    }
}
