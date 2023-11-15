package com.example.chatboard.board;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    //사용자 입력값 저장
    @Transactional
    public Long saveboardPost(BoardPOSTDto boardPOSTDto) {
        return boardRepository.save(boardPOSTDto.toEntity()).getSequence();
    }

    @Transactional
    public List<BoardPOSTDto> getBoardList() {
        List<Board> boardList = boardRepository.findAll();
        List<BoardPOSTDto> boardPOSTDTOList = new ArrayList<>();

        for(Board board : boardList) {
            BoardPOSTDto boardPOSTDTO = BoardPOSTDto.builder()
                    .sequence(board.getSequence())
                    .user_id(board.getUser_id())
                    .title(board.getTitle())
                    .build();
            boardPOSTDTOList.add(boardPOSTDTO);
        }
        return boardPOSTDTOList;
    }

    //글 상세 페이지
    @Transactional
    public Board detail(Long sequence) {
        return boardRepository.findById(sequence).orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다. id=" + sequence));
    }
}