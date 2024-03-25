package com.example.lista2ts.service;

import com.example.lista2ts.entity.BookEntity;
import com.example.lista2ts.entity.LoanEntity;
import com.example.lista2ts.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {
    private LoanRepository loanRepository;

    @Autowired
    public LoanService(LoanRepository loanRepository){this.loanRepository = loanRepository;}

    public List<LoanEntity> getAll() {return loanRepository.findAll();}

    public LoanEntity getOne(long loanId) {
        return loanRepository.findById(loanId).orElseThrow(() -> new RuntimeException("Loan record not found!"));
    }

    public LoanEntity create(LoanEntity loan) {
        return loanRepository.save(loan);
    }

    public void delete(long loanId){
        loanRepository.deleteById(loanId);
    }
}
