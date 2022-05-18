package com.web.f5.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.f5.member.vo.MemberVO;

public class MemberDAO {

	@Autowired 
	private SqlSessionTemplate session;
	private String namespace = "mapper.member";
	
	public int select(MemberVO vo) {
		int result =session.selectOne(namespace+".loginCheck",vo);
		return result;
}
	public int insert(MemberVO vo) {
		return session.insert(namespace+".insert",vo);
	}
	public MemberVO select(String memberId) {
		return session.selectOne(namespace+".select",memberId);
	}
}