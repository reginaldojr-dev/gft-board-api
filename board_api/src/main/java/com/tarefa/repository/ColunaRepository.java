package com.tarefa.repository;

import com.tarefa.model.Coluna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColunaRepository extends JpaRepository<Coluna, Long> {
}
