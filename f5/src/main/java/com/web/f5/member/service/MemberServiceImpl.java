package com.web.f5.member.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.f5.member.dao.MemberDAO;
import com.web.f5.member.vo.MemberVO;



public class MemberServiceImpl implements MemberService{


@Autowired
MemberDAO memberDao;
	
@Override
public int login_result(MemberVO vo) {

	return memberDao.select(vo);
}
}
