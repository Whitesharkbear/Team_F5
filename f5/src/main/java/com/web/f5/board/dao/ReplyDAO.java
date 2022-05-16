package com.web.f5.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.f5.board.vo.ReplyVO;

public class ReplyDAO {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	private String namespace = "mapper.reply";
	
	
	// 댓글삭제
	public int delete(String reply_idx) {
		return sqlSession.delete(namespace+".delete", reply_idx);
	}
	
	// 댓글리스트
	public List<ReplyVO> select(String board_idx) {
		return sqlSession.selectList(namespace+".list", board_idx);
	}
	
	
	// 댓글입력
	public int insert(ReplyVO vo) {
		return sqlSession.insert(namespace+".insert", vo);
	}

}
