package com.web.f5.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class PageServiceImpl {

	@Autowired
	private AdminMemberServiceImpl adminMemberService;
	
	@Autowired
	private AdminNoticeServiceImpl adminNoticeService;
	
	@Autowired
	private AdminBoardServiceImpl adminBoardService;
	
	@Autowired
	private AdminFaqServiceImpl adminFaqService;
	
	public Map<String, String> getPageResult(String rpage, String serviceName, ObjService service) {
		
		Map<String, String> param = new HashMap<String, String>();
		
		int startCount = 0;
		int endCount = 0;
		int pageSize = 10;
		int reqPage = 1;
		int pageCount = 1;
		int dbCount = 0;
		
		if ( serviceName.equals("member") ) {
			
			adminMemberService = (AdminMemberServiceImpl) service;
			dbCount = adminMemberService.getListCount();
		} else if ( serviceName.equals("notice") ) {
			
			adminNoticeService = (AdminNoticeServiceImpl) service;
			dbCount = adminNoticeService.getListCount();
		} else if ( serviceName.equals("board") ) {
			
			adminBoardService = (AdminBoardServiceImpl) service;
			dbCount = adminBoardService.getListCount();
		} else if ( serviceName.equals("faq") ) {
			
			adminFaqService = (AdminFaqServiceImpl) service;
			dbCount = adminFaqService.getListCount();
		}
		
		if ( dbCount % pageSize == 0 ) {
			
			pageCount = dbCount / pageSize;
		} else {
			
			pageCount = dbCount / pageSize + 1;
		}
		
		if ( rpage != null ) {
			
			reqPage = Integer.parseInt(rpage);
			startCount = ( reqPage - 1 ) * pageSize + 1;
			endCount = reqPage * pageSize;
		} else {
			
			startCount = 1;
			endCount = pageSize;
		}
		
		param.put("start", String.valueOf(startCount));
		param.put("end", String.valueOf(endCount));
		param.put("dbCount", String.valueOf(dbCount));
		param.put("pageSize", String.valueOf(pageSize));
		param.put("reqPage", String.valueOf(reqPage));
		
		return param;
	}
	
	public Map<String, String> getSearchResult(String search, String rpage, String serviceName, ObjService service) {
		
		Map<String, String> param = new HashMap<String, String>();
		
		int startCount = 0;
		int endCount = 0;
		int pageSize = 10;
		int reqPage = 1;
		int pageCount = 1;
		int dbCount = 0;
		
		if ( serviceName.equals("member") ) {
			
			adminMemberService = (AdminMemberServiceImpl) service;
			dbCount = adminMemberService.getSearchCount(search);
		}
		
		if ( dbCount % pageSize == 0 ) {
			
			pageCount = dbCount / pageSize;
		} else {
			
			pageCount = dbCount / pageSize + 1;
		}
		
		if ( rpage != null ) {
			
			reqPage = Integer.parseInt(rpage);
			startCount = ( reqPage - 1 ) * pageSize + 1;
			endCount = reqPage * pageSize;
		} else {
			
			startCount = 1;
			endCount = pageSize;
		}
		
		param.put("start", String.valueOf(startCount));
		param.put("end", String.valueOf(endCount));
		param.put("dbCount", String.valueOf(dbCount));
		param.put("pageSize", String.valueOf(pageSize));
		param.put("reqPage", String.valueOf(reqPage));
		
		return param;
	}
}
