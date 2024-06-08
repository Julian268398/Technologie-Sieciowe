package com.example.lista2ts.service;

import com.example.lista2ts.dto.LoanCreateDTO;
import com.example.lista2ts.dto.LoanCreateResponseDTO;
import com.example.lista2ts.dto.LoanDTO;
import com.example.lista2ts.entity.LoanEntity;
import com.example.lista2ts.repository.BookRepository;
import com.example.lista2ts.repository.UserRepository;
import com.example.lista2ts.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanService {
    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    @Autowired
    public LoanService(LoanRepository loanRepository, BookRepository bookRepository, UserRepository userRepository) {
        this.loanRepository = loanRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public List<LoanDTO> getAll() {
        var loans = loanRepository.findAll();

        return loans.stream().map(loan -> new LoanDTO(
                loan.getId(),
                loan.getBook().getId(),
                loan.getUser().getId(),
                loan.getDateOfLoan(),
                loan.getDeadlineOfLoan(),
                loan.getDateOfReturn()
        )).collect(Collectors.toList());
    }

    public LoanDTO getOne(long loanId) {
        var loan = loanRepository.findById(loanId).orElseThrow(() -> new RuntimeException("Loan record not found!"));
        return new LoanDTO(
                loan.getId(),
                loan.getBook().getId(),
                loan.getUser().getId(),
                loan.getDateOfLoan(),
                loan.getDeadlineOfLoan(),
                loan.getDateOfReturn()
        );
    }

    public LoanCreateResponseDTO create(LoanCreateDTO loan) {
        var book = bookRepository.findById(loan.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found!"));
        var user = userRepository.findById(loan.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found!"));

        var loanEntity = new LoanEntity();
        loanEntity.setBook(book);
        loanEntity.setUser(user);
        loanEntity.setDateOfLoan(loan.getDateOfLoan());
        loanEntity.setDeadlineOfLoan(loan.getDeadlineOfLoan());
        loanEntity.setDateOfReturn(loan.getDateOfReturn());

        var newLoan = loanRepository.save(loanEntity);

        return new LoanCreateResponseDTO(
                newLoan.getId(),
                newLoan.getBook().getId(),
                newLoan.getUser().getId(),
                newLoan.getDateOfLoan(),
                newLoan.getDeadlineOfLoan(),
                newLoan.getDateOfReturn()
        );
    }

    public void delete(long loanId) {
        if (!loanRepository.existsById(loanId)) {
            throw new RuntimeException("Loan not found!");
        }
        loanRepository.deleteById(loanId);
    }
}
