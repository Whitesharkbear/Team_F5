package com.web.f5.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.f5.vo.BoardVO;
import com.web.f5.vo.RecommendVO;

public class BoardDAO {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	private String namespace = "mapper.board";
	
	public RecommendVO recoSelect(String boardIdx, String memberId) {
		Map param = new HashMap<String, String>();
		param.put("boardIdx", boardIdx);
		param.put("memberId", memberId);
		return sqlSession.selectOne(namespace+".reco_select", param);
	}
	
	// 추천 수
	public int recoCount(String boardRecommendCheck, String boardIdx) {
		Map param = new HashMap<String, String>();
		param.put("boardRecommendCheck", boardRecommendCheck);
		param.put("boardIdx", boardIdx);
		return sqlSession.selectOne(namespace+".reco_count", param);
	}
	
	// 추천 삭제
	public int recoDelete(RecommendVO vo) {
		return sqlSession.delete(namespace+".reco_delete", vo);
	}
	
	// 추천 업데이트
	public int recoUpdate(RecommendVO vo) {
		return sqlSession.update(namespace+".reco_update", vo);
	}
	
	// 추천 여부조회
	public int recoCheck(String boardIdx, String memberId) {
		Map param = new HashMap<String, String>();
		param.put("boardIdx", boardIdx);
		param.put("memberId", memberId);
		return sqlSession.selectOne(namespace+".reco_check", param);
	}
	
	// 추천
	public int recoInsert(RecommendVO vo) {
		return sqlSession.insert(namespace+".reco_insert", vo);
	}
	
	// 게시판 조회수 업데이트
	public void update_hits(String boardIdx) {
		sqlSession.update(namespace+".update_hits", boardIdx);
	}
	
	// 게시판 삭제
	public int delete(String boardIdx) {
		return sqlSession.delete(namespace+".delete", boardIdx);
	}
	
	
	// 게시판 수정
	public int update(BoardVO vo) {
		return sqlSession.update(namespace+".update", vo);
	}
	
	
	// 게시판 상세보기
	public BoardVO selectContent(String boardIdx) {
		return sqlSession.selectOne(namespace+".content", boardIdx);
	}
	
	
	// 게시판 리스트
	public List<BoardVO> select(String boardCategory) {
		Map param = new HashMap<String, String>();
		param.put("boardCategory", boardCategory);
		return sqlSession.selectList(namespace+".list", param);
		
	}
	
	
	// 게시판 쓰기
	public int insert(BoardVO vo) {
		return sqlSession.insert(namespace+".insert", vo);
	}

}
