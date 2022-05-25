package com.web.f5.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.f5.dao.MemberDAO;
import com.web.f5.vo.MemberVO;

public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO memberDao;

	@Override // MemberService
	public int getIdCheckResult(String id) {
		return memberDao.idCheck(id);
	}

	@Override
	public int login_result(MemberVO vo) {
		// TODO Auto-generated method stub
		return memberDao.select(vo);
	}

	@Override
	public int insert_result(MemberVO vo) {
		// TODO Auto-generated method stub
		return memberDao.insert(vo);
	}

	@Override
	public MemberVO select_result(String memberId) {
		// TODO Auto-generated method stub
		return (MemberVO) memberDao.select(memberId);
	}
	
}
