package com.example.chatboard.board;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본 생성자 자동명시
@Getter
@Setter
@Entity(name = "board") //DB 연결
@EntityListeners(AuditingEntityListener.class) // JPA에게 해당 Entity는 Auditiong 기능을 사용함을 알림
public class Board {
    @Id //PK 명시
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sequence;
    private String user_id;
    private String title;
    private String detail;
    private String etc; //사진

    @Builder
    public Board(Long sequence, String user_id, String title, String detail, String etc) {
        this.sequence = sequence;
        this.user_id = user_id;
        this.title = title;
        this.detail = detail;
        this.etc = etc;
    }
}