package com.web.f5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminQuestionController {
	
	@RequestMapping ( value = "admin/question_list.do", method = RequestMethod.GET )
	public String admin_question_list() {
		
		return "admin/question/question_list";
	}
	
	@RequestMapping ( value = "admin/question_content.do", method = RequestMethod.GET )
	public String admin_question_content() {
		
		return "admin/question/question_content";
	}
	
	@RequestMapping ( value = "admin/question_receive.do", method = RequestMethod.GET )
	public String admin_question_receive() {
		
		return "admin/question/question_receive";
	}
}
