package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.web.dao.CgvMemberDAO;
import com.web.service.MemberServiceImpl;
import com.web.vo.CgvMemberVO;

@Controller
public class JoinController {
	
	@Autowired
	private MemberServiceImpl memberService;
	

	/**
	 * 아이디 중복체크 처리
	 */
	@ResponseBody
	@RequestMapping(value="/idcheck.do", method=RequestMethod.GET)
	public String idcheck(String id) {
		int result = memberService.getIdCheckResult(id);		
		return String.valueOf(result);
	}	
	
	/**
	 * 회원가입 처리
	 */
	@RequestMapping(value="/join.do", method=RequestMethod.POST)
	public ModelAndView join(CgvMemberVO vo) {
		ModelAndView mv = new ModelAndView();
		int result = memberService.getInsertResult(vo);
		
		if(result == 1) {
			mv.addObject("join_result", "succ");
			mv.setViewName("/login/login");
		}else {
			//에러페이지로 이동
		}
		
		return mv;
	}
	
	
	/**
	 * 회원가입 화면
	 */
	@RequestMapping(value="/join.do", method=RequestMethod.GET)
	public String join() {
		return "/join/join";
	}

}






