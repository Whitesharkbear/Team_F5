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
public class MypageController {
	
	@Autowired
	private MemberServiceImpl memberService;
	
	// 회원탈퇴
	@ResponseBody
	@RequestMapping(value="/join_status.do", method=RequestMethod.GET)
	public String join_status(String id, String status) {

		//CgvMemberDAO dao = new CgvMemberDAO();
		int result = memberService.getStatusUpdate(id, status);
		
		
		return String.valueOf(result);
	}
	
	
	// 마이페이지 정보
	@RequestMapping(value="/mypage.do", method=RequestMethod.GET)
	public ModelAndView mypage() {
		//test,1234 라는 계정으로 테스트
		String id = "test";
		ModelAndView mv = new ModelAndView();
		//CgvMemberDAO dao = new CgvMemberDAO();
		CgvMemberVO vo = (CgvMemberVO)memberService.getContent(id);

		mv.addObject("vo", vo);
		mv.setViewName("/mypage/mypage");
		
		return mv;
	}
	
}
