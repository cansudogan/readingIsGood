package com.getir.readingIsGood.model.request;

import com.getir.readingIsGood.model.dto.BookDetailDTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


public class OrderCreateRequest {
    @NotEmpty(message = "Order list can not be empty")
    private List<BookDetailDTO> bookOrders;

    public List<BookDetailDTO> getBookOrders() {
        return bookOrders;
    }

    public void setBookOrders(List<BookDetailDTO> bookOrders) {
        this.bookOrders = bookOrders;
    }
}
