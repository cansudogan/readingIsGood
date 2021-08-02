package com.getir.readingIsGood.service;

import com.getir.readingIsGood.domain.Book;
import com.getir.readingIsGood.domain.Order;
import com.getir.readingIsGood.domain.User;
import com.getir.readingIsGood.model.dto.BookDetailDTO;
import com.getir.readingIsGood.model.request.OrderByDateRequest;
import com.getir.readingIsGood.model.request.OrderCreateRequest;
import com.getir.readingIsGood.repository.IBookRepository;
import com.getir.readingIsGood.repository.IOrderRepository;
import com.getir.readingIsGood.repository.IUserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.*;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {
    @InjectMocks
    private OrderService orderService;

    @Mock
    private IBookRepository bookRepository;

    @Mock
    private IUserRepository userRepository;

    @Mock
    private IOrderRepository orderRepository;

    @Test
    public void testCreateOrder() {
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

        Mockito.when(bookRepository.findAllById(Mockito.anyCollection())).thenReturn(bookList);

        User user = new User();
        user.setId(1L);
        user.setUsername("cansudogan");
        user.setEmail("cansudogan95@gmail.com");
        user.setRoles(new HashSet());
        user.setPassword("12345");

        Mockito.when(userRepository.getById(user.getId())).thenReturn(user);

        List<BookDetailDTO> orders = new ArrayList<>();
        BookDetailDTO dto = new BookDetailDTO();
        dto.setBookCount(1L);
        dto.setBookId(1L);

        OrderCreateRequest request = new OrderCreateRequest();
        request.setUserId(1L);
        request.setBookOrders(orders);

        orderService.createOrder(request, request.getUserId());

    }

    @Test
    public void testGetOrderById() {
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

        Order order = new Order();
        order.setId(1L);
        order.setDateCreated(new Date(2021, Calendar.AUGUST, 7));
        order.setTotalPrice(new BigDecimal(500));
        order.setUserId(1L);
        order.setBook(bookList);

        User user = new User();
        user.setId(1L);
        user.setUsername("cansudogan");
        user.setEmail("cansudogan95@gmail.com");
        user.setRoles(new HashSet());
        user.setPassword("12345");

        Mockito.when(orderRepository.getByIdAndUserId(order.getId(), user.getId())).thenReturn(order);

    }

    @Test
    public void testGetOrderByDateInterval() {
        OrderByDateRequest request = new OrderByDateRequest();
        request.setStartDate(new Date(2020, Calendar.AUGUST, 2));
        request.setEndDate(new Date(2021, Calendar.AUGUST, 2));

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

        List<Order> orderList = new ArrayList<>();
        Order order = new Order();
        order.setId(1L);
        order.setDateCreated(new Date(2021, Calendar.AUGUST, 7));
        order.setTotalPrice(new BigDecimal(500));
        order.setUserId(1L);
        order.setBook(bookList);

        orderList.add(order);
        orderList.add(order);

        Mockito.when(orderRepository.getAllByUserIdAndDateCreatedBetween(1L, request.getStartDate(), request.getEndDate()))
                .thenReturn(orderList);

        orderService.getOrderByDateInterval(1L, request);

    }
}
