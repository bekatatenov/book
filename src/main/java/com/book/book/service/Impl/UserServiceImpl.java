package com.book.book.service.Impl;

import com.book.book.entity.User;
import com.book.book.enums.Role;
import com.book.book.model.UserModel;
import com.book.book.repository.UserRepository;
import com.book.book.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    @Override
    public void save(UserModel userModel) throws ValidationException {
        if (userModel.getUsername() == null || userModel.getUsername().isBlank())
            throw new ValidationException("Не указано username");

        if (userModel.getEmail() == null || userModel.getEmail().isBlank()) {
            throw new ValidationException("Не указано email");
        }

        if (userModel.getPassword() == null || userModel.getPassword().isBlank()) {
            throw new ValidationException("Не указано password");
        }

        if (userRepository.existsByUserName(userModel.getUsername())) {
            throw new ValidationException("user с таким username уже существует");
        }

        if (userRepository.existsByEmail(userModel.getEmail())) {
            throw new ValidationException("user с таким email уже существует");
        }
        User user = User.builder()
                .userName(userModel.getUsername())
                .email(userModel.getEmail())
                .enabled(true)
                .role(Role.USER)
                .password(passwordEncoder.encode(userModel.getPassword()))
                .build();
        userRepository.save(user);
    }
}
