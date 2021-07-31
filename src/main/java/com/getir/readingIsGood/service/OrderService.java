package com.getir.readingIsGood.service;

import com.getir.readingIsGood.domain.Book;
import com.getir.readingIsGood.domain.Customer;
import com.getir.readingIsGood.domain.Order;
import com.getir.readingIsGood.model.dto.BookDetailDTO;
import com.getir.readingIsGood.model.request.OrderCreateRequest;
import com.getir.readingIsGood.model.response.OrderResponse;
import com.getir.readingIsGood.repository.IBookRepository;
import com.getir.readingIsGood.repository.ICustomerRepository;
import com.getir.readingIsGood.repository.IOrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    private final Logger log = LoggerFactory.getLogger(OrderService.class);

    private final ICustomerRepository customerRepository;
    private final IBookRepository bookRepository;
    private final IOrderRepository orderRepository;

    public OrderService(ICustomerRepository customerRepository, IBookRepository bookRepository, IOrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.bookRepository = bookRepository;
        this.orderRepository = orderRepository;
    }

    public OrderResponse createOrder(OrderCreateRequest request) {
        log.debug("OrderService - createOrder started");
        Customer customer = customerRepository.getById(request.getCustomerId());

        List<Long> bookIDs = new ArrayList<Long>();
        request.getBookOrders().forEach(bookDetailDTO -> bookIDs.add(bookDetailDTO.getBookId()));
        List<Book> books = bookRepository.findAllById(bookIDs);

        Order order = new Order();
        order.setCustomerId(request.getCustomerId());
        order.setBook(books);
        order.setDateCreated(new Date());
        order.setTotalBookCount(calculateTotalBookCount(request));
        order.setTotalPrice(calculateTotalPrice(request, books));
        customer.getOrderList().add(order);

        customerRepository.save(customer);
        updateBookStock(request, books);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrder(order.responseDTO(order));
        orderResponse.setCustomer(customer.responseDTO(customer));

        log.debug("OrderService - createOrder - order created");
        return orderResponse;
    }

    private BigDecimal calculateTotalPrice(OrderCreateRequest request, List<Book> books) {
        log.debug("OrderService - calculateTotalPrice started");
        long totalPrice = 0L;
        for (BookDetailDTO dto : request.getBookOrders()) {
            Book book = books.stream().filter(b -> b.getId().equals(dto.getBookId())).findAny().orElse(null);
            if (book != null) {
                totalPrice += book.getPrice().longValue() * dto.getBookCount();
            } else {
                throw new EntityExistsException();
            }
        }
        log.debug("OrderService - calculateTotalPrice - totalPrice calculated");
        return new BigDecimal(totalPrice);
    }

    private void updateBookStock(OrderCreateRequest request, List<Book> books) {
        log.debug("OrderService - updateBookStock started");
        for (BookDetailDTO dto : request.getBookOrders()) {
            Book book = books.stream().filter(b -> b.getId().equals(dto.getBookId())).findAny().orElse(null);
            if (book != null) {
                if (book.getRemainingStock() > dto.getBookCount()) {
                    book.setRemainingStock(book.getRemainingStock() - dto.getBookCount());
                    bookRepository.save(book);
                    log.debug("OrderService - updateBookStock - bookStockInformation updated");
                } else {
                    log.error("Book not found");
                    throw new EntityExistsException("Book not found");
                }
            }

        }
    }

    private Long calculateTotalBookCount(OrderCreateRequest request) {
        log.debug("OrderService - calculateTotalBookCount started");
        Long totalBookCount = 0L;
        for (BookDetailDTO dto : request.getBookOrders()) {
            totalBookCount += dto.getBookCount();
        }
        log.debug("OrderService - calculateTotalBookCount - totalBookCount calculated");
        return totalBookCount;
    }
}
