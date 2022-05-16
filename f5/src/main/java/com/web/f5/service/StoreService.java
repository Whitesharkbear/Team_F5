package com.web.f5.service;

import java.util.ArrayList;

import com.web.f5.vo.StoreVO;

public interface StoreService {
	public int insertResult(StoreVO vo);
	public ArrayList<StoreVO> select(int startCount,int endCount);
	public int totalCountResult();
	public StoreVO selectResult(String Store_idx);
	
}
