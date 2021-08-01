package com.getir.readingIsGood.model.response;

import com.getir.readingIsGood.model.dto.OrderDTO;
import org.springframework.data.domain.Page;

public class CustomerPageResponse {
    private Page<OrderDTO> orderDTO;

    public Page<OrderDTO> getOrderDTOS() {
        return orderDTO;
    }

    public void setOrderDTO(Page<OrderDTO> orderDTO) {
        this.orderDTO = orderDTO;
    }

    @Override
    public String toString() {
        return "CustomerPageResponse{" +
                "orderDTO=" + orderDTO +
                '}';
    }
}
