package com.example.lista2ts.controller;

import com.example.lista2ts.entity.Book;
import com.example.lista2ts.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @PostMapping("/add")
    @ResponseStatus(code= HttpStatus.CREATED)
    public @ResponseBody Book addBook (@RequestBody Book book){
        return bookRepository.save(book);
    }

    @GetMapping("/getAll")
    public @ResponseBody Iterable<Book> getAllBooks(){
        return bookRepository.findAll();
    }
}
