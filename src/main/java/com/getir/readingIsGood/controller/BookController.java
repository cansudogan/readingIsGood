package com.getir.readingIsGood.controller;

import com.getir.readingIsGood.model.request.BookCreateRequest;
import com.getir.readingIsGood.model.request.BookStockUpdateRequest;
import com.getir.readingIsGood.model.response.BookResponse;
import com.getir.readingIsGood.service.BookService;
import io.swagger.annotations.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/book")
@Api
@SwaggerDefinition(tags = {
        @Tag(name = "book-api", description = "Book Api")
})
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Create Book", notes = "Create Book", authorizations = {@Authorization(value = "jwtToken")})
    public BookResponse createBook(@Valid @RequestBody BookCreateRequest request) {
        return bookService.createBook(request);
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('CUSTOMER') OR hasRole('ADMIN')")
    @ApiOperation(value = "Get book by id ", notes = "Get book by id", authorizations = {@Authorization(value = "jwtToken")})
    public BookResponse getBook(@PathVariable Long id) {
        return bookService.getBook(id);
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Update Book", notes = "Update Book", authorizations = {@Authorization(value = "jwtToken")})
    public BookResponse updateBookStock(@Valid @RequestBody BookStockUpdateRequest request) {
        return bookService.updateBookStock(request);
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "Delete Book", notes = "Delete Book", authorizations = {@Authorization(value = "jwtToken")})
    public BookResponse deleteBook(@PathVariable Long id) {
        return bookService.deleteBook(id);
    }
}
