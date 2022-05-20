package com.web.service;

import java.util.List;

import com.web.vo.CgvMemberVO;

public interface MemberService extends ObjectService{
	int getStatusUpdate(String id, String status);
	int getIdCheckResult(String id);
	int getLoginResult(CgvMemberVO vo);
}