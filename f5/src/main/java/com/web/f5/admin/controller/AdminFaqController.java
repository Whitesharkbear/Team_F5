package com.web.f5.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminFaqController {

	@RequestMapping ( value = "admin/faq_list.do", method = RequestMethod.GET )
	public String faq_list() {
		
		return "admin/faq/faq_list";
	}
	
	@RequestMapping ( value = "admin/faq_write.do", method = RequestMethod.GET )
	public String faq_write() {
		
		return "admin/faq/faq_write";
	}
	
	@RequestMapping ( value = "admin/faq_update.do", method = RequestMethod.GET )
	public String faq_update() {
		
		return "admin/faq/faq_update";
	}
}
