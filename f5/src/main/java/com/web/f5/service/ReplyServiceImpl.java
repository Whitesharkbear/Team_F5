package com.web.f5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.f5.dao.ReplyDAO;
import com.web.f5.vo.ReplyVO;

public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyDAO replyDao;
	
	@Override
	public int getInsertResult(ReplyVO vo) {
		return replyDao.insert(vo);
	}

	@Override
	public List<ReplyVO> getSelectList(String boardIdx) {
		return replyDao.select(boardIdx);
	}

	@Override
	public int getDeleteResult(String replyIdx) {
		return replyDao.delete(replyIdx);
	}
	
	
}
