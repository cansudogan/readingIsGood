package com.getir.readingIsGood.controller;

import com.getir.readingIsGood.model.response.CustomerStatisticsResponse;
import com.getir.readingIsGood.service.StatisticsService;
import com.getir.readingIsGood.util.Util;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/statistics")
@Api
@SwaggerDefinition(tags = {
        @Tag(name = "statistics-api", description = "Statistics Api")
})
public class StatisticsController {
    private static final Logger log = LoggerFactory.getLogger(StatisticsController.class);

    private final StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('CUSTOMER')")
    @ApiOperation(value = "Get User Statistics", notes = "Get User Statistics", authorizations = {@Authorization(value = "jwtToken")})
    public CustomerStatisticsResponse getCustomerStatistics() {
        Long userId = Util.getUserId();
        log.debug("Get customer statistics by user id {}", userId);
        return statisticsService.getCustomerStatistics(userId);
    }
}
