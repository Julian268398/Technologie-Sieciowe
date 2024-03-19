package com.example.lista2ts.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "loan", schema = "library_w11")
public class LoanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "bookId")
    private BookEntity book;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity user;

    @Basic
    @Column(name = "dateOfLoan")
    private String dateOfLoan;

    @Basic
    @Column(name = "deadlineOfLoan")
    private String deadlineOfLoan;

    @Basic
    @Column(name = "dateOfReturn")
    private String dateOfReturn;
}
