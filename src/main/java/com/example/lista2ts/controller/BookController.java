package com.example.lista2ts.controller;

import com.example.lista2ts.dto.BookCreateDTO;
import com.example.lista2ts.dto.BookCreateResponseDTO;
import com.example.lista2ts.dto.BookDTO;
import com.example.lista2ts.entity.BookEntity;
import com.example.lista2ts.entity.BookEntity;
import com.example.lista2ts.repository.BookRepository;
import com.example.lista2ts.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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
    public @ResponseBody Iterable<BookDTO> getAll() {

        return bookService.getAll();
    }

    @GetMapping("/get/{bookId}")
    public BookDTO getOne(@PathVariable int bookId) {
        return bookService.getOne(bookId);
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(code = HttpStatus.CREATED)
    public @ResponseBody BookCreateResponseDTO create(@RequestBody BookCreateDTO book) {
        return bookService.create(book);
    }

    @DeleteMapping("/delete/{bookId}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int bookId) {
        bookService.delete(bookId);
    }
}
