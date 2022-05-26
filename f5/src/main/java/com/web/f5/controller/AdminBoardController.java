package com.web.f5.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.f5.service.AdminBoardService;
import com.web.f5.service.PageServiceImpl;
import com.web.f5.vo.AdminBoardVO;

@Controller
public class AdminBoardController {

	@Autowired
	private AdminBoardService adminBoardService;
	
	@Autowired
	private PageServiceImpl pageService;
	
	@RequestMapping ( value = "/admin/board_list.do", method = RequestMethod.GET )
	public ModelAndView admin_board_list( String rpage ) {
		
		ModelAndView mv = new ModelAndView();
		
		Map<String, String> param = pageService.getPageResult(rpage, "admin_Board", adminBoardService);
		
		int startCount = Integer.parseInt(param.get("start"));
		int endCount = Integer.parseInt(param.get("end"));
		
		List<Object> olist = adminBoardService.getListResult(startCount, endCount);
		ArrayList<AdminBoardVO> list = new ArrayList<AdminBoardVO>();
		
		for ( Object obj : olist ) {
			
			list.add( (AdminBoardVO) obj );
		}
		
		mv.addObject("list", list);
		mv.addObject("dbCount", Integer.parseInt(param.get("dbCount")));
		mv.addObject("pageSize", Integer.parseInt(param.get("pageSize")));
		mv.addObject("reqPage", Integer.parseInt(param.get("reqPage")));
		
		mv.setViewName("/admin/board/board_list");
		
		return mv;
	}
	
	@RequestMapping ( value = "/admin/board_content.do", method = RequestMethod.GET )
	public ModelAndView admin_board_content(String idx, String rno) {
		
		ModelAndView mv = new ModelAndView();
		AdminBoardVO vo = (AdminBoardVO) adminBoardService.getContent(idx);
		
		mv.addObject("vo", vo);
		mv.addObject("rno", rno);
		mv.setViewName("admin/board/board_content");
		
		return mv;
	}
	
	@RequestMapping ( value = "/admin/board_write.do", method = RequestMethod.GET )
	public ModelAndView admin_board_write() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("admin/board/board_write");
		
		return mv;
	}
	
	@RequestMapping ( value = "/admin/board_write.do", method = RequestMethod.POST )
	public ModelAndView admin_board_write( AdminBoardVO vo ) {
		
		ModelAndView mv = new ModelAndView();
		
		int result = adminBoardService.getInsertResult(vo);
		
		if ( result == 1 ) {
			
			mv.setViewName("redirect:/admin/board_list.do");
		} else {
			
			// errorPage
		}
		
		return mv;
	}
	
	@RequestMapping ( value = "/admin/board_update.do", method = RequestMethod.GET )
	public ModelAndView admin_board_update(String idx, String rno) {
		
		ModelAndView mv = new ModelAndView();
		
		AdminBoardVO vo = (AdminBoardVO) adminBoardService.getContent(idx);
		
		mv.addObject("vo", vo);
		mv.addObject("rno", rno);
		
		mv.setViewName("admin/board/board_update");
		
		return mv;
	}
	
	@RequestMapping ( value = "/admin/board_update.do", method = RequestMethod.POST )
	public ModelAndView admin_board_update(AdminBoardVO vo) {
		
		ModelAndView mv = new ModelAndView();
		
		int result = adminBoardService.getUpdateResult(vo);
		
		if ( result == 1 ) {
			
			mv.setViewName("redirect:/admin/board_list.do");
		} else {
			
			// errorPage
		}
		
		return mv;
	}
	
	@RequestMapping ( value = "/admin/board_delete.do", method = RequestMethod.GET )
	public ModelAndView admin_board_delete(String idx) {
		
		ModelAndView mv = new ModelAndView();
		
		int result = adminBoardService.getDeleteResult(idx);
		
		if ( result == 1 ) {
			
			mv.setViewName("redirect:/admin/board_list.do");
		} else {
			
			// errorPage
		}
		
		return mv;
	}
}
