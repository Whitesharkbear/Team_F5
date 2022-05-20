package com.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.vo.CgvNoticeVO;

public class CgvNoticeDAO implements CgvObjectDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "mapper.notice";
	
	
	/**
	 * nsfile 
	 */
	@Override
	public String selectFile(String nid) {
		return sqlSession.selectOne(namespace+".nsfile", nid);
	}
	
	
	/**
	 * 페이징 처리 - 전체 row 카운트
	 */
	@Override
	public int execTotalCount() {
		return sqlSession.selectOne(namespace+".count");		
	}
	
	/**
	 * 공지사항 삭제
	 */
	@Override
	public int delete(String nid) {
		return sqlSession.delete(namespace+".delete", nid);		
	}
	
	/**
	 * 공지사항 업데이트
	 */
	@Override
	public int update(Object obj) {
		CgvNoticeVO vo = (CgvNoticeVO)obj;
		return sqlSession.update(namespace +".update", vo);
	}
	
	/**
	 * 공지사항 조회수 업데이트
	 */
	@Override
	public void updateHits(String nid) {
		sqlSession.update(namespace+".updateHits", nid);		
	}
	
	/**
	 * 공지사항 상세 정보, 업데이트폼
	 */
	@Override
	public Object select(String nid) {
		return sqlSession.selectOne(namespace+".content", nid); //CgvNoticeVO
		
	}
	
	
	/**
	 * 공지사항 전체 리스트 - 페이징처리
	 */
	@Override
	public List<Object> select(int startCount, int endCount){
		Map param = new HashMap<String, String>();
		param.put("start", startCount);
		param.put("end", endCount);
		
		return sqlSession.selectList(namespace+".list", param);		
	}
	
	
	/**
	 * 공지사항 등록
	 */
	@Override
	public int insert(Object obj) {
		CgvNoticeVO vo = (CgvNoticeVO)obj;
		return sqlSession.insert(namespace + ".insert",vo);		
	}
	
}








