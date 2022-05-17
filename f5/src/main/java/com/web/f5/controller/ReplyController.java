package com.web.f5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.f5.service.ReplyServiceImpl;
import com.web.f5.vo.ReplyVO;


@Controller
public class ReplyController {
	
	@Autowired
	private ReplyServiceImpl replyService;
	
	// 댓글삭제
	@RequestMapping(value="/reply_delete.do", method=RequestMethod.POST)
	public String board_reply_delete(String replyIdx, String boardIdx) {
		replyService.getDeleteResult(replyIdx);
		
		return "redirect:/board_content.do?boardIdx=" + boardIdx;
	}
	
	// 댓글쓰기
	@RequestMapping(value="/reply_write.do", method=RequestMethod.POST)
	public ModelAndView board_reply_write(ReplyVO vo) {
		ModelAndView mv = new ModelAndView();
		replyService.getInsertResult(vo);
		mv.addObject("re_vo", vo);
		mv.setViewName("redirect:/board_content.do?boardIdx="+vo.getboardIdx());
		
		return mv;
		
	}
	
}
