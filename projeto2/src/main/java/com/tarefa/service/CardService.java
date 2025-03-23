package com.tarefa.service;

import com.tarefa.model.Card;
import com.tarefa.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    public List<Card> listarCards() {
        return cardRepository.findAll();
    }

    public Card salvarCard(Card card) {
        return cardRepository.save(card);
    }

    public Optional<Card> moverCard(Long id) {
        return Optional.empty();
    }

    public Optional<Card> bloquearCard(Long id, String motivo) {
        return Optional.empty();
    }

    public Optional<Card> desbloquearCard(Long id, String motivo) {
        return Optional.empty();
    }
}

