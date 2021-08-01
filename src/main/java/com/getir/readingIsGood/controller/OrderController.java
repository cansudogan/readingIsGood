package com.getir.readingIsGood.controller;

import com.getir.readingIsGood.model.request.OrderByDateRequest;
import com.getir.readingIsGood.model.request.OrderCreateRequest;
import com.getir.readingIsGood.model.response.OrderListResponse;
import com.getir.readingIsGood.model.response.OrderResponse;
import com.getir.readingIsGood.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public OrderResponse createOrder(@Valid @RequestBody OrderCreateRequest request) {
        return orderService.createOrder(request);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderResponse getOrderById(@PathVariable Long id) {
        log.debug("OrderController - getOrderById started");
        return orderService.getOrderById(id);
    }

    @PostMapping(value = "/date")
    @ResponseStatus(HttpStatus.OK)
    public OrderListResponse getOrderByDateInterval(@Valid @RequestBody OrderByDateRequest request) {
        log.debug("Get order by date interval started for request {}", request);
        return orderService.getOrderByDateInterval(request);
    }
}
