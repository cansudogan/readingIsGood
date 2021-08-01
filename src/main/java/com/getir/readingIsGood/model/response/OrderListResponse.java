package com.getir.readingIsGood.model.response;

import com.getir.readingIsGood.model.dto.OrderDTO;

import java.util.List;

public class OrderListResponse {
    private List<OrderDTO> orders;

    @Override
    public String toString() {
        return "OrderListResponse{" +
                "orders=" + orders +
                '}';
    }

    public List<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDTO> orders) {
        this.orders = orders;
    }
}
