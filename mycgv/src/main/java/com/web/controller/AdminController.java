package com.web.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.service.FileServiceImpl;
import com.web.service.MemberServiceImpl;
import com.web.service.NoticeServiceImpl;
import com.web.service.PageServiceImpl;
import com.web.vo.CgvMemberVO;
import com.web.vo.CgvNoticeVO;

@Controller
public class AdminController {
	
	//@Resource(name="memberDao")
	@Autowired
	private NoticeServiceImpl noticeService;
	
	@Autowired
	private MemberServiceImpl memberService;
	
	@Autowired
	private PageServiceImpl pageService;
	
	@Autowired
	private FileServiceImpl fileService;
	
	// 관리자 공지 수정처리
	@RequestMapping(value="/admin/notice_update.do", method=RequestMethod.POST)
	public ModelAndView admin_notice_notice_update(CgvNoticeVO vo, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		String oldFile = vo.getNsfile();
		
		vo = fileService.fileCheck(vo);
		
		
		int result = noticeService.getUpdateResult(vo);
		
		if(result == 1) {
			fileService.fileSave(vo, request, oldFile);
			mv.setViewName("redirect:/admin/notice_list.do");
			
			
		} else {
			// 에러페이지
		}
		
		return mv;
	}
	
	
	// 관리자 공지 수정
	@RequestMapping(value="/admin/notice_update.do", method=RequestMethod.GET)
	public ModelAndView admin_notice_update(String nid, String rno) {
		ModelAndView mv = new ModelAndView();
		//CgvNoticeDAO dao = new CgvNoticeDAO();
		CgvNoticeVO vo = noticeService.getContent(nid);
		
		mv.addObject("vo", vo);
		mv.addObject("rno", rno);
		mv.setViewName("/admin/notice/notice_update");
		
		return mv;
	}
	
	// 관리자 공지 삭제처리
		@RequestMapping(value="/admin/notice_delete.do", method=RequestMethod.POST)
		public ModelAndView admin_notice_delete(CgvNoticeVO vo, HttpServletRequest requst) throws Exception {
			ModelAndView mv = new ModelAndView();
			//CgvNoticeDAO dao = new CgvNoticeDAO();
			String nsfile = noticeService.getFilename(vo.getNid());
			int result = noticeService.getDeleteResult(vo.getNid());
			System.out.println("nsfile--->" + nsfile);
			
			if(result == 1) {
				// 파일이 있는 경우 upload폴더에서 파일을 삭제
				String path = requst.getSession().getServletContext().getRealPath("/");
				path += "resources\\upload\\";
				File file = new File(path + nsfile);
				if(file.exists()) {
					file.delete();
				}
				
				mv.setViewName("redirect:/admin/notice_list.do");
			}
			
			return mv;
		}
	
	
	// 관리자 공지 리스트 삭제
	@RequestMapping(value="/admin/notice_delete.do", method=RequestMethod.GET)
	public ModelAndView admin_notice_delete(String nid, String rno) {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("nid", nid);
		mv.addObject("rno", rno);
		mv.setViewName("/admin/notice/notice_delete");
		
		return mv;
	}
	
	
	// 관리자 공지 리스트 쓰기처리
	@RequestMapping(value="/admin/notice_write.do", method=RequestMethod.POST)
	public ModelAndView admin_notice_write(CgvNoticeVO vo, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		//CgvNoticeDAO dao = new CgvNoticeDAO();
		
		vo = fileService.fileCheck(vo);
		
		int result = noticeService.getInsertResult(vo);
		
		if(result == 1) {
			fileService.fileSave(vo, request);			
			mv.setViewName("redirect:/admin/notice_list.do");
		} else {
			// 에러페이지
		}
		
		
		return mv;
	}
	
	// 관리자 공지 리스트 쓰기
	@RequestMapping(value="/admin/notice_write.do", method=RequestMethod.GET)
	public String admin_notice_write() {
		return "/admin/notice/notice_write";
	}
	
	// 관리자 공지 리스트 상세
	@RequestMapping(value="/admin/notice_content.do", method=RequestMethod.GET)
	public ModelAndView admin_notice_content(String nid, String rno) {
		ModelAndView mv = new ModelAndView();
		//CgvNoticeDAO dao = new CgvNoticeDAO();
		//dao.updateHits(nid);
		CgvNoticeVO vo = noticeService.getContent(nid);
		
		mv.addObject("vo", vo);
		mv.addObject("rno", rno);
		mv.setViewName("/admin/notice/notice_content");
		
		return mv;
	}
	
	// 관리자 공지 리스트
	@RequestMapping(value="/admin/notice_list.do", method=RequestMethod.GET)
	public ModelAndView admin_notice_list(String rpage) {
		ModelAndView mv = new ModelAndView();
		//CgvNoticeDAO dao = new CgvNoticeDAO();
		
		Map<String, String> param = pageService.getPageResult(rpage, "notice", noticeService);
		int startCount = Integer.parseInt(param.get("start"));
		int endCount = Integer.parseInt(param.get("end"));
		
		/*
		//페이징 처리 - startCount, endCount 구하기
		int startCount = 0;
		int endCount = 0;
		int pageSize = 3;	//한페이지당 게시물 수
		int reqPage = 1;	//요청페이지	
		int pageCount = 1;	//전체 페이지 수
		int dbCount = noticeService.getListCount();	//DB에서 가져온 전체 행수
		
		//총 페이지 수 계산
		if(dbCount % pageSize == 0){
			pageCount = dbCount/pageSize;
		}else{
			pageCount = dbCount/pageSize+1;
		}
		
		//요청 페이지 계산
		if(rpage != null){
			reqPage = Integer.parseInt(rpage);
			startCount = (reqPage-1) * pageSize+1;
			endCount = reqPage *pageSize;
		}else{
			startCount = 1;
			endCount = 3;
		}
		*/
		
		List<Object> olist = noticeService.getListResult(startCount, endCount);
		// list 형변환 --> ArrayList<CgvMemberVO>
		ArrayList<CgvNoticeVO> list = new ArrayList<CgvNoticeVO>();
		for(Object obj : olist) {
			//CgvMemberVO vo = (CgvMemberVO)obj;
			list.add((CgvNoticeVO)obj);
		}
		
		
		mv.addObject("list", list);
		mv.addObject("dbCount", Integer.parseInt(param.get("dbCount")));
		mv.addObject("pageSize", Integer.parseInt(param.get("pageSize")));
		mv.addObject("reqPage", Integer.parseInt(param.get("reqPage")));
		
		mv.setViewName("admin/notice/notice_list");
		
		return mv;
	}
	
	// 관리자 멤버 상세
	@RequestMapping(value="/admin/member_content.do", method=RequestMethod.GET)
	public ModelAndView admin_member_content(String id, String rno) {
		ModelAndView mv = new ModelAndView();
		//CgvMemberDAO dao = new CgvMemberDAO();
		CgvMemberVO vo = (CgvMemberVO)memberService.getContent(id);
		
		mv.addObject("vo", vo);
		mv.addObject("rno", rno);
		mv.setViewName("/admin/member/member_content");
		
		return mv;
	}
	
	// 관리자 멤버 리스트
	@RequestMapping(value="/admin/member_list.do", method=RequestMethod.GET)
	public ModelAndView admin_member_list(String rpage) {
		ModelAndView mv = new ModelAndView();
		//CgvMemberDAO dao = new CgvMemberDAO();
		
		Map<String, String> param = pageService.getPageResult(rpage, "member", memberService);
		int startCount = Integer.parseInt(param.get("start"));
		int endCount = Integer.parseInt(param.get("end"));
		
		
		//ArrayList<CgvMemberVO> list = memberService.getListResult(startCount, endCount);
		ArrayList<CgvMemberVO> list = new ArrayList<CgvMemberVO>();
		List<Object> olist = memberService.getListResult(startCount, endCount);
		for(Object obj : olist) {
			list.add((CgvMemberVO)obj);
		}
		
		
		mv.addObject("list", list);
		mv.addObject("dbCount", Integer.parseInt(param.get("dbCount")));
		mv.addObject("pageSize", Integer.parseInt(param.get("pageSize")));
		mv.addObject("reqPage", Integer.parseInt(param.get("reqPage")));
		
		mv.setViewName("/admin/member/member_list");
		
		return mv;
	}
	
	// 관리자 페이지
	@RequestMapping(value="/admin.do", method=RequestMethod.GET)
	public String admin() {
		return "/admin/admin";
	}
}







