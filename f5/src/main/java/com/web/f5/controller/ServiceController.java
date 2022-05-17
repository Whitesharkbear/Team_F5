package com.web.f5.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.f5.service.AdminFaqService;
import com.web.f5.service.PageServiceImpl;
import com.web.f5.vo.AdminFaqVO;

@Controller
public class ServiceController {

	@Autowired
	private AdminFaqService adminFaqService;
	
	@Autowired
	private PageServiceImpl pageService;
	
	@RequestMapping( value = "faq_list.do", method = RequestMethod.GET )
	public ModelAndView faq_list(String rpage) {
		
		ModelAndView mv = new ModelAndView();
		
		Map<String, String> param = pageService.getPageResult(rpage, "faq", adminFaqService);
		
		int startCount = Integer.parseInt( param.get("start") );
		int endCount = Integer.parseInt( param.get("end") );
		
		List<Object> olist = adminFaqService.getListResult(startCount, endCount);
		ArrayList<AdminFaqVO> list = new ArrayList<AdminFaqVO>();
	
		for ( Object obj : olist ) {
			
			list.add( (AdminFaqVO) obj );
		}
		
		mv.setViewName("service/faq_list");
	
		mv.addObject("list", list);
		mv.addObject("dbCount", Integer.parseInt(param.get("dbCount")));
		mv.addObject("pageSize", Integer.parseInt(param.get("pageSize")));
		mv.addObject("reqPage", Integer.parseInt(param.get("reqPage")));
		
		return mv;
	}
}
