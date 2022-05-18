package com.web.f5.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.f5.vo.ReservationVO;

public class ReservationDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private String namespace = "mapper.reservation";
	
	public int insert(ReservationVO vo) {
		return sqlSession.insert(namespace+".insert",vo);
	}
}
