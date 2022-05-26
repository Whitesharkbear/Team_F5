package com.web.f5.service;

import java.util.List;
import java.util.Map;

import com.web.f5.vo.AdminMemberVO;

public interface AdminMemberService extends ObjService {

	int getListCount();
	List<Object> getListResult(int startCount, int endCount);
	int getInsertResult(Object obj);
	Object getContent(String id);
	int getUpdateResult(Object obj);
	int getDeleteResult(String id);
	List<AdminMemberVO> getLimitList();
	int getmberTotalCnt();
	int getmberTodayCnt();
	List<Object> getSearchListResult(int startCount, int endCount, String search, String search_type);
	int chkMberUpdate(String id, String auth);
}
