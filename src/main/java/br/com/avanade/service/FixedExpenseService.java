package br.com.avanade.service;

import br.com.avanade.model.FixedExpense;
import br.com.avanade.repository.FixedExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FixedExpenseService {

    @Autowired
    private FixedExpenseRepository fixedExpenseRepository;

    public List<FixedExpense> getAllFixedExpenses() {
        return fixedExpenseRepository.findAll();
    }

    public List<FixedExpense> getFixedExpensesByType(String type) {
        return fixedExpenseRepository.findByType(type);
    }

    public FixedExpense createFixedExpense(FixedExpense fixedExpense) {
        return fixedExpenseRepository.save(fixedExpense);
    }

    public void deleteFixedExpense(Long id) {
        fixedExpenseRepository.deleteById(id);
    }
}
