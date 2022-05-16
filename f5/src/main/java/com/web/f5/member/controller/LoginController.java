package com.web.f5.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.f5.member.service.MemberService;
import com.web.f5.member.vo.MemberVO;

@Controller
public class LoginController {

	
@Autowired
MemberService memberService;
	
	@RequestMapping(value="/login.do", method = RequestMethod.GET)
	public String login() {
		return "member/login/login";
	}
	
	@RequestMapping(value="/login.do", method = RequestMethod.POST)
	public String login(MemberVO vo, HttpSession session) {
		
		int result = memberService.login_result(vo);
		System.out.println("controller_result = "+result);
		if(result == 1) {
			session.setAttribute("member_id", vo.getMember_id());
			System.out.println("로그인성공");
			return "main/index";
		}else {
			System.out.println("로그인실패");
			return "member/login/login";
		}
	}
}
