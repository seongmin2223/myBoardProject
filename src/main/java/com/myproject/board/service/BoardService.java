package com.myproject.board.service;

import com.myproject.board.dto.BoardDTO;
import com.myproject.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void savePost(BoardDTO boardDTO) {
        boardRepository.savePost(boardDTO);
    }

    public List<BoardDTO> selectList() {
        return boardRepository.selectList();
    }

    public BoardDTO boardDetail(Long id) {
        return boardRepository.boardDetail(id);
    }

    public void boardUpdate(BoardDTO boardDTO) {
        boardRepository.boardUpdate(boardDTO);
    }

    public void boardDelete(Long id) {
        boardRepository.boardDelete(id);
    }
}
