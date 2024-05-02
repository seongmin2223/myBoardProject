package com.myproject.board.controller;

import com.myproject.board.dto.BoardDTO;
import com.myproject.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/save")
    public String save(){
        return "save";
    }

    @PostMapping("/save")
    public String savePost(BoardDTO boardDTO){
        boardService.savePost(boardDTO);
        return "index";
    }

    @GetMapping("/list")
    public String boardList(Model model){
        List<BoardDTO> boardList = boardService.selectList();
        model.addAttribute("boardList", boardList);
        return "list";
    }

    @GetMapping("/{id}")
    public String boardDetail(@PathVariable("id") Long id, Model model){
        BoardDTO boardDTO = boardService.boardDetail(id);
        model.addAttribute("board", boardDTO);
        return "boardDetail";
    }

    @GetMapping("/update/{id}")
    public String boardUpdate(@PathVariable("id") Long id, Model model){
        BoardDTO boardDTO = boardService.boardDetail(id);
        model.addAttribute("board", boardDTO);
        return "boardUpdate";
    }

    @PostMapping("/update/{id}")
    public String boardUpdate(BoardDTO boardDTO, Model model){
        boardService.boardUpdate(boardDTO);
        BoardDTO boardDto = boardService.boardDetail(boardDTO.getId());
        model.addAttribute("board", boardDto);
        return "boardDetail";
    }

    @GetMapping("/delete/{id}")
    public String boardDelete(@PathVariable("id") Long id){
        boardService.boardDelete(id);
        return "redirect:/list";
    }

}
