package com.getir.readingIsGood.model.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CustomerRequest {
    @NotNull(message = "Id is required")
    private Long id;

    @NotNull(message = "Page is required")
    @Min(value = 0)
    private int page;

    @NotNull(message = "Page size is required")
    @Min(value = 0)
    private int size;

    @Override
    public String toString() {
        return "CustomerRequest{" +
                "id=" + id +
                ", page=" + page +
                ", size=" + size +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
