package com.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.dao.CgvBoardDAO;
import com.web.vo.CgvBoardVO;

public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private CgvBoardDAO boardDao;
	
	@Override	//BoardService
	public String getFilename(String bid) {
		return boardDao.selectFile(bid);
	}
	
	@Override	//ObjectService
	public int getDeleteResult(String bid) {
		return boardDao.delete(bid);
	}
	
	@Override	//ObjectService
	public int getUpdateResult(Object obj) {
		CgvBoardVO vo = (CgvBoardVO)obj;
		return boardDao.update(vo);
	}
	
	@Override	//ObjectService
	public void getUpdateHits(String bid) {
		boardDao.updateHits(bid);
	}
	
	@Override	//ObjectService
	public Object getContent(String bid) { //리턴타입이 Object이면 메소드를 호출한 곳에서 형변환!!
		return boardDao.select(bid);	//Object
	}
	
	@Override	//ObjectService
	public int getInsertResult(Object obj) {
		CgvBoardVO vo = (CgvBoardVO)obj;
		return boardDao.insert(vo);
	}
	
	@Override	//ObjectService
	public List<Object> getListResult(int startCount, int endCount){
		//부모 --> 자식 : 반드시 자식의 모습으로 형변환
		//자식 --> 부모 : 자동으로 형변환
//		List<Object> olist = boardDao.select(startCount, endCount);
//		List<CgvBoardVO> list = new ArrayList<CgvBoardVO>();
//		
//		for(Object obj : olist) {
//			CgvBoardVO vo = (CgvBoardVO)obj;
//			list.add(vo);
//		}
		
 		return boardDao.select(startCount, endCount);
	}
	
	@Override	//ObjectService
	public int getListCount() {
		return boardDao.execTotalCount();
	}

}







