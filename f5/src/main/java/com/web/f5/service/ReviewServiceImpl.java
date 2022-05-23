package com.web.f5.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.f5.dao.ReviewDAO;
import com.web.f5.vo.ReviewVO;

public class ReviewServiceImpl implements ReviewService{
	
	@Autowired ReviewDAO reviewDao;
	
	@Override
	public ArrayList<ReviewVO> selectListResult(int startCount, int endCount) {
		// TODO Auto-generated method stub
		return reviewDao.select(startCount, endCount);
	}
	@Override
	public int insertResult(ReviewVO vo) {
		// TODO Auto-generated method stub
		return reviewDao.insert(vo);
	}
	@Override
	public int deleteResult(String reviewIdx) {
		// TODO Auto-generated method stub
		return reviewDao.delete(reviewIdx);
	}
	@Override
	public int updateResult(String reviewIdx, String reviewContent) {
		// TODO Auto-generated method stub
		return reviewDao.update(reviewIdx, reviewContent);
	}
}
