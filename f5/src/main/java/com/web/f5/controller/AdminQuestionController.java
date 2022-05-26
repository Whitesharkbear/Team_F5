package com.web.f5.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.web.f5.service.AdminQuestionService;
import com.web.f5.service.PageServiceImpl;
import com.web.f5.vo.AdminQuestionVO;

@Controller
public class AdminQuestionController {
	
	@Autowired
	private AdminQuestionService adminQuestionService;
	
	@Autowired
	private PageServiceImpl pageService;
	
	@RequestMapping ( value = "admin/question_list.do", method = RequestMethod.GET )
	public ModelAndView admin_question_list(String rpage, String search, String search_type, String proceed) {
		
		ModelAndView mv = new ModelAndView();
			
		Map<String, String> param = pageService.getPageResult(rpage, "admin_Question", adminQuestionService);
			
			int startCount = Integer.parseInt( param.get("start") ); 
			int endCount = Integer.parseInt( param.get("end") );
			
		List<Object> olist = adminQuestionService.getListResult(startCount, endCount);
		
		ArrayList<AdminQuestionVO> list = new ArrayList<AdminQuestionVO>();
		
		for ( Object obj : olist ) {
			
			list.add( (AdminQuestionVO) obj );
		}
		
		mv.addObject("list", list);
		mv.addObject("search", search);
		mv.addObject("search_type", search_type);
		mv.addObject("proceed", proceed);
		mv.addObject("dbCount", Integer.parseInt( param.get("dbCount") ));
		mv.addObject("pageSize", Integer.parseInt( param.get("pageSize") ));
		mv.addObject("reqPage", Integer.parseInt( param.get("reqPage") ));
		
		mv.setViewName("admin/question/question_list");
		
		return mv;
	}
	
	@ResponseBody
	@RequestMapping ( value = "admin/question_search_list.do", method = RequestMethod.GET )
	public String admin_question_search_list(String rpage, String search, String search_type) {
		
		Map<String, String> param = pageService.getSearchResult(search_type, search, rpage, "admin_Question_search", adminQuestionService);
		
		int startCount = Integer.parseInt( param.get("start") );
		int endCount = Integer.parseInt( param.get("end") );
		
		ArrayList<AdminQuestionVO> list = adminQuestionService.getSearchJSONResult(startCount, endCount, search, search_type);
		
		JsonObject jdata = new JsonObject();
		JsonArray jlist = new JsonArray();
		Gson gson = new Gson();
		
		for ( AdminQuestionVO vo : list ) {
			
			JsonObject obj = new JsonObject();
			
			obj.addProperty("rno", vo.getRno());
			obj.addProperty("questionIdx", vo.getQuestionIdx());
			obj.addProperty("memberId", vo.getMemberId());
			obj.addProperty("questionDate", vo.getQuestionDate());
			obj.addProperty("questionTitle", vo.getQuestionTitle());
			obj.addProperty("questionContent", vo.getQuestionContent());
			obj.addProperty("questionProceed", vo.getQuestionProceed());
			
			jlist.add(obj);
		}
		
		jdata.add("jlist", jlist);
		
		return gson.toJson(jdata);
	}
	
	@ResponseBody
	@RequestMapping ( value = "admin/question_search_proceed.do", method = RequestMethod.GET )
	public String admin_question_search_proceed(String proceed, String rpage) {
		
		Map<String, String> param = pageService.getProceedResult(rpage, proceed, "question_proceed_search", adminQuestionService);
		
		int startCount = Integer.parseInt( param.get("start") );
		int endCount = Integer.parseInt( param.get("end") );
		
		ArrayList<AdminQuestionVO> list = adminQuestionService.getQuestionProceed(startCount, endCount, proceed);
		
		JsonObject jdata = new JsonObject();
		JsonArray jlist = new JsonArray();
		Gson gson = new Gson();
		
		for ( AdminQuestionVO vo : list ) {
			
			JsonObject obj = new JsonObject();
			
			obj.addProperty("rno", vo.getRno());
			obj.addProperty("questionIdx", vo.getQuestionIdx());
			obj.addProperty("memberId", vo.getMemberId());
			obj.addProperty("questionDate", vo.getQuestionDate());
			obj.addProperty("questionTitle", vo.getQuestionTitle());
			obj.addProperty("questionContent", vo.getQuestionContent());
			obj.addProperty("questionProceed", vo.getQuestionProceed());
			
			jlist.add(obj);
		}
		
		jdata.add("jlist", jlist);
		
		return gson.toJson(jdata);
	}
	
	@RequestMapping ( value = "admin/question_content.do", method = RequestMethod.GET )
	public ModelAndView admin_question_content(String idx, String rno) {
		
		ModelAndView mv = new ModelAndView();
		
		AdminQuestionVO vo = (AdminQuestionVO) adminQuestionService.getContent(idx);
		
		mv.addObject("vo", vo);
		mv.addObject("rno", rno);
		
		mv.setViewName("admin/question/question_content");
		
		return mv;
	}
	
	@RequestMapping ( value = "admin/question_write.do", method = RequestMethod.GET )
	public ModelAndView admin_question_write() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("admin/question/question_write");
		
		return mv;
	}
	
	@RequestMapping ( value = "admin/question_write.do", method = RequestMethod.POST )
	public ModelAndView admin_question_write(AdminQuestionVO vo) {
		
		ModelAndView mv = new ModelAndView();
		
		vo.setQuestionContent(vo.getQuestionContent().replace("\r\n", "<br>"));
		int result = adminQuestionService.getInsertResult(vo);
		
		if ( result == 1 ) {
			
			mv.setViewName("redirect:/admin/question_list.do");
		} else {
			
			// errorPage;
		}
		
		return mv;
	}

	@RequestMapping ( value = "admin/question_receive.do", method = RequestMethod.GET )
	public ModelAndView admin_question_receive(String idx, String rno) {
		
		ModelAndView mv = new ModelAndView();
		AdminQuestionVO vo = null;
		int result = adminQuestionService.receiveBefore(idx);
		
		if ( result == 1 ) {
			
			vo = (AdminQuestionVO) adminQuestionService.getContent(idx);
		} else {
			
			//errorPage
		}
		
		mv.addObject("vo", vo);
		mv.addObject("rno", rno);
		
		mv.setViewName("admin/question/question_receive");
		
		return mv;
	}
	
	@RequestMapping ( value = "admin/question_receive.do", method = RequestMethod.POST )
	public ModelAndView admin_question_receive(AdminQuestionVO vo) {
		
		ModelAndView mv = new ModelAndView();
		
		int result = adminQuestionService.getUpdateResult(vo);
		
		if ( result == 1 ) {
			
			mv.setViewName("redirect:/admin/question_list.do");
		} else {
			
			// errorPage
		}
		
		return mv;
	}
}
