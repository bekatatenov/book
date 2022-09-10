package com.book.book.service.Impl;

import com.book.book.entity.Author;
import com.book.book.entity.Book;
import com.book.book.enums.BookStatus;
import com.book.book.model.BookModel;
import com.book.book.repository.BookRepository;
import com.book.book.service.AuthorService;
import com.book.book.service.BookService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.util.List;

@AllArgsConstructor
@Data
@Service
public class BooksServiceImpl implements BookService {
    BookRepository bookRepository;
    AuthorService authorService;


    @Override
    public Book add(BookModel model) throws ValidationException {
        Author byId = authorService.findById(model.getAuthorId());
        Book book = Book.builder()
                .author(byId)
                .name(model.getName())
                .bookStatus(BookStatus.FREE)
                .build();
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findALl() {
        return bookRepository.findAll();
    }

}
