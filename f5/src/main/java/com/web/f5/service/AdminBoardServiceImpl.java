package com.web.f5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.f5.dao.AdminBoardDAO;
import com.web.f5.vo.AdminBoardVO;

public class AdminBoardServiceImpl implements AdminBoardService {

	@Autowired
	private AdminBoardDAO adminBoardDAO;
	
	@Override
	public List<Object> getListResult(int startCount, int endCount) {
		
		return adminBoardDAO.select(startCount, endCount);
	}

	@Override
	public int getListCount() {
		
		return adminBoardDAO.execTotalCount();
	}

	@Override
	public Object getContent(String id) {
		
		return adminBoardDAO.select(id);
	}

	@Override
	public int getUpdateResult(Object obj) {
		
		AdminBoardVO vo = (AdminBoardVO) obj;
		
		return adminBoardDAO.update(vo);
	}

	@Override
	public int getDeleteResult(String id) {
		
		return adminBoardDAO.delete(id);
	}

	@Override
	public int getInsertResult(Object obj) {
		
		AdminBoardVO vo = (AdminBoardVO) obj;
		
		return adminBoardDAO.insert(vo);
	}

	@Override
	public List<AdminBoardVO> getLimitList() {
		
		return adminBoardDAO.select();
	}

	@Override
	public int getSearchCount(String search_type, String search) {
		
		return adminBoardDAO.searchCount(search_type, search);
	}
}
