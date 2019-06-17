package com.nithin.spring.service;

import com.nithin.spring.model.Book;

import java.util.List;

public interface BookService {

    long save(Book book);

    Book get(long id);

    List<Book> list();

    void update(long id, Book book);

    void delete(long id);

}
