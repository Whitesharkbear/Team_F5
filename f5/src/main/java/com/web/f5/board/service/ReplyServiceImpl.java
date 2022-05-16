package com.web.f5.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.f5.board.dao.ReplyDAO;
import com.web.f5.board.vo.ReplyVO;

public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyDAO replyDao;
	
	@Override
	public int getInsertResult(ReplyVO vo) {
		return replyDao.insert(vo);
	}

	@Override
	public List<ReplyVO> getSelectList(String board_idx) {
		return replyDao.select(board_idx);
	}

	@Override
	public int getDeleteResult(String reply_idx) {
		return replyDao.delete(reply_idx);
	}
	
	
}
