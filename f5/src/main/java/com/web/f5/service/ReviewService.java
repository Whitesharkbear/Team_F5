package com.web.f5.service;

import java.util.ArrayList;

import com.web.f5.vo.ReviewVO;

public interface ReviewService {
	public ArrayList<ReviewVO> selectListResult(int startCount, int endCount);
	public int insertResult(ReviewVO vo);
}
