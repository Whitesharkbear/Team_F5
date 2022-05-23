package com.web.f5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.f5.dao.BoardDAO;
import com.web.f5.vo.BoardVO;

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
	public BoardVO getContentList(String boardIdx) {
		return boardDao.select(boardIdx);
	}


	@Override
	public int getContentUpdate(BoardVO vo) {
		return boardDao.update(vo);
	}


	@Override
	public int getDeleteResult(String boardIdx) {
		return boardDao.delete(boardIdx);
	}


	@Override
	public void getUpdateHits(String boardIdx) {
		boardDao.update_hits(boardIdx);
		
	}

}
