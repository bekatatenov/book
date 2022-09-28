package com.book.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping("/login")
    public String index(){
        return "login";
    }

    @GetMapping("/")
    public String main(){
        return "logout";
    }
}
