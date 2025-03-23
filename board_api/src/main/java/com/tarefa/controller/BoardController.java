package com.tarefa.controller;

import com.tarefa.model.*;
import com.tarefa.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/boards")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping
    public List<Board> listarBoards() {
        return boardService.listarBoards();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Board> buscarBoardPorId(@PathVariable Long id) {
        Optional<Board> board = boardService.buscarBoardPorId(id);
        return board.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Board criarBoard(@RequestBody Board board) {
        return boardService.salvarBoard(board);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirBoard(@PathVariable Long id) {
        boardService.excluirBoard(id);
        return ResponseEntity.noContent().build();
    }
}
