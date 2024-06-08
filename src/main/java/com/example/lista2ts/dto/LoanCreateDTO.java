package com.example.lista2ts.dto;

public class LoanCreateDTO {
    private long bookId;
    private long userId;
    private String dateOfLoan;
    private String deadlineOfLoan;
    private String dateOfReturn;

    public LoanCreateDTO() {
    }

    public LoanCreateDTO(long bookId, long userId, String dateOfLoan, String deadlineOfLoan, String dateOfReturn) {
        this.bookId = bookId;
        this.userId = userId;
        this.dateOfLoan = dateOfLoan;
        this.deadlineOfLoan = deadlineOfLoan;
        this.dateOfReturn = dateOfReturn;
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
