package com.web.f5.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.f5.dao.AdminQuestionDAO;
import com.web.f5.vo.AdminQuestionVO;

public class AdminQuestionServiceImpl implements AdminQuestionService {

	@Autowired
	private AdminQuestionDAO adminQuestionDAO;
	
	@Override
	public List<Object> getListResult(int startCount, int endCount) {
		
		return adminQuestionDAO.select(startCount, endCount);
	}

	@Override
	public int getListCount() {
		
		return adminQuestionDAO.execTotalCount();
	}

	@Override
	public int getSearchCount(String search_type, String search) {
		System.out.println("serImpl search"+search);
		System.out.println("serImpl search_type"+search_type);
		return adminQuestionDAO.getCountResult(search_type, search);
	}

	public int getProceedCount(String proceed) {
		
		return adminQuestionDAO.getProceedCount(proceed);
	}	
	@Override
	public Object getContent(String idx) {
		
		return adminQuestionDAO.select(idx);
	}

	@Override
	public int getUpdateResult(Object obj) {
		
		AdminQuestionVO vo = (AdminQuestionVO) obj;
		
		return adminQuestionDAO.update(vo);
	}

	@Override
	public int getDeleteResult(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getInsertResult(Object obj) {
		
		AdminQuestionVO vo = (AdminQuestionVO) obj;
		
		return adminQuestionDAO.insert(vo);
	}

	@Override
	public List<Object> getSearchListResult(int startCount, int endCount, String search, String search_type) {
		
		return adminQuestionDAO.select(startCount, endCount, search, search_type);
	}

	@Override
	public int receiveBefore(String idx) {
		
		return adminQuestionDAO.update(idx);
	}

	@Override
	public ArrayList<AdminQuestionVO> getSearchJSONResult(int startCount, int endCount, String search, String search_type) {
		
		return adminQuestionDAO.getSearchJSONResult(startCount, endCount, search, search_type);
	}

	@Override
	public ArrayList<AdminQuestionVO> getQuestionProceed(int startCount, int endCount, String proceed) {
		
		return adminQuestionDAO.getSearchJSONProceed(startCount, endCount, proceed);
	}
}
