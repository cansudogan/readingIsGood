package com.getir.readingIsGood.repository;

import com.getir.readingIsGood.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order, Long> {
}
