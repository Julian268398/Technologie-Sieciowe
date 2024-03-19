package com.example.lista2ts.controller;

import com.example.lista2ts.entity.BookEntity;
import com.example.lista2ts.entity.BookEntity;
import com.example.lista2ts.repository.BookRepository;
import com.example.lista2ts.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/getAll")
    public @ResponseBody Iterable<BookEntity> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/get/{id}")
    public BookEntity getOne(@PathVariable int bookId) {
        return bookService.getOne(bookId);
    }

    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public @ResponseBody BookEntity create(@RequestBody BookEntity book) {
        return bookService.create(book);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int bookId) {
        bookService.delete(bookId);
    }
}
