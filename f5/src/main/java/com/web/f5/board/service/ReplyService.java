package com.web.f5.board.service;

import java.util.List;

import com.web.f5.board.vo.ReplyVO;

public interface ReplyService {
	List<ReplyVO> getSelectList(String board_idx);
	int getInsertResult(ReplyVO vo);
	int getDeleteResult(String reply_idx);
}
