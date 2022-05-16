package com.web.f5.board.service;

import java.util.List;

import com.web.f5.board.vo.BoardVO;

public interface BoardService {
	
	void getUpdateHits(String board_idx);
	int getDeleteResult(String board_idx);
	int getContentUpdate(BoardVO vo);
	BoardVO getContentList(String board_idx);
	List<BoardVO> getSelectList();
	int getInsertResult(BoardVO vo);
}
