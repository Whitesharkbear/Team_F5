package com.web.f5.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.f5.dao.StoreDAO;
import com.web.f5.vo.StoreVO;

public class StoreServiceImpl implements StoreService{
	
	@Autowired
	private StoreDAO storeDao;
	
	@Override
	public int insertResult(StoreVO vo) {
		return storeDao.insert(vo);
	}
	public ArrayList<StoreVO> select(int startCount,int endCount){
		return storeDao.select(startCount, endCount);
	}
	@Override
	public int totalCountResult() {
		return storeDao.execTotalCount();
	}
	@Override
	public StoreVO selectResult(String Store_idx) {
		return storeDao.select(Store_idx);
	}
	@Override
	public StoreVO getmCountResult(String storeIdx) {
		// TODO Auto-generated method stub
		return storeDao.getMaxCount(storeIdx);
	}
}
