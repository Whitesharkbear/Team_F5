package com.web.f5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PromoteController {
	
	
	@RequestMapping(value="/promote_write.do", method=RequestMethod.GET)
	public String Promote_write() {
		
		return "board/promote/promote_write";
	}
	
	
	@RequestMapping(value="/promote_update.do", method=RequestMethod.GET)
	public String Promote_update() {
		
		return "board/promote/promote_update";
	}
	
	
	@RequestMapping(value="/promote_list.do", method=RequestMethod.GET)
	public String Promote_list() {
		
		return "board/promote/promote_list";
	}
}
