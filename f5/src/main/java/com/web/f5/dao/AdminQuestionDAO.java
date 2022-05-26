package com.web.f5.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.f5.vo.AdminQuestionVO;

public class AdminQuestionDAO implements AdminObjDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	String namespace = "mapper.adminquestion";
	
	@Override
	public List<Object> select(int startCount, int endCount) {
		
		Map param = new HashMap<String, String>();
		param.put("start", startCount);
		param.put("end", endCount);
		
		return sqlSession.selectList(namespace + ".list", param);
	}
	
	public int getProceedCount(String proceed) {
		
		Map param = new HashMap<String, String>();
		param.put("proceed", proceed);
		
		return sqlSession.selectOne(namespace + ".searchProceed", param);
	}
	
	public int getCountResult(String search_type, String search) {
		
		Map param = new HashMap<String, String>();
		param.put("search", search);
		param.put("search_type", search_type);
		
		return sqlSession.selectOne(namespace + ".searchCount", param);
	}
	@Override
	public int execTotalCount() {

		return sqlSession.selectOne(namespace + ".count");
	}
	
	@Override
	public int insert(Object obj) {
		
		AdminQuestionVO vo = (AdminQuestionVO) obj;
		
		return sqlSession.insert(namespace + ".insert", vo);
	}

	@Override
	public Object select(String id) {
		
		return sqlSession.selectOne(namespace + ".questionContent", id);
	}

	public int update(String idx) {
		
		return sqlSession.update(namespace + ".questionReceiveBefore", idx);
	}
	
	@Override
	public int update(Object obj) {
		
		AdminQuestionVO vo = (AdminQuestionVO) obj;
		
		return sqlSession.update(namespace + ".questionReceiveAfter", vo);
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Object> select(int startCount, int endCount, String search, String search_type) {
		
		Map param = new HashMap<String, String>();
		param.put("start", startCount);
		param.put("end", endCount);
		param.put("search", search);
		param.put("search_type", search_type);
		
		return sqlSession.selectList(namespace + ".searchList", param);
	}

	public ArrayList<AdminQuestionVO> getSearchJSONResult(int startCount, int endCount, String search, String search_type) {
		
		Map param = new HashMap<String, String>();
		param.put("start", startCount);
		param.put("end", endCount);
		param.put("search", search);
		param.put("search_type", search_type);
		
		List<AdminQuestionVO> list = new ArrayList<AdminQuestionVO>();
		list = sqlSession.selectList(namespace + ".JSONlist", param);
		
		return (ArrayList<AdminQuestionVO>) list;
	}

	public ArrayList<AdminQuestionVO> getSearchJSONProceed(int startCount, int endCount, String proceed) {
		
		Map param = new HashMap<String, String>();
		param.put("start", startCount);
		param.put("end", endCount);
		param.put("proceed", proceed);
		
		List<AdminQuestionVO> list = new ArrayList<AdminQuestionVO>();
		list = sqlSession.selectList(namespace + ".JSONproceed", param);
		
		return (ArrayList<AdminQuestionVO>) list;
	}
}
