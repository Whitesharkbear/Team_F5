package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	@RequestMapping(value="/index.do", method=RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("name", "ȫ�浿");
		mv.addObject("age", 30);
		
		String strlist[] = {"ȫ�浿","��ö��","�׽�Ʈ"};
		mv.addObject("list", strlist);
		
		return mv;
	}
}
