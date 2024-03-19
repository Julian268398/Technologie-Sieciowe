package com.example.lista2ts.service;

import com.example.lista2ts.entity.BookEntity;
import com.example.lista2ts.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookEntity> getAll() {
        return bookRepository.findAll();
    }

    public BookEntity getOne(long bookId) {
        return bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found!"));
    }

    public BookEntity create(BookEntity book) {
        return bookRepository.save(book);
    }

    public void delete(long bookId){
        bookRepository.deleteById(bookId);
    }
}
