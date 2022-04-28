package com.web.f5.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyPageController {

	@RequestMapping(value="/mypage.do", method = RequestMethod.GET)
	public String mypage() {
		return "member/mypage/mypage";
	}


	@RequestMapping(value="/mypage_info.do", method = RequestMethod.GET)
	public String mypage_info() {
		return "member/mypage/mypage_info";
	}
}