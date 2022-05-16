package com.web.f5.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.f5.vo.AdminNoticeVO;

public class AdminNoticeDAO implements AdminObjDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "mapper.notice";
	
	@Override
	public List<Object> select(int startCount, int endCount) {

		Map param = new HashMap<String, String>(); 
		param.put("start", startCount);
		param.put("end", endCount);
		
		return sqlSession.selectList(namespace + ".list", param);
	}

	@Override
	public int execTotalCount() {
		
		return sqlSession.selectOne(namespace + ".count");
	}

	@Override
	public int insert(Object obj) {
		
		AdminNoticeVO vo = (AdminNoticeVO) obj;
		
		return sqlSession.insert(namespace + ".noticeInsert", vo);
	}

	@Override
	public Object select(String idx) {
		
		return sqlSession.selectOne(namespace + ".noticeContent", idx);
	}

	@Override
	public int update(Object obj) {
		
		AdminNoticeVO vo = (AdminNoticeVO) obj;
		
		return sqlSession.update(namespace + ".noticeUpdate", vo);
	}

	@Override
	public int delete(String idx) {
		
		return sqlSession.delete(namespace + ".noticeDelete", idx);
	}

	public List<AdminNoticeVO> select() {
		
		return sqlSession.selectList(namespace + ".limitList");
	}
}
