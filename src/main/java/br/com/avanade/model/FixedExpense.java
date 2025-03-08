package br.com.avanade.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("FIXED")
public class FixedExpense extends Expense {

    private String type;  // Water, Electricity, Internet
    private LocalDate dueDate;

    public FixedExpense() {}

    public FixedExpense(String category, double amount, LocalDate date, String description, User user, String type, LocalDate dueDate) {
        super(category, amount, date, description, user);
        this.type = type;
        this.dueDate = dueDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "FixedExpense{" +
                "type='" + type + '\'' +
                ", dueDate=" + dueDate +
                "} " + super.toString();
    }
}
