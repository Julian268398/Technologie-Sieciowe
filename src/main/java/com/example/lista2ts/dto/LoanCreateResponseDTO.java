package com.example.lista2ts.dto;

public class LoanCreateResponseDTO {
    private long id;
    private long bookId;
    private long userId;
    private String dateOfLoan;
    private String deadlineOfLoan;
    private String dateOfReturn;

    public LoanCreateResponseDTO(long id, long bookId, long userId, String dateOfLoan, String deadlineOfLoan, String dateOfReturn) {
        this.id = id;
        this.bookId = bookId;
        this.userId = userId;
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

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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
