package edu.cit.morales.creditful.dto;

import java.time.LocalDate;

public class LoanRequest {

    private Long borrowerId;
    private double amountBorrowed;
    private LocalDate dueDate;

    // getters and setters

    public Long getBorrowerId() {
        return borrowerId;
    }
    public void setBorrowerId(Long borrowerId) {
        this.borrowerId = borrowerId;
    }
    public double getAmountBorrowed() {
        return amountBorrowed;
    }
    public void setAmountBorrowed(double amountBorrowed) {
        this.amountBorrowed = amountBorrowed;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }
}