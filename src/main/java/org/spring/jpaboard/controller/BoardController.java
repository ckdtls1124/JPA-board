package org.spring.jpaboard.controller;

import org.spring.jpaboard.dto.BoardRequestDTO;
import org.spring.jpaboard.dto.BoardResponseDTO;
import org.spring.jpaboard.entity.BoardEntity;
import org.spring.jpaboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;
    public BoardController(BoardService boardService){
        this.boardService=boardService;
    }


//    =========================Main===============================
    @GetMapping({"/", "/main"})
    public String index(){
        return "main";
    }

//    =========================Write on Board===============================
    @GetMapping("/board/show")
    public String showBoard(){
        return "board/showBoard";
    }

    @PostMapping("/board/write")
    public String writeBoard(@ModelAttribute BoardRequestDTO dto){
        boardService.write(dto);

        return "redirect:lists";
    }
//    =========================Show everything on Board===============================

    @GetMapping("/board/lists")
    public String showAllOnBoard(Model model){
        List<BoardResponseDTO> boardLists=boardService.showAllLists();
        model.addAttribute("each", boardLists);
        return "board/lists";
    }

//    =========================Show certain writing on Board===============================
    @GetMapping("/board/detail/{number}")
    public String showOneOnBoard(@PathVariable Long number, Model model){
//        boardService.incrementViews(number); //Increment views

        BoardResponseDTO oneWriting=boardService.showOneList(number);
        model.addAttribute("one", oneWriting);
        return "board/showOneList";
    }

//    ===========================Paging===================================================
    @GetMapping("/board/pagingList")
    public String pagingList(Model model, @PageableDefault(page = 0, size = 3, sort = "number", direction = Sort.Direction.DESC)Pageable pageable){


//        Paging
        Page<BoardResponseDTO> boardList=boardService.boardPaging(pageable);
        int bockNum=4;
        int nowPage=boardList.getNumber()+1;
        int startPage=Math.max(1, boardList.getNumber()-bockNum);
        int endPage=boardList.getTotalPages();

        model.addAttribute("boardList", boardList);
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return "board/lists";

    }


}
