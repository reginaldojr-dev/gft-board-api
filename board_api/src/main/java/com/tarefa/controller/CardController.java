package com.tarefa.controller;

import com.tarefa.model.Card;
import com.tarefa.model.Status;
import com.tarefa.service.CardService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {

    private final CardService service;

    public CardController(CardService service) {
        this.service = service;
    }

    // GET /cards?board=default&status=DOING
    @GetMapping
    public List<Card> listar(@RequestParam(defaultValue = "default") String board,
                             @RequestParam(required = false) Status status) {
        return (status == null)
                ? service.listar(board)
                : service.listarPorStatus(status, board);
    }

    @GetMapping("/{id}")
    public Card buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    // POST /cards?board=marketing
    @PostMapping
    public ResponseEntity<Card> criar(@RequestBody @Valid Card c,
                                      @RequestParam(defaultValue = "default") String board) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(c, board));
    }

    @PutMapping("/{id}")
    public Card atualizar(@PathVariable Long id, @RequestBody @Valid Card c) {
        return service.atualizar(id, c);
    }

    @PutMapping("/{id}/move")
    public Card mover(@PathVariable Long id, @RequestParam("to") Status to) {
        return service.mover(id, to);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
