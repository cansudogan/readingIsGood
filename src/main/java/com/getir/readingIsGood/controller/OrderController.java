package com.getir.readingIsGood.controller;

import com.getir.readingIsGood.model.request.OrderCreateRequest;
import com.getir.readingIsGood.model.response.OrderResponse;
import com.getir.readingIsGood.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public OrderResponse createOrder(@Valid @RequestBody OrderCreateRequest request) {
        return orderService.createOrder(request);
    }
}
