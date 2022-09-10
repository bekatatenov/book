package com.book.book.restController;


import com.book.book.entity.Author;
import com.book.book.service.AuthorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.ValidationException;

@RestController
@RequestMapping("/author")
public class AuthorRestController {

    AuthorService authorService;

    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/saveNew")
    public Author save(@RequestParam String fullname) throws ValidationException {
        return authorService.save(fullname);
    }
}
