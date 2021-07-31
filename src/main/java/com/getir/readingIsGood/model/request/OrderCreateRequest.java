package com.getir.readingIsGood.model.request;

import com.getir.readingIsGood.model.dto.BookDetailDTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


public class OrderCreateRequest {
    @NotNull(message = "Customer id is required")
    private Long customerId;

    @NotEmpty(message = "Order list can not be empty")
    private List<BookDetailDTO> bookOrders;

    @Override
    public String toString() {
        return "OrderCreateRequest{" +
                "customerId=" + customerId +
                ", bookOrders=" + bookOrders +
                '}';
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<BookDetailDTO> getBookOrders() {
        return bookOrders;
    }

    public void setBookOrders(List<BookDetailDTO> bookOrders) {
        this.bookOrders = bookOrders;
    }
}
