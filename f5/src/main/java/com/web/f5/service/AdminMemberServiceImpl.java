package com.web.f5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.f5.dao.AdminMemberDAO;
import com.web.f5.vo.AdminMemberVO;

public class AdminMemberServiceImpl implements AdminMemberService {

	@Autowired
	private AdminMemberDAO adminMemberDAO;
	
	@Override
	public int getInsertResult(Object obj) {
		
		AdminMemberVO vo = (AdminMemberVO) obj;
		
		return adminMemberDAO.insert(vo);
	}
	
	@Override
	public List<Object> getListResult( int startCount, int endCount ){
		return adminMemberDAO.select(startCount, endCount);
	}

	@Override
	public int getListCount() {
		
		return adminMemberDAO.execTotalCount();
	}
	
	public int getSearchCount(String search) {
		
		return adminMemberDAO.searchCount(search);
	}
	
	@Override
	public Object getContent(String id) {
		
		return adminMemberDAO.select(id);
	}
	
	@Override
	public int getUpdateResult(Object obj) {
		
		AdminMemberVO vo = (AdminMemberVO) obj;
		
		return adminMemberDAO.update(vo);
	}
	
	@Override
	public int getDeleteResult(String id) {
		
		return adminMemberDAO.delete(id);
	}

	@Override
	public List<AdminMemberVO> getLimitList() {
		
		return adminMemberDAO.select();
	}
	
	@Override
	public int getmberTotalCnt() {
		
		return adminMemberDAO.mberTotalCnt();
	}
	
	@Override
	public int getmberTodayCnt() {
		
		return adminMemberDAO.mberTodayCnt();
	}

	@Override
	public List<Object> getSearchListResult(int startCount, int endCount, String search) {
		
		return adminMemberDAO.select(startCount, endCount, search);
	}
}
