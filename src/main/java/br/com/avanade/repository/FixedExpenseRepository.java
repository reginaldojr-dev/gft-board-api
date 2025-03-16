package br.com.avanade.repository;

import br.com.avanade.model.FixedExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FixedExpenseRepository extends JpaRepository<FixedExpense, Long> {
}
