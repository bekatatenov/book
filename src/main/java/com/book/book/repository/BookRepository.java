package com.book.book.repository;

import com.book.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByAuthor(String author);
    List<Book> findAllByName(String name);
}
