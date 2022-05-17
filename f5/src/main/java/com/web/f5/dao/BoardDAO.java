package com.web.f5.dao;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.f5.vo.BoardVO;

public class BoardDAO {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	private String namespace = "mapper.board";
	
	
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
	public BoardVO select(String boardIdx) {
		return sqlSession.selectOne(namespace+".content", boardIdx);
	}
	
	
	// 게시판 리스트
	public List<BoardVO> select() {
		return sqlSession.selectList(namespace+".list");
		
	}
	
	
	// 게시판 쓰기
	public int insert(BoardVO vo) {
		return sqlSession.insert(namespace+".insert", vo);
	}

}
