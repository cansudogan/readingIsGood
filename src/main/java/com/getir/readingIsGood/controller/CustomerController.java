package com.getir.readingIsGood.controller;

import com.getir.readingIsGood.model.request.CustomerCreateRequest;
import com.getir.readingIsGood.model.response.CustomerResponse;
import com.getir.readingIsGood.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public CustomerResponse createCustomer(@Valid @RequestBody CustomerCreateRequest request) {
        return customerService.createCustomer(request);
    }

    @GetMapping(value = "/{id}")
    public CustomerResponse getCustomer(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }

}
