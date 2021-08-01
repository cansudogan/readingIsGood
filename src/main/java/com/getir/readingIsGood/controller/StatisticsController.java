package com.getir.readingIsGood.controller;

import com.getir.readingIsGood.model.response.CustomerStatisticsResponse;
import com.getir.readingIsGood.service.StatisticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/statistics")
public class StatisticsController {
    private static final Logger log = LoggerFactory.getLogger(StatisticsController.class);

    private final StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerStatisticsResponse getCustomerStatistics(@PathVariable Long id) {
        log.debug("Get customer statistics by customer id {}", id);
        return statisticsService.getCustomerStatistics(id);
    }
}
