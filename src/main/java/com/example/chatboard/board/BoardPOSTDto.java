package com.example.chatboard.board;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

//Controller와 Service 사이에 데이터 주고 받는 DTO(Data Access Object)
@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardPOSTDto {
    private Long sequence;
    private String user_id;

    @NotBlank(message = "제목을 입력해 주세요!")
    private String title;
    @NotBlank(message = "내용을 입력해 주세요!")
    private String detail;
    private String etc;

    public Board toEntity() {
        Board build = Board.builder()
                .sequence(sequence)
                .user_id(user_id)
                .title(title)
                .detail(detail)
                .etc(etc)
                .build();
        return build;
    }

    @Builder
    public BoardPOSTDto(Long sequence, String  user_id, String title, String detail, String etc) {
        this.sequence = sequence;
        this.user_id = user_id;
        this.title = title;
        this.detail = detail;
        this.etc = etc;
    }
}
