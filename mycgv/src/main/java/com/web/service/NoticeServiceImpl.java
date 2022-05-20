package com.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.dao.CgvNoticeDAO;
import com.web.vo.CgvNoticeVO;

public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	private CgvNoticeDAO noticeDao;
	
	@Override	//NoticeService
	public String getFilename(String nid) {
		return noticeDao.selectFile(nid);
	}
	
	@Override	//ObjectService
	public int getDeleteResult(String nid) {
		return noticeDao.delete(nid);
	}
	
	@Override	//ObjectService
	public int getUpdateResult(Object obj) {
		CgvNoticeVO vo = (CgvNoticeVO)obj;
		return noticeDao.update(vo);
	}
	
	@Override	//ObjectService
	public void getUpdateHits(String nid) {
		noticeDao.updateHits(nid);
	}
	
	@Override	//ObjectService
	public Object getContent(String nid) {
		return noticeDao.select(nid);  //Object
	}
	
	@Override	//ObjectService
	public int getListCount() {
		return noticeDao.execTotalCount();
	}
	
	@Override	//ObjectService
	public List<Object> getListResult(int startCount, int endCount){
//		List<Object> olist = noticeDao.select(startCount, endCount);
//		List<CgvNoticeVO> list = new ArrayList<CgvNoticeVO>();
//		
//		for(Object obj : olist) {
//			list.add((CgvNoticeVO)obj);
//		}
		
		return noticeDao.select(startCount, endCount);
	}
	
	@Override	//ObjectService
	public int getInsertResult(Object obj) {
		CgvNoticeVO vo = (CgvNoticeVO)obj;
		return noticeDao.insert(vo);
	}
}














