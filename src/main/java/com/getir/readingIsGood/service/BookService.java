package com.getir.readingIsGood.service;

import com.getir.readingIsGood.domain.Book;
import com.getir.readingIsGood.model.request.BookCreateRequest;
import com.getir.readingIsGood.model.request.BookStockUpdateRequest;
import com.getir.readingIsGood.model.response.BookResponse;
import com.getir.readingIsGood.repository.IBookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class BookService {
    private final Logger log = LoggerFactory.getLogger(BookService.class);

    private final IBookRepository bookRepository;

    public BookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookResponse createBook(BookCreateRequest request) {
        log.debug("BookService - createBook started");
        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setDescription(request.getDescription());
        book.setAuthor(request.getAuthor());
        book.setPrice(request.getPrice());
        book.setRemainingStock(request.getRemainingStock());

        bookRepository.save(book);

        BookResponse response = new BookResponse();
        response.setBook(book);

        log.debug("BookService - createBook - book created");
        return response;
    }

    public BookResponse getBook(Long id) {
        log.debug("BookService - getBook started");
        Book book = bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
        BookResponse response = new BookResponse();
        response.setBook(book);

        log.debug("BookService - getBook ended");
        return response;
    }

    public BookResponse updateBookStock(BookStockUpdateRequest request) {
        log.debug("BookService - updateBookStock started");
        Book book = bookRepository.findById(request.getId()).orElseThrow(() -> new EntityNotFoundException(String.valueOf(request.getId())));

        book.setRemainingStock(request.getRemainingStock());

        bookRepository.save(book);

        BookResponse response = new BookResponse();
        response.setBook(book);

        log.debug("BookService - updateBookStock - bookStock updated");
        return response;
    }

    public BookResponse deleteBook(Long id) {
        log.debug("BookService - deleteBook started");
        BookResponse response = new BookResponse();
        Book book = bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));

        response.setBook(book);
        bookRepository.delete(book);

        log.debug("BookService - deleteBook - book is deleted");
        return response;
    }
}
