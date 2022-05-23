package com.web.f5.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.f5.vo.ReviewVO;

public class ReviewDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private String namespace = "mapper.review";

	public ArrayList<ReviewVO> select(int startCount,int endCount) {
		Map<String,Integer> param = new HashMap<String, Integer>();
		param.put("Start", startCount);
		param.put("End", endCount);
		List<ReviewVO> list= sqlSession.selectList(namespace+".selectlist",param);
		return (ArrayList<ReviewVO>)list;
	}
	
	public int insert(ReviewVO vo) {
		return sqlSession.insert(namespace+".insert",vo);
	}
}
