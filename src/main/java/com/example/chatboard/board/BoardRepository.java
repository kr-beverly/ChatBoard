package com.example.chatboard.board;

import org.springframework.data.jpa.repository.JpaRepository;

//스프링부트에서 실제로 DB에 접근하는 객체
public interface BoardRepository extends JpaRepository<Board, Long> {

}