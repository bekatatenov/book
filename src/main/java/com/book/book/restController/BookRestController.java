package com.book.book.restController;

import com.book.book.entity.Book;
import com.book.book.model.BookModel;
import com.book.book.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;

@RestController
@AllArgsConstructor
@RequestMapping("/book")
public class BookRestController {

    BookService bookService;

    @PostMapping("/add")
    @ResponseBody
    public Book add(@RequestBody BookModel book) throws ValidationException {
        return bookService.add(book);
    }
}
