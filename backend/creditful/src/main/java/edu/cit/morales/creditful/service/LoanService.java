package edu.cit.morales.creditful.service;

import edu.cit.morales.creditful.entity.Loan;
import edu.cit.morales.creditful.entity.User;
import edu.cit.morales.creditful.repository.LoanRepository;
import edu.cit.morales.creditful.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    private final LoanRepository loanRepository;
    private final UserRepository userRepository;

    public LoanService(LoanRepository loanRepository, UserRepository userRepository) {
        this.loanRepository = loanRepository;
        this.userRepository = userRepository;
    }

    public Loan createLoan(Long userId, double principal, double interest) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Loan loan = new Loan();
        loan.setAmountBorrowed(principal);
        loan.setAmountRemaining(principal + interest);
        loan.setStatus("ACTIVE");
        loan.setBorrower(user);

        return loanRepository.save(loan);
    }

    public List<Loan> getLoansByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return loanRepository.findByBorrower(user);
    }
}