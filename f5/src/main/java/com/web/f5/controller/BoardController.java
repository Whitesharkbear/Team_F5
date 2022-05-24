package com.web.f5.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.web.f5.service.BoardServiceImpl;
import com.web.f5.service.ReplyServiceImpl;
import com.web.f5.vo.BoardVO;
import com.web.f5.vo.RecommendVO;
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

	mv.setViewName("redirect:/board_content.do?boardIdx="+vo.getBoardIdx());
	
	return mv;
	}
	
	// 게시글 추천
	@ResponseBody
	@RequestMapping(value="/board_recommend.do", method=RequestMethod.POST)
	public void board_Recommend(RecommendVO vo) {

		int result = boardService.getRecoCheckResult(vo.getBoardIdx(), vo.getMemberId());
		if(result == 0) {
			boardService.getRecoInsertResult(vo);
			System.out.println(result);
		} else {
			System.out.println("update");
			System.out.println(vo.getBoardRecommendCheck());
			if(vo.getBoardRecommendCheck().equals("0") || vo.getBoardRecommendCheck().equals("1")) {
				System.out.println(vo.getBoardRecommendCheck());
				boardService.getRecoUpdateResult(vo);
				System.out.println("처리완료");
			} else if(vo.getBoardRecommendCheck().equals("2")) {
				boardService.getRecoDeleteResult(vo);
			}
		}
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
		List<String> ridx = new ArrayList<String>();
		
		rlist = replyService.getSelectList(boardIdx);
		ridx = replyService.getSelectIdxList(boardIdx);		
		System.out.println(ridx);
		for(ReplyVO lvo : rlist) {
			
			for(String r : ridx) {
				if(lvo.getreplyIdx().equals(r)) {
					int recount = replyService.getRecoCountResult("0", r);
					int decount = replyService.getRecoCountResult("1", r);
					lvo.setRecoCount(recount);
					lvo.setDerecoCount(decount);
					System.out.println(lvo.getRecoCount());
					System.out.println(lvo.getDerecoCount());
					
					ReplyVO vo = lvo;
					int result = replyService.getRecoCheckResult(vo);
					System.out.println("recoCheckResult = "+result);
					
					vo.setReplyRecommendCheck(replyService.getSelectReCheck(r, vo.getmemberId()));
					
					System.out.println("멤버 아이디 = "+vo.getmemberId());
					System.out.println("보드 인덱스 = "+vo.getboardIdx());
					System.out.println("댓글 인덱스 = "+vo.getreplyIdx());
					System.out.println("추천체크 = "+vo.getReplyRecommendCheck());
					System.out.println("추천수 = "+vo.getRecoCount());
					System.out.println("비추천수 = "+vo.getDerecoCount());
					System.out.println();
						
				}
			
			}
		}
		
		BoardVO vo = boardService.getContentList(boardIdx);
		
		RecommendVO brvo = null;
		
		if(boardService.getRecoCheckResult(boardIdx, "test") !=0 ) {
			brvo = boardService.getRecoSelect(boardIdx, "test");
			System.out.println(brvo.getBoardIdx());
			System.out.println(brvo.getMemberId());
			System.out.println(brvo.getBoardRecommendCheck());
			mv.addObject("brvo", brvo);
		}
		
		int reco = boardService.getRecoCountResult("0", boardIdx);
		int deco = boardService.getRecoCountResult("1", boardIdx);
		
		
		mv.addObject("vo", vo);
		mv.addObject("rlist", rlist);
		mv.addObject("reco",reco);
		mv.addObject("deco",deco);
		mv.addObject("brvo", brvo);
		
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
