package com.web.f5.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminBoardController {

	@RequestMapping ( value = "/admin/board_list.do", method = RequestMethod.GET )
	public String admin_board_list() {
		
		return "admin/board/board_list";
	}
	
	@RequestMapping ( value = "/admin/board_content.do", method = RequestMethod.GET )
	public String admin_board_content() {
		
		return "admin/board/board_content";
	}
	
	@RequestMapping ( value = "/admin/board_write.do", method = RequestMethod.GET )
	public String admin_board_write() {
		
		return "admin/board/board_write";
	}
	
	@RequestMapping ( value = "/admin/board_update.do", method = RequestMethod.GET )
	public String admin_board_update() {
		
		return "admin/board/board_update";
	}
	
	@RequestMapping ( value = "/admin/board_delete.do", method = RequestMethod.GET )
	public String admin_board_delete() {
		
		return "redirect:/admin/board_list.do";
	}
}
