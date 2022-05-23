package com.web.service;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.web.vo.CgvBoardVO;
import com.web.vo.CgvNoticeVO;

public class FileServiceImpl {
	
	
	// 파일 체크 후 bsfile 생성 ---> VO 리턴
	public CgvBoardVO fileCheck(CgvBoardVO vo) {
		
		UUID uuid = UUID.randomUUID();
		
		if(vo != null) {
			if(!vo.getFile1().getOriginalFilename().equals("")) { // 파일이 존재하는 경우
				
				vo.setBfile(vo.getFile1().getOriginalFilename());
				vo.setBsfile(uuid + "_" + vo.getFile1().getOriginalFilename());
				
			}
		} 
		
		return vo;
	}
	// 파일 체크 후 nsfile 생성 ---> VO 리턴
	public CgvNoticeVO fileCheck(CgvNoticeVO vo) {
		
		UUID uuid = UUID.randomUUID();
		
		if(vo != null) {
			if(!vo.getFile1().getOriginalFilename().equals("")) { // 파일이 존재하는 경우
				
				vo.setNfile(vo.getFile1().getOriginalFilename());
				vo.setNsfile(uuid + "_" + vo.getFile1().getOriginalFilename());
				
			}
		} 
		
		return vo;
	}
	
	// board 파일저장
	public void fileSave(CgvBoardVO vo, HttpServletRequest request) throws Exception {
		
		if(!vo.getFile1().getOriginalFilename().equals("")) {
		
			// 파일저장 위치 확인
			String root_path = request.getSession().getServletContext().getRealPath("/");
			root_path += "resources\\upload\\";
			
			
			// 파일저장
			File file = new File(root_path + vo.getBsfile());
			vo.getFile1().transferTo(file);
		}
	}
	
	// board 파일수정
	public void fileSave(CgvBoardVO vo, HttpServletRequest request, String fname) throws Exception {
		
		if(!vo.getFile1().getOriginalFilename().equals("")) {
			// 파일저장 위치 확인
			String root_path = request.getSession().getServletContext().getRealPath("/");
			root_path += "resources\\upload\\";
			
			
			// 파일저장
			File file = new File(root_path + vo.getBsfile());
			vo.getFile1().transferTo(file);
			
			// 기존 파일이 존재하는 경우 삭제처리
			File ofile = new File(root_path + fname);
			if(ofile.exists()) {
				ofile.delete();
			}
		}
	}
	
	// notice 파일저장
	public void fileSave(CgvNoticeVO vo, HttpServletRequest request) throws Exception {
		
		if(!vo.getFile1().getOriginalFilename().equals("")) {
			// 파일저장 위치 확인
			String root_path = request.getSession().getServletContext().getRealPath("/");
			root_path += "resources\\upload\\";
			
			
			// 파일저장
			File file = new File(root_path + vo.getNsfile());
			vo.getFile1().transferTo(file);
		}
	}
	
	// notice 파일수정
	public void fileSave(CgvNoticeVO vo, HttpServletRequest request, String fname) throws Exception {
		
		if(!vo.getFile1().getOriginalFilename().equals("")) {
			// 파일저장 위치 확인
			String root_path = request.getSession().getServletContext().getRealPath("/");
			root_path += "resources\\upload\\";
			
			
			// 파일저장
			File file = new File(root_path + vo.getNsfile());
			vo.getFile1().transferTo(file);
			
			// 기존 파일이 존재하는 경우 삭제처리
			File ofile = new File(root_path + fname);
			if(ofile.exists()) {
				ofile.delete();
			}
		}
	}
}















