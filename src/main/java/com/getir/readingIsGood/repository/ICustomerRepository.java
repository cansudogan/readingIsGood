package com.getir.readingIsGood.repository;

import com.getir.readingIsGood.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
}
