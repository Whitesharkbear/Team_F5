package com.web.f5.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {
	
	// 게시판 수정
	@RequestMapping(value="/board_update.do", method=RequestMethod.GET)
	public String board_update() {
		
		return "/board/board_update";
	}
	
	// 게시판 상세
	@RequestMapping(value="/board_content.do", method=RequestMethod.GET)
	public String board_content() {
		
		return "/board/board_content";
	}
	
	
	// 게시판 쓰기
	@RequestMapping(value="/board_write.do", method=RequestMethod.GET)
	public String board_write() {
		
		return "/board/board_write";
	}

	// 게시판리스트 출력
	@RequestMapping(value="/board_list.do", method=RequestMethod.GET)
	public String board_list() {
		
		return "/board/board_list";
	}
	
	
}
