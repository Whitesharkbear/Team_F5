package com.web.f5.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.f5.service.BoardService;
import com.web.f5.service.BoardServiceImpl;
import com.web.f5.vo.BoardVO;

@Controller
public class PromoteController {
	
	@Autowired
	private BoardServiceImpl boardService;
	
	
	// 홍보 삭제처리
	@RequestMapping(value="/promote_delete.do", method=RequestMethod.GET)
	public ModelAndView promote_delete(String boardIdx) {
		ModelAndView mv = new ModelAndView();
		
		boardService.getDeleteResult(boardIdx);
		
		mv.setViewName("redirect:/promote_list.do");
		
		return mv;
	}
	
	// 홍보 수정처리
	@RequestMapping(value="/promote_update.do", method=RequestMethod.POST)
	public ModelAndView promote_update(BoardVO vo) {
		ModelAndView mv = new ModelAndView();
		
		boardService.getContentUpdate(vo);
		
		mv.setViewName("redirect:/promote_list.do");
		
		return mv;
	}
	
	
	// 홍보 수정
	@RequestMapping(value="/promote_update.do", method=RequestMethod.GET)
	public ModelAndView promote_update(String boardIdx) {
		ModelAndView mv = new ModelAndView();
		BoardVO vo = boardService.getContentList(boardIdx);
		
		mv.addObject("vo", vo);
		mv.setViewName("board/promote/promote_update");
		
		return mv;
	}
	
	
	
	// 홍보 쓰기 처리
	@RequestMapping(value="/promote_write.do", method=RequestMethod.POST)
	public ModelAndView promote_write(BoardVO vo) {
		ModelAndView mv = new ModelAndView();
		
		vo.setBoardCategory("홍보");
		boardService.getInsertResult(vo);
		
		mv.setViewName("redirect:/promote_list.do");
		
		return mv;
		
	}
	
	// 홍보 쓰기
	@RequestMapping(value="/promote_write.do", method=RequestMethod.GET)
	public String promote_write() {
		
		return "board/promote/promote_write";
	}
	
	
	
	// 홍보 리스트
	@RequestMapping(value="/promote_list.do", method=RequestMethod.GET)
	public ModelAndView promote_list() {
		ModelAndView mv = new ModelAndView();
		List<BoardVO> list = new ArrayList<BoardVO>();
		String boardCategory = "1";
		list = boardService.getSelectList(boardCategory);
		
		mv.addObject("list", list);
		mv.setViewName("board/promote/promote_list");
		
		return mv;
	}
}








