package com.myproject.board.repository;

import com.myproject.board.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final SqlSessionTemplate sql;

    public void savePost(BoardDTO boardDTO) {
        sql.insert("Board.savePost", boardDTO);
    }


    public List<BoardDTO> selectList() {
        return sql.selectList("Board.selectList");
    }

    public BoardDTO boardDetail(Long id) {
        return sql.selectOne("Board.boardDetail", id);
    }

    public void boardUpdate(BoardDTO boardDTO) {
        sql.update("Board.boardUpdate", boardDTO);
    }

    public void boardDelete(Long id) {
        sql.delete("Board.boardDelete", id);
    }
}
