package br.com.avanade.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "expense_type")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;
    private double amount;
    private LocalDate date;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Expense() {}

    public Expense(String category, double amount, LocalDate date, String description, User user) {
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }
}
