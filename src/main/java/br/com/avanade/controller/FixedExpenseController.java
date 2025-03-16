package br.com.avanade.controller;

import br.com.avanade.model.FixedExpense;
import br.com.avanade.service.FixedExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fixed-expenses") //  Define a rota principal
public class FixedExpenseController {

    @Autowired
    private FixedExpenseService fixedExpenseService;

    //  1. Criar uma nova despesa fixa
    @PostMapping
    public ResponseEntity<FixedExpense> createFixedExpense(@RequestBody FixedExpense fixedExpense) {
        FixedExpense savedExpense = fixedExpenseService.createFixedExpense(fixedExpense);
        return ResponseEntity.ok(savedExpense);
    }

    //  2. Buscar todas as despesas fixas
    @GetMapping
    public List<FixedExpense> getAllFixedExpenses() {
        return fixedExpenseService.getAllFixedExpenses();
    }

    //  3. Buscar despesa fixa por ID
    @GetMapping("/{id}")
    public ResponseEntity<FixedExpense> getFixedExpenseById(@PathVariable Long id) {
        Optional<FixedExpense> fixedExpense = fixedExpenseService.getFixedExpenseById(id);
        return fixedExpense.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //  4. Atualizar uma despesa fixa existente
    @PutMapping("/{id}")
    public ResponseEntity<FixedExpense> updateFixedExpense(
            @PathVariable Long id, @RequestBody FixedExpense fixedExpense) {
        FixedExpense updatedExpense = fixedExpenseService.updateFixedExpense(id, fixedExpense);
        return ResponseEntity.ok(updatedExpense);
    }

    //  5. Excluir uma despesa fixa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFixedExpense(@PathVariable Long id) {
        fixedExpenseService.deleteFixedExpense(id);
        return ResponseEntity.noContent().build();
    }
}
