package org.spring.jpaboard.controller;

import org.spring.jpaboard.dto.BoardRequestDTO;
import org.spring.jpaboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/board")
public class BoardController {

    @Autowired
    private final BoardService boardService;
    public BoardController(BoardService boardService){
        this.boardService=boardService;
    }


//    =========================Main===============================
//    =========================Main===============================
    @GetMapping({"/", "/main"})
    public String index(){
        return "main";
    }

//    =========================Write on Board===============================
    @GetMapping("board/show")
    public String showBoard(){
        return "board/showBoard";
    }

    @PostMapping("board/write")
    public String writeBoard(@RequestAttribute BoardRequestDTO dto){
        boardService.write(dto);

        return "redirect : board/show";
    }

    @PostMapping("board/show")
    public String showOnBoard(){

        return "";
    }
}
