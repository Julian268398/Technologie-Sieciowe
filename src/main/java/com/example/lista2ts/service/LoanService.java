package com.example.lista2ts.service;

import com.example.lista2ts.dto.BookDTO;
import com.example.lista2ts.dto.LoanCreateDTO;
import com.example.lista2ts.dto.LoanCreateResponseDTO;
import com.example.lista2ts.dto.LoanDTO;
import com.example.lista2ts.entity.BookEntity;
import com.example.lista2ts.entity.LoanEntity;
import com.example.lista2ts.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanService {
    private LoanRepository loanRepository;

    @Autowired
    public LoanService(LoanRepository loanRepository){this.loanRepository = loanRepository;}

    public List<LoanDTO> getAll() {
        var loans = loanRepository.findAll();

        return loans.stream().map((loan) -> new LoanDTO(loan.getId(), loan.getBook(), loan.getUser(), loan.getDateOfLoan(), loan.getDeadlineOfLoan(), loan.getDateOfReturn())).collect(Collectors.toList());
    }

    public LoanDTO getOne(long loanId) {
        var loan = loanRepository.findById(loanId).orElseThrow(() -> new RuntimeException("Loan record not found!"));
        return new LoanDTO(loan.getId(), loan.getBook(), loan.getUser(), loan.getDateOfLoan(), loan.getDeadlineOfLoan(), loan.getDateOfReturn());
    }

    public LoanCreateResponseDTO create(LoanCreateDTO loan) {
        var loanEntity = new LoanEntity();

        loanEntity.setBook(loan.getBook());
        loanEntity.setUser(loan.getUser());
        loanEntity.setDateOfLoan(loan.getDateOfLoan());
        loanEntity.setDeadlineOfLoan(loan.getDeadlineOfLoan());
        loanEntity.setDateOfReturn(loan.getDateOfReturn());

        var newLoan = loanRepository.save(loanEntity);

        return new LoanCreateResponseDTO(newLoan.getId(), newLoan.getBook(), newLoan.getUser(), newLoan.getDateOfLoan(), newLoan.getDeadlineOfLoan(), newLoan.getDateOfReturn());
    }

    public void delete(long loanId){
        if (!loanRepository.existsById(loanId)){
            throw new RuntimeException();
        }
        loanRepository.deleteById(loanId);
    }
}
