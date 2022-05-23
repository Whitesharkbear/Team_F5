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

import com.web.service.BoardServiceImpl;
import com.web.service.FileServiceImpl;
import com.web.service.PageServiceImpl;
import com.web.vo.CgvBoardVO;

@Controller
public class BoardController {
	
	
	@Autowired
	private BoardServiceImpl boardService;
	
	@Autowired
	private PageServiceImpl pageService;
	
	@Autowired
	private FileServiceImpl fileService;
	
	// 게시판 수정처리
	@RequestMapping(value="/board_update.do", method=RequestMethod.POST)
	public ModelAndView board_update(CgvBoardVO vo, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		//CgvBoardDAO dao = new CgvBoardDAO();
		//String bfile, bsfile = "";
		String oldFile = vo.getBsfile();
		
		vo = fileService.fileCheck(vo);
		
		/*
		// 1. vo.getFile1().getOriginalFilename() 값이 널인지 체크
		// 널인 경우 --> 기존의 파일 유지, 널이 아닌 경우 --> 기존파일을 새로운 파일로 업데이트
		if(vo.getFile1().getOriginalFilename().equals("")) {
			UUID uuid = UUID.randomUUID();
			bfile = vo.getFile1().getOriginalFilename();
			bsfile = uuid + "_" + bfile;
			
			vo.setBfile(bfile);
			vo.setBsfile(bsfile);
		} else {
			vo.setBfile("null");
			vo.setBsfile("null");
		}
		*/
		
		int result = boardService.getUpdateResult(vo);
		
		if(result == 1) {
			
			fileService.fileSave(vo, request, oldFile);
			/*
			if(vo.getFile1().getOriginalFilename().equals("")) {	
				// 파일저장 위치 확인
				String path = request.getSession().getServletContext().getRealPath("/");
				path += "resources\\upload\\";
				//System.out.println(root_path);
				
				// 파일저장
				File file = new File(path + bsfile);
				vo.getFile1().transferTo(file);
				
				
				// 기존 파일이 존재하는 경우 삭제처리
				File ofile = new File(path + oldFile);
				if(ofile.exists()) {
					ofile.delete();
				}
				
			}
			*/
			mv.setViewName("redirect:/board_list.do");
		} else {
			// 에러페이지
		}
		
		return mv;
	}
	
	
	// 게시판 수정
	@RequestMapping(value="/board_update.do", method=RequestMethod.GET)
	public ModelAndView board_update(String bid, String rno) {
		ModelAndView mv = new ModelAndView();
		//CgvBoardDAO dao = new CgvBoardDAO();
		CgvBoardVO vo = (CgvBoardVO)boardService.getContent(bid);
		mv.addObject("vo", vo);
		mv.addObject("rno", rno);
		mv.setViewName("/board/board_update");
		
		return mv;
	}
	
	// 게시판 상세
	@RequestMapping(value="/board_content.do", method=RequestMethod.GET)
	public ModelAndView board_content(String bid, String rno) {
		ModelAndView mv = new ModelAndView("board/board_content"); // setviewname과 같음
		//CgvBoardDAO dao = new CgvBoardDAO();
		boardService.getUpdateHits(bid);
		CgvBoardVO vo = (CgvBoardVO)boardService.getContent(bid);
		
		mv.addObject("vo", vo);
		mv.addObject("rno", rno);
		//mv.setViewName("board/board_content");
		
		return mv;
	}
	
	
	// 게시판 삭제처리
	@RequestMapping(value="/board_delete.do", method=RequestMethod.POST)
	public ModelAndView board_delete(CgvBoardVO vo, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		//CgvBoardDAO dao = new CgvBoardDAO();
		
		String bsfile = boardService.getFilename(vo.getBid());	
		int result = boardService.getDeleteResult(vo.getBid());
		
		if(result == 1) {
			if(bsfile != null) {
				String path = request.getSession().getServletContext().getRealPath("/");
				path += "resources\\upload\\";
				File file = new File(path + bsfile);
				if(file.exists()) {
					file.delete();
				}
			}
			mv.setViewName("redirect:/board_list.do");			
		} else {
			// 에러페이지 이동
		}
		
		
		return mv;
	}
	
	
	// 게시판 삭제
	@RequestMapping(value="/board_delete.do", method=RequestMethod.GET)
	public ModelAndView board_delete(String bid, String rno) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("bid", bid);
		mv.addObject("rno", rno);
		mv.setViewName("board/board_delete");
		
		return mv;
	}
	
	// 게시판 쓰기처리
	@RequestMapping(value="/board_write.do", method=RequestMethod.POST)
	public String board_write(CgvBoardVO vo, HttpServletRequest request) throws Exception {
		String result_page = "";
		//String bfile, bsfile = "";
		
		//CgvBoardDAO dao = new CgvBoardDAO();
		
		// 파일업로드 데이터 생성 --> bfile, bsfile
		/*
		if(!vo.getFile1().getOriginalFilename().equals("")) { // 파일이 존재하는 경우
			UUID uuid = UUID.randomUUID();
			bfile = vo.getFile1().getOriginalFilename();
			bsfile = uuid + "_" + vo.getFile1().getOriginalFilename();
			
			vo.setBfile(bfile);
			vo.setBsfile(bsfile);
		}
		*/
			
/*
			int result = dao.insert(vo);
			if(result == 1) {
				
//				System.out.println("bfile---> " + vo.getFile1().getOriginalFilename());
//				System.out.println("bsfile --->" + uuid + "_" + vo.getFile1().getOriginalFilename());
				
				// 파일저장 위치 확인
				String root_path = request.getSession().getServletContext().getRealPath("/");
				root_path += "resources\\upload\\";
				System.out.println(root_path);
				
				// 파일저장
				File file = new File(root_path + bsfile);
				vo.getFile1().transferTo(file);
				
			} 
*/			
			
		
		/*
		 * else { vo.setBfile("null"); vo.setBsfile("null"); }
		 */

		vo = fileService.fileCheck(vo);
		
		
		int result = boardService.getInsertResult(vo);
		
		if(result == 1) {
			fileService.fileSave(vo, request);
			/*
			if(!vo.getFile1().getOriginalFilename().equals("")) {
//				System.out.println("bfile---> " + vo.getFile1().getOriginalFilename());
//				System.out.println("bsfile --->" + uuid + "_" + vo.getFile1().getOriginalFilename());
				
				// 파일저장 위치 확인
				String root_path = request.getSession().getServletContext().getRealPath("/");
				root_path += "resources\\upload\\";
				
				
				// 파일저장
				File file = new File(root_path + bsfile);
				vo.getFile1().transferTo(file);
				
			}
			*/
			
			result_page = "redirect:/board_list.do";
		} else {
			// 에러페이지 호출
		}
		
		return result_page;
	}
	
	
	// 게시판 쓰기
	@RequestMapping(value="/board_write.do", method=RequestMethod.GET)
	public String board_write() {
		return "board/board_write";
	}
	
	
	// 게시판 리스트
	@RequestMapping(value="/board_list.do", method=RequestMethod.GET)
	public ModelAndView board_list(String rpage) {
		ModelAndView mv = new ModelAndView();
		//CgvBoardDAO dao = new CgvBoardDAO();
		
		Map<String, String> param = pageService.getPageResult(rpage, "board", boardService);
		int startCount = Integer.parseInt(param.get("start"));
		int endCount = Integer.parseInt(param.get("end"));
		
		//ArrayList<CgvBoardVO> list = dao.select();  // 전체 리스트를 모두 출력
		List<Object> list = boardService.getListResult(startCount, endCount);
		ArrayList<CgvBoardVO> olist = new ArrayList<CgvBoardVO>();
		for(Object obj : olist) {
			list.add((CgvBoardVO)obj);
		}
		
		mv.addObject("list", list);
		mv.addObject("dbCount", Integer.parseInt(param.get("dbCount")));
		mv.addObject("pageSize", Integer.parseInt(param.get("pageSize")));
		mv.addObject("reqPage", Integer.parseInt(param.get("reqPage")));
		
		mv.setViewName("board/board_list");
		
		
		return mv;
	}
} // controller










