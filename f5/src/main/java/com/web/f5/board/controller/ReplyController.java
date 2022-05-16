package com.web.f5.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.f5.board.service.ReplyServiceImpl;
import com.web.f5.board.vo.ReplyVO;


@Controller
public class ReplyController {
	
	@Autowired
	private ReplyServiceImpl replyService;
	
	// 댓글삭제
	@RequestMapping(value="/reply_delete.do", method=RequestMethod.POST)
	public String board_reply_delete(String reply_idx, String board_idx) {
		replyService.getDeleteResult(reply_idx);
		
		return "redirect:/board_content.do?board_idx=" + board_idx;
	}
	
	// 댓글쓰기
	@RequestMapping(value="/reply_write.do", method=RequestMethod.POST)
	public ModelAndView board_reply_write(ReplyVO vo) {
		ModelAndView mv = new ModelAndView();
		replyService.getInsertResult(vo);
		mv.addObject("re_vo", vo);
		mv.setViewName("redirect:/board_content.do?board_idx="+vo.getBoard_idx());
		
		return mv;
		
	}
	
}
