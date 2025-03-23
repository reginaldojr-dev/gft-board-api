package br.com.avanade.service;

import br.com.avanade.model.FixedExpense;
import br.com.avanade.repository.FixedExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FixedExpenseService {

    @Autowired
    private FixedExpenseRepository fixedExpenseRepository;

    //  Criar nova despesa fixa
    public FixedExpense createFixedExpense(FixedExpense fixedExpense) {
        return fixedExpenseRepository.save(fixedExpense);
    }

    //  Buscar todas as despesas fixas
    public List<FixedExpense> getAllFixedExpenses() {
        return fixedExpenseRepository.findAll();
    }

    //  Buscar despesa fixa por ID
    public Optional<FixedExpense> getFixedExpenseById(Long id) {
        return fixedExpenseRepository.findById(id);
    }

    //  Atualizar despesa fixa existente
    public FixedExpense updateFixedExpense(Long id, FixedExpense updatedExpense) {
        return fixedExpenseRepository.findById(id).map(existingExpense -> {
            existingExpense.setCategory(updatedExpense.getCategory());
            existingExpense.setAmount(updatedExpense.getAmount());
            existingExpense.setDescription(updatedExpense.getDescription());
            return fixedExpenseRepository.save(existingExpense);
        }).orElseThrow(() -> new RuntimeException("FixedExpense not found with id " + id));
    }

    //  Excluir despesa fixa
    public void deleteFixedExpense(Long id) {
        fixedExpenseRepository.deleteById(id);
    }
}
