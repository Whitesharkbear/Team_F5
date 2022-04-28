package com.web.f5.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ServiceController {

	@RequestMapping ( value = "/faq_list.do", method = RequestMethod.GET )
	public String faq_list() {
		
		return "service/faq_list";
	}
}
