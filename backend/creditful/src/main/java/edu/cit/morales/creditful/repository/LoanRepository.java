package edu.cit.morales.creditful.repository;

import edu.cit.morales.creditful.entity.Loan;
import edu.cit.morales.creditful.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    List<Loan> findByBorrower(User borrower);

    List<Loan> findByBorrower_Id(Long borrowerId);
}