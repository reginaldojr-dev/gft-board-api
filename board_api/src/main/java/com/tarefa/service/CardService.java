package com.tarefa.service;

import com.tarefa.model.Card;
import com.tarefa.model.Status;
import com.tarefa.repository.CardRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CardService {

    private final CardRepository repo;

    public CardService(CardRepository repo) {
        this.repo = repo;
    }

    public List<Card> listar(String board) {
        return repo.findByBoard(board);
    }

    public List<Card> listarPorStatus(Status status, String board) {
        return repo.findByBoardAndStatus(board, status);
    }

    public Card buscar(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Card criar(Card c, String board) {
        if (c.getBoard() == null || c.getBoard().isBlank()) c.setBoard(board);
        if (c.getStatus() == null) c.setStatus(Status.TODO);
        return repo.save(c);
    }

    public Card atualizar(Long id, Card c) {
        Card ref = buscar(id);
        if (c.getTitle() != null) ref.setTitle(c.getTitle());
        if (c.getDescription() != null) ref.setDescription(c.getDescription());
        if (c.getStatus() != null) ref.setStatus(c.getStatus());
        if (c.getBoard() != null && !c.getBoard().isBlank()) ref.setBoard(c.getBoard());
        return repo.save(ref);
    }

    public Card mover(Long id, Status novo) {
        Card ref = buscar(id);
        ref.setStatus(novo);
        return repo.save(ref);
    }

    public void deletar(Long id) {
        if (!repo.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        repo.deleteById(id);
    }
}
