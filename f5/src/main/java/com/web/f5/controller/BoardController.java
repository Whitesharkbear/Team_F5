package com.web.f5.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.f5.service.BoardServiceImpl;
import com.web.f5.service.ReplyServiceImpl;
import com.web.f5.vo.BoardVO;
import com.web.f5.vo.ReplyVO;

@Controller
public class BoardController {

	@Autowired
	private BoardServiceImpl boardService;
	
	@Autowired
	private ReplyServiceImpl replyService;
	
	// 게시판 삭제 처리
	@RequestMapping(value = "/board_delete.do", method=RequestMethod.POST)
	public String board_delete(String boardIdx) {
		boardService.getDeleteResult(boardIdx);
		
		
		return "redirect:/board_list.do";
	}
	
	
	// 게시판 수정처리
	@RequestMapping(value="/board_update.do", method=RequestMethod.POST) 
	public ModelAndView board_update(BoardVO vo) {
	ModelAndView mv = new ModelAndView();
	
	boardService.getContentUpdate(vo);

	mv.setViewName("redirect:/board_list.do");
	
	return mv;
	}
	

	// 게시판 수정
	@RequestMapping(value = "/board_update.do", method = RequestMethod.GET)
	public ModelAndView board_update(String boardIdx) {
		ModelAndView mv = new ModelAndView();
		BoardVO vo = boardService.getContentList(boardIdx);
		mv.addObject("vo", vo);
		mv.setViewName("/board/board_update");

		return mv;
	}

	// 게시판 상세
	@RequestMapping(value = "/board_content.do", method = RequestMethod.GET)
	public ModelAndView boardContent(String boardIdx) {
		ModelAndView mv = new ModelAndView();
		boardService.getUpdateHits(boardIdx);
		
		List<ReplyVO> rlist = new ArrayList<ReplyVO>();
		rlist = replyService.getSelectList(boardIdx);
		
		BoardVO vo = boardService.getContentList(boardIdx);
		
		mv.addObject("vo", vo);
		mv.addObject("rlist", rlist);
		mv.setViewName("/board/board_content");
		return mv;
	}

	// 게시판 쓰기처리
	@RequestMapping(value = "/board_write.do", method = RequestMethod.POST)
	public ModelAndView board_write(BoardVO vo) {
		ModelAndView mv = new ModelAndView();

		boardService.getInsertResult(vo);

		mv.setViewName("redirect:/board_list.do");

		return mv;
	}

	// 게시판 쓰기
	@RequestMapping(value = "/board_write.do", method = RequestMethod.GET)
	public String board_write() {

		return "/board/board_write";
	}

	// 게시판리스트 출력
	@RequestMapping(value = "/board_list.do", method = RequestMethod.GET)
	public ModelAndView board_list() {
		ModelAndView mv = new ModelAndView();
		List<BoardVO> list = new ArrayList<BoardVO>();
		list = boardService.getSelectList();
		mv.addObject("list", list);
		mv.setViewName("/board/board_list");

		return mv;
	}

}
