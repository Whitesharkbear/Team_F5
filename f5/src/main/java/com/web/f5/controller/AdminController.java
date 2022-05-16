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
import org.springframework.web.servlet.ModelAndView;

import com.web.f5.service.AdminBoardService;
import com.web.f5.service.AdminMemberService;
import com.web.f5.vo.AdminBoardVO;
import com.web.f5.vo.AdminMemberVO;

@Controller
public class AdminController {

	@Autowired
	private AdminBoardService adminBoardService;
	
	@Autowired
	private AdminMemberService adminMemberService;
	
	@RequestMapping ( value = "admin/admin.do", method = RequestMethod.GET )
	public ModelAndView admin(String rpage) {
		
		String todayCnt = "0";
		String totalCnt = "0";
		
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
		List<AdminBoardVO> boardList = adminBoardService.getLimitList();
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		
		int mberTotalCnt = adminMemberService.getmberTotalCnt();
		int mberTodayCnt = adminMemberService.getmberTodayCnt();
		
		totalCnt = formatter.format(mberTotalCnt);
		todayCnt = formatter.format(mberTodayCnt);
		
		
		result.put("totalCnt", totalCnt);
		result.put("todayCnt", todayCnt);
		result.put("memberList", memberList);
		result.put("boardList", boardList);
		
		return new ModelAndView("admin/dashboard", "result", result);
	}
}
