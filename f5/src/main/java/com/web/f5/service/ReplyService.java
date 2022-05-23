package com.web.f5.service;

import java.util.List;

import com.web.f5.vo.ReplyVO;

public interface ReplyService {
	List<ReplyVO> getSelectList(String boardIdx);
	int getInsertResult(ReplyVO vo);
	int getDeleteResult(String replyIdx);
}
