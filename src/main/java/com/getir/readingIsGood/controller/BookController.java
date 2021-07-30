package com.getir.readingIsGood.controller;

import com.getir.readingIsGood.model.request.BookCreateRequest;
import com.getir.readingIsGood.model.request.BookUpdateRequest;
import com.getir.readingIsGood.model.response.BookResponse;
import com.getir.readingIsGood.service.BookService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public BookResponse createBook(@Valid @RequestBody BookCreateRequest request){
        return bookService.createBook(request);
    }

    @GetMapping(value = "/{id}")
    public BookResponse getBook(@PathVariable Long id){
        return bookService.getBook(id);
    }

    @PutMapping
    public BookResponse updateBook(@Valid @RequestBody BookUpdateRequest request){
        return bookService.updateBook(request);
    }

    @DeleteMapping(value = "/{id}")
    public BookResponse deleteBook(@PathVariable Long id){
        return bookService.deleteBook(id);
    }
}
