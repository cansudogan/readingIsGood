package com.getir.readingIsGood.domain;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Long customerId;

    @DecimalMin(value = "0.0", inclusive = false, message = "Price can not be less than 0.")
    private BigDecimal totalPrice;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @NotEmpty(message = "Order must have minimum one book")
    @ManyToMany(cascade = {CascadeType.ALL})
    private List<Book> bookList;

    private Long totalBookCount;

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", totalPrice=" + totalPrice +
                ", dateCreated=" + dateCreated +
                ", bookList=" + bookList +
                ", totalBookCount=" + totalBookCount +
                '}';
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Long getTotalBookCount() {
        return totalBookCount;
    }

    public void setTotalBookCount(Long totalBookCount) {
        this.totalBookCount = totalBookCount;
    }
}
