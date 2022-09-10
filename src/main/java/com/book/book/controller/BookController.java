package com.book.book.controller;

import com.book.book.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {
    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("test", "Text form controller");
        return "index";
    }

    @GetMapping("/books")
    public String books(Model model){
        model.addAttribute("books",bookService.findALl());
        return "books";
    }
}
