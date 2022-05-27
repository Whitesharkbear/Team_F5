package com.web.f5.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.f5.vo.AdminMemberVO;

public class AdminMemberDAO implements AdminObjDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "mapper.adminmember";
	
	@Override
	public List<Object> select( int startCount, int endCount ) {
		
		Map param = new HashMap<String, String>();
		param.put("start", startCount);
		param.put("end", endCount);
		
		return sqlSession.selectList(namespace + ".list", param);
	}
	
	@Override
	public int execTotalCount() {
		
		return sqlSession.selectOne(namespace + ".count");
	}
	
	public int searchCount(String search_type, String search) {
		Map param = new HashMap<String, String>();
		param.put("search", search);
		param.put("search_type", search_type);
		
		return sqlSession.selectOne(namespace + ".searchCount", param);
	}
	
	@Override
	public int insert(Object obj) {
		
		AdminMemberVO vo = (AdminMemberVO) obj;
		
		return sqlSession.insert(namespace + ".memberInsert", vo);
	}
	
	@Override
	public Object select(String id) {
		
		return sqlSession.selectOne(namespace + ".memberContent", id);
	}
	
	@Override
	public int update(Object obj) {
		
		AdminMemberVO vo = (AdminMemberVO) obj;
		
		return sqlSession.update(namespace + ".memberUpdate", vo);
	}
	
	@Override
	public int delete(String id) {
		
		return sqlSession.delete(namespace + ".memberDelete", id);
	}
	
	public List<AdminMemberVO> select() {
		
		return sqlSession.selectList(namespace + ".limitList");
	}
	
	public int mberTotalCnt() {
		
		return sqlSession.selectOne(namespace + ".mberTotalCnt");
	}
	
	public int mberTodayCnt() {
		
		return sqlSession.selectOne(namespace + ".mberTodayCnt");
	}

	public List<Object> select(int startCount, int endCount, String search, String search_type) {
		
		Map param = new HashMap<String, String>();
		param.put("start", startCount);
		param.put("end", endCount);
		param.put("search", search);
		param.put("search_type", search_type);
		
		return sqlSession.selectList(namespace + ".searchList", param);
	}
	
	public int chkMberUpdate(String id, String auth) {
		
		Map param = new HashMap<String, String>();
		param.put("memberId", id);
		param.put("memberAuthority", auth);
		
		return sqlSession.update(namespace + ".chkMberUpdate", param);
	}

	public int getBlackInsert(String id) {
		
		return sqlSession.update(namespace + ".getBlackInsert", id);
	}

	public int getBlackOut(String id) {
		
		return sqlSession.update(namespace + ".getBlackOut", id);
	}

	public ArrayList<AdminMemberVO> getSearchJSONResult(int startCount, int endCount, String search, String search_type) {
		
		Map param = new HashMap<String, String>();
		param.put("start", startCount);
		param.put("end", endCount);
		param.put("search", search);
		param.put("search_type", search_type);
		
		List<AdminMemberVO> list = new ArrayList<AdminMemberVO>();
		list = sqlSession.selectList(namespace + ".JSONlist", param);
		
		return (ArrayList<AdminMemberVO>) list;
	}
}
