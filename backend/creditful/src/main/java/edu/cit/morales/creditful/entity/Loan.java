package edu.cit.morales.creditful.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount_borrowed", nullable = false)
    private double amountBorrowed;

    @Column(name = "amount_remaining", nullable = false)
    private double amountRemaining;

    @Column(nullable = false)
    private String status; // ACTIVE, COMPLETED

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @ManyToOne
    @JoinColumn(name = "borrower_id", nullable = false)
    private User borrower;

    public Loan() {}

    public Loan(double amountBorrowed, User borrower) {
        this.amountBorrowed = amountBorrowed;
        this.amountRemaining = amountBorrowed;
        this.status = "ACTIVE";
        this.borrower = borrower;
    }
    
    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmountBorrowed() {
        return amountBorrowed;
    }

    public void setAmountBorrowed(double amountBorrowed) {
        this.amountBorrowed = amountBorrowed;
    }

    public double getAmountRemaining() {
        return amountRemaining;
    }

    public void setAmountRemaining(double amountRemaining) {
        this.amountRemaining = amountRemaining;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getBorrower() {
        return borrower;
    }

    public void setBorrower(User user) {
        this.borrower = user;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}