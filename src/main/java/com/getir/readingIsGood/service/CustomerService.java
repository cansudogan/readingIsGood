package com.getir.readingIsGood.service;

import com.getir.readingIsGood.domain.Customer;
import com.getir.readingIsGood.model.request.CustomerCreateRequest;
import com.getir.readingIsGood.model.response.CustomerResponse;
import com.getir.readingIsGood.repository.ICustomerRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class CustomerService {
    private final ICustomerRepository repository;

    public CustomerService(ICustomerRepository repository) {
        this.repository = repository;
    }

    public CustomerResponse createCustomer(CustomerCreateRequest request) {
        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setSurname(request.getSurname());
        customer.setMail(request.getEmail());
        repository.save(customer);

        CustomerResponse response = new CustomerResponse();
        response.setCustomer(customer);

        return response;
    }

    public CustomerResponse getCustomer(Long id) {
        Customer customer = repository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
        CustomerResponse response = new CustomerResponse();
        response.setCustomer(customer);

        return response;
    }
}
