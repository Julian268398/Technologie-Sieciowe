package com.example.lista2ts.controller;

import com.example.lista2ts.dto.LoanCreateDTO;
import com.example.lista2ts.dto.LoanCreateResponseDTO;
import com.example.lista2ts.dto.LoanDTO;
import com.example.lista2ts.entity.LoanEntity;
import com.example.lista2ts.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loan")
@CrossOrigin
public class LoanController {
    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService){
        this.loanService = loanService;
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasRole('ADMIN')")
    public @ResponseBody Iterable<LoanDTO> getAll() {

        return loanService.getAll();
    }

    @GetMapping("/get/{loanId}")
    @PreAuthorize("permitAll()")
    public LoanDTO getOne(@PathVariable int loanId) {
        return loanService.getOne(loanId);
    }

    @PostMapping("/create")
    @PreAuthorize("permitAll()")
    @ResponseStatus(code = HttpStatus.CREATED)
    public @ResponseBody LoanCreateResponseDTO create(@RequestBody LoanCreateDTO loan) {
        return loanService.create(loan);
    }

    @DeleteMapping("/delete/{loanId}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int loanId) {
        loanService.delete(loanId);
    }
}
