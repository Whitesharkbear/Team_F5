package com.web.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import com.web.service.ProductServiceImpl;
import com.web.vo.CgvMemberVO;
import com.web.vo.CgvNoticeVO;
import com.web.vo.CgvProductVO;

@Controller
public class AdminController {
	
	@Autowired
	private MemberServiceImpl memberService;
	
	@Autowired
	private NoticeServiceImpl noticeService;
	
	@Autowired
	private PageServiceImpl pageService;
	
	@Autowired
	private FileServiceImpl fileService;
	
	@Autowired
	private ProductServiceImpl productService;
	
	

	/** 
	 * 상품 상세정보 **/
	@RequestMapping(value="/admin/product_content.do", method=RequestMethod.GET)
	public ModelAndView admin_product_content(String pid) {
		ModelAndView mv = new ModelAndView();
		CgvProductVO vo = (CgvProductVO)productService.getContent(pid);
		
		mv.addObject("vo", vo);
		mv.setViewName("/admin/product/product_content");
		
		return mv;
	}
	
	/** 
	 * 상품 리스트 **/
	@RequestMapping(value="/admin/product_list.do", method=RequestMethod.GET)
	public ModelAndView admin_product_list(String rpage) {
		ModelAndView mv = new ModelAndView();
		
		Map<String,String> param = pageService.getPageResult(rpage, "notice", noticeService);
		int startCount = Integer.parseInt(param.get("start"));
		int endCount = Integer.parseInt(param.get("end"));
		
		List<Object> olist = productService.getListResult(startCount,endCount);
		//olist 형변환 --> ArrayList<CgvMemberVO>
		ArrayList<CgvProductVO> list = new ArrayList<CgvProductVO>();
		for(Object obj : olist) {
			list.add((CgvProductVO)obj);
		}
		
		mv.addObject("list", list);
		mv.addObject("dbCount", Integer.parseInt(param.get("dbCount")));
		mv.addObject("pageSize", Integer.parseInt(param.get("pageSize")));
		mv.addObject("reqPage", Integer.parseInt(param.get("reqPage")));
		
		mv.setViewName("/admin/product/product_list");
		
		return mv;
	}
	
	
	/**
	 * 상품관리 - 상품등록 처리
	 */
	@RequestMapping(value="/admin/product_insert.do", method=RequestMethod.POST)
	public ModelAndView product_insert(CgvProductVO vo, HttpServletRequest request) 
																		throws Exception{
		ModelAndView mv = new ModelAndView();
	
		vo = fileService.multiFileCheck(vo);
		int result = productService.getInsertResult(vo);
	
		if(result == 1) {
			fileService.multiFileSave(vo, request);
			mv.setViewName("redirect:/admin/product_list.do");
		}else {
			//에러페이지
		}
		
		return mv;
	}
	
	/**
	 * 상품관리 - 상품등록
	 */
	@RequestMapping(value="/admin/product_insert.do", method=RequestMethod.GET)
	public ModelAndView product_insert() {
		ModelAndView mv = new ModelAndView();
	
		mv.setViewName("/admin/product/product_insert");
		
		return mv;
	}
	
	
	/** 
	 * 관리자 공지사항 리스트 **/
	@RequestMapping(value="/admin/notice_list.do", method=RequestMethod.GET)
	public ModelAndView admin_notice_list(String rpage) {
		ModelAndView mv = new ModelAndView();
		
		Map<String,String> param = pageService.getPageResult(rpage, "notice", noticeService);
		int startCount = Integer.parseInt(param.get("start"));
		int endCount = Integer.parseInt(param.get("end"));
		
		List<Object> olist = noticeService.getListResult(startCount,endCount);
		//olist 형변환 --> ArrayList<CgvMemberVO>
		ArrayList<CgvNoticeVO> list = new ArrayList<CgvNoticeVO>();
		for(Object obj : olist) {
			list.add((CgvNoticeVO)obj);
		}
		
		mv.addObject("list", list);
		mv.addObject("dbCount", Integer.parseInt(param.get("dbCount")));
		mv.addObject("pageSize", Integer.parseInt(param.get("pageSize")));
		mv.addObject("reqPage", Integer.parseInt(param.get("reqPage")));
		
		mv.setViewName("/admin/notice/notice_list");
		
		return mv;
	}
		
	
	/** 
	 * 관리자 공지사항 등록 처리 **/
	@RequestMapping(value="/admin/notice_write.do", method=RequestMethod.POST)
	public ModelAndView admin_notice_write(CgvNoticeVO vo, HttpServletRequest request) 
																	throws Exception{
		ModelAndView mv = new ModelAndView();
		
		vo = fileService.fileCheck(vo);
		int result = noticeService.getInsertResult(vo);
		
		if(result == 1) {
			fileService.fileSave(vo, request);
			mv.setViewName("redirect:/admin/notice_list.do");
		}else {
			//에러페이지
		}
		
		return mv;
	}
	
	/** 관리자 공지사항 등록화면 **/
	@RequestMapping(value="/admin/notice_write.do", method=RequestMethod.GET)
	public String admin_notice_write() {
		return "/admin/notice/notice_write";
	}
	
	
	/** 
	 * 관리자 공지사항 상세정보 **/
	@RequestMapping(value="/admin/notice_content.do", method=RequestMethod.GET)
	public ModelAndView admin_notice_content(String nid, String rno) {
		ModelAndView mv = new ModelAndView();
		CgvNoticeVO vo = (CgvNoticeVO)noticeService.getContent(nid);
		
		mv.addObject("vo", vo);
		mv.addObject("rno", rno);
		mv.setViewName("/admin/notice/notice_content");
		
		return mv;
	}
	
	/** 관리자 공지사항 수정처리 **/
	@RequestMapping(value="/admin/notice_update.do", method=RequestMethod.POST)
	public ModelAndView admin_notice_update(CgvNoticeVO vo, HttpServletRequest request) 
															throws Exception{
		ModelAndView mv = new ModelAndView();
		String oldFile = vo.getNsfile();
		vo = fileService.fileCheck(vo);		
		int result = noticeService.getUpdateResult(vo);
		
		if(result ==1) {
			fileService.fileSave(vo, request, oldFile);
			mv.setViewName("redirect:/admin/notice_list.do");			
		}else {
			//에러페이지 호출
		}		
		
		return mv;
	}
	
	
	/** 관리자 공지사항 수정화면 **/
	@RequestMapping(value="/admin/notice_update.do", method=RequestMethod.GET)
	public ModelAndView admin_notice_update(String nid, String rno) {
		ModelAndView mv = new ModelAndView();
		CgvNoticeVO vo = (CgvNoticeVO)noticeService.getContent(nid);
		
		mv.addObject("vo", vo);
		mv.addObject("rno", rno);
		mv.setViewName("/admin/notice/notice_update");
		
		return mv;
	}
	
	
	/** 관리자 공지사항 삭제처리 **/
	@RequestMapping(value="/admin/notice_delete.do", method=RequestMethod.POST)
	public ModelAndView admin_notice_delete(CgvNoticeVO vo, HttpServletRequest request)
															throws Exception{
		ModelAndView mv = new ModelAndView();
		String nsfile = noticeService.getFilename(vo.getNid()); 
		int result = noticeService.getDeleteResult(vo.getNid());
		
		if(result ==1) {
			//파일이 있는경우 upload폴더에서 파일을 삭제
			if(nsfile != null) {
				String path = request.getSession().getServletContext().getRealPath("/");
				path += "resources\\upload\\";
				File file = new File(path+nsfile);
				if(file.exists()) {
					file.delete();
				}
			}
			mv.setViewName("redirect:/admin/notice_list.do");			
		}
				
		return mv;
	}
	
	
	/** 관리자 공지사항 삭제화면 **/
	@RequestMapping(value="/admin/notice_delete.do", method=RequestMethod.GET)
	public ModelAndView admin_notice_delete(String nid, String rno) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("nid", nid);
		mv.addObject("rno", rno);
		mv.setViewName("/admin/notice/notice_delete");
		
		return mv;
	}
	
	
	/** 관리자 회원 상세정보 **/
	@RequestMapping(value="/admin/member_content.do", method=RequestMethod.GET)
	public ModelAndView admin_member_content(String id, String rno) {
		ModelAndView mv = new ModelAndView();
		CgvMemberVO vo = (CgvMemberVO)memberService.getContent(id);
		
		mv.addObject("vo", vo);
		mv.addObject("rno", rno);
		mv.setViewName("/admin/member/member_content");		
		
		return mv;
	}
	

	/** 관리자 회원 리스트 **/
	@RequestMapping(value="/admin/member_list.do", method=RequestMethod.GET)
	public ModelAndView admin_member_list(String rpage) {
		ModelAndView mv = new ModelAndView();
		
		Map<String,String> param = pageService.getPageResult(rpage, "member", memberService);
		int startCount = Integer.parseInt(param.get("start"));		
		int endCount = Integer.parseInt(param.get("end"));		
		
		ArrayList<CgvMemberVO> list = new ArrayList<CgvMemberVO>();
		List<Object> olist = memberService.getListResult(startCount, endCount);
		for(Object obj : olist) {
			list.add((CgvMemberVO)obj);
		}
				
		mv.addObject("list",list);
		mv.addObject("dbCount", Integer.parseInt(param.get("dbCount")));
		mv.addObject("pageSize", Integer.parseInt(param.get("pageSize")));
		mv.addObject("reqPage", Integer.parseInt(param.get("reqPage")));	
		
		mv.setViewName("/admin/member/member_list");		
		
		return mv;
	}
		
	
	/** 관리자 메인 페이지 **/
	@RequestMapping(value="/admin.do", method=RequestMethod.GET)
	public String admin() {
		return "/admin/admin";
	}
}






