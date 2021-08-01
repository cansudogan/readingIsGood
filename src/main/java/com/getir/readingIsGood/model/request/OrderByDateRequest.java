package com.getir.readingIsGood.model.request;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class OrderByDateRequest {
    @NotNull(message = "Start date is required.")
    private Date startDate;

    @NotNull(message = "End date is required.")
    private Date endDate;

    @Override
    public String toString() {
        return "OrderByDateRequest{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
