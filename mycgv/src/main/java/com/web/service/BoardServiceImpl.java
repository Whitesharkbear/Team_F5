package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.dao.CgvBoardDAO;
import com.web.vo.CgvBoardVO;

public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private CgvBoardDAO boardDao;
	
	@Override
	public int getListCount() {
		return boardDao.execTotalCount();
		
	}

	@Override
	public List<Object> getListResult(int startCount, int endCount) {
		return boardDao.select(startCount, endCount);
	}

	@Override
	public Object getContent(String bid) {
		return boardDao.select(bid);
	}

	@Override
	public int getInsertResult(Object obj) {
		CgvBoardVO vo = (CgvBoardVO)obj;
		return boardDao.insert(vo);
	}

	@Override
	public void getUpdateHits(String bid) {
		boardDao.updateHits(bid);
	}

	@Override
	public String getFilename(String bid) {
		return boardDao.selectFile(bid);
	}

	@Override
	public int getUpdateResult(Object obj) {
		CgvBoardVO vo = (CgvBoardVO)obj;
		return boardDao.update(vo);
	}

	@Override
	public int getDeleteResult(String bid) {
		return boardDao.delete(bid);
	}
}
