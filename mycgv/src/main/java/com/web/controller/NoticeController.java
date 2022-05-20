package com.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.service.NoticeServiceImpl;
import com.web.service.PageServiceImpl;
import com.web.vo.CgvNoticeVO;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeServiceImpl noticeService;
	
	@Autowired
	private PageServiceImpl pageService;

	
	@RequestMapping(value="/notice_content.do", method=RequestMethod.GET)
	public ModelAndView notice_content(String nid, String rno) {
		ModelAndView mv = new ModelAndView();
		noticeService.getUpdateHits(nid);
		CgvNoticeVO vo = (CgvNoticeVO)noticeService.getContent(nid);
		
		mv.addObject("vo",vo);
		mv.addObject("rno",rno);
		mv.setViewName("/notice/notice_content");
		
		return mv;
	}
	
	
	@RequestMapping(value="/notice_list.do", method=RequestMethod.GET)
	public ModelAndView notice_list(String rpage) {
		ModelAndView mv = new ModelAndView();
		Map<String,String> param = pageService.getPageResult(rpage, "notice", noticeService);
		int startCount = Integer.parseInt(param.get("start"));
		int endCount = Integer.parseInt(param.get("end"));		
				
		ArrayList<CgvNoticeVO> list =  new ArrayList<CgvNoticeVO>();
		List<Object> olist = noticeService.getListResult(startCount, endCount); //start,end
		for(Object obj:olist) {
			list.add((CgvNoticeVO)obj);
		}		
		
		mv.addObject("list", list);
		mv.addObject("dbCount", Integer.parseInt(param.get("dbCount")));
		mv.addObject("pageSize", Integer.parseInt(param.get("pageSize")));
		mv.addObject("reqPage", Integer.parseInt(param.get("reqPage")));	
		
		mv.setViewName("/notice/notice_list");
		
		return mv;
	}
}














