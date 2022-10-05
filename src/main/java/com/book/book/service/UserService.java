package com.book.book.service;

import com.book.book.model.UserModel;

import javax.xml.bind.ValidationException;

public interface UserService {
    void save(UserModel userModel) throws ValidationException;
}
