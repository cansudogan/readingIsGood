package com.getir.readingIsGood.domain;

import com.getir.readingIsGood.model.dto.BookDTO;
import com.getir.readingIsGood.model.dto.BookResponseDTO;
import com.getir.readingIsGood.model.dto.OrderDTO;
import com.getir.readingIsGood.model.dto.OrderResponseDTO;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private int version;

    private Long userId;

    @DecimalMin(value = "0.0", inclusive = false, message = "Price can not be less than 0.")
    private BigDecimal totalPrice;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "orders_books",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> book;

    private Long totalBookCount;

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", totalPrice=" + totalPrice +
                ", dateCreated=" + dateCreated +
                ", book=" + book +
                ", totalBookCount=" + totalBookCount +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }

    public Long getTotalBookCount() {
        return totalBookCount;
    }

    public void setTotalBookCount(Long totalBookCount) {
        this.totalBookCount = totalBookCount;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public OrderDTO orderDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setTotalPrice(order.getTotalPrice());
        dto.setDateCreated(order.getDateCreated());
        dto.setCustomerId(order.getUserId());
        dto.setTotalBookCount(order.getTotalBookCount());

        List<BookDTO> bookDTOS = new ArrayList<>();
        order.getBook().forEach(book -> bookDTOS.add(book.bookDTO(book)));

        dto.setBookList(bookDTOS);

        return dto;
    }

    public OrderResponseDTO responseDTO(Order order) {
        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
        orderResponseDTO.setDateCreated(order.getDateCreated());
        orderResponseDTO.setTotalPrice(order.getTotalPrice());

        List<BookResponseDTO> bookResponseDTOs = new ArrayList<BookResponseDTO>();
        order.getBook().forEach(book -> bookResponseDTOs.add(book.responseDTO(book)));

        orderResponseDTO.setBookList(bookResponseDTOs);

        return orderResponseDTO;
    }
}
