package com.getir.readingIsGood.model.response;

import com.getir.readingIsGood.domain.Customer;
import com.getir.readingIsGood.model.dto.CustomerDTO;

public class CustomerResponse {
    private CustomerDTO customer;

    @Override
    public String toString() {
        return "CustomerResponse{" +
                "customer=" + customer +
                '}';
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }
}
