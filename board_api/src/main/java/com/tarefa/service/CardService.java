package com.tarefa.service;

import com.tarefa.model.Card;
import com.tarefa.model.Coluna;
import com.tarefa.repository.CardRepository;
import com.tarefa.repository.ColunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private ColunaRepository colunaRepository;

    public List<Card> listarCards() {
        return cardRepository.findAll();
    }

    public Card salvarCard(Card card) {
        return cardRepository.save(card);
    }

    public Optional<Card> moverCard(Long id) {
        Optional<Card> cardOpt = cardRepository.findById(id);
        if (cardOpt.isPresent()) {
            Card card = cardOpt.get();
            if (card.isBloqueado()) {
                return Optional.empty();
            }
            List<Coluna> colunas = card.getColuna().getBoard().getColunas();
            colunas.sort((c1, c2) -> Integer.compare(c1.getOrdem(), c2.getOrdem()));
            int indexAtual = colunas.indexOf(card.getColuna());
            if (indexAtual < colunas.size() - 1) {
                card.setColuna(colunas.get(indexAtual + 1));
                cardRepository.save(card);
            }
            return Optional.of(card);
        }
        return Optional.empty();
    }

    public Optional<Card> bloquearCard(Long id, String motivo) {
        Optional<Card> cardOpt = cardRepository.findById(id);
        if (cardOpt.isPresent()) {
            Card card = cardOpt.get();
            card.setBloqueado(true);
            card.setMotivoBloqueio(motivo);
            cardRepository.save(card);
            return Optional.of(card);
        }
        return Optional.empty();
    }

    public Optional<Card> desbloquearCard(Long id, String motivo) {
        Optional<Card> cardOpt = cardRepository.findById(id);
        if (cardOpt.isPresent()) {
            Card card = cardOpt.get();
            card.setBloqueado(false);
            card.setMotivoBloqueio(motivo);
            cardRepository.save(card);
            return Optional.of(card);
        }
        return Optional.empty();
    }
}