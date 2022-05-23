package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.dao.CgvNoticeDAO;
import com.web.vo.CgvNoticeVO;

public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private CgvNoticeDAO noticeDao;
	
	@Override
	public int getInsertResult(Object obj) {
		CgvNoticeVO vo = (CgvNoticeVO)obj;
		return noticeDao.insert(vo);
	}

	@Override
	public List<Object> getListResult(int startCount, int endCount) {
		return noticeDao.select(startCount, endCount);
	}

	@Override
	public String getFilename(String nid) {
		return noticeDao.selectFile(nid);
	}

	@Override
	public int getDeleteResult(String nid) {
		return noticeDao.delete(nid);
	}

	@Override
	public int getUpdateResult(Object obj) {
		CgvNoticeVO vo = (CgvNoticeVO)obj;
		return noticeDao.update(vo);
	}

	@Override
	public void getUpdateHits(String nid) {
		noticeDao.updateHits(nid);
		
	}

	@Override
	public CgvNoticeVO getContent(String nid) {
		return noticeDao.select(nid);
	}

	@Override
	public int getListCount() {
		return noticeDao.execTotalCount();
	}

}
