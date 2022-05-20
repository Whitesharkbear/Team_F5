package com.web.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.service.BoardServiceImpl;
import com.web.service.FileServiceImpl;
import com.web.service.PageServiceImpl;
import com.web.vo.CgvBoardVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardServiceImpl boardService;  //클래스타입 객체명;
	
	@Autowired
	private PageServiceImpl pageService;  //클래스타입 객체명;
	
	@Autowired
	private FileServiceImpl fileService;  //클래스타입 객체명;
	
	/**
	 * 게시글 삭제 처리
	 * @return
	 */
	@RequestMapping(value="/board_delete.do", method=RequestMethod.POST)
	public ModelAndView board_delete(CgvBoardVO vo, HttpServletRequest request)
													throws Exception{
		ModelAndView mv = new ModelAndView();
		String bsfile = boardService.getFilename(vo.getBid());
		int result = boardService.getDeleteResult(vo.getBid());
	
		if(result == 1) {
			if(bsfile != null) {
				String path = request.getSession().getServletContext().getRealPath("/");
				path += "resources\\upload\\";
				File file = new File(path + bsfile);
				if(file.exists()) file.delete();
			}
			mv.setViewName("redirect:/board_list.do");			
		}else {
			//에러페이지 호출
		}		
		
		return mv;
	}
	
	
	/**
	 * 게시글 삭제 화면
	 * @return
	 */
	@RequestMapping(value="/board_delete.do", method=RequestMethod.GET)
	public ModelAndView board_delete(String bid, String rno) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("bid", bid);
		mv.addObject("rno", rno);
		mv.setViewName("/board/board_delete");
		
		return mv;
	}
	
	
	/**
	 * 게시글 업데이트 처리
	 * @return
	 */
	@RequestMapping(value="/board_update.do", method=RequestMethod.POST)
	public ModelAndView board_update(CgvBoardVO vo, HttpServletRequest request) 
														throws Exception{
		ModelAndView mv = new ModelAndView();
		String oldFile = vo.getBsfile();
		
		vo = fileService.fileCheck(vo);
		int result = boardService.getUpdateResult(vo);
		
		if(result == 1) {
			fileService.fileSave(vo, request, oldFile);
			mv.setViewName("redirect:/board_list.do");
		}else {
			//에러페이지 호출
		}
				
		return mv;
	}
		
	
	
	/**
	 * 게시글 업데이트 폼
	 * @return
	 */
	@RequestMapping(value="/board_update.do", method=RequestMethod.GET)
	public ModelAndView board_update(String bid, String rno) {
		ModelAndView mv = new ModelAndView();
		CgvBoardVO vo = (CgvBoardVO)boardService.getContent(bid);
		
		mv.addObject("vo", vo);
		mv.addObject("rno",rno);
		mv.setViewName("/board/board_update");
		
		
		return mv;
	}
	
	/**
	 * 게시글 상세보기
	 * @return
	 */
	@RequestMapping(value="/board_content.do", method=RequestMethod.GET)
	public ModelAndView board_content(String bid, String rno) {
		ModelAndView mv = new ModelAndView();
		boardService.getUpdateHits(bid);
		CgvBoardVO vo = (CgvBoardVO)boardService.getContent(bid);
		
		mv.addObject("vo", vo);
		mv.addObject("rno", rno);
		mv.setViewName("/board/board_content");
		
		return mv;
	}
	
	/**
	 * 게시글 등록 처리
	 * @return
	 */
	@RequestMapping(value="/board_write.do", method=RequestMethod.POST)
	public String board_write(CgvBoardVO vo, HttpServletRequest request) 
													throws Exception{
		String result_page = "";		
	
		vo = fileService.fileCheck(vo);
		int result = boardService.getInsertResult(vo);
		
		if(result == 1) {
			fileService.fileSave(vo,request);					
			result_page = "redirect:/board_list.do";
			
		}else {
			//에러페이지 호출
		}		
		
		return result_page;
	}
	
	
	
	/**
	 * 게시글 등록폼
	 * @return
	 */
	@RequestMapping(value="/board_write.do", method=RequestMethod.GET)
	public String board_write() {
		return "/board/board_write";
	}

	
	/**
	 * 게시글 전체 리스트
	 * @return
	 */
	@RequestMapping(value="/board_list.do", method=RequestMethod.GET)
	public ModelAndView board_list(String rpage) {
		ModelAndView mv = new ModelAndView();
		Map<String,String> param = pageService.getPageResult(rpage, "board", boardService);
		int startCount = Integer.parseInt(param.get("start"));
		int endCount = Integer.parseInt(param.get("end"));
		
		ArrayList<CgvBoardVO> list = new  ArrayList<CgvBoardVO>();
		List<Object> olist = boardService.getListResult(startCount, endCount);
		for(Object obj : olist) {
			list.add((CgvBoardVO)obj);
		}
		
		mv.addObject("list", list);
		mv.addObject("dbCount", Integer.parseInt(param.get("dbCount")));
		mv.addObject("pageSize", Integer.parseInt(param.get("pageSize")));
		mv.addObject("reqPage", Integer.parseInt(param.get("reqPage")));		
		mv.setViewName("/board/board_list");
		
		return mv;
	}
	
}//controller

















