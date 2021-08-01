package com.getir.readingIsGood.service;

import com.getir.readingIsGood.domain.Order;
import com.getir.readingIsGood.model.dto.CustomerStatisticsDTO;
import com.getir.readingIsGood.model.response.CustomerStatisticsResponse;
import com.getir.readingIsGood.repository.IOrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@Service
@Transactional
public class StatisticsService {
    private final Logger log = LoggerFactory.getLogger(CustomerService.class);

    private final IOrderRepository orderRepository;

    public StatisticsService(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public CustomerStatisticsResponse getCustomerStatistics(Long id) {
        CustomerStatisticsResponse response = new CustomerStatisticsResponse();
        List<CustomerStatisticsDTO> statisticList = new ArrayList<>();

        List<Order> orderList = orderRepository.findByCustomerId(id);

        Map<Month, List<Order>> orderMap = orderList.stream()
                .collect(groupingBy(order -> {
                    LocalDate localDate = order.getDateCreated().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    return localDate.getMonth();
                }));

        orderMap.forEach((key, orders) -> {
            CustomerStatisticsDTO dto = new CustomerStatisticsDTO();
            dto.setMonth(key);
            dto.setTotalOrderCount(orders.size());
            dto.setTotalBookCount(orders.stream().mapToInt(order -> Math.toIntExact(order.getTotalBookCount())).sum());
            BigDecimal totalAmount = BigDecimal.ZERO;
            for (Order o : orders) {
                totalAmount = totalAmount.add(BigDecimal.valueOf(o.getTotalPrice().doubleValue()));
            }
            dto.setTotalPurchasedAmount(totalAmount);
            statisticList.add(dto);
        });

        response.setCustomerStatistics(statisticList);

        log.debug("Statistics: {}", response);

        return response;
    }
}
