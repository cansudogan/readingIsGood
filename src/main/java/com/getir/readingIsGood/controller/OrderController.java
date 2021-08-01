package com.getir.readingIsGood.controller;

import com.getir.readingIsGood.model.request.CustomerPageRequest;
import com.getir.readingIsGood.model.request.OrderByDateRequest;
import com.getir.readingIsGood.model.request.OrderCreateRequest;
import com.getir.readingIsGood.model.response.CustomerPageResponse;
import com.getir.readingIsGood.model.response.OrderListResponse;
import com.getir.readingIsGood.model.response.OrderResponse;
import com.getir.readingIsGood.service.OrderService;
import com.getir.readingIsGood.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/order")
public class OrderController {
    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('CUSTOMER')")
    public OrderResponse createOrder(@Validated @RequestBody OrderCreateRequest request) {
        Long userId = Util.getUserId();
        return orderService.createOrder(request, userId);
    }

    @GetMapping(value = "/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('CUSTOMER') OR hasRole('ADMIN')")
    public OrderResponse getOrderById(@PathVariable Long orderId) {
        log.debug("OrderController - getOrderById started");
        return orderService.getOrderById(Util.getUserId(), orderId);
    }

    @PostMapping(value = "/date")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('CUSTOMER') OR hasRole('ADMIN')")
    public OrderListResponse getOrderByDateInterval(@Valid @RequestBody OrderByDateRequest request) {
        log.debug("Get order by date interval started for request {}", request);
        Long userId = Util.getUserId();
        return orderService.getOrderByDateInterval(userId, request);
    }

    @PostMapping(value = "/getAllOrders")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('CUSTOMER')")
    public CustomerPageResponse getAllOrders(@Valid @RequestBody CustomerPageRequest request) {
        log.info("Get customer orders started for request {}", request);
        Long userId = Util.getUserId();
        return orderService.getAllOrders(request, userId);
    }
}
