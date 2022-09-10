package com.book.book.entity;

import com.book.book.enums.BookStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;


@Builder
@AllArgsConstructor
@Entity
@Table(name = Book.TABLE_NAME)
public class Book {

    public static final String TABLE_NAME = "BOOKS";
    public static final String SEQ_NAME = TABLE_NAME + "_SEQ";

    @Id
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    @GeneratedValue(generator = SEQ_NAME)
    private Long id;

    String name;

    @Enumerated(EnumType.STRING)
    BookStatus bookStatus;

    String author;


}