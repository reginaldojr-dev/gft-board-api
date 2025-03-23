package com.tarefa.controller;

import com.tarefa.model.Coluna;
import com.tarefa.service.ColunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colunas")
public class ColunaController {
    @Autowired
    private ColunaService colunaService;

    @GetMapping
    public List<Coluna> listarColunas() {
        return colunaService.listarColunas();
    }

    @PostMapping
    public Coluna criarColuna(@RequestBody Coluna coluna) {
        return colunaService.salvarColuna(coluna);
    }
}