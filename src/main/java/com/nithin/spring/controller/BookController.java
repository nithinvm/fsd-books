package com.nithin.spring.controller;

import com.nithin.spring.model.Book;
import com.nithin.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    /*-- Add new book---*/
    @PostMapping("/book")
    public ResponseEntity<?> save(@RequestBody Book book) {
        System.out.println("The json value of book id ::::::::" + book);
        long id = bookService.save(book);
        return ResponseEntity.ok().body("New book has been saved with Id :" + id);
    }

    /*-- Get a book by id---*/
    @GetMapping("/book/{id}")
    public ResponseEntity<?> get(@PathVariable("id") long id) {
        Book book = bookService.get(id);
        return ResponseEntity.ok().body(book);
    }

    /*-- Get all books---*/
    @GetMapping("/book")
    public ResponseEntity<List<Book>> list() {
        List<Book> books = bookService.list();
        return ResponseEntity.ok().body(books);
    }


    /*-- Update a book by id---*/
    @PutMapping("/book/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Book book) {
        bookService.update(id, book);
        return ResponseEntity.ok().body("Book has been updated successfully");
    }

    /*-- Delete a book by id---*/
    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        bookService.delete(id);
        return ResponseEntity.ok().body("Book has been deleted successfully");

    }


}
