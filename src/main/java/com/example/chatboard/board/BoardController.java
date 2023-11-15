package com.example.chatboard.board;

import jakarta.validation.Valid;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@ReadingConverter
@Controller
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }


    //게시글 리스트 페이지
//    @GetMapping("/board/list")
//    public String boardlist(Model model) {
//        model.addAttribute("boardList", boardService.findAll());
//        return "list";
//    }

    @GetMapping("/board/list")
    public String boardlist(Model model) {
        List<BoardPOSTDto> boardPOSTDTOList = boardService.getBoardList();
        model.addAttribute("boardList", boardPOSTDTOList);
        return "list";
    }

    @GetMapping("/board/write")
    public String board_post() {
        return "write";
    }

    //글쓰기 페이지
    @PostMapping("/board/write")
    public String write(@Valid BoardPOSTDto boardPOSTDto, Errors errors) {
//        if (seccess){
        boardService.saveboardPost(boardPOSTDto);
        return "redirect:list";
//        } else {
//            return "redirect:write_error";
//        }
    }

    //게시글 상세 페이지 구현
    @GetMapping("/board/detail")
    public String detail(@RequestParam("id") Long sequence, Model model){
        model.addAttribute("detail", boardService.detail(sequence));
        return "detail";
    }

}