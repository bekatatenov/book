package com.book.book.utills;

import com.book.book.entity.User;
import com.book.book.enums.Role;
import com.book.book.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
@AllArgsConstructor
public class CreateUsers {
    PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner run(UserRepository userRepository) {
        return (args) -> {
            List<User> all = userRepository.findAll();
            if (all.size() < 2) {

                User test = User
                        .builder()
                        .userName("test")
                        .email("test@test.com")
                        .enabled(true)
                        .password(passwordEncoder.encode("123"))
                        .role(Role.ADMIN)
                        .build();

                User test2 = User
                        .builder()
                        .userName("test2")
                        .email("test2@test.com")
                        .enabled(true)
                        .password(passwordEncoder.encode("123"))
                        .role(Role.USER)
                        .build();
                userRepository.save(test);
                userRepository.save(test2);

            }
        };
    }
}
