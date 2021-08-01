package com.getir.readingIsGood.service;

import com.getir.readingIsGood.domain.Customer;
import com.getir.readingIsGood.domain.Order;
import com.getir.readingIsGood.model.dto.OrderDTO;
import com.getir.readingIsGood.model.request.CustomerCreateRequest;
import com.getir.readingIsGood.model.request.CustomerRequest;
import com.getir.readingIsGood.model.response.CustomerPageResponse;
import com.getir.readingIsGood.model.response.CustomerResponse;
import com.getir.readingIsGood.repository.ICustomerRepository;
import com.getir.readingIsGood.repository.IOrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CustomerService {
    private final Logger log = LoggerFactory.getLogger(CustomerService.class);
    private final ICustomerRepository customerRepository;
    private final IOrderRepository orderRepository;

    public CustomerService(ICustomerRepository customerRepository, IOrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    public CustomerResponse createCustomer(CustomerCreateRequest request) {
        log.debug("CustomerService - createCustomer started");
        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setSurname(request.getSurname());
        customer.setMail(request.getEmail());
        customerRepository.save(customer);

        CustomerResponse response = new CustomerResponse();
        response.setCustomer(customer.customerDTO(customer));

        log.debug("CustomerService - createCustomer - customer created");
        return response;
    }

    public CustomerResponse getCustomer(Long id) {
        log.debug("CustomerService - getCustomer started");
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));

        CustomerResponse response = new CustomerResponse();
        response.setCustomer(customer.customerDTO(customer));

        log.debug("Custome information: {}", response);

        return response;
    }

    public CustomerPageResponse getCustomerOrders(CustomerRequest request) {
        CustomerPageResponse customerPageResponse = new CustomerPageResponse();
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());
        List<Order> orderList = orderRepository.findByCustomerId(request.getId(), pageable);

        if (orderList.isEmpty()) {
            customerPageResponse.setOrderDTO(new PageImpl<>(Collections.emptyList()));
            return customerPageResponse;
        }

        List<OrderDTO> dtoList = new ArrayList<>();

        orderList.forEach(order -> dtoList.add(order.orderDTO(order)));
        customerPageResponse.setOrderDTO(new PageImpl<>(dtoList, PageRequest.of(request.getPage(), request.getSize()), orderRepository.count()));
        log.debug("CustomerService - getCustomerOrders is finished {}", customerPageResponse);
        return customerPageResponse;
    }
}
