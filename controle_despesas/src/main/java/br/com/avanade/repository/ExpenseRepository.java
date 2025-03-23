package br.com.avanade.repository;

import br.com.avanade.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    // Método para buscar despesas por categoria
    List<Expense> findByCategory(String category);

    // Método para buscar todas as despesas de um usuário
    List<Expense> findByUserId(Long userId);
}
