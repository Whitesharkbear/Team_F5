package com.web.f5.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView login(MemberVO vo, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		int result = memberService.login_result(vo);
		MemberVO mvo = new MemberVO();
		mvo = memberService.select_result(vo.getMemberId());
		if(result == 1) {
			session.setAttribute("memberId", vo.getMemberId());
			session.setAttribute("memberName", mvo.getMemberName());
			mv.addObject("mvo",mvo);
			mv.setViewName("main/index");
			System.out.println("로그인성공");
			return mv;
		}else {
			System.out.println("로그인실패");
			mv.setViewName("member/login/login");
			return mv;
		}
	}
}
