package br.com.avanade.controller;

import br.com.avanade.model.FixedExpense;
import br.com.avanade.service.FixedExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fixed-expenses")
public class FixedExpenseController {

    @Autowired
    private FixedExpenseService fixedExpenseService;

    @GetMapping
    public List<FixedExpense> getAllFixedExpenses() {
        return fixedExpenseService.getAllFixedExpenses();
    }

    @GetMapping("/type/{type}")
    public List<FixedExpense> getFixedExpensesByType(@PathVariable String type) {
        return fixedExpenseService.getFixedExpensesByType(type);
    }

    @PostMapping
    public FixedExpense createFixedExpense(@RequestBody FixedExpense fixedExpense) {
        return fixedExpenseService.createFixedExpense(fixedExpense);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFixedExpense(@PathVariable Long id) {
        fixedExpenseService.deleteFixedExpense(id);
        return ResponseEntity.noContent().build();
    }
}
