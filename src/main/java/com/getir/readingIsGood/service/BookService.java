package com.getir.readingIsGood.service;

import com.getir.readingIsGood.domain.Book;
import com.getir.readingIsGood.model.request.BookCreateRequest;
import com.getir.readingIsGood.model.request.BookStockUpdateRequest;
import com.getir.readingIsGood.model.response.BookResponse;
import com.getir.readingIsGood.repository.IBookRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class BookService {
    private final IBookRepository bookRepository;

    public BookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookResponse createBook(BookCreateRequest request) {
        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setDescription(request.getDescription());
        book.setAuthor(request.getAuthor());
        book.setPrice(request.getPrice());
        book.setRemainingStock(request.getRemainingStock());

        bookRepository.save(book);

        BookResponse response = new BookResponse();
        response.setBook(book);

        return response;
    }

    public BookResponse getBook(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
        BookResponse response = new BookResponse();
        response.setBook(book);

        return response;
    }

    public BookResponse updateBookStock(BookStockUpdateRequest request) {
        Book book = bookRepository.findById(request.getId()).orElseThrow(() -> new EntityNotFoundException(String.valueOf(request.getId())));

        book.setRemainingStock(request.getRemainingStock());

        bookRepository.save(book);

        BookResponse response = new BookResponse();
        response.setBook(book);

        return response;
    }

    public BookResponse deleteBook(Long id) {
        BookResponse response = new BookResponse();
        Book book = bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));

        response.setBook(book);
        bookRepository.delete(book);

        return response;
    }
}
