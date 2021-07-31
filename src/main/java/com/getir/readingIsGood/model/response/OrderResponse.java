package com.getir.readingIsGood.model.response;

import com.getir.readingIsGood.model.dto.CustomerResponseDTO;
import com.getir.readingIsGood.model.dto.OrderResponseDTO;

public class OrderResponse {
    private OrderResponseDTO order;
    private CustomerResponseDTO customer;

    @Override
    public String toString() {
        return "OrderResponse{" +
                "order=" + order +
                ", customer=" + customer +
                '}';
    }

    public OrderResponseDTO getOrder() {
        return order;
    }

    public void setOrder(OrderResponseDTO order) {
        this.order = order;
    }

    public CustomerResponseDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerResponseDTO customer) {
        this.customer = customer;
    }
}
