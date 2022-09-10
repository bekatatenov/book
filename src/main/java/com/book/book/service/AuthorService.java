package com.book.book.service;

import com.book.book.entity.Author;

import javax.xml.bind.ValidationException;

public interface AuthorService {
    Author save(Author author);
    Author save(String fullname) throws ValidationException;
    Author findById(Long id) throws ValidationException;

}
