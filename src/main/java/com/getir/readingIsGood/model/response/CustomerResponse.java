package com.getir.readingIsGood.model.response;

import com.getir.readingIsGood.domain.Customer;

public class CustomerResponse {
    private Customer customer;

    @Override
    public String toString() {
        return "CustomerResponse{" +
                "customer=" + customer +
                '}';
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
