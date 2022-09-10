package com.book.book.service.Impl;

import com.book.book.entity.Author;
import com.book.book.repository.AuthorRepository;
import com.book.book.service.AuthorService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.util.List;

@AllArgsConstructor
@Data
@Service
public class AuthorServiceImpl implements AuthorService {

    AuthorRepository repository;

    @Override
    public Author save(Author author) {
        return repository.save(author);
    }

    @Override
    public Author save(String fullname) throws ValidationException {
        List<Author> all = repository.findAllByFullname(fullname);
        if (!all.isEmpty()) throw new ValidationException("Автор с таким ФИО уже сущ");
        return repository.save(Author.builder()
                .fullname(fullname)
                .build());
    }

    @Override
    public Author findById(Long id) throws ValidationException {
        return repository.findById(id)
                .orElseThrow(() -> new ValidationException("Автор с таким Id не найдено"));
    }
}
