package com.web.f5.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.f5.board.dao.BoardDAO;
import com.web.f5.board.vo.BoardVO;

public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDao;
	
	
	@Override
	public int getInsertResult(BoardVO vo) {
		return boardDao.insert(vo);
	}


	@Override
	public List<BoardVO> getSelectList() {
		return boardDao.select();
	}


	@Override
	public BoardVO getContentList(String board_idx) {
		return boardDao.select(board_idx);
	}


	@Override
	public int getContentUpdate(BoardVO vo) {
		return boardDao.update(vo);
	}


	@Override
	public int getDeleteResult(String board_idx) {
		return boardDao.delete(board_idx);
	}


	@Override
	public void getUpdateHits(String board_idx) {
		boardDao.update_hits(board_idx);
		
	}

}
