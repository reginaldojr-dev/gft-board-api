package com.tarefa.service;

import com.tarefa.model.Coluna;
import com.tarefa.repository.ColunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColunaService {
    @Autowired
    private ColunaRepository colunaRepository;

    public List<Coluna> listarColunas() {
        return colunaRepository.findAll();
    }

    public Coluna salvarColuna(Coluna coluna) {
        return colunaRepository.save(coluna);
    }
}

