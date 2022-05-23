package com.web.f5.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.f5.vo.ReplyVO;

public class ReplyDAO {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	private String namespace = "mapper.reply";
	
	
	// 댓글삭제
	public int delete(String replyIdx) {
		return sqlSession.delete(namespace+".delete", replyIdx);
	}
	
	// 댓글리스트
	public List<ReplyVO> select(String boardIdx) {
		return sqlSession.selectList(namespace+".list", boardIdx);
	}
	
	
	// 댓글입력
	public int insert(ReplyVO vo) {
		return sqlSession.insert(namespace+".insert", vo);
	}

}
