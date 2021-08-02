package com.getir.readingIsGood.repository;

import com.getir.readingIsGood.domain.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface IOrderRepository extends JpaRepository<Order, Long> {
    List<Order> getAllByUserIdAndDateCreatedBetween(Long userId, Date startDate, Date endDate);

    Order getByIdAndUserId(Long orderId, Long userId);

    List<Order> findByUserId(Long id);

    List<Order> findAllByUserId(Long userId, Pageable pageable);
}
