package com.tarefa.repository;

import com.tarefa.model.Card;
import com.tarefa.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findByBoard(String board);
    List<Card> findByBoardAndStatus(String board, Status status);
}
