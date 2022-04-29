package com.web.f5.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminMemberController {

	@RequestMapping ( value = "/admin/member_list.do", method = RequestMethod.GET )
	public String admin_member_list() {
		
		return "admin/member/member_list";
	}
	
	@RequestMapping ( value = "/admin/member_content.do", method = RequestMethod.GET )
	public String admin_member_content() {
		
		return "admin/member/member_content";
	}
	
	@RequestMapping ( value = "/admin/member_insert.do", method = RequestMethod.GET )
	public String admin_member_insert() {
		
		return "admin/member/member_insert";
	}
	
	@RequestMapping ( value = "/admin/member_update.do", method = RequestMethod.GET )
	public String admin_member_update() {
		
		return "admin/member/member_update";
	}
	
	@RequestMapping ( value = "/admin/member_delete.do", method = RequestMethod.GET )
	public String admin_member_delete() {
		
		return "redirect:/admin/member/member_list";
	}
	
	@RequestMapping ( value = "/admin/ceo_member_list.do", method = RequestMethod.GET )
	public String admin_ceo_member_list() {
		
		return "admin/member/ceo_member_list";
	}
	
	@RequestMapping ( value = "/admin/ceo_member_content.do", method = RequestMethod.GET )
	public String admin_ceo_member_content() {
		
		return "admin/member_ceo_member_content";
	}
	
	@RequestMapping ( value = "/admin/ceo_member_insert.do", method = RequestMethod.GET )
	public String admin_ceo_member_insert() {
		
		return "admin/member/ceo_member_insert";
	}
	
	@RequestMapping ( value = "/admin/ceo_member_update.do", method = RequestMethod.GET )
	public String admin_ceo_member_update() {
		
		return "admin/member/ceo_member_update";
	}
	
	@RequestMapping ( value = "/admin/ceo_member_delete.do", method = RequestMethod.GET )
	public String admin_ceo_member_delete() {
		
		return "redirect:/admin/ceo_member_list.do";
	}
}
