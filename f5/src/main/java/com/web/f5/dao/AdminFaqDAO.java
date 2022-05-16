package com.web.f5.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.f5.vo.AdminFaqVO;

public class AdminFaqDAO implements AdminObjDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "mapper.faq";
	
	@Override
	public List<Object> select(int startCount, int endCount) {
		
		Map param = new HashMap<String, String>();
		param.put("start", startCount);
		param.put("end", endCount);
		
		return sqlSession.selectList(namespace + ".list", param);
	}

	public List<Object> Searchselect(int startCount, int endCount) {

		Map param = new HashMap<String, String>();
		param.put("start", startCount);
		param.put("end", endCount);
		
		return sqlSession.selectList(namespace + ".searchList", param);
	}
	@Override
	public int execTotalCount() {
		
		return sqlSession.selectOne(namespace + ".count");
	}

	@Override
	public int insert(Object obj) {
		
		AdminFaqVO vo = (AdminFaqVO) obj;
		
		return sqlSession.insert(namespace + ".faqInsert", vo);
	}

	@Override
	public Object select(String idx) {
		
		return sqlSession.selectOne(namespace + ".faqContent", idx);
	}

	@Override
	public int update(Object obj) {
		
		AdminFaqVO vo = (AdminFaqVO) obj;
		
		return sqlSession.update(namespace + ".faqUpdate", vo);
	}

	@Override
	public int delete(String idx) {
		
		return sqlSession.delete(namespace + ".faqDelete", idx);
	}
}
