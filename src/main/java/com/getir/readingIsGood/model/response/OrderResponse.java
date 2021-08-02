package com.getir.readingIsGood.model.response;

import com.getir.readingIsGood.model.dto.OrderResponseDTO;
import com.getir.readingIsGood.model.dto.UserResponseDTO;

public class OrderResponse {
    private OrderResponseDTO order;
    private UserResponseDTO user;


    public OrderResponseDTO getOrder() {
        return order;
    }

    public void setOrder(OrderResponseDTO order) {
        this.order = order;
    }

    public UserResponseDTO getUser() {
        return user;
    }

    public void setUser(UserResponseDTO user) {
        this.user = user;
    }
}
