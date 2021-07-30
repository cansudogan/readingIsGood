package com.getir.readingIsGood.repository;

import com.getir.readingIsGood.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Long> {
}
