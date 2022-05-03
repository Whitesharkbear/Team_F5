package com.web.f5.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminNoticeController {

	@RequestMapping ( value = "/admin/notice_list.do", method = RequestMethod.GET )
	public String admin_notice_list() {
		
		return "admin/notice/notice_list";
	}
	
	@RequestMapping ( value = "/admin/notice_content.do", method = RequestMethod.GET )
	public String admin_notice_content() {
		
		return "admin/notice/notice_content";
	}
	
	@RequestMapping ( value = "/admin/notice_write.do", method = RequestMethod.GET )
	public String admin_notice_write() {
		
		return "admin/notice/notice_write";
	}
	
	@RequestMapping ( value = "/admin/notice_update.do", method = RequestMethod.GET )
	public String admin_notice_update() {
		
		return "admin/notice/notice_update";
	}
	
	@RequestMapping ( value = "/admin/notice_delete.do", method = RequestMethod.GET )
	public String admin_notice_delete() {
		
		return "admin/notice/notice_delete";
	}
}
