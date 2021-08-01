package com.getir.readingIsGood.model.response;

import com.getir.readingIsGood.model.dto.UserStatisticsDTO;

import java.util.List;

public class CustomerStatisticsResponse {
    List<UserStatisticsDTO> customerStatistics;

    public List<UserStatisticsDTO> getCustomerStatistics() {
        return customerStatistics;
    }

    public void setCustomerStatistics(List<UserStatisticsDTO> customerStatistics) {
        this.customerStatistics = customerStatistics;
    }

    @Override
    public String toString() {
        return "CustomerStatisticsResponse{" +
                "customerStatistics=" + customerStatistics +
                '}';
    }
}
