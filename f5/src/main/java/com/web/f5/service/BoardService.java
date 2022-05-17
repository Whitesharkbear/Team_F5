package com.web.f5.service;

import java.util.List;

import com.web.f5.vo.BoardVO;

public interface BoardService {
	
	void getUpdateHits(String boardIdx);
	int getDeleteResult(String boardIdx);
	int getContentUpdate(BoardVO vo);
	BoardVO getContentList(String boardIdx);
	List<BoardVO> getSelectList();
	int getInsertResult(BoardVO vo);
}
