package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.dao.CgvProductDAO;
import com.web.vo.CgvProductVO;

public class ProductServiceImpl extends ObjectServiceAdapter{

	@Autowired
	private CgvProductDAO productDao;
	
	@Override
	public Object getContent(String pid){
		return productDao.select(pid);
	}
	
	@Override
	public List<Object> getListResult(int startCount, int endCount){
		return productDao.select(startCount, endCount);
	}
	
	@Override
	public int getInsertResult(Object obj) {		
		return productDao.insert(obj);
	}
}
