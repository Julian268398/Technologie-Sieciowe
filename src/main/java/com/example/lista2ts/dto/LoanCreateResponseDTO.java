package com.example.lista2ts.dto;

import com.example.lista2ts.entity.BookEntity;
import com.example.lista2ts.entity.UserEntity;

public class LoanCreateResponseDTO {
    private long id;

    private BookEntity book;

    private UserEntity user;

    private String dateOfLoan;

    private String deadlineOfLoan;

    private String dateOfReturn;

    public LoanCreateResponseDTO() {
    }

    public LoanCreateResponseDTO(long id, BookEntity book, UserEntity user, String dateOfLoan, String deadlineOfLoan, String dateOfReturn) {
        this.id = id;
        this.book = book;
        this.user = user;
        this.dateOfLoan = dateOfLoan;
        this.deadlineOfLoan = deadlineOfLoan;
        this.dateOfReturn = dateOfReturn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getDateOfLoan() {
        return dateOfLoan;
    }

    public void setDateOfLoan(String dateOfLoan) {
        this.dateOfLoan = dateOfLoan;
    }

    public String getDeadlineOfLoan() {
        return deadlineOfLoan;
    }

    public void setDeadlineOfLoan(String deadlineOfLoan) {
        this.deadlineOfLoan = deadlineOfLoan;
    }

    public String getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(String dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }
}
