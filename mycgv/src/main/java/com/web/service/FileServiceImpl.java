package com.web.service;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.web.vo.CgvBoardVO;
import com.web.vo.CgvNoticeVO;
import com.web.vo.CgvProductVO;

public class FileServiceImpl {
	/**
	 * 멀티 파일 저장
	 */
	public void multiFileSave(CgvProductVO vo, HttpServletRequest request) throws Exception{
		
		if(vo != null) {
			for(int i=0; i<vo.getFiles().length; i++) {
				CommonsMultipartFile pfile = vo.getFiles()[i]; //files 배열에 저장된 주소번지의 파일반환
			
				if(!pfile.getOriginalFilename().equals("")) {
				
					//파일저장 위치 확인
					String root_path = request.getSession().getServletContext().getRealPath("/");
					root_path += "resources\\upload\\";
					System.out.println(root_path);
					
					//파일저장
					File file = new File(root_path + vo.getPsfiles().get(i));			
					pfile.transferTo(file);
				}
			}
		}	
	}
	
	/**
	 * 멀티파일 체크
	 */
	public CgvProductVO multiFileCheck(CgvProductVO vo) {		
		
		if(vo != null) {
			for(int i=0; i<vo.getFiles().length; i++) {
				UUID uuid = UUID.randomUUID();		
				CommonsMultipartFile file = vo.getFiles()[i]; //files 배열에 저장된 주소번지의 파일반환
				
				if(!file.getOriginalFilename().equals("")) { //파일존재 하는 경우	
					vo.getPfiles().add(file.getOriginalFilename());
					vo.getPsfiles().add(uuid + "_" + file.getOriginalFilename());
				}else {
					vo.getPfiles().add("");
					vo.getPsfiles().add("");
				}
				System.out.println(vo.getPfiles().size());
			}
		}
				
				
		return vo;
	}
	
	
	/**
	 * 파일 체크 후 bsfile 생성 ---> VO 리턴
	 */
	public CgvBoardVO fileCheck(CgvBoardVO vo) {
		
		UUID uuid = UUID.randomUUID();		
		
		if(vo != null) {
			if(!vo.getFile1().getOriginalFilename().equals("")) { //파일존재 하는 경우	
				vo.setBfile(vo.getFile1().getOriginalFilename());
				vo.setBsfile(uuid + "_" + vo.getFile1().getOriginalFilename());
			}
		}
				
		return vo;
	}
	
	
	/**
	 * 파일 체크 후 nsfile 생성 ---> VO 리턴
	 */
	public CgvNoticeVO fileCheck(CgvNoticeVO vo) {
		
		UUID uuid = UUID.randomUUID();		
		
		if(vo != null) {
			if(!vo.getFile1().getOriginalFilename().equals("")) { //파일존재 하는 경우	
				vo.setNfile(vo.getFile1().getOriginalFilename());
				vo.setNsfile(uuid + "_" + vo.getFile1().getOriginalFilename());
			}
		}
				
		return vo;
	}
		
	
	
	/**
	 * 파일 저장
	 */
	public void fileSave(CgvBoardVO vo, HttpServletRequest request) throws Exception{
		
		if(!vo.getFile1().getOriginalFilename().equals("")) {
		
			//파일저장 위치 확인
			String root_path = request.getSession().getServletContext().getRealPath("/");
			root_path += "resources\\upload\\";
			System.out.println(root_path);
			
			//파일저장
			File file = new File(root_path + vo.getBsfile());			
			vo.getFile1().transferTo(file);
		}
			
	}
	
	/**
	 * 파일 저장 - 기존 파일 삭제
	 */
	public void fileSave(CgvBoardVO vo, HttpServletRequest request, String fname) throws Exception{
		
		if(!vo.getFile1().getOriginalFilename().equals("")) {
		
			//파일저장 위치 확인
			String root_path = request.getSession().getServletContext().getRealPath("/");
			root_path += "resources\\upload\\";
			System.out.println(root_path);
			
			//파일저장
			File file = new File(root_path + vo.getBsfile());			
			vo.getFile1().transferTo(file);
			
			//기존 파일이 존재하는 경우 삭제처리
			File ofile = new File(root_path+fname);
			if(ofile.exists()) {
				ofile.delete();
			}
		}
			
	}
	
	/**
	 * 파일 저장
	 */
	public void fileSave(CgvNoticeVO vo, HttpServletRequest request) throws Exception{
		if(!vo.getFile1().getOriginalFilename().equals("")) {			
			//파일저장 위치 확인
			String root_path = request.getSession().getServletContext().getRealPath("/");
			root_path += "resources\\upload\\";
			System.out.println(root_path);
			
			//파일저장
			File file = new File(root_path + vo.getNsfile());			
			vo.getFile1().transferTo(file);
		}
		
	}
	
	public void fileSave(CgvNoticeVO vo, HttpServletRequest request, String fname) throws Exception{
		if(!vo.getFile1().getOriginalFilename().equals("")) {			
			//파일저장 위치 확인
			String root_path = request.getSession().getServletContext().getRealPath("/");
			root_path += "resources\\upload\\";
			System.out.println(root_path);
			
			//파일저장
			File file = new File(root_path + vo.getNsfile());			
			vo.getFile1().transferTo(file);
			
			//기존 파일이 존재하는 경우 삭제처리
			File ofile = new File(root_path+fname);
			if(ofile.exists()) {
				ofile.delete();
			}
		}
		
	}
}


















