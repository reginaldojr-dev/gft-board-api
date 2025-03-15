package br.com.avanade.repository;

import br.com.avanade.model.FixedExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FixedExpenseRepository extends JpaRepository<FixedExpense, Long> {
    // Método para buscar despesas fixas por tipo (Água, Luz, Internet)
    List<FixedExpense> findByType(String type);
}
