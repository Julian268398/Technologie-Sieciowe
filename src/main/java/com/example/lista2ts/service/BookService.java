package com.example.lista2ts.service;

import com.example.lista2ts.dto.BookCreateDTO;
import com.example.lista2ts.dto.BookCreateResponseDTO;
import com.example.lista2ts.dto.BookDTO;
import com.example.lista2ts.entity.AuthEntity;
import com.example.lista2ts.entity.BookEntity;
import com.example.lista2ts.errors.BookAlreadyExistsException;
import com.example.lista2ts.errors.UserAlreadyExistsException;
import com.example.lista2ts.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDTO> getAll() {
        var books = bookRepository.findAll();

        return books.stream().map((book) -> new BookDTO(book.getId(), book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPublisher(), book.getYearOfPublish(), book.getAvailableCopies())).collect(Collectors.toList());
    }

    public BookDTO getOne(long bookId) {
        var book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found!"));
        return new BookDTO(book.getId(), book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPublisher(), book.getYearOfPublish(), book.getAvailableCopies());
    }

    public BookCreateResponseDTO create(BookCreateDTO book) {

        Optional<BookEntity> existingBook = bookRepository.findByIsbn(book.getIsbn());

        if (existingBook.isPresent()) {
            throw BookAlreadyExistsException.create(book.getIsbn());
        }

        var bookEntity = new BookEntity();

        bookEntity.setAuthor(book.getAuthor());
        bookEntity.setTitle(book.getTitle());
        bookEntity.setIsbn(book.getIsbn());
        bookEntity.setPublisher(book.getPublisher());
        bookEntity.setAvailableCopies(book.getAvailableCopies());
        bookEntity.setYearOfPublish(book.getYearOfPublish());

        var newBook = bookRepository.save(bookEntity);

        return new BookCreateResponseDTO(newBook.getId(), newBook.getIsbn(), newBook.getTitle(), newBook.getAuthor(), newBook.getPublisher(), newBook.getYearOfPublish(), newBook.getAvailableCopies());
    }

    public void delete(long bookId){
        if (!bookRepository.existsById(bookId)){
            throw new RuntimeException();
        }
        bookRepository.deleteById(bookId);
    }
}
