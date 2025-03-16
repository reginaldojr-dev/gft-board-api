package br.com.avanade.controller;

import br.com.avanade.model.Expense;
import br.com.avanade.model.User;
import br.com.avanade.service.ExpenseService;
import br.com.avanade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @PostMapping
    public ResponseEntity<?> createExpense(@RequestBody Expense expense) {
        if (expense.getId() != null) {
            return ResponseEntity.badRequest().body("Não envie o ID ao criar uma nova despesa.");
        }

        if (expense.getUser() == null || expense.getUser().getId() == null) {
            return ResponseEntity.badRequest().body("O usuário deve ser informado com um ID.");
        }

        Optional<User> userOpt = userService.getUserById(expense.getUser().getId());
        if (userOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Usuário não encontrado.");
        }

        expense.setUser(userOpt.get()); // Garante que o usuário existe e está associado corretamente
        Expense savedExpense = expenseService.createExpense(expense);
        return ResponseEntity.ok(savedExpense);
    }
}
