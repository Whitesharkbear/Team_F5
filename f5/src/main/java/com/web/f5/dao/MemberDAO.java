package com.web.f5.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.f5.vo.AdminMemberVO;
import com.web.f5.vo.MemberVO;

public class MemberDAO{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "mapper.member";
	
	public int select(MemberVO vo) {
		int result =sqlSession.selectOne(namespace+".loginCheck",vo);
		return result;
}




	public int insert(MemberVO vo) {

		return sqlSession.insert(namespace + ".memberInsert", vo);
	}
	public MemberVO select(String memberId) {
		return sqlSession.selectOne(namespace+".select",memberId);
	}

	

	

	
}