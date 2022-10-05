package com.book.book.controller;

import com.book.book.model.UserModel;
import com.book.book.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.xml.bind.ValidationException;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/")
public class MainController {
    UserService userService;

    @GetMapping("/login")
    public String index(){
        return "login";
    }

    @GetMapping("/registrationPage")
    public String registerPage(){
        return "registrationPage";
    }

    @GetMapping("/resetPage")
    public String resetPage(){
        return "resetPage";
    }

    @PostMapping("/register")
    public RedirectView register(UserModel userModel) throws ValidationException {
        userService.save(userModel);
        return new RedirectView("/login");
    }
}
