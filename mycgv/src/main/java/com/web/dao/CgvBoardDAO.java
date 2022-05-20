package com.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.vo.CgvBoardVO;

public class CgvBoardDAO implements CgvObjectDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "mapper.board";
	
	/**
	 * bsfile
	 */
	@Override
	public String selectFile(String bid) {
		return sqlSession.selectOne(namespace+".bsfile", bid);		
	}
	
	/**
	 * 페이징 처리 - 전체 row 카운트
	 */
	@Override
	public int execTotalCount() {
		return sqlSession.selectOne(namespace + ".count");
		
	}
	
	
	
	/**
	 * 게시글 삭제 : delete(pk값) 
	 */
	@Override
	public int delete(String bid) {
		return sqlSession.delete(namespace+".delete", bid);	
	}
			
	
	/**
	 * 게시글 업데이트 : update(pk값)
	 */
	@Override
	public int update(Object obj) {
		CgvBoardVO vo = (CgvBoardVO)obj;	
		return sqlSession.update(namespace+".update", vo);
	}
		
	
	/**
	 * 조회수 업데이트 : updateHits(pk값)
	 */
	@Override
	public void updateHits(String bid) {
		sqlSession.update(namespace+".update_hits", bid);		
	}
	
	/**
	 * 게시글 상세 보기 : select(pk값)
	 */
	@Override
	public Object select(String bid) {
		return sqlSession.selectOne(namespace+".content", bid);	//CgvBoardVO	
	}
	
	
	/**
	 * 게시글 전체 리스트 : select(int startCount, int endCount)
	 */
	@Override
	public List<Object> select(int startCount, int endCount){
		Map param = new HashMap<String,String>();
		param.put("start", startCount);
		param.put("end", endCount);
		
		return sqlSession.selectList(namespace+".list",param);	
	}	
	
	
	/**
	 * 게시글 등록 : insert
	 */
	@Override
	public int insert(Object obj) {
		CgvBoardVO vo = (CgvBoardVO)obj;
		return sqlSession.insert(namespace+".insert", vo);		
	}
	
}




