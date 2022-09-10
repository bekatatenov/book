package com.book.book.service.Impl;

import com.book.book.entity.Book;
import com.book.book.repository.BookRepository;
import com.book.book.service.BookService;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BooksServiceImpl implements BookService {
    BookRepository bookRepository;


    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }
}
