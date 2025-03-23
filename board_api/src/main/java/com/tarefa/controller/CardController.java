package com.tarefa.controller;

import com.tarefa.model.Card;
import com.tarefa.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cards")
public class CardController {
    @Autowired
    private CardService cardService;

    @GetMapping
    public List<Card> listarCards() {
        return cardService.listarCards();
    }

    @PostMapping
    public Card criarCard(@RequestBody Card card) {
        return cardService.salvarCard(card);
    }

    @PutMapping("/{id}/mover")
    public ResponseEntity<Card> moverCard(@PathVariable Long id) {
        Optional<Card> card = cardService.moverCard(id);
        return card.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/bloquear")
    public ResponseEntity<Card> bloquearCard(@PathVariable Long id, @RequestParam String motivo) {
        Optional<Card> card = cardService.bloquearCard(id, motivo);
        return card.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/desbloquear")
    public ResponseEntity<Card> desbloquearCard(@PathVariable Long id, @RequestParam String motivo) {
        Optional<Card> card = cardService.desbloquearCard(id, motivo);
        return card.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
