package com.example.chatboard.board;

import lombok.Getter;

@Getter
public class BoardResponseDto {
    private Long sequence;
    private String user_id;
    private String title;
    private String detail;
    private String etc;

    public BoardResponseDto(Board entity) {
        this.sequence = entity.getSequence();
        this.user_id = entity.getUser_id();
        this.title = entity.getTitle();
        this.detail = entity.getDetail();
        this.etc = getEtc();
    }
}
