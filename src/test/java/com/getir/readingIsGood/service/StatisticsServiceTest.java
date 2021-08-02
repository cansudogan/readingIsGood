package com.getir.readingIsGood.service;

import com.getir.readingIsGood.domain.Book;
import com.getir.readingIsGood.domain.Order;
import com.getir.readingIsGood.repository.IOrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class StatisticsServiceTest {
    @InjectMocks
    private StatisticsService statisticsService;

    @Mock
    private IOrderRepository orderRepository;

    @Test
    public void testGetCustomerStatistics() {
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Test");
        book.setDescription("Test test test");
        book.setAuthor("Test test");
        book.setPrice(new BigDecimal(500));
        book.setRemainingStock(10L);

        List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        bookList.add(book);
        bookList.add(book);

        Order order1 = new Order();
        order1.setId(1L);
        order1.setDateCreated(new Date(2021, Calendar.AUGUST, 2));
        order1.setTotalPrice(new BigDecimal(500));
        order1.setUserId(1L);
        order1.setBook(bookList);
        order1.setTotalBookCount(10L);

        Order order2 = new Order();
        order2.setId(1L);
        order2.setDateCreated(new Date(2021, Calendar.JULY, 2));
        order2.setTotalPrice(new BigDecimal(500));
        order2.setUserId(1L);
        order2.setBook(bookList);
        order2.setTotalBookCount(15L);

        List<Order> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);

        Mockito.when(orderRepository.findByUserId(1L)).thenReturn(orderList);
        statisticsService.getCustomerStatistics(1L);
    }
}
