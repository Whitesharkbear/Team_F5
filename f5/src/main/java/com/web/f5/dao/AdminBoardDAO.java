package com.web.f5.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.f5.vo.AdminBoardVO;

public class AdminBoardDAO implements AdminObjDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "mapper.adminboard";
	
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

	public int searchCount(String search_type, String search) {
		Map param = new HashMap<String, String>();
		param.put("search", search);
		param.put("search_type", search_type);
		
		return sqlSession.selectOne(namespace + ".searchCount", param);
	}
	
	@Override
	public int insert(Object obj) {
		
		AdminBoardVO vo = (AdminBoardVO) obj;
		
		return sqlSession.insert(namespace + ".boardInsert", vo);
	}

	@Override
	public Object select(String idx) {
		
		return sqlSession.selectOne(namespace + ".boardContent", idx);
	}

	@Override
	public int update(Object obj) {
		
		AdminBoardVO vo = (AdminBoardVO) obj;
		
		return sqlSession.update(namespace + ".boardUpdate", vo);
	}

	@Override
	public int delete(String idx) {
		System.out.println(idx);
		return sqlSession.delete(namespace + ".boardDelete", idx);
	}

	public List<AdminBoardVO> select() {
		
		return sqlSession.selectList(namespace + ".limitList");
	}
}
