package com.web.f5.controller;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.web.f5.service.AdminBoardService;
import com.web.f5.service.AdminMemberService;
import com.web.f5.service.AdminQuestionService;
import com.web.f5.vo.AdminBoardVO;
import com.web.f5.vo.AdminMemberVO;
import com.web.f5.vo.AdminQuestionVO;

@Controller
public class AdminController {

	@Autowired
	private AdminMemberService adminMemberService;
	
	@Autowired
	private AdminQuestionService adminQuestionService;
	
	@RequestMapping ( value = "admin/admin.do", method = RequestMethod.GET )
	public ModelAndView admin(String rpage) {
		
		String todayCnt = "0";
		String totalCnt = "0";
		String questionTotalCnt = "0";
		String questionTodayCnt = "0";
		String CEOTotalCnt = "0";
		String CEORequestCnt = "0";
		
		// 난수 처리
		Random rnd =new Random();
		StringBuffer buf =new StringBuffer();
		
		for ( int i = 0; i < 10; i++ ) {
			
			if ( rnd.nextBoolean() ) {
				
				buf.append( (char)( (int)( rnd.nextInt(26) ) + 97 ) );
			}else{
				buf.append( ( rnd.nextInt(5) ) ); 
			}
		}
		
		System.out.println("난수 --->" + buf);
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<AdminMemberVO> memberList = adminMemberService.getLimitList();
		List<AdminQuestionVO> questionList = adminQuestionService.getLimitList();
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		
		int mberTotalCnt = adminMemberService.getmberTotalCnt();
		int mberTodayCnt = adminMemberService.getmberTodayCnt();
		int questionTotal = adminQuestionService.getTotalCnt();
		int questionToday = adminQuestionService.getTodayCnt();
		int CEOTotal = adminMemberService.getCEOTotal();
		int CEORequest = adminMemberService.getCEORequest();
		
		totalCnt = formatter.format(mberTotalCnt);
		todayCnt = formatter.format(mberTodayCnt);
		questionTotalCnt = formatter.format(questionTotal);
		questionTodayCnt = formatter.format(questionToday);
		CEOTotalCnt = formatter.format(CEOTotal);
		CEORequestCnt = formatter.format(CEORequest);
		
		result.put("CEOTotalCnt", CEOTotalCnt);
		result.put("CEORequestCnt", CEORequestCnt);
		result.put("questionTotalCnt", questionTotalCnt);
		result.put("questionTodayCnt", questionTodayCnt);
		result.put("totalCnt", totalCnt);
		result.put("todayCnt", todayCnt);
		result.put("memberList", memberList);
		result.put("questionList", questionList);
		
		return new ModelAndView("admin/dashboard", "result", result);
	}
	
	@ResponseBody
	@RequestMapping ( value = "/admin/member_black_insert.do", method = RequestMethod.GET )
	public String member_black_insert(String id) {
		
		String msg = "";
		
		int result = adminMemberService.getBlackInsert(id);
		
		if ( result == 1 ) {
			
			msg = "success";
		} else {
			
			msg = "fail";
		}
		
		return msg;
	}
	
	@ResponseBody
	@RequestMapping ( value = "/admin/member_black_out.do", method = RequestMethod.GET )
	public String member_black_out(String id) {
		
		String msg = "";
		
		int result = adminMemberService.getBlackOut(id);
		
		if ( result == 1 ) {
			
			msg = "success";
		} else {
			
			msg = "fail";
		}
		
		return msg;
	}
}
