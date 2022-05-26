package com.web.f5.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.web.f5.service.AdminNoticeService;
import com.web.f5.service.PageServiceImpl;
import com.web.f5.vo.AdminNoticeVO;

@Controller
public class AdminNoticeController {

	@Autowired
	private AdminNoticeService adminNoticeService;
	
	@Autowired
	private PageServiceImpl pageService;
	
	@RequestMapping ( value = "/admin/notice_list.do", method = RequestMethod.GET )
	public ModelAndView admin_notice_list(String rpage) {
		
		ModelAndView mv = new ModelAndView();
			
		Map<String, String> param = pageService.getPageResult(rpage, "admin_Notice", adminNoticeService);
			
			int startCount = Integer.parseInt(param.get("start"));
			int endCount = Integer.parseInt(param.get("end"));
			
		List<Object> olist = adminNoticeService.getListResult(startCount, endCount);
		ArrayList<AdminNoticeVO> list = new ArrayList<AdminNoticeVO>();
		
		for ( Object obj : olist ) {
			
			list.add( (AdminNoticeVO) obj );
		}
		
		mv.addObject("list", list);
		mv.addObject("dbCount", Integer.parseInt(param.get("dbCount")));
		mv.addObject("pageSize", Integer.parseInt(param.get("pageSize")));
		mv.addObject("reqPage", Integer.parseInt(param.get("reqPage")));
		
		mv.setViewName("admin/notice/notice_list");
		
		return mv;
	}
	
	@RequestMapping ( value =  "/admin/notice_search_list.do", method = RequestMethod.GET )
//	public String notice_search_list(String search, String search_type, String rpage) {
	public ModelAndView notice_search_list(String search, String search_type, String rpage) {
		
		ModelAndView mv = new ModelAndView();
//		String msg = "";
		Map<String, String> param = pageService.getSearchResult(search_type, search, rpage, "admin_Notice", adminNoticeService);
		
		int startCount = Integer.parseInt(param.get("start"));
		int endCount = Integer.parseInt(param.get("end"));
		
		List<Object> olist = adminNoticeService.getSearchListResult(startCount, endCount, search, search_type);
		ArrayList<AdminNoticeVO> list = new ArrayList<AdminNoticeVO>();
		
		for ( Object obj : olist ) {
			
			list.add( (AdminNoticeVO) obj );
		}
//		msg = "success";
		mv.addObject("list", list);
		mv.addObject("search_type", search_type);
		mv.addObject("search", search);
		mv.addObject("dbCount", Integer.parseInt(param.get("dbCount")));
		mv.addObject("pageSize", Integer.parseInt(param.get("pageSize")));
		mv.addObject("reqPage", Integer.parseInt(param.get("reqPage")));
		
		mv.setViewName("admin/notice/notice_list");
		
		return mv;
//		return msg;
	}
	
	@RequestMapping ( value = "/admin/notice_content.do", method = RequestMethod.GET )
	public ModelAndView admin_notice_content(String idx, String rno) {
		
		ModelAndView mv = new ModelAndView();
		AdminNoticeVO vo = (AdminNoticeVO) adminNoticeService.getContent(idx);
		vo.setBoardContent(vo.getBoardContent().replace("<br>", "\r\n"));
		mv.addObject("vo", vo);
		mv.addObject("rno", rno);
		
		mv.setViewName("admin/notice/notice_content");
		
		return mv;
	}
	
	@RequestMapping ( value = "/admin/notice_write.do", method = RequestMethod.GET )
	public String admin_notice_write() {
		
		return "admin/notice/notice_write";
	}
	
	@RequestMapping ( value = "/admin/notice_write.do", method = RequestMethod.POST )
	public ModelAndView admin_notice_write(AdminNoticeVO vo) {
		
		ModelAndView mv = new ModelAndView();
		vo.setBoardContent(vo.getBoardContent().replace("\r\n", "<br>"));
		int result = adminNoticeService.getInsertResult(vo);
		
		if ( result == 1 ) {
			
			mv.setViewName("redirect:/admin/notice_list.do");
		} else {
			
			// errorPage
		}
		
		return mv;
	}
	
	@RequestMapping ( value = "/admin/notice_update.do", method = RequestMethod.GET )
	public ModelAndView admin_notice_update(String idx, String rno) {
		
		ModelAndView mv = new ModelAndView();
		AdminNoticeVO vo = (AdminNoticeVO) adminNoticeService.getContent(idx);
		vo.setBoardContent(vo.getBoardContent().replace("<br>", "\r\n"));
		mv.addObject("vo", vo);
		mv.addObject("rno", rno);
		
		mv.setViewName("admin/notice/notice_update");
		
		return mv;
	}
	
	@RequestMapping ( value = "/admin/notice_update.do", method = RequestMethod.POST )
	public ModelAndView admin_notice_update(AdminNoticeVO vo) {
		
		ModelAndView mv = new ModelAndView();
		vo.setBoardContent(vo.getBoardContent().replace("\r\n", "<br>"));
		int result = adminNoticeService.getUpdateResult(vo);
		
		if ( result == 1 ) {
			
			mv.setViewName("redirect:/admin/notice_list.do");
		} else {
			
			// errorPage
		}
		
		return mv;
	}
	
	@RequestMapping ( value = "/admin/notice_delete.do", method = RequestMethod.GET )
	public ModelAndView admin_notice_delete(String idx) {
		
		ModelAndView mv = new ModelAndView();
		
		int result = adminNoticeService.getDeleteResult(idx);
		
		if ( result == 1 ) {
			
			mv.setViewName("redirect:/admin/notice_list.do");
		} else {
			
			// errorPage
		}
		
		return mv;
	}
}
