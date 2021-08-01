package com.getir.readingIsGood.model.dto;

import java.math.BigDecimal;
import java.time.Month;

public class CustomerStatisticsDTO {
    private Month month;
    private int totalOrderCount;
    private int totalBookCount;
    private BigDecimal totalPurchasedAmount;

    @Override
    public String toString() {
        return "CustomerStatisticsDTO{" +
                "month=" + month +
                ", totalOrderCount=" + totalOrderCount +
                ", totalBookCount=" + totalBookCount +
                ", totalPurchasedAmount=" + totalPurchasedAmount +
                '}';
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public int getTotalOrderCount() {
        return totalOrderCount;
    }

    public void setTotalOrderCount(int totalOrderCount) {
        this.totalOrderCount = totalOrderCount;
    }

    public int getTotalBookCount() {
        return totalBookCount;
    }

    public void setTotalBookCount(int totalBookCount) {
        this.totalBookCount = totalBookCount;
    }

    public BigDecimal getTotalPurchasedAmount() {
        return totalPurchasedAmount;
    }

    public void setTotalPurchasedAmount(BigDecimal totalPurchasedAmount) {
        this.totalPurchasedAmount = totalPurchasedAmount;
    }
}
