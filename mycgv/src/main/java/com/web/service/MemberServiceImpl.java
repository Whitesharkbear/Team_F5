package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.dao.CgvMemberDAO;
import com.web.vo.CgvMemberVO;

public class MemberServiceImpl extends ObjectServiceAdapter implements MemberService {
	
	@Autowired
	private CgvMemberDAO memberDao;
	
	
	@Override  //MemberService
	public int getStatusUpdate(String id, String status) {
		return memberDao.updateJoinStatus(id, status);
	}
	
	@Override	//ObjectServiceAdapater
	public Object getContent(String id) {
		return memberDao.select(id);  //Object
	}
	
	@Override	//ObjectServiceAdapater
	public int getListCount() {
		return memberDao.execTotalCount();
	}
	
	
	@Override	//ObjectServiceAdapater
	public List<Object> getListResult(int startCount, int endCount){
//		List<Object> olist = memberDao.select(startCount, endCount);
//		List<CgvMemberVO> list = new ArrayList<CgvMemberVO>();
//		for(Object obj : olist) {
//			list.add((CgvMemberVO)obj);
//		}
		
		return memberDao.select(startCount, endCount);
	}
	
	@Override	//MemberService
	public int getLoginResult(CgvMemberVO vo) {
		return memberDao.select(vo);
	}
	
	@Override	//ObjectServiceAdapater
	public int getInsertResult(Object obj) {
		CgvMemberVO vo = (CgvMemberVO)obj;
		return memberDao.insert(vo);
	}
	
	
	@Override	//MemberService
	public int getIdCheckResult(String id) {
		return memberDao.idCheck(id);
	}

	
	
}
