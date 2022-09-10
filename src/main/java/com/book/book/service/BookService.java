package com.book.book.service;

import com.book.book.entity.Book;
import com.book.book.model.BookModel;

import javax.xml.bind.ValidationException;
import java.util.List;

public interface BookService {
    Book add(BookModel model) throws ValidationException;

    List<Book> findALl();
}
