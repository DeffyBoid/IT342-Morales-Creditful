package edu.cit.morales.creditful.controller;

import edu.cit.morales.creditful.entity.Loan;
import edu.cit.morales.creditful.service.LoanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/loans")
@CrossOrigin(origins = "*")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    // CREATE LOAN
    @PostMapping
    public Loan createLoan(
            @RequestParam Long userId,
            @RequestParam double principal,
            @RequestParam double interest
    ) {
        return loanService.createLoan(userId, principal, interest);
    }

    // GET MY LOANS
    @GetMapping("/me")
    public List<Loan> getMyLoans(@RequestParam Long userId) {
        return loanService.getLoansByUser(userId);
    }

}