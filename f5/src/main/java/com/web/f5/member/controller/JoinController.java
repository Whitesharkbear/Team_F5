package com.web.f5.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.f5.member.service.MemberService;
import com.web.f5.member.vo.MemberVO;

@Controller
public class JoinController {
	
	@Autowired MemberService memberService;
	
	@RequestMapping(value="/join.do", method=RequestMethod.GET)
	public String join() {
		return "member/join/join";
	}
	@RequestMapping(value="/join.do", method=RequestMethod.POST)
	public ModelAndView join(MemberVO vo) {
		ModelAndView mv = new ModelAndView();
		int result = memberService.insert_result(vo);
		
		if(result == 1) {
			System.out.println("가입성공");
			mv.setViewName("member/login/login");
		}else {
			System.out.println("가입실패");
			mv.setViewName("join/join");
		}
		return mv;
	}
}
