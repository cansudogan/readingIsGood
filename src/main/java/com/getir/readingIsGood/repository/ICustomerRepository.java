package com.getir.readingIsGood.repository;

import com.getir.readingIsGood.domain.Customer;
import com.getir.readingIsGood.domain.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    Customer getCustomerByOrderListId(Long id);
}
