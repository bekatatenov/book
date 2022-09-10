package com.book.book.repository;

import com.book.book.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findAllByFullname(String fullname);
}
