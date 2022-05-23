package com.web.f5.member.service;

import com.web.f5.member.vo.MemberVO;

public interface MemberService {
	public int login_result(MemberVO vo);	
	public int insert_result(MemberVO vo);
	public MemberVO select_result(String memberId);
}
