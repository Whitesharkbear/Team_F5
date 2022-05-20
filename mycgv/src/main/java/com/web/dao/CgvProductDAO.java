package com.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.vo.CgvProductVO;

public class CgvProductDAO implements CgvObjectDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "mapper.product";
	
	/**
	 * 상품 상세정보
	 */
	@Override
	public Object select(String pid){
		return sqlSession.selectOne(namespace+".content", pid);
	}
	
	
	/**
	 * 상품 리스트
	 */
	@Override
	public List<Object> select(int startCount, int endCount){
		Map param = new HashMap<String, String>();
		param.put("start", startCount);
		param.put("end", endCount);
		
		return sqlSession.selectList(namespace+".select", param);
	}
	
	/**
	 * 상품 등록 : insert
	 */
	@Override
	public int insert(Object obj) {
		int result = 0;
		CgvProductVO vo = (CgvProductVO)obj;
		result = sqlSession.insert(namespace+".insert", vo);
		if(result==1) {
			String pid = sqlSession.selectOne(namespace+".select_pid");
			vo.setPid(pid);
			result = sqlSession.insert(namespace+".insert_file", vo);
		}
		return result;
	}
	
	public void updateHits(String id) {}
	public int update(Object obj) {return 0;}
	public int delete(String id) {return 0;}
	public int execTotalCount() {return 0;}
	public String selectFile(String id) {return "";}
	
}




