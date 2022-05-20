package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.web.service.MemberServiceImpl;
import com.web.vo.CgvMemberVO;

@Controller
public class MypageController {
	
	@Autowired
	private MemberServiceImpl memberService;
	
	/**
	 * 회원탈퇴 신청
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/join_status.do", method=RequestMethod.GET)
	public String join_status(String id, String status) {
		int result = memberService.getStatusUpdate(id, status);
		
		return String.valueOf(result);
	}
	
	
	@RequestMapping(value="/mypage.do", method=RequestMethod.GET)
	public ModelAndView mypage() {
		//test,1234 라는 계정으로 테스트
		/** test 라는 계정의 정보를 가져와서 출력해주세요 **/
		
		ModelAndView mv = new ModelAndView();
		CgvMemberVO vo = (CgvMemberVO)memberService.getContent("hong");
		
		mv.addObject("vo", vo);
		mv.setViewName("/mypage/mypage");		
		
		return mv;
	}
}







