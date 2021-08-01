package com.getir.readingIsGood.model.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CustomerPageRequest {

    @NotNull(message = "Page is required")
    @Min(value = 0)
    private int page;

    @NotNull(message = "Page size is required")
    @Min(value = 0)
    private int size;

    @Override
    public String toString() {
        return "CustomerPageRequest{" +
                ", page=" + page +
                ", size=" + size +
                '}';
    }


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
