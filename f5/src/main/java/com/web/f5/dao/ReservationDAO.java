package com.web.f5.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.web.f5.vo.ReservationVO;

public class ReservationDAO {
	private SqlSessionTemplate sqlSession;
	private String namespace = "mapper.reservation";
	
	public int insert(ReservationVO vo) {
		System.out.println(sqlSession.insert(namespace+".insert",vo));
		return sqlSession.insert(namespace+".insert",vo);
	}
}
