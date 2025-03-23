package com.tarefa.service;

import com.tarefa.model.Board;
import com.tarefa.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public List<Board> listarBoards() {
        return boardRepository.findAll();
    }

    public Optional<Board> buscarBoardPorId(Long id) {
        return boardRepository.findById(id);
    }

    public Board salvarBoard(Board board) {
        return boardRepository.save(board);
    }

    public void excluirBoard(Long id) {
        boardRepository.deleteById(id);
    }
}

