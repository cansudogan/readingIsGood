package com.getir.readingIsGood.service;

import com.getir.readingIsGood.domain.Customer;
import com.getir.readingIsGood.model.request.CustomerCreateRequest;
import com.getir.readingIsGood.model.response.CustomerResponse;
import com.getir.readingIsGood.repository.ICustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class CustomerService {
    private final Logger log = LoggerFactory.getLogger(CustomerService.class);
    private final ICustomerRepository repository;

    public CustomerService(ICustomerRepository repository) {
        this.repository = repository;
    }

    public CustomerResponse createCustomer(CustomerCreateRequest request) {
        log.debug("CustomerService - createCustomer started");
        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setSurname(request.getSurname());
        customer.setMail(request.getEmail());
        repository.save(customer);

        CustomerResponse response = new CustomerResponse();
        response.setCustomer(customer);

        log.debug("CustomerService - createCustomer - customer created");
        return response;
    }

    public CustomerResponse getCustomer(Long id) {
        log.debug("CustomerService - getCustomer started");
        Customer customer = repository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
        CustomerResponse response = new CustomerResponse();
        response.setCustomer(customer);

        return response;
    }
}
