package com.example.lista2ts.controller;

import com.example.lista2ts.entity.LoanEntity;
import com.example.lista2ts.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loan")
public class LoanController {
    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService){
        this.loanService = loanService;
    }

    @GetMapping("/getAll")
    public @ResponseBody Iterable<LoanEntity> getAll() {
        return loanService.getAll();
    }

    @GetMapping("/get/{loanId}")
    public LoanEntity getOne(@PathVariable int loanId) {
        return loanService.getOne(loanId);
    }

    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public @ResponseBody LoanEntity create(@RequestBody LoanEntity book) {
        return loanService.create(book);
    }

    @DeleteMapping("/delete/{loanId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int loanId) {
        loanService.delete(loanId);
    }
}
