package com.getir.readingIsGood.service;

import com.getir.readingIsGood.domain.Book;
import com.getir.readingIsGood.model.request.BookCreateRequest;
import com.getir.readingIsGood.model.request.BookStockUpdateRequest;
import com.getir.readingIsGood.repository.IBookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {
    @InjectMocks
    private BookService bookService;

    @Mock
    private IBookRepository bookRepository;

    @Test
    public void testSaveBook() {
        BookCreateRequest request = new BookCreateRequest();
        request.setTitle("Test");
        request.setDescription("TestDesc");
        request.setAuthor("Test Test");
        request.setPrice(new BigDecimal(11));
        request.setRemainingStock(10L);

        bookService.createBook(request);
    }

    @Test
    public void testUpdateBook() {
        Book book = new Book();
        book.setId(2L);

        Mockito.when(bookRepository.findById(book.getId())).thenReturn(java.util.Optional.of(book));

        BookStockUpdateRequest request = new BookStockUpdateRequest();
        request.setId(2L);
        request.setRemainingStock(15L);

        bookService.updateBookStock(request);

    }

    @Test
    public void testDeleteBook() {
        Book book = new Book();
        book.setId(2L);
        book.setTitle("Test");
        book.setAuthor("Test test");
        book.setDescription("Test test test");
        book.setPrice(new BigDecimal(50));

        Mockito.when(bookRepository.findById(book.getId())).thenReturn(java.util.Optional.of(book));

        bookService.deleteBook(book.getId());
    }

}
